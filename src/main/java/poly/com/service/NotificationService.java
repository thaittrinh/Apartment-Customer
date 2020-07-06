package poly.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import poly.com.entity.Notification;
import poly.com.repository.NotificationRepository;
import poly.com.request.PaginationRequest;

@Service
public class NotificationService {

	@Autowired
	NotificationRepository notificationRepository;
	
	public ResponseEntity<Page<Notification>> pagenation(PaginationRequest paginationRequest){	
		try {
			Sort sortable = null;
			if (paginationRequest.getSortType().equals("ASC")) {
			      sortable = Sort.by("date").ascending();
			}else {
				 sortable = Sort.by("date").descending();  // default DESC
			 }
			Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), sortable);			
			Page<Notification> pages =  notificationRepository.findByTitleContaining(paginationRequest.getTitle(), pageable);
			
			return ResponseEntity.ok(pages);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
