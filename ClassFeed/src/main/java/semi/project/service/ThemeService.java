package semi.project.service;

import java.util.List;

import semi.project.domain.ThemeVo;

public interface ThemeService {
	String selectByThcodeS(String thcode);
	List<ThemeVo> selectAllS(String thcode);
	void thinsertS(ThemeVo themeVo);
	List<ThemeVo> selectBysucodeS(String sucode);
}
