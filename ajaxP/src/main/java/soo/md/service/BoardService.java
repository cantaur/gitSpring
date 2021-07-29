package soo.md.service;

import java.util.List;
import soo.md.domain.Address;
import soo.md.domain.Board;
import soo.md.domain.BoardListResult;


public interface BoardService {
	BoardListResult getBoardListResult(int cp, int ps);
	Board getBoard(long seq);

	void write(Board board);
	void edit(Board board);
	void remove(long seq);
}
