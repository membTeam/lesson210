package lesson210.utils;

import lesson210.exceptions.ErrorRequestParamsException;
import lesson210.models.Emploee;
import org.apache.commons.lang3.StringUtils;

public class EmploeeConvData {
    public static void verifyAndConvDataEmploee(Emploee emploee) {
        if (!StringUtils.isAlpha(emploee.getFirstName()) ||
                !StringUtils.isAlpha(emploee.getLastName()) ) {
            throw new ErrorRequestParamsException("Ошибка запроса.");
        }

        var firstName = StringUtils.capitalize(emploee.getFirstName().toLowerCase());
        var lastName = StringUtils.capitalize(emploee.getLastName().toLowerCase());

        emploee.setFirstName(firstName);
        emploee.setLastName(lastName);
    }
}
