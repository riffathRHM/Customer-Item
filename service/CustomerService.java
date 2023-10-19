package com.springBootAcadamy.lombok.service;


import com.springBootAcadamy.lombok.dto.CustomerDTO;
import com.springBootAcadamy.lombok.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDTO CustomerDto);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);



    List<CustomerDTO> getAllCustomersByActiveState(boolean activeState);
}
