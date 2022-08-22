package com.spring.hibernate.issuelisting.repository;

import com.spring.hibernate.issuelisting.model.MasterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MasterDataRepo  extends JpaRepository<MasterData,Integer> {
    @Modifying
    @Transactional
    @Query(value = "Truncate table masterdata;",nativeQuery = true)
    public void truncateMasterData();
}
