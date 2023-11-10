package lesson210.servises;

import lesson210.models.Emploee;
import lesson210.repositories.EmploeeRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConfigLoadData implements CommandLineRunner {

    @Autowired
    private EmploeeRepositories repo;

    @Override
    public void run(String... args) {
        try {
            repo.deleteAll();

            repo.save(new Emploee(null, null, "Даниил", "Андрианов", 1));
            repo.save(new Emploee(null, null, "Кирилл", "Артемов", 2));
            repo.save(new Emploee(null, null, "Денис", "Артамонов", 1));
            repo.save(new Emploee(null, null, "Илья", "Афанасьев", 2));
            repo.save(new Emploee(null, null, "Егор", "Борисов", 3));
            repo.save(new Emploee(null, null, "София","Васильева", 3));
            repo.save(new Emploee(null, null, "София", "Бородина", 1));
            repo.save(new Emploee(null, null, "Алиса","Беляева", 3));

        } catch (Exception ex) {
            System.out.println("err: "  + ex.getMessage());
        }
    }
}
