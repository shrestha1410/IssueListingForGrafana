package com.spring.hibernate.issuelisting.dao;

import com.spring.hibernate.issuelisting.model.MasterData;
import com.spring.hibernate.issuelisting.repository.MasterDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterDataService {
    @Autowired
    private MasterDataRepo masterDataRepo;

    @Value("#{'${my.list.of.strings}'.split(',')}")
    private List<String> myList;

    public void addEmployee() {
        MasterData masterData = new MasterData();
        for (String str : myList) {
            masterData.setEmployeename(str);
            //masterData.getEmployeename();
             masterDataRepo.save(masterData);
        }
    }
}
