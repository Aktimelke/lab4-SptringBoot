package com.lab4.more_tables.service;

import com.lab4.more_tables.model.Phone;
import com.lab4.more_tables.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    private final PhoneRepository phoneRepository;
    @Autowired
    public PhoneService(PhoneRepository phoneRepository){
        this.phoneRepository=phoneRepository;
    }

    public Phone findById(Long id){
        return phoneRepository.getOne(id);
    }
    public List<Phone> findAll(){
        return phoneRepository.findAll();
    }
    public Phone savePhone(Phone phone){
        return phoneRepository.save(phone);
    }
    public void deleteById(Long id){
        phoneRepository.deleteById(id);
    }
}
