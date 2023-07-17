package ezen.pro.mapper;

import java.util.List;

import ezen.pro.domain.boardVO;

public interface boardmapper {
	
	// �Խñ� ���
	public void boardRegister(boardVO board);
	
	// �Խñ� �� ���� ��ȸ
	public boardVO getBoardDetail(int bno);
	
	// �Խñ� ����
	public void updateBoard(boardVO board);
	
	// �Խñ� ����
	public void deleteBoard(int bno);
	
	// ��ü �Խñ� ��� ��ȸ
	public List<boardVO> getAllBoard();
	
	// ����¡ ó���� �Խñ� ��� ��ȸ
	public List<boardVO> getPagingBoard(int offset, int limit);
}
