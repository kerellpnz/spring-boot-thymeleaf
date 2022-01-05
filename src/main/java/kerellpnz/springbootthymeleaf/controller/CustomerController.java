package kerellpnz.springbootthymeleaf.controller;

import kerellpnz.springbootthymeleaf.model.Customer;
import kerellpnz.springbootthymeleaf.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String getCustomers(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int customerId, Model model) {
        Customer customer = customerService.findById(customerId);
        if (customer == null) {
            throw new RuntimeException("Customer not found! With id = " + customerId);
        }
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/delete")
    public String delete (@RequestParam("customerId") int customerId) {
        Customer customer = customerService.findById(customerId);
        if (customer == null) {
            throw new RuntimeException("Customer not found! With id = " + customerId);
        }
        customerService.deleteById(customerId);
        return "redirect:/customers/list";
    }
}
