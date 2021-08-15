package semi.project.mapper;

import java.util.List;

import semi.project.domain.SubjectVo;

public interface SubjectMapper {
	String selectBySucode(String sucode);
	String selectBySkeep(String sucode);
	
	List<SubjectVo> selectAll(SubjectVo subjectVo);
	void suinsert(SubjectVo subjectVo);
}
