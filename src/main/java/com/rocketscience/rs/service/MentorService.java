package com.rocketscience.rs.service;

import com.rocketscience.rs.entity.Mentor;
import com.rocketscience.rs.entity.Student;
import com.rocketscience.rs.entity.User;
import com.rocketscience.rs.repository.MentorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MentorService {

    private final MentorRepository mentorRepository;


    public void register(Mentor mentor){
        mentorRepository.save(mentor);
    }

    public void saveOrUpdate(Mentor mentor) {
        Mentor existingMentor = mentorRepository.findById(mentor.getId()).orElse(null);
        if (existingMentor != null) {
            existingMentor.setServices(mentor.getServices());
            existingMentor.setEducation(mentor.getEducation());
            existingMentor.setExperience(mentor.getExperience());
            existingMentor.setPrice(mentor.getPrice());
            existingMentor.setGender(mentor.getGender());
            existingMentor.setInstagram(mentor.getInstagram());
            existingMentor.setFacebook(mentor.getFacebook());
            existingMentor.setTwitter(mentor.getTwitter());
            existingMentor.setYoutube(mentor.getYoutube());
            mentorRepository.save(existingMentor);
        } else {

        }
    }
    public Mentor findById(Long id) {
        return mentorRepository.getOne(id);
    }
    public List<Mentor> findAll(){return mentorRepository.findAll();}

    //Поиск по предоставляемым услугам
    public List<Mentor> findByServicesContains(String services){
        return mentorRepository.findByServicesContains(services);
    }

    //Поиск по минимальному опыту (Тоесть опыт должен быть больше или равным указанным пользователем)
    public List<Mentor> findByExperienceAbove(Double minExperience){
        return mentorRepository.findByExperienceAboveOrEqual(minExperience);
    }


}
