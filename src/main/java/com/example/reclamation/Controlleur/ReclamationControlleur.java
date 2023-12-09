package com.example.reclamation.Controlleur;

import com.example.reclamation.Entity.Reclamation;
import com.example.reclamation.Service.ReclamationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reclamation")
public class ReclamationControlleur {

    private final ReclamationService reclamationService;

    public ReclamationControlleur(ReclamationService reclamationService) {
        this.reclamationService = reclamationService;
    }

    @GetMapping("/list")
    public List<Reclamation> getAll (){
        return  reclamationService.getAllReclamations();
    }

    @GetMapping("getById/{id}")
    public Reclamation getById(@PathVariable("id") int id) {
        return reclamationService.getReclamationById(id);
    }

    @PostMapping("/add")
    public Reclamation createReclamation(@RequestBody Reclamation reclamation ) {
        return reclamationService.saveReclamation(reclamation);
    }

    @PutMapping("/update/{id}")
    public Reclamation updateReclamation(@PathVariable("id") int id,@RequestBody Reclamation updatedReclamation) {
        return reclamationService.updateReclamation(id,updatedReclamation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReclamation(@PathVariable("id") int id) {
        reclamationService.deleteReclamation(id);
    }



}
