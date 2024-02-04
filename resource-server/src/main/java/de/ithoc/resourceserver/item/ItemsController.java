package de.ithoc.resourceserver.item;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {

    @GetMapping
    public ResponseEntity<List<Item>> getItems() {

        List<Item> items = List.of(
            new Item("Item 1", "Description 1"),
            new Item("Item 2", "Description 2"),
            new Item("Item 3", "Description 3")
        );
        return ResponseEntity.ok(items);
    }

}
