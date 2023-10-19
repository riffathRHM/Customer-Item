package com.springBootAcadamy.lombok.service;

import com.springBootAcadamy.lombok.dto.request.ItemSaveRequestDTO;

public interface ItemService {
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);
}
