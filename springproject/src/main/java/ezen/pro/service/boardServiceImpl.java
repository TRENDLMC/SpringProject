package ezen.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.pro.domain.boardVO;
import ezen.pro.mapper.boardmapper;

@Service
public class boardServiceImpl implements boardService {

    private final boardmapper boardMapper;

    @Autowired
    public boardServiceImpl(boardmapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    // ��� �Խñ� ��������
    @Override
    public List<boardVO> getAllBoard() {
        return boardMapper.getAllBoard();
    }

    // �Խñ� ���
    @Override
    public void boardRegister(boardVO board) {
        boardMapper.boardRegister(board);
    }

    // �Խñ� ����
    @Override
    public void deleteBoard(int bno) {
        boardMapper.deleteBoard(bno);
    }

    // �Խñ� �� ��ȸ
    @Override
    public boardVO getBoardDetail(int bno) {
        return boardMapper.getBoardDetail(bno);
    }
}
