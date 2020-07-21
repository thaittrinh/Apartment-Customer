package poly.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import poly.com.entity.Apartment;
import poly.com.repository.ApartmentRepository;
import poly.com.request.ChangePasswordRequest;

@Service

public class ChangePasswordService {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String>ChanePassword(ChangePasswordRequest changePasswordRequest ) {
        try {
            Apartment apartment = apartmentRepository.findById(changePasswordRequest.getId()).orElse(null);
            if (apartment == null) {
                return new ResponseEntity<>("Căn hộ không tồn tại", HttpStatus.NOT_FOUND);
            }
            else{
                String dbPassword = apartment.getPassword();
                String oldPassword = changePasswordRequest.getOldPassword();
                if (passwordEncoder.matches(oldPassword, dbPassword)) {
                    apartment.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
                    apartmentRepository.save(apartment);
                    return new ResponseEntity<>("Đã đổi mật khẩu", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("Mật khẩu cũ không đúng" , HttpStatus.BAD_REQUEST);
                }
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Lỗi server", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
