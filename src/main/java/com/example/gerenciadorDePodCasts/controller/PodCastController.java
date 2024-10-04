package com.example.gerenciadorDePodCasts.controller;


import com.example.gerenciadorDePodCasts.model.PodCast;
import com.example.gerenciadorDePodCasts.service.PodCastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/podcasts")
public class PodCastController {

    private PodCastService service;

    @Autowired
    public PodCastController(PodCastService service) {
        this.service = service;
    }


    @GetMapping
    public String getRoot() {
        return "Yay podcasts!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<PodCast> getPodCast ( @PathVariable long id) {
        if (id > 1000) {
            return ResponseEntity.notFound().build();
        }
        PodCast podCast = service.findPodCastById(id);
        podCast.setId((id));
        podCast.setName("Meu podcast");
        podCast.setUrl("http://www.meupodcast.com.br");
        return ResponseEntity.ok(podCast);
    }

    @GetMapping("/search")
    public String searchPodcasts(@RequestParam String title) {
        return "Você buscou por Podcasts com o titulo: %s".formatted(title);
    }
/*
nova requisição de GER
http://localhost:8080/podcasts/search?title=podcasts sobre Java
Resposta: Você buscou por Podcasts com o titulo: podcasts sobre Java
 */

    @PostMapping
    public ResponseEntity<PodCast> creatPodCast (@RequestBody PodCast newPodCast) {
        PodCast savedPodCast = service.savePodCast(newPodCast);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPodCast);

    }
}
