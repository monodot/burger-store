package com.tutorialworks.burgerstore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    @GetMapping("/menu")
    List<MenuItem> getMenu() {
        List<MenuItem> menu = new ArrayList<MenuItem>();
        menu.add(new MenuItem("Vegan Shape", 350));
        menu.add(new MenuItem("Deluxe Double Cheese Burger", 850));
        menu.add(new MenuItem("Basic Burger", 450));

        return menu;
    }

}
