package com.example.gerenciadorDePodCasts.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/podcasts")
public class PodCastController {
    @GetMapping
    public String getRoot() {
        return "Yay podcasts!";
    }
}
