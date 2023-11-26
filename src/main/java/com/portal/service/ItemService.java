package com.portal.service;

import com.portal.controller.ItemDto;
import com.portal.enttiy.Item;
import com.portal.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {
    
    private final ItemRepository itemRepository;
    
    public Page<Item> getItems(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }
    public Item getItem(String name) {
        return itemRepository.findByName(name)
                .orElseThrow(() -> {
                    return new EntityNotFoundException("ITEM_NOT_FOUND");
                });
    }


    public void deleteItem(String name) {
    }

    public Item createItem(ItemDto itemDto) {
        return null;
    }

    public Item updateItem(String name, ItemDto itemDto) {
        return null;
    }
}
