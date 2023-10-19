package com.springBootAcadamy.lombok.dto.request;


import com.springBootAcadamy.lombok.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSaveRequestDTO {


    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;


}
