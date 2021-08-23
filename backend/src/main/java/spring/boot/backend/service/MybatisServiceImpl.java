package spring.boot.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.backend.domain.MybatisDTO;
import spring.boot.backend.mapper.MybatisMapper;

@Service
@AllArgsConstructor
public class MybatisServiceImpl implements MybaticService{

    private MybatisMapper mapper;

    @Override
    public MybatisDTO selectAll() {
        return mapper.selectMybatis();
    }
}
