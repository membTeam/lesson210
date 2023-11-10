package lesson210.repositories;

import lesson210.models.Emploee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmploeeRepositories extends CrudRepository<Emploee, String > {
    @Query("select * from Emploee limit :amount")
    Iterable<Emploee> findAll(@Param("amount") int amount);

    @Query("Select * from Emploee limit 1")
    Emploee findFirstEmploee();

    @Query("select * from Emploee limit 1 offset (select count(*) from Emploee) -1 ")
    Emploee findLastEmploee();

    @Query("select count(*) from Emploee where first_name = :first and last_name= :last")
    Integer findByFistNameAndLastName(@Param("first") String firstName,
                                      @Param("last") String lastName );

}
