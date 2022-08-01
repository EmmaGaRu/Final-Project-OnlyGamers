package proxyreview.controller.impl;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import proxyreview.models.UserReview;
import proxyreview.repository.ReviewRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ReviewControllerImplTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    ReviewRepository reviewRepository;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private UserReview review1, review2;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        review1 = new UserReview("Emma", "good game", 7, "little hope");
        review2 = new UserReview("Lemmy", "cui cui cui", 9, "blasphemous");

        reviewRepository.saveAll(List.of(review1,review2));
    }

    @AfterEach
    void tearDown() {
        reviewRepository.deleteAll();
    }

    @Test
    void findById() throws Exception {
        MvcResult mvcResult = (MvcResult) mockMvc.perform(get("/user/" + review1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Emma"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Lemmy"));

    }

    @Test
    void findMeanRate() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/findMeanUsersRate")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));

    }

    @Test
    void postReview() throws Exception {
//        String body = objectMapper.writeValueAsString(review2);
//        MvcResult mvcResult = (MvcResult) mockMvc.perform(post("/review")
//                        .content(body)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andReturn();
//
//        assertTrue(mvcResult.getResponse().getContentAsString().contains("Lemmy"));
//        assertFalse(mvcResult.getResponse().getContentAsString().contains("Emma"));

    }
}