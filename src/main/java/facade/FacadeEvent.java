/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.EventDTO;
import entity.PetDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Oliver
 */
public class FacadeEvent {
    EntityManagerFactory emf;
    
    public List<EventDTO> getPetEvents() {
        EntityManager em = emf.createEntityManager();
        
        List<EventDTO> pets = null;
        
        try {
            em.getTransaction().begin();
            TypedQuery<EventDTO> query = em.createQuery("SELECT new entity.EventDTO(e.)", EventDTO.class);
            pets = query.getResultList();
            em.getTransaction().commit();
            return pets;
        } finally {
            em.close();
        }
    }
}
