/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Pet;
import entity.PetDTO;
import java.util.List;

/**
 *
 * @author Oliver
 */
public interface FacadePetInterface {
    public List<PetDTO> getAllPets();
    public List<PetDTO> getLivingPets();
    public List<PetDTO> getPetEvents();
    public int getPetCount();
    public Pet getPet(int petId);
    
}
