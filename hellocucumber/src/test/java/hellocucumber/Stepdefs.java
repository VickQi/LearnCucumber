package hellocucumber;

import cucumber.api.java.zh_cn.*;
import static org.junit.Assert.*;

public class Stepdefs {
    private String today;
    private String actualAnswer;

    // [^\"]: 不是引号(\")的任意一个字符
    @假如("^今天是\"([^\"]*)\"$")
    public void today_is(String today) {
        this.today = today;
    }

    @当("^我问今天是不是星期五$")
    public void i_ask_whether_is_s_Friday_yet() {
        this.actualAnswer = IsItFriday.isItFriday(today);
    }

    // [^\"]: 不是引号(\")的任意一个字符
    @那么("^我应该被告知：\"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}

class IsItFriday {
    static String isItFriday(String today) {
        if("星期五".equals(today)){
            return "今天是星期五";
        }else if("星期一".equals(today)||
                "星期二".equals(today)||
                "星期三".equals(today)||
                "星期四".equals(today)||
                "星期六".equals(today)||
                "星期日".equals(today)){
            return "今天不是星期五";
        }
        return "日期非法";
    }
}
