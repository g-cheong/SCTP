package com.simplecrm.app;

import java.util.ArrayList;

public interface InteractionService {
    Interaction createInteraction(Interaction interaction);
    Interaction getInteraction(Long id);
    ArrayList<Interaction> getAllInteraction();
    Interaction updateInteraction(Long id, Interaction interaction);
    void deleteInteraction(Long id);
}
