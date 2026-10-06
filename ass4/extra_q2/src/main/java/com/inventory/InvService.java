package com.inventory;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class InvService {
    private Map<Integer, Item> items = new HashMap<>();
    private int nextId = 1;

    public Item add(Item item) {
        item.setId(nextId++);
        items.put(item.getId(), item);
        return item;
    }

    public List<Item> getAll() { return new ArrayList<>(items.values()); }
    public Item get(int id) { return items.get(id); }

    public Item updateStock(int id, int qty) {
        Item item = items.get(id);
        if (item != null) item.setStock(item.getStock() + qty);
        return item;
    }

    public boolean delete(int id) { return items.remove(id) != null; }

    public List<Item> lowStock(int threshold) {
        List<Item> low = new ArrayList<>();
        for (Item i : items.values()) {
            if (i.getStock() <= threshold) low.add(i);
        }
        return low;
    }
}
