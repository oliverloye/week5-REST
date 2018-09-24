/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Pet;
import entity.PetDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Oliver
 */
public class FacadePet implements FacadePetInterface {

    EntityManagerFactory emf;

    public FacadePet(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<PetDTO> getAllPets() {
        EntityManager em = emf.createEntityManager();

        List<PetDTO> pets = null;

        try {
            em.getTransaction().begin();
            TypedQuery<PetDTO> query = em.createQuery("SELECT new entity.PetDTO(p.id, p.name, p.birth, p.species, p.death, p.ownerId.firstName, p.ownerId.lastName) FROM Pet p", PetDTO.class);
            pets = query.getResultList();
            em.getTransaction().commit();
            return pets;

            } finally {
                em.clear();
            }
        }

    @Override
    public int getPetCount() {
        EntityManager em = emf.createEntityManager();
        int numbersOfPets;
        try{
            em.getTransaction().begin();
            TypedQuery<Pet> query = em.createNamedQuery("Pet.findAll", Pet.class);
            numbersOfPets = query.getResultList().size();
            em.getTransaction().commit();
            return numbersOfPets;
        } finally {
            em.close();
        }
    }

    @Override
    public List<PetDTO> getLivingPets() {
        EntityManager em = emf.createEntityManager();
        
        List<PetDTO> pets = null;
        
        try {
            em.getTransaction().begin();
            TypedQuery<PetDTO> query = em.createQuery("SELECT new entity.PetDTO(p.id, p.name, p.birth, p.species) FROM Pet p WHERE p.death IS NULL", PetDTO.class);
            pets = query.getResultList();
            em.getTransaction().commit();
            return pets;
        } finally {
            em.close();
        }
    }

    @Override
    public List<PetDTO> getPetEvents() {
        EntityManager em = emf.createEntityManager();
        
        List<PetDTO> pets = null;
        
        try {
            em.getTransaction().begin();
            TypedQuery<PetDTO> query = em.createQuery("SELECT new entity.PetDTO(p.id, p.name, p.birth, p.species) FROM Pet p JOIN p.eventCollection.event", PetDTO.class);
            pets = query.getResultList();
            em.getTransaction().commit();
            return pets;
        } finally {
            em.close();
        }
    }

    @Override
    public Pet getPet(int petId) {
        EntityManager em = emf.createEntityManager();
        
        Pet pet;
        
        try {
            em.getTransaction().begin();
            TypedQuery<Pet> query = em.createNamedQuery("Pet.findById", Pet.class);
            query.setParameter("id", petId);
            pet = query.getSingleResult();
            em.getTransaction().commit();
            return pet;
        } finally {
            em.close();
        }
    }
    
    public PetDTO getPetDTO(int id) {
        EntityManager em = emf.createEntityManager();
        
        PetDTO pet;
        
        try {
            em.getTransaction().begin();
            TypedQuery<PetDTO> query = em.createQuery("SELECT new entity.PetDTO(p.id, p.name, p.birth, p.species, p.death, p.ownerId.firstName, p.ownerId.lastName) FROM Pet p WHERE p.id = :id", PetDTO.class);
            query.setParameter("id", id);
            pet = query.getSingleResult();
            em.getTransaction().commit();
            return pet;
        } finally {
            em.close();
        }
    }

}
