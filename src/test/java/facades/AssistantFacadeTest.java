package facades;

import dtos.AssistantDTO;
import entities.Assistant;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssistantFacadeTest {

    private static EntityManagerFactory emf;
    private static AssistantFacade facade;

    public AssistantFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = AssistantFacade.getAssistantFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            List<Assistant> waList = new ArrayList<>();
            Assistant assistant = new Assistant("Turbo Troels", "dansk", 8, 160);
            Assistant assistant2 = new Assistant("Tænke Troels", "dansk", 22, 200);
            Assistant assistant3 = new Assistant("Børge", "dansk", 12, 175);
            waList.add(assistant);

            em.getTransaction().begin();
            em.persist(assistant);
            em.persist(assistant2);
            em.persist(assistant3);


            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method
    @Test
    public void testGetAll() throws Exception {
        assertEquals(7, facade.getAllAssistants().size());
    }

    @Test
    public void testCreateWashingAssistant(){
        AssistantDTO asDTO = new AssistantDTO("TestDude", "Danish", 20, 230);
        facade.createAssistant(asDTO);
        assertEquals("TestDude", asDTO.getName());
    }


}