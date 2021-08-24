package spring.boot.backend.mapper;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.boot.backend.domain.Address;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Log
@AllArgsConstructor
class AddressMapperTest {
    private AddressMapper mapper;

    @Test
    void list() {
        log.info("#AddressMapperTest mapper: "+mapper);
        log.info("#AddressMapperTest mapper: "+mapper.list());
    }

    @Test
    void insert() {
        Address address = new Address(-1, "오늘은", "화요일", null);
        mapper.insert(address);
        log.info("#AddressMapperTest insert() 수행 완료!");
    }

    @Test
    void delete() {
        int seq = 9;
        mapper.delete(seq);
        log.info("#AddressMapperTest delete() 수행 완료!");
    }
}