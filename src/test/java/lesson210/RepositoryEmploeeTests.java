package lesson210;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import lesson210.repositories.EmploeeRepositories;

@SpringBootTest
public class RepositoryEmploeeTests {
    @Autowired
    EmploeeRepositories repo;

    @Test
    public void getCountRecord() {

        var count = repo.count();

        assertThat(count).isGreaterThan(0);
    }

    @Test
    public void findFirstEmploee_test() {
        var res = repo.findFirstEmploee();

        assertThat(res).isNotNull();
    }

    @Test
    public void findLastEmploee_test() {
        var res = repo.findLastEmploee();

        assertThat(res).isNotNull();
    }

    @Test
    public void findByFistNameAndLastName() {
        var emploee = repo.findFirstEmploee();

        var firstName = emploee.getFirstName();
        var lastName = emploee.getLastName();

        var result = repo.findByFistNameAndLastName(firstName, lastName);
        assertThat(result).isGreaterThan(0);
    }

}
