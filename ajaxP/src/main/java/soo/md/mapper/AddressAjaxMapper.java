package soo.md.mapper;

import soo.md.domain.Address;

import java.util.List;

public interface AddressAjaxMapper {
	List<Address> list();
	void insert(Address address);
	void delete(long seq);

	//for Ajax
	Address selectBySeq(long seq);
	List<Address> selectByName(String name);
}
