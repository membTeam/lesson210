package lesson210.web;

import lesson210.models.Emploee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmploeeController {

    @Autowired
    EmploeeControllerServImpl contrServ;

    @GetMapping("/find/{id}")
    public Emploee findEmploee(@PathVariable("id") String id) {
        return contrServ.findEmploee(id);
    }

    @GetMapping("/delete/{id}")
    public String deleteEmploee(@PathVariable("id") String id) {
        contrServ.deleteEmploee(id);
        return "remove emploee";
    }

    @GetMapping("/all-emploee")
    public Iterable<Emploee> allEmploee() {
        return contrServ.allEmploee();
    }

    @GetMapping("/amount-emploee/{number}")
    public Iterable<Emploee> allAmountEmploee(@PathVariable("number") Integer number) {
        return contrServ.allAmountEmploee(number);
    }

    @PostMapping(path = "/add-emploee", consumes="application/json")
    public Emploee addEmploee(@RequestBody Emploee emploee) {
        return contrServ.addEmploee(emploee);
    }

}
