package sp2.md.service;

import junit.framework.TestCase;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/spring/applicationContext.xml")
public class SampleLogServiceTest extends TestCase {
    @Setter(onMethod_ = {@Autowired})
    private SampleLogService service;

    @Test
    public void testAdd() throws Exception{
        int result = service.add("10", "20");
        log.info("#testAdd() result: " + result);
    }

//    @Test
//    public void addError() throws Exception{
//        int result = service.add("10", "호랑이");
//        log.info("#testAdd() result: " + result);
//    }

}