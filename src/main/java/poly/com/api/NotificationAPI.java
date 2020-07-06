package poly.com.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.com.entity.Notification;
import poly.com.request.PaginationRequest;
import poly.com.service.NotificationService;

@RestController
@RequestMapping("/api/notification")
public class NotificationAPI {

	@Autowired
	NotificationService notificationService;
	
	@GetMapping
	public ResponseEntity<Page<Notification>> pagenation(@RequestBody PaginationRequest paginationRequest){	
		
		return notificationService.pagenation(paginationRequest);
	}
	
	
	
}
