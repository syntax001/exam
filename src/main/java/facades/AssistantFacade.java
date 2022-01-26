package facades;

import dtos.AssistantDTO;
import entities.Assistant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import java.util.List;

public class  AssistantFacade {

    private static AssistantFacade instance;
    private static EntityManagerFactory emf;

    private AssistantFacade() {
    }

    public static AssistantFacade getAssistantFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AssistantFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<AssistantDTO> getAllAssistants() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Assistant> query = em.createQuery("SELECT w FROM Assistant w", Assistant.class);
        List<Assistant> result = query.getResultList();
        return AssistantDTO.getDTO(result);
    }

    public AssistantDTO createAssistant(AssistantDTO assistantDTO) {
        EntityManager em = emf.createEntityManager();
        try {
                Assistant assistant = new Assistant(assistantDTO.getName(), assistantDTO.getPrimaryLanguage(), assistantDTO.getYrsOfExperience(), assistantDTO.getHourlyWage());
                em.getTransaction().begin();
                em.persist(assistant);
                em.getTransaction().commit();
                return new AssistantDTO(assistant);
            }
         finally {
            em.close();
        }
    }
}