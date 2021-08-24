package spring.boot.backend.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import spring.boot.backend.domain.Address;
import spring.boot.backend.mapper.AddressRestMapper;
import java.util.List;


@Log
@AllArgsConstructor
@Service
public class AddressRestServiceImpl implements AddressRestService {
    private AddressRestMapper mapper;

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
