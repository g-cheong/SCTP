package com.example.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    //SampleItem item = new SampleItem();
    @Autowired
    SampleItem item;

    @Value("${spring.application.name}")
    private String appName;
    @Value("${server.port}")
    private String port;
    
    @GetMapping("/item")
    public SampleItem getItem() {
        item.setId(1);
        item.setName("Apple");
        item.setPrice(1.99);
        item.setDesc("A red apple");
        return item;
    }

    @GetMapping("/app-info")
    public String getAppInfo() {
        return "App is running on port " + port;
    }

    @GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	@GetMapping("/greet")
	public String greet(@RequestParam(defaultValue = "World") String name, @RequestParam(defaultValue = "inventor") String role) {
		return "Hello " + name + ", the " + role + ".\n";
	}

	@GetMapping("/users/{id}")
	public String getUser(@PathVariable int id) {
		return "User ID: " + id + "\n";
	}
	
	@GetMapping("products")
	public String products(@RequestParam(defaultValue = "") String search) {
		if(search.equals("")){
			return "This is the product page.\n";
		}
		return "You have searched for " + search + ".\n";
	}

	@GetMapping("products/{id}")
	public String searchProducts(@PathVariable int id) {
		return "You have requested for product with id: " + id + ".\n";
	}
}
