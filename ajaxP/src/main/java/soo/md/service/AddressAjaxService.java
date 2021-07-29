package soo.md.service;

import soo.md.domain.Address;

import java.util.List;

public interface AddressAjaxService {
	List<Address> listS();
	void insertS(Address address);
	void deleteS(long seq);
	//for Ajax
	Address selectBySeqS(long seq);
	List<Address> selectByNameS(String name);
}
