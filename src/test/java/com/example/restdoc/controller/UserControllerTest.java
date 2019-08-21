package com.example.restdoc.controller;

import static com.example.restdoc.utils.ApiDocumentUtils.getDocumentRequest;
import static com.example.restdoc.utils.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.payload.PayloadDocumentation.beneathPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

import com.example.restdoc.domain.User;
import com.example.restdoc.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureRestDocs
public class UserControllerTest {

  @Autowired private MockMvc mockMvc;

  @Autowired private ObjectMapper objectMapper;

  private List<User> users;
  @MockBean private UserService userService;

  @Before
  public void setUp() throws Exception {
    users =
        Arrays.asList(
            User.builder()
                .id(1L)
                .loginId("yh_kim")
                .name("김윤호")
                .number("010-6261-5283")
                .age(31)
                .build(),
            User.builder()
                .id(2L)
                .loginId("hchong")
                .name("홍호철")
                .number("010-1234-1234")
                .age(31)
                .build());
  }

  @Test
  public void findAll() throws Exception {
    // given
    given(userService.findAll()).willReturn(users);

    // when
    ResultActions resultActions =
        this.mockMvc.perform(
            RestDocumentationRequestBuilders.get("/api/allUsers")
                .accept(MediaType.APPLICATION_JSON));

    // then
    resultActions
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(
            MockMvcRestDocumentation.document(
                "users-find-all",
                getDocumentRequest(),
                getDocumentResponse(),
                responseFields(
                    beneathPath("data").withSubsectionId("data"),
                    fieldWithPath("[]id").type(JsonFieldType.NUMBER).description("아이디"),
                    fieldWithPath("[]name").type(JsonFieldType.STRING).description("이름"),
                    fieldWithPath("[]loginId")
                        .type(JsonFieldType.STRING)
                        .description("로그인 아이디"),
                    fieldWithPath("[]number")
                        .type(JsonFieldType.STRING)
                        .description("핸드폰 번호"),
                    fieldWithPath("[]age").type(JsonFieldType.NUMBER).description("나이"))));
  }
}
