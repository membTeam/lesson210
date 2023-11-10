package lesson210.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@Builder
public class Emploee {
    @Id
    private String id;
    private String INN;
    private String firstName;
    private String lastName;
    private int department;
}
