package tim.mytrello.ajax;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response {
    private String status;
    private Object data;
}
