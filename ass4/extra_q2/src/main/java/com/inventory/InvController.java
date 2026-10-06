package com.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InvController {
    @Autowired
    private InvService service;

    @PostMapping
    public Item add(@RequestBody Item item) { return service.add(item); }

    @GetMapping
    public List<Item> all() { return service.getAll(); }

    @GetMapping("/{id}")
    public Item one(@PathVariable int id) { return service.get(id); }

    @PutMapping("/{id}/stock")
    public Item updateStock(@PathVariable int id, @RequestParam int quantity) {
        return service.updateStock(id, quantity);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return service.delete(id) ? "Deleted" : "Not found";
    }

    @GetMapping("/low-stock")
    public List<Item> lowStock(@RequestParam(defaultValue = "5") int threshold) {
        return service.lowStock(threshold);
    }
}
