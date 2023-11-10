package lesson210;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class StringUtilsTests {
    @Test
    public void stringUtils_containsAny() {
        var string = "foreach.com";

        assertThat(StringUtils.containsAny(string, '.')).isTrue();

        assertThat(StringUtils.containsAny(string, "abc")).isTrue();
    }

    @Test
    public void stringUtils_containsAny_2() {
        var anyChar = "абвгд";
                //"a-Z";
        //var anyChar2 = "0123459,.:; _!#$%^&*(){}[]-+=/\\'\"";
                //"а-Я";
                //
        var strTest1 = "Names";
        var strTest2 = "Провер";
//        var strTest3 = "ПроверяемаяСтрок/а";
//        var strTest4 = "ПроверяемаяСтрок-а";

        assertThat(StringUtils.containsAny(strTest1, anyChar)).isFalse();
        assertThat(StringUtils.containsAny(strTest2, anyChar)).isFalse();
//        assertThat(StringUtils.containsAny(strTest3, anyChar)).isTrue();
//        assertThat(StringUtils.containsAny(strTest4, anyChar)).isTrue();
    }


    @Test
    public void stringUtils_reverse() {
        var originalString = "foreach";
        var reverseString = StringUtils.reverse(originalString);

        assertThat(reverseString).isEqualTo("hcaerof");
    }

    @Test
    public void stringUtils_capitalise() {
        var firstName = "nike";
        var result = StringUtils.capitalize(firstName);

        assertThat(result).isEqualTo("Nike");
    }

    @Test
    public void stringUtils_rotate() {
        var original = "foreach";
        var rotated = StringUtils.rotate(original, 4);

        assertThat(rotated).isEqualTo("eachfor");
    }

    @Test
    public void stringUtils_difference() {
        String tutorials = "ForEach Tutorials";
        String courses = "ForEach Courses";
        String diff1 = StringUtils.difference(tutorials, courses);
        String diff2 = StringUtils.difference(courses, tutorials);

        assertThat("Courses").isEqualTo(diff1);

        assertThat("Tutorials").isEqualTo(diff2);
    }

    @Test
    public void verifyStringData() {
        var str = "автоСтрокаИеёМожноПроверитьъ";
        List<Integer> lsInt = new ArrayList<>();

        final int MINCHAR = 1040,
                MAXCHAR = 1103,
                ANYMINCHAR = 1025,
                ANYMAXCHAR = 1105;

        int index = -1;
        while (++index < str.length()) {
            int intChar = str.charAt(index);

            if ( (intChar < MINCHAR && intChar != ANYMINCHAR)
                    || (intChar > MAXCHAR && intChar != ANYMAXCHAR) ) {
                System.out.println("Не допустимый символ: " +
                        ((char) intChar) +
                        " intChar: " + intChar +
                        " index: " + index);
                break;
            }
        }
    }

    @Test
    public void capitalize_test() {

        String str = "где-то строка";

        int firstChar = str.charAt(0);
        if (firstChar > 'Я') {
            firstChar -= 32;
            str = (char)firstChar + str.substring(1);
        }

        System.out.println(str);
    }

    @Test
    public void verifyString_test() {
        char ch1 = 'ь';
        char ch2 = 'Ь';

        int dif = ch1 - ch2;

        System.out.println("dif: " + dif);


        // А 1040  Ё 1025 ё 1105  а 1072 я 1103 ь 1100  ъ 1098
        // 1025 1105  1040 - 1103

        /*int intChar = ch;

        System.out.println("intChar: " + intChar);

        System.out.println( "char for 1106: " + ((char) 1106) );*/

    }

    @Test
    public void verifyString_isAlpha() {

        var strTest = "ЭтоСтрока";
        var strTest2 = "ЭтоСтрока</";
        var strTest3 = "ЭтоСтрокаThisString";

        assertThat(StringUtils.isAlpha(strTest)).isTrue();

        assertThat(StringUtils.isAlpha(strTest2)).isFalse();

        assertThat(StringUtils.isAlpha(strTest3)).isTrue();

    }


}
