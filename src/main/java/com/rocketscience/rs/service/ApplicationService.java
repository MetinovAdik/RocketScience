package com.rocketscience.rs.service;

import com.rocketscience.rs.entity.Application;
import com.rocketscience.rs.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    //Находим все заявки игрока
    public List<Application> findAllByStudentId(Long id){
        return applicationRepository.findAllByStudentId(id);
    }

    //Находим все заявки ментора
    public List<Application> findAllByMentorId(Long id){
        return applicationRepository.findAllByMentorId(id);
    }
}
