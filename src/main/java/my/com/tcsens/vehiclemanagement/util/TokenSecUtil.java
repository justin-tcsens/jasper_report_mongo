package my.com.tcsens.vehiclemanagement.util;


import lombok.val;
import lombok.var;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static io.netty.util.internal.StringUtil.NEWLINE;

@Component
public class TokenSecUtil {

    private final String TOKENSEC_EXE = "ClientAuthToken.exe ";
    private final String TOKENSEC_PATH = "TokenSec/";

    public String verifyKey(String dataFile) {
        var clientKey =new StringBuilder();

        try {
            String[] commands = {"powershell.exe", TOKENSEC_PATH + TOKENSEC_EXE + TOKENSEC_PATH + dataFile};
            val pb = new ProcessBuilder(commands).redirectErrorStream(true);
            val process = pb.start();
            val in = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while(true) {
                val line = in.readLine();
                if(line == null) break;
                clientKey.append(line).append(NEWLINE);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientKey.toString();
    }
}
