package com.example.gerenciadorDePodCasts.service;

import com.example.gerenciadorDePodCasts.model.PodCast;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PodCastService {
    /**
     * Método para simular busca por um podcast pelo ID.
     */
    public PodCast findPodCastById(Long id) {
        PodCast podCast = new PodCast();
        podCast.setId(id);
        podCast.setName("Meu podcast");
        podCast.setUrl("http://www.meupodcast.com.br");

        return podCast;
    }

    /**
     * Método para simular a criação de um novo podcast.
     */
    public PodCast savePodCast(PodCast podCast) {
        PodCast savedPodCast = new PodCast();

        // Vamos fingir que estamos salvando o podcast
        // ao atribuir um ID aleatório a ele

        savedPodCast.setId(new Random().nextLong(0, 1000));
        savedPodCast.setName(podCast.getName());
        savedPodCast.setUrl(podCast.getUrl());

        return savedPodCast;
    }
}