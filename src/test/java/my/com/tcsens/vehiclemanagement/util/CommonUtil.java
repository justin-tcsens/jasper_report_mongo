package my.com.tcsens.vehiclemanagement.util;

import lombok.val;
import lombok.var;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class CommonUtil {
    public String getRandomNumber(int maxValue, int maxLength) {
        val random = new Random();
        val randomNumber = random.nextInt(maxValue - 1) + maxValue;

        return getPrefixString(String.valueOf(randomNumber), maxLength);
    }

    public String getPrefixString(String value, int size) {
        var formatText = value;

        while(formatText.length() < size) {
            formatText = "0" + formatText;
        }
        return formatText;
    }
}
