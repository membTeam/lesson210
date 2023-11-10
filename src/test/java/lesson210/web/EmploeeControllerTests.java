package lesson210.web;

import lesson210.models.Emploee;
import lesson210.repositories.EmploeeRepositories;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmploeeControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    EmploeeRepositories repo;

    @Test
    public void addEmploee() throws Exception {
        var emploee = Emploee.builder()
                .firstName("FirstName")
                .lastName("LastName")
                .department(1)
                .build();

        mockMvc.perform(post("/api/add-emploee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(JsonUtil.toJson(emploee)) )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.firstName").value("Firstname"))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.lastName").value("Lastname"))
                .equals(MockMvcResultMatchers
                        .jsonPath("$.department").value(1)) ;
    }

    @Test
    public void addEmploee_forError() throws Exception {
        var emploee = Emploee.builder()
                .firstName("даниил")
                .lastName("андрианов")
                .department(1)
                .build();

        mockMvc.perform(post("/api/add-emploee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(emploee)) )
                .andExpect(status().isBadRequest());
    }

    @Test
    public void amountEmploee() throws Exception {

        mockMvc.perform(get("/api/amount-emploee/3"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.length()")
                        .value(3) );
    }

    @Test
    public void allEmploee() throws Exception{
        var count = repo.count();

        mockMvc.perform(get("/api/all-emploee"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers
                            .jsonPath("$.length()")
                            .value(count));
    }

    @Test
    public void findEmploee_byID() throws Exception {
        var emploee = repo.findLastEmploee();
        var id = emploee.getId();
        mockMvc.perform(get("/api/find/"+id))
                .andExpect(status().isOk());
    }

    @Test
    public void findEmploee_byID_retunNull() throws Exception {
        var emploee = repo.findLastEmploee();
        var id = emploee.getId() + "-012";
        mockMvc.perform(get("/api/find/"+id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()); // code 204
    }

    @Test
    public void deleteEmploee_byID() throws Exception {
        var emploee = repo.findLastEmploee();
        var id = emploee.getId();
        mockMvc.perform(get("/api/delete/"+id))
                .andExpect(status().isOk())
                .andExpect(content().string("remove emploee"));

    }

}
