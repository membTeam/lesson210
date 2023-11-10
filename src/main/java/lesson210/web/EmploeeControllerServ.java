package lesson210.web;

import lesson210.models.Emploee;

import java.util.List;

public interface EmploeeControllerServ {
    Emploee addEmploee(Emploee emploee);
    Emploee findEmploee(String id);
    void deleteEmploee(String id);
    Iterable<Emploee> allEmploee();
    Iterable<Emploee> allAmountEmploee(int amount);

}
