package com.mindfire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindfire.model.User;
import com.mindfire.model.VerificationToken;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

	 VerificationToken findByToken(String token);

	 VerificationToken findByUser(User user);
}
