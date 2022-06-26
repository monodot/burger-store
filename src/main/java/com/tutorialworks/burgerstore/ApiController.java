package com.tutorialworks.burgerstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    private Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/menu")
    List<MenuItem> getMenu() {
        LOGGER.trace("getMenu called");

        List<MenuItem> menu = new ArrayList<MenuItem>();
        menu.add(new MenuItem("Vegan Shape", 350));
        menu.add(new MenuItem("Deluxe Double Cheese Burger", 850));
        menu.add(new MenuItem("Basic Burger", 450));

        LOGGER.debug("Returning menu");
        return menu;
    }

}
