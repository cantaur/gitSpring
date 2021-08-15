package semi.project.mapper;

import semi.project.domain.StudentVo;

public interface StudentMapper {
	String slogin(StudentVo studentVo); // 로그인용
	String sidck(String sid); // 선생 or 학생 구분
	void sinsert(StudentVo studentVo); // 회원가입
}
