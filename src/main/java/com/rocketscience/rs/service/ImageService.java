package com.rocketscience.rs.service;

import com.rocketscience.rs.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;
}
