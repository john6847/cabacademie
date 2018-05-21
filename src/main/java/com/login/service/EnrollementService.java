package com.login.service;

import com.login.model.Enrollement;
import com.login.repository.EnrollementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dany on 18/05/2018.
 */
@Service
public class EnrollementService {
    @Autowired
    private EnrollementRepository enrollementRepository;

    public List<Enrollement> fetchAllEnrollements(){
        return enrollementRepository.findAll();
    }

    public Enrollement fetchEnrollement(Long id){
        return enrollementRepository.findOne(id);
    }

    public Enrollement updateEnrollement (Enrollement enrollement){
        Enrollement currentEnrollement= enrollementRepository.findOne(enrollement.getId());
        currentEnrollement.setAmount(enrollement.getAmount());
        currentEnrollement.setCourse(enrollement.getCourse());
        currentEnrollement.setLocalUser(enrollement.getLocalUser());

        return enrollementRepository.save(currentEnrollement);
    }
    public Enrollement saveEnrollement(Enrollement enrollement){
        return enrollementRepository.save(enrollement);
    }
    public void deleteEnrollement(Long id){
        enrollementRepository.delete(id);
    }
    //other delete methods
    //other fetching methods
}
