package com.springBootAcadamy.lombok.controller;


import com.springBootAcadamy.lombok.dto.CustomerDTO;
import com.springBootAcadamy.lombok.dto.request.ItemSaveRequestDTO;
import com.springBootAcadamy.lombok.dto.response.ItemGetResponseDTO;
import com.springBootAcadamy.lombok.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){


       String message = itemService.saveItem(itemSaveRequestDTO);
        return "Saved";
    }
    @GetMapping(
            path ="/get-by-name",
            params = "name"
    )
    public List<>

}
