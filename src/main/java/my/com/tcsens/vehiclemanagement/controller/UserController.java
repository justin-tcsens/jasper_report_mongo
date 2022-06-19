package my.com.tcsens.vehiclemanagement.controller;

import lombok.val;
import my.com.tcsens.vehiclemanagement.api.UserApi;
import my.com.tcsens.vehiclemanagement.util.TokenSecUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class UserController implements UserApi {
    private final TokenSecUtil tokenSecUtil;

    public UserController(TokenSecUtil tokenSecUtil) {
        this.tokenSecUtil = tokenSecUtil;
    }

    @Override
    public ResponseEntity<String> getUserThumbprint(String userId) {
        return ResponseEntity.ok(tokenSecUtil.verifyKey(userId));
    }
}
