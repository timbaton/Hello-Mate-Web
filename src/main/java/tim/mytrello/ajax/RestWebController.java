package tim.mytrello.ajax;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@RestController
@RequestMapping("/api/customer")
public class RestWebController {

    List<Customer> cust = new ArrayList<Customer>();

    @GetMapping(value = "/all")
    public Response getResource() {
        Response response = new Response("Done", cust);
        return response;
    }

    @PostMapping(value = "/save")
    public Response postCustomer(@RequestBody Customer customer) {
        cust.add(customer);

        // Create Response Object
        Response response = new Response("Done", customer);
        return response;
    }
}
