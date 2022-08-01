package proxyvideogames.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import proxyvideogames.Repository.VideogameRepository;
import proxyvideogames.enums.Genre;
import proxyvideogames.model.Videogame;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class VideogameControllerImplTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    VideogameRepository videogameRepository;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Videogame videogame1, videogame2;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        videogame1 = new Videogame("Bloodborne", "photo", Genre.ACTION, "genial", 9);
        videogame2 = new Videogame("Amnesia", "photo", Genre.ACTION, "terrifying", 8);

        videogameRepository.saveAll(List.of(videogame1, videogame2));
    }

    @AfterEach
    void tearDown() {
        videogameRepository.deleteAll();
    }

    @Test
    void postVideogame() throws Exception{
//                String body = objectMapper.writeValueAsString(videogame1);
//        MvcResult mvcResult = (MvcResult) mockMvc.perform(post("/games")
//                        .content(body)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
//                .andReturn();
//
//        assertTrue(mvcResult.getResponse().getContentAsString().contains("Bloodborne"));
//        assertFalse(mvcResult.getResponse().getContentAsString().contains("Fall guys"));
    }

    @Test
    void findGameByName() throws Exception{
        MvcResult mvcResult = (MvcResult) mockMvc.perform(get("/games/" + videogame1.getName())
                        .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Bloodborne"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Fall guys"));
    }

    @Test
    void deleteVideogame() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(
//                        delete("/games/"+ videogame1.getId())
//                ).andExpect(status().isNoContent())
//                .andReturn();
//        assertTrue(videogameRepository.count()==1);

    }
}