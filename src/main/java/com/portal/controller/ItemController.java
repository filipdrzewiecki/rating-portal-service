package com.portal.controller;

import com.portal.enttiy.Item;
import com.portal.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public Page<Item> getItems(@PageableDefault Pageable pageable) {
        return itemService.getItems(pageable);
    }

    @GetMapping("/{name}")
    public Item getItem(@PathVariable String name) {
        return itemService.getItem(name);
    }

    @PostMapping()
    public Item createItem(@RequestBody ItemDto itemDto) {
        return itemService.createItem(itemDto);
    }

    @PutMapping("/{name}")
    public Item updateItem(@PathVariable String name, @RequestBody ItemDto itemDto) {
        return itemService.updateItem(name, itemDto);
    }

    @DeleteMapping("/{name}")
    public void deleteItem(@PathVariable String name) {
        itemService.deleteItem(name);
    }
}
