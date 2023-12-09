package com.example.reclamation.Service;

import com.example.reclamation.Entity.Reclamation;
import com.example.reclamation.Repository.ReclamationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamationService {
    ReclamationRepo reclamationRepository ;

    @Autowired
    public ReclamationService(ReclamationRepo reclamationRepository) {
        this.reclamationRepository = reclamationRepository;
    }

    // Création ou mise à jour (Create)
    public Reclamation saveReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    // Lecture (Read)
    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    public Reclamation getReclamationById(int id) {
        return reclamationRepository.findById(id).orElse(null);
    }

    // Suppression (Delete)
    public void deleteReclamation(int id) {
        reclamationRepository.deleteById(id);
    }

    public Reclamation updateReclamation(int id, Reclamation updatedReclamation) {
        Reclamation existingReclamation = reclamationRepository.findById(id).orElse(null);
        if (existingReclamation != null) {
            existingReclamation.setSujet(updatedReclamation.getSujet());
            existingReclamation.setDescription(updatedReclamation.getDescription());
            existingReclamation.setEmail(updatedReclamation.getEmail());
            return reclamationRepository.save(existingReclamation);
        }
        return null;
    }

}
