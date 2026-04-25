package com.example.backend.service;
import com.example.backend.entity.User;
import com.example.backend.respository.UserResponsitory;
import com.example.backend.util.JwtUtil;
import com.google.api.client.googleapis.auth.oauth2.*;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;


@Service
public class GoogleAuthService {
}