package com.springBootAcadamy.lombok.service.impl;


import com.springBootAcadamy.lombok.dto.CustomerDTO;
import com.springBootAcadamy.lombok.dto.request.CustomerUpdateDTO;
import com.springBootAcadamy.lombok.entity.Customer;
import com.springBootAcadamy.lombok.repositary.CustomerRepo;
import com.springBootAcadamy.lombok.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getConatactNumber(),
                customerDTO.getNic(),
                customerDTO.getSalary(),
                customerDTO.isActive()
        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {

         if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){
             Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
             customer.setCustomerName(customerUpdateDTO.getCustomerName());
             customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
             customer.setSalary(customerUpdateDTO.getSalary());
             customerRepo.save(customer);
             return customerUpdateDTO.getCustomerName()+" updated successfully";
         }
         else
         {
             throw new RuntimeException("No data Found for that id");
         }

    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(

                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getConatactNumber(),
                    customer.getSalary(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDTO;
        } else {
            throw new RuntimeException("No Customer");
        }


    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for(Customer customer:getAllCustomers)
        {
           CustomerDTO customerDTO = new CustomerDTO(
                   customer.getCustomerId(),
                   customer.getCustomerName(),
                   customer.getCustomerAddress(),
                   customer.getConatactNumber(),
                   customer.getSalary(),
                   customer.getNic(),
                   customer.isActive()
           );
           customerDTOList.add(customerDTO);
        }
            return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId))
        {
            customerRepo.deleteById(customerId);
            return "deleted sucessfully"+customerId;
        }
        else
        {
            throw new RuntimeException("No customer found in that Id");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {
        List<Customer> getAllCustomers = customerRepo.countAllByActiveEquals(activeState);
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for(Customer customer:getAllCustomers)
        {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getConatactNumber(),
                    customer.getSalary(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
}