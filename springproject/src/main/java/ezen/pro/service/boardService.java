package ezen.pro.service;

import java.util.List;

import ezen.pro.domain.boardVO;

public interface boardService {

    List<boardVO> getAllBoard();  // ��ü �Խñ� ��� ��ȸ

    void boardRegister(boardVO board);  // �Խñ� ���

    void deleteBoard(int bno);  // �Խñ� ����

    boardVO getBoardDetail(int bno);  // �Խñ� �� ��ȸ
}
