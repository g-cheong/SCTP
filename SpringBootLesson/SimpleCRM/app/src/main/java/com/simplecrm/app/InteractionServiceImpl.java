package com.simplecrm.app;

import java.util.ArrayList;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class InteractionServiceImpl implements InteractionService {
    private InteractionRepository interactionRepository;

    public InteractionServiceImpl(InteractionRepository interactionRepository) {
        this.interactionRepository = interactionRepository;
    }

    @Override
    public Interaction createInteraction(Interaction interaction) {
        return interactionRepository.save(interaction);
    }

    @Override
    public Interaction getInteraction(Long id) {
        return interactionRepository.findById(id).get();
    }

    @Override
    public ArrayList<Interaction> getAllInteraction() {
        return (ArrayList<Interaction>) interactionRepository.findAll();
    }

    @Override
    public Interaction updateInteraction(Long id, Interaction interaction) {
        Interaction existingInteraction = interactionRepository.findById(id).get();
        existingInteraction.setRemarks(interaction.getRemarks());
        existingInteraction.setInteractionDate(interaction.getInteractionDate());
        return interactionRepository.save(existingInteraction);
    }

    @Override
    public void deleteInteraction(Long id) {
        interactionRepository.deleteById(id);
    }
    
}
