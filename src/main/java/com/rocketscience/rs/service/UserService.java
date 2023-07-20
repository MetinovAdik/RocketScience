package com.rocketscience.rs.service;

import com.rocketscience.rs.entity.Mentor;
import com.rocketscience.rs.entity.User;
import com.rocketscience.rs.exception.NotFoundException;
import com.rocketscience.rs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            return userRepository.findByEmail(email).get(0);
        } else throw new NotFoundException("Не могу найти пользователя");
    }

    public List<User> findByName(String string) {
        List<User> i = new ArrayList<>();
        i.addAll(userRepository.findByFirstNameContains(string));
        i.addAll(userRepository.findByLastNameContains(string));
        return i;
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
}
