package com.springBootAcadamy.lombok.service.impl;


import com.springBootAcadamy.lombok.dto.request.ItemSaveRequestDTO;

import com.springBootAcadamy.lombok.entity.Item;
import com.springBootAcadamy.lombok.repositary.ItemRepo;
import com.springBootAcadamy.lombok.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
//        Item item = new Item(
//                1,
//                itemSaveRequestDTO.getItemName(),
//                itemSaveRequestDTO.getMeasuringUnitType(),
//                itemSaveRequestDTO.getBalanceQty(),
//                itemSaveRequestDTO.getSupplierPrice(),
//                itemSaveRequestDTO.getSellingPrice(),
//                true
//
//        );
//        itemRepo.save(item);
//        return item.getItemName();
        Item item = modelMapper.map(itemSaveRequestDTO,Item.class);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemId()+"Saved sucessfully";
        }
        else{
            throw new DuplicateKeyException("Already Added");
        }

    }



}
