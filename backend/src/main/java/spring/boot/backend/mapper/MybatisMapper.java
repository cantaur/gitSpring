package spring.boot.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import spring.boot.backend.domain.MybatisDTO;


@Repository
@Mapper
public interface MybatisMapper {
    MybatisDTO selectMybatis();
}
