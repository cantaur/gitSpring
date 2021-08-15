package semi.project.mapper;

import java.util.List;

import semi.project.domain.ClassVo;
import semi.project.domain.SubjectVo;

public interface ClassMapper {
	List<SubjectVo> selectBySucode(String sucode);
	void insert(ClassVo classVo);
}
