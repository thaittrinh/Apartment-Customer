package poly.com.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationRequest {

	@NotNull(message = "Page is not null!")
	private Integer page;
	
	@NotNull(message = "Size is not null!")
	private Integer size;
	
	private String title;
	
	private String sortType;
	
}
