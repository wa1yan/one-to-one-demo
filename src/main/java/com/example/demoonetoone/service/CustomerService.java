package com.example.demoonetoone.service;

import com.example.demoonetoone.dao.AddressDao;
import com.example.demoonetoone.dao.CustomerDao;
import com.example.demoonetoone.entities.Address;
import com.example.demoonetoone.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    @Transactional //For getTransaction
    public void createDB(){
        Customer customer1 = new Customer("William","Playing Football");
        Customer customer2 = new Customer("Suzan","Travelling");

        Address address1 = new Address("Karmaryut","Yangon","12312");
        Address address2 = new Address("Hledan", "Yangon","34343");

        address1.setCustomer(customer1);
        address2.setCustomer(customer2);
        customer1.setAddress(address1);
        customer2.setAddress(address2);

        //save to database
        addressDao.save(address1);
        addressDao.save(address2);
        customerDao.save(customer1);
        customerDao.save(customer1);


    }

    @Transactional
    public Customer findCustomerById(int id){
        return customerDao.getById(id);
    }

    @Transactional
    public Address findAddressById(int id){
        return addressDao.getById(id);
    }
}
