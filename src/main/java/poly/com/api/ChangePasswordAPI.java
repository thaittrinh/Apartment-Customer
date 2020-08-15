package poly.com.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import poly.com.helper.MessageResponse;
import poly.com.request.ChangePasswordRequest;
import poly.com.service.ChangePasswordService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class ChangePasswordAPI {
    @Autowired
    private ChangePasswordService changePasswordService;

    @PostMapping("/changepassword")
    public ResponseEntity<MessageResponse> ChangePassword(@Valid  @RequestBody ChangePasswordRequest changePasswordRequest) {
        return changePasswordService.ChanePassword(changePasswordRequest);
    }
}
