package spring.boot.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import spring.boot.backend.domain.Address;

import java.util.List;

@Repository
@Mapper
public interface AddressOracleMapper {
    List<Address> list();
    void insert(Address address);
    void delete(int seq);
}
