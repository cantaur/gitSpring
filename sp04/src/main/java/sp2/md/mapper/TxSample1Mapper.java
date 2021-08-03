package sp2.md.mapper;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface TxSample1Mapper {
    @Insert("insert into tbl_sample1 values(#{data})")
    public int insertCol1(String data);
}

