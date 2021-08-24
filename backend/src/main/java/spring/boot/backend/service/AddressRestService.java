package spring.boot.backend.service;


import spring.boot.backend.domain.Address;

import java.util.List;

public interface AddressRestService {
	List<Address> listS();
	void insertS(Address address);
	void deleteS(long seq);
	//for Ajax
	Address selectBySeqS(long seq);
	List<Address> selectByNameS(String name);
}
