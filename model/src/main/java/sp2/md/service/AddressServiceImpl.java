package sp2.md.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sp2.md.domain.Address;
import sp2.md.mapper.AddressMapper;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
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
