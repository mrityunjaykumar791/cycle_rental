package com.mindfire.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindfire.dto.UserDTO;
import com.mindfire.model.ProofDetail;
import com.mindfire.model.RateGroup;
import com.mindfire.model.Role;
import com.mindfire.model.User;
import com.mindfire.services.UserService;

@Component
public class UserComponent {
	
	@Autowired
	private UserService userService;

	public User mapUserComponent(UserDTO userDTO){
		
		User newUser = new User();
		
		newUser.setFirstName(userDTO.getFirstName());
		newUser.setLastName(userDTO.getLastName());
		newUser.setEmail(userDTO.getEmail());
		newUser.setUserAddress(userDTO.getUserAddress());
		newUser.setMobileNo(userDTO.getMobileNo());
		newUser.setDateOfBirth(userDTO.getDateOfBirth());
		
		
		ProofDetail proofDetail = new ProofDetail();
		
		proofDetail.setProofType(userDTO.getProofType());
		proofDetail.setProofNo(userDTO.getProofNo());
		proofDetail.setDocument(userDTO.getDocument());
		
		Role userRole = new Role();
		userRole.setUserRole("user");
		
		RateGroup rateGroup = new RateGroup();
		rateGroup.setGroupType("user-type");
		
		return userService.saveUserDetails(newUser, proofDetail,userRole,rateGroup);
	}
}
