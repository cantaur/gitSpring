package sp2.md.persistence;

import java.sql.Connection;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.extern.log4j.Log4j;
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/spring/applicationContext.xml") //이 파일을 이용해서 설정하여라
public class DataSourceTests {
    @Autowired //객체를 자동으로 주입
    private DataSource dataSource;

    @Test //해당 메소드에 대해 Test를 하라는 어노테이션
    public void testConnection() {
        try {
            log.info("#dataSource: " + dataSource);
            Connection con = dataSource.getConnection();
            log.info("#con: " + con);
        }catch(Exception e) {
            log.info("#testConnection() exception: " + e);
        }
    }
}