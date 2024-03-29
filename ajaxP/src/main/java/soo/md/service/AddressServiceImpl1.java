package soo.md.service;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soo.md.domain.Address;
import soo.md.mapper.AddressMapper1;


@Service("addressService1")
public class AddressServiceImpl1 implements AddressService {
	@Autowired
	private AddressMapper1 addressMapper;
	
	@Override
	public List<Address> listS() {
		return addressMapper.list();
	}

	@Override
	public void insertS(Address address) {
		addressMapper.insert(address);
	}

	@Override
	public void deleteS(long seq) {
		addressMapper.delete(seq);
	}
}
