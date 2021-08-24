package spring.boot.backend.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import spring.boot.backend.domain.Address;

import java.util.List;

@Repository
@Mapper
public interface AddressRestMapper {
	List<Address> list();
	void insert(Address address);
	void delete(long seq);

	//for Ajax
	Address selectBySeq(long seq);
	List<Address> selectByName(String name);
}
