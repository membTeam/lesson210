package lesson210.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lesson210.exceptions.ErrorNotFoundException;
import lesson210.exceptions.ErrorRequestParamsException;
import lesson210.models.Emploee;
import lesson210.repositories.EmploeeRepositories;
import static lesson210.utils.EmploeeConvData.verifyAndConvDataEmploee;


@Component
public class EmploeeControllerServImpl implements EmploeeControllerServ {

    @Autowired
    EmploeeRepositories repo;

    @Override
    public Emploee addEmploee(Emploee emploee) {
        verifyAndConvDataEmploee(emploee);

        if (repo.findByFistNameAndLastName(emploee.getFirstName(), emploee.getLastName()) > 0) {
            throw new ErrorRequestParamsException("Повторный ввод данных");
        }

        return repo.save(emploee);
    }

    @Override
    public Emploee findEmploee(String id) {
        return repo.findById(id).orElseThrow(() -> {
            throw new ErrorRequestParamsException("Нет данных"); } );
    }

    @Override
    public void deleteEmploee(String id) {
        if (repo.findById(id).isEmpty()) {
            throw new ErrorNotFoundException("Нет данных");
        }

        repo.deleteById(id);
    }

    @Override
    public Iterable<Emploee> allEmploee() {
        return repo.findAll() ;
    }

    @Override
    public Iterable<Emploee> allAmountEmploee(int amount) {
        return repo.findAll(amount);
    }
}
