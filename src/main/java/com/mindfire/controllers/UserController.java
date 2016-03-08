package com.mindfire.controllers;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.component.MessageBean;
import com.mindfire.component.UserComponent;
import com.mindfire.constants.Constant;
import com.mindfire.dto.UserDTO;
import com.mindfire.event.OnRegistrationCompleteEvent;
import com.mindfire.event.ResendVerificationTokenEvent;
import com.mindfire.model.User;
import com.mindfire.model.VerificationToken;
import com.mindfire.repositories.VerificationTokenRepository;
import com.mindfire.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserComponent userComponent;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	private UserService userService;

	@Autowired
	private VerificationTokenRepository tokenRepository;

	@Autowired
	private MessageBean messageBean;

	/**
	 * This method maps the registration request. Simply render the index view.
	 * 
	 * @return the registration view.
	 */
	@RequestMapping("registration.html")
	public String register(@ModelAttribute("userData") UserDTO userDTO, BindingResult result) {
		return Constant.REGISTRATION;
	}

	/**
	 * This method maps the registration request. Simply render the index view.
	 * 
	 * @return the registration view.
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userData") UserDTO userDTO, BindingResult result, WebRequest request) {

		User registered = userComponent.mapUserComponent(userDTO);
		try {
			String appUrl = System.getProperty("server.context-path");
			eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));
		} catch (Exception me) {
			System.out.println(me.getMessage());
		}
		return new ModelAndView("successRegister", "user", userDTO);
	}

	@RequestMapping("badUser")
	public ModelAndView badUser(Model model) {
		return new ModelAndView("badUser");
	}

	@RequestMapping("badUser2")
	public ModelAndView badUser2(Model model) {
		return new ModelAndView("badUser2");
	}

	@RequestMapping("setPassword")
	public ModelAndView setPassword(Model model) {
		return new ModelAndView("setPassword");
	}

	@RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
	public ModelAndView confirmRegistration(Model model, @RequestParam("token") String token, HttpSession session) {
		System.out.println(token);
		VerificationToken verificationToken = tokenRepository.findByToken(token);

		if (verificationToken == null) {
			String message = messageBean.getInvalidToken();
			model.addAttribute("message", message);
			return new ModelAndView("redirect:/badUser2.html");
		}

		User user = verificationToken.getUser();
		System.out.println(user);
		Calendar cal = Calendar.getInstance();
		if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			model.addAttribute("message", messageBean.getExpired());
			model.addAttribute("expired", true);
			model.addAttribute("token", verificationToken);
			session.setAttribute("token", verificationToken.getToken());
			return new ModelAndView("redirect:/badUser.html");
		}

		user.setEnabled(true);
		userService.saveRegisteredUser(user);
		return new ModelAndView("redirect:/setPassword.html");
	}

	@RequestMapping(value = "resendRegistrationToken", method = RequestMethod.GET)
	public ModelAndView resendRegistrationToken(
			  HttpServletRequest request, @RequestParam("token") String existingToken) {
		
		 VerificationToken newToken = userService.generateNewVerificationToken(existingToken);
	     
		    User user = userService.getUser(newToken.getToken());
		    String appUrl = messageBean.getContextPath();
		    try {
		        eventPublisher.publishEvent(new ResendVerificationTokenEvent(appUrl, request.getLocale(), newToken, user));
		    } catch (Exception me) {
		        System.out.println(me.getMessage());
		    }
			return new ModelAndView("successRegister");
		    
	}
}
