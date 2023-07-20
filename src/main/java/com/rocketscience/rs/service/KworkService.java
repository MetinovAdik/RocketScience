package com.rocketscience.rs.service;

import com.rocketscience.rs.entity.Kwork;
import com.rocketscience.rs.entity.Science;
import com.rocketscience.rs.entity.Subject;
import com.rocketscience.rs.entity.Type;
import com.rocketscience.rs.repository.KworkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class KworkService {

    private final KworkRepository kworkRepository;


    //Список по предмету
    public List<Kwork> findBySubject(Subject subject) {
        return kworkRepository.findBySubject(subject);
    }

    //Список по типу(индивидуальные или групповые)
    public List<Kwork> findByType(Type type) {
        return kworkRepository.findByType(type);
    }

    //Список по наукам(Гуманитарные или Технические)
    public List<Kwork> findByScience(Science science){
        return kworkRepository.findByScience(science);
    }

    //Список по цене
    public List<Kwork> findByPriceLower(String price) { return kworkRepository.findByPriceLower(price);}
}
