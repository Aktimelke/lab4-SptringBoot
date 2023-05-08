package com.lab4.more_tables.service;

import com.lab4.more_tables.model.Tv;
import com.lab4.more_tables.repository.TvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvService {
    private final TvRepository tvRepository;
    @Autowired
    public TvService(TvRepository tvRepository){
        this.tvRepository=tvRepository;
    }

    public Tv findById(Long id){
        return tvRepository.getOne(id);
    }
    public List<Tv> findAll(){
        return tvRepository.findAll();
    }
    public Tv saveTv(Tv tv){
        return tvRepository.save(tv);
    }
    public void deleteById(Long id){
        tvRepository.deleteById(id);
    }
}
