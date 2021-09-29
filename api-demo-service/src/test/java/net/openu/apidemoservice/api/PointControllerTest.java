package net.openu.apidemoservice.api;

import static org.mockito.BDDMockito.given;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import net.openu.apidemoservice.service.PointService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PointControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PointService pointService;

    @Test
    public void 포인트를_추가한다_POST() throws Exception {
        //given
        String url = "/api/point";
        String content = "{\n"
            + "  \"userId\": \"bbn\",\n"
            + "  \"reason\": \"reg member\",\n"
            + "  \"amount\": 100\n"
            + "}";
        given(pointService.addPoint()).willReturn("TestPoint");

        //when
        ResultActions resultActions = this.mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
            .content(content)
        );
        //then
        resultActions
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Point")));
    }

}