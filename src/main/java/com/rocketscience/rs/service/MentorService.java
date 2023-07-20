package com.rocketscience.rs.service;

import com.rocketscience.rs.entity.Mentor;
import com.rocketscience.rs.entity.Role;
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
    private final UserService userService;

    public List<Mentor> findAll(){return mentorRepository.findAll();}

    //Поиск по id (списками) Сделал это думая об ленте менторов
    //Работает в связке с методом из юзер сервиса. Возможно изменю позже
    public List<Mentor> findAllByIds(List<User> users) {
        List<Long> userIds = new ArrayList<>();

        for (User user : users) {
            userIds.add(user.getId());
        }

        List<Mentor> mentors = mentorRepository.findAllById(userIds);
        return mentors;
    }

    //Поиск по предоставляемым услугам
    public List<Mentor> findByServicesContains(String services){
        return mentorRepository.findByServicesContains(services);
    }

    //Поиск по минимальному опыту (Тоесть опыт должен быть больше или равным указанным пользователем)
    public List<Mentor> findByExperienceAbove(Double minExperience){
        return mentorRepository.findByExperienceAboveOrEqual(minExperience);
    }

    public Mentor saveMentor(Mentor mentor){
        mentor.getUser().setRole(Role.MENTOR);
        User savedMentor = userService.saveUser(mentor.getUser());
        mentor.setUser(savedMentor);
        return mentorRepository.save(mentor);
    }

    public Mentor findByEmail(String email){
        User user = userService.findByEmail(email);
        if (user!=null && user.getRole()==Role.MENTOR){
            return mentorRepository.findByUser(user);
        }
        return null;
    }


}
