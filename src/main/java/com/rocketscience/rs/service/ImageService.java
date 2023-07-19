package com.rocketscience.rs.service;

import com.rocketscience.rs.entity.Image;
import com.rocketscience.rs.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;



}
