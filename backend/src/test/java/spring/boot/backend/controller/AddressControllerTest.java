package spring.boot.backend.controller;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.ModelMap;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Log
@AutoConfigureMockMvc
class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void list() throws Exception{
        ModelMap mm = mockMvc.perform(get("/address/list.do")).andReturn().getModelAndView().getModelMap();
        log.info("#AddressControllerTest list() mm: " + mm);
    }

    @Test
    void write() throws Exception{
        ResultActions ra = mockMvc.perform(MockMvcRequestBuilders.post("/address/write.do")
                .param("name", "가")
                .param("addr", "나"));

        String result = ra.andReturn().getModelAndView().getViewName();
        log.info("#AddressControllerTest write() result: " + result);
    }

    @Test
    void delete() throws Exception{
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/address/del.do").param("seq", "2"))
                .andReturn()
                .getModelAndView()
                .getViewName();

        log.info("#AddressControllerTest delete() result: " + result);
    }
}