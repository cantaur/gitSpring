package spring.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.backend.domain.Address;
import spring.boot.backend.mapper.AddressMapper;
import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{

    private AddressMapper addressMapper;

    @Override
    public List<Address> list() {
        return addressMapper.list();
    }

    @Override
    public void insert(Address address) {
        addressMapper.insert(address);
    }

    @Override
    public void delete(int seq) {
        addressMapper.delete(seq);
    }
}
