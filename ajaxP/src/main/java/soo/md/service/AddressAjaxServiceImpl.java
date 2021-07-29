package soo.md.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import soo.md.domain.Address;
import soo.md.mapper.AddressAjaxMapper;

import java.util.List;

@Log4j
@AllArgsConstructor
@Service
public class AddressAjaxServiceImpl implements AddressAjaxService{
    private AddressAjaxMapper mapper;

    @Override
    public List<Address> listS() {

        return mapper.list();
    }

    @Override
    public void insertS(Address address) {
        mapper.insert(address);

    }

    @Override
    public void deleteS(long seq) {
        mapper.delete(seq);

    }

    @Override
    public Address selectBySeqS(long seq) {
        return mapper.selectBySeq(seq);
    }

    @Override
    public List<Address> selectByNameS(String name) {
        return mapper.selectByName(name);
    }
}
