package com.springBootAcadamy.lombok.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "customer")
@TypeDefs({
        @TypeDef(name="json",typeClass = JsonType.class)
})

public class Customer {
    @Id //using for primary key
    @Column(name="customer_id",length = 45) //desing table name and length in the table
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name="customer_name",length = 100,nullable = false)
    private String customerName;

    @Column(name="customer_address",length = 255)
    private String customerAddress;

    @Type(type ="json")
    @Column(name="contact_number",columnDefinition = "json")
    private ArrayList conatactNumber;

    @Column(name ="customer_salary")
    private double salary;

    @Column(name = "nic")
    private String nic;

    @Column(name ="active_state", columnDefinition ="TINYINT default 0")
    private boolean active;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerAddress, ArrayList conatactNumber, String nic,double salary ,boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.conatactNumber = conatactNumber;
        this.nic = nic;
        this.salary = salary;
        this.active = active;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public ArrayList getConatactNumber() {
        return conatactNumber;
    }

    public void setConatactNumber(ArrayList conatactNumber) {
        this.conatactNumber = conatactNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", conatactNumber=" + conatactNumber +
                ", salary=" + salary +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }
}
