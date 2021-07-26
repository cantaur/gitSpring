package sp2.md.service;

import junit.framework.TestCase;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sp2.md.domain.Address;


@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/spring/applicationContext.xml") //이 파일을 이용해서 설정하여라
public class AddressServiceImplTest extends TestCase {
    @Setter(onMethod_ = {@Autowired}) //롬복에서 지원하는 인젝션
    private AddressService addressService;

//    @Test
//    public void testList() {
//        log.info("#AddressMapperTests addressMapper: "+addressService);
//        log.info("#AddressMapperTests testList(): "+addressService.list());
//    }

//    @Test
//    public void testInsert() {
//        Address address = new Address(-1,"양궁","파이팅",null);
//        addressService.insert(address);
//        log.info("#AddressMapperTests testInsert(): 수행 성공");
//    }


    @Test
    public void testDelete() {
        int seq = 5;
        addressService.delete(seq);
        log.info("#AddressMapperTests testDelete(): 수행 성공");

    }
}