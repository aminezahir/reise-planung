package contr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping
    public String home() {
        return "index";
    }

    @PostMapping("/submitForm")
    public String handleFormSubmission(@RequestParam("from") String from,
                                       @RequestParam("to") String to,
                                       @RequestParam("date") String date,
                                       @RequestParam("passengers") int passengers,
                                       Model model) {
        // Perform necessary processing or forward the request to another resource

        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("from", from);
        modelMap.put("to", to);
        modelMap.put("date", date);
        modelMap.put("passengers", passengers);

        model.addAllAttributes(modelMap);

        // Return the name of the view to render
        return "result"; // Assuming you have a result.html or result.jsp view to render the response
    }
}
