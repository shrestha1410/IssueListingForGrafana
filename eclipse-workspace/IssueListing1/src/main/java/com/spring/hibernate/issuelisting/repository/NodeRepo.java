package com.spring.hibernate.issuelisting.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.hibernate.issuelisting.model.Nodes;

import java.util.Date;


@Repository
public interface NodeRepo  extends JpaRepository<Nodes, String> {

	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = 
		"SET FOREIGN_KEY_CHECKS=OFF; 	")
  void offForeign();
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value =
			"delete from nodes where iid=?1")
	void deletenodes(String iid);
	@Query(nativeQuery = true,value = 
		"select  MAX(date(nodeupdatedat)) from nodes")
	Date maxDate();
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value =
			"UPDATE nodes SET module = ?1, milestonetitle = ?2, labelproject=?3 ,iterationduedate=?4,startdate=?5,team=?6,type=?7,labelstate=?8 where iid=?9")
	void update(String module,String milestonetitle, String labelproject, Date iterationduedate, Date startdate, String team ,String type,String state,int node );
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value = 
		"SET FOREIGN_KEY_CHECKS=ON; ")
  void onForeign();

}
