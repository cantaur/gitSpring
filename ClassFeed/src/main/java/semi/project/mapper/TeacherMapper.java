package semi.project.mapper;

import semi.project.domain.TeacherVo;

public interface TeacherMapper {
	String tlogin(TeacherVo teacherVo);
	String tidck(String tid); // 선생 or 학생 구분
	void tinsert(TeacherVo teacherVo);
}
