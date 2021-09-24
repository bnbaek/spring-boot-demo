package net.openu.apidemoservice.dto.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by iopenu@gmail.com on 2021/09/24
 * Github : https://github.com/bnbaek
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class BookControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void modelAttribute_GET() throws Exception {
    //given
    String url = "/api/book?title=bbn&id=bbnid&requestDate=2021-09-24T11:12:23";
    //when
    ResultActions resultActions = this.mockMvc.perform(get(url));

    //then
    resultActions
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("GET")));
  }

  @Test
  public void requestParam_GET() throws Exception {
    //given
    String url = "/api/book/requestParam?requestDate=2021-09-24T11:12:23";
    //when
    ResultActions resultActions = this.mockMvc.perform(get(url));

    //then
    resultActions
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("GET")));
  }

  @Test
  public void requestBody_Post() throws Exception {
    //given
    String url = "/api/book";
    String content = "{\"title\":\"titlePost\" ,\"id\":\"idPost\",\"requestDate\":\"2021-09-24T11:12:23\"}";
    //when
    ResultActions resultActions = this.mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
        .content(content)

    );

    //then
    resultActions
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("POST")));
  }

  @Test
  public void responseTest() throws Exception {
    //given
    String url = "/api/book/response";

    //when
    ResultActions resultActions = this.mockMvc.perform(get(url));

    //then
    resultActions
        .andExpect(status().isOk())
        .andExpect(content().json("{\"title\":\"resTitle\",\"id\":\"resId\", \"requestDate\":\"2021-09-24T11:12:23\"}"));

  }


}