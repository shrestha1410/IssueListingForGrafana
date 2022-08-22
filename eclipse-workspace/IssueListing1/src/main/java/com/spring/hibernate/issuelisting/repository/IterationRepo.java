package com.spring.hibernate.issuelisting.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.hibernate.issuelisting.model.Iteration;
@Repository
public interface IterationRepo extends JpaRepository<Iteration, String> {
	@Modifying
	@Transactional
	@Query(value = "Delete from iteration where nodes_qid=?1",nativeQuery = true)
    public void deleteIteration(int nodes_qid);
}
