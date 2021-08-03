package sp2.md.mapper;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface TxSample2Mapper {
    @Insert("insert into tbl_sample2 values(#{data})")
    public int insertCol2(String data);
}
