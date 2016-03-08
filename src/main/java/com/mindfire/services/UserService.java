package com.mindfire.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindfire.dto.UserDTO;
import com.mindfire.model.ProofDetail;
import com.mindfire.model.RateGroup;
import com.mindfire.model.Role;
import com.mindfire.model.User;
import com.mindfire.model.VerificationToken;
import com.mindfire.repositories.ProofDetailRepository;
import com.mindfire.repositories.RateGroupRepository;
import com.mindfire.repositories.RoleRepository;
import com.mindfire.repositories.UserRepository;
import com.mindfire.repositories.VerificationTokenRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VerificationTokenRepository tokenRepository;

	@Autowired
	private ProofDetailRepository proofDetailRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RateGroupRepository rateGroupRepository;

	public User login(UserDTO userDTO) {
		return userRepository.findByEmail(userDTO.getEmail());
	}

	public User saveUserDetails(User user, ProofDetail proofDetail,Role userRole,RateGroup rateGroup) {
		
		proofDetailRepository.save(proofDetail);
		roleRepository.save(userRole);
		rateGroupRepository.save(rateGroup);
		user.setProofDetail(proofDetail);
		user.setRole(userRole);
		user.setRateGroupId(rateGroup);
		userRepository.save(user);
		
		proofDetailRepository.save(proofDetail);
		user.setProofDetail(proofDetail);
		userRepository.save(user);
		return user;
	}

	public void createVerificationTokenForUser(final User user, final String token) {
		final VerificationToken myToken = new VerificationToken(token, user);
		tokenRepository.save(myToken);
	}

	public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {
		VerificationToken vToken = tokenRepository.findByToken(existingVerificationToken);
		vToken.updateToken(UUID.randomUUID().toString());
		vToken = tokenRepository.save(vToken);
		return vToken;
	}

	public User getUser(String verificationToken) {
		User user = tokenRepository.findByToken(verificationToken).getUser();
		return user;
	}

	public VerificationToken getVerificationToken(String VerificationToken) {
		return tokenRepository.findByToken(VerificationToken);
	}

	public void saveRegisteredUser(User user) {
		userRepository.save(user);
	}

	public void createVerificationToken(User user, String token) {
		VerificationToken myToken = new VerificationToken(token, user);
		tokenRepository.save(myToken);
	}
}
