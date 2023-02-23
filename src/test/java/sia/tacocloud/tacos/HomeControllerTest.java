package sia.tacocloud.tacos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk()) // 응답이 HTTP 200이어야 한다.
                .andExpect(view().name("home")) // home뷰가 있어야 한다.
                .andExpect(content().string( // 콘텐츠에 "Welcome to..."가 포함되어야 한다.
                        containsString("Welcome to...")
                ));
    }
}