package com.mindfire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindfire.model.ProofDetail;

@Repository
public interface ProofDetailRepository extends JpaRepository<ProofDetail, Long>{

}
