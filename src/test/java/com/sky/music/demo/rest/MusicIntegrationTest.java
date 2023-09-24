package com.sky.music.demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.music.demo.domain.Music;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:music-schema.sql", "classpath:music-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class MusicIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception {

        Music testMusic = new Music("rap", "usa", "eminem", 1999);
        String reqBody = this.mapper.writeValueAsString(testMusic);

        System.out.println("Music: " + testMusic);
        System.out.println("JSON: " + reqBody);

        RequestBuilder req = post("/create").content(reqBody).contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = status().isCreated();
        testMusic.setId(2);
        String resBody = this.mapper.writeValueAsString(testMusic);
        System.out.println("SAVED MUSIC: " + testMusic);
        System.out.println("RES JSON: " + resBody);
        ResultMatcher checkBody = content().json(resBody);

        mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testCreate2() throws Exception {

        String reqBody = this.mapper.writeValueAsString(new Music("rap", "usa", "eminem", 1999));

        String resBody = this.mapper.writeValueAsString(new Music(2,"rap", "usa", "eminem", 1999));

        mvc.perform(post("/create").content(reqBody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andExpect(content().json(resBody));
    }

    @Test
    void testRead() throws Exception {
        String resBody = this.mapper.writeValueAsString(new Music(1,"rap","usa","eminem",1999));
        this.mvc.perform(MockMvcRequestBuilders.get("/get/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(resBody));
    }

    @Test
    void testReadAll() throws Exception {
        List<Music> musicList = new ArrayList<>();
        musicList.add(new Music(1,"rap","usa","eminem",1999));

        String resBody = this.mapper.writeValueAsString(musicList);
        this.mvc.perform(MockMvcRequestBuilders.get("/getAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(resBody));
    }

    @Test
    void testUpdate() throws Exception {

        Music update = new Music(1,"rap", "canada", "drake", 2008);
        String reqBody = this.mapper.writeValueAsString(update);


        String resBody = this.mapper.writeValueAsString(update);
        this.mvc.perform(MockMvcRequestBuilders.patch("/update?id=1&year=2008&genre=rap&artist=drake&country=canada")
                .content(reqBody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(resBody));

    }
}
