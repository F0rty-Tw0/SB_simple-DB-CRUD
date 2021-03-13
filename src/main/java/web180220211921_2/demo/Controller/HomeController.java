package web180220211921_2.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web180220211921_2.demo.Model.Person;
import web180220211921_2.demo.Service.IPersonService;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    IPersonService personService;

    @GetMapping("/")
    public String Home(Model model){
        List<Person> personList = personService.fetchAll();
        model.addAttribute("persons",personList);
        return "home/index";
    }

    @GetMapping("/viewOne/{id}")
    public String ViewOne(@PathVariable("id") int id,Model model){
        model.addAttribute("person",personService.findPersonById(id));
        return "home/viewone";
    }

    // Called by the form tag and here we use metode=post
    @PostMapping("/create")
    public String create(@ModelAttribute Person person){
        personService.addPerson(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        Boolean delete = personService.deleteUser(id);
        if(delete)
            return "redirect:/";
        else
            return "home/error";
    }
}
