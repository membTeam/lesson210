package lesson210.models;


import org.springframework.data.annotation.Id;

public class Emploee {
    @Id
    private long id;
    private long INN;
    private String firstName;
    private String lastName;
    private int department;

}
