package spring.boot.backend.service;

import spring.boot.backend.domain.Address;
import java.util.List;


public interface AddressService {
    List<Address> list();
    void insert(Address address);
    void delete(int seq);
}



