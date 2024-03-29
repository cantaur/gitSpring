package sp2.md.mapper;

import org.springframework.stereotype.Repository;
import sp2.md.domain.Address;

import java.util.List;

@Repository
public interface AddressMapper1 {
    List<Address> list();
    void insert(Address address);
    void delete(int seq);
}
