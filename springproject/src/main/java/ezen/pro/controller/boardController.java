package ezen.pro.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ezen.pro.domain.boardVO;
import ezen.pro.service.boardService;

@Controller
@RequestMapping("/board")
public class boardController {

    private final boardService boardService;

    @Autowired
    public boardController(boardService boardService) {
        this.boardService = boardService;
    }

    // �Խñ� ��� ��ȸ
    @GetMapping("/main.do")
    public String getBoardList(Model model) {
        // �Խñ� ����� �����ͼ� �𵨿� �߰�
        List<boardVO> boardList = boardService.getAllBoard();
        model.addAttribute("boardList", boardList);
        return "list"; // ��� ������ ���ø����� �̵�
    }

    // �Խñ� �� ��ȸ
    @GetMapping("/detail")
    public String getBoardDetail(
            @RequestParam("bno") int bno,
            Model model
    ) {
        // �Խñ� �� ������ �����ͼ� �𵨿� �߰�
        boardVO board = boardService.getBoardDetail(bno);
        model.addAttribute("board", board);
        return "detail"; // �� ������ ���ø����� �̵��մϴ�.
    }

    // ���ο� �Խñ� �ۼ� ���� �����ֱ� ����
    @GetMapping("/add")
    public String showAddBoardForm(Model model) {
        model.addAttribute("board", new boardVO());
        return "addboard"; // ���ο� �Խñ� �ۼ� �� ���ø����� �̵�
    }

    // �Խñ� ����� ó��
    @PostMapping("/add")
    public String addBoard(
            @ModelAttribute("board") boardVO board,
            RedirectAttributes redirectAttributes
    ) {
        // ������ null�̰ų� ����ִ��� Ȯ��
        if (board.getBtie() == null || board.getBtie().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "������ ��� �� �� �����ϴ�.");
            return "redirect:/board/add";
        }

        // �����ͺ��̽��� ���ο� �Խñ� ���
        boardService.boardRegister(board);
        redirectAttributes.addFlashAttribute("message", "���ο� �Խñ� ����� �����Ͽ����ϴ�.");
        return "redirect:/board/list"; // ��� �������� �̵�
    }
    
    @GetMapping("/board/detail")
    public String getBoardDetail1(@RequestParam("bno") int bno, Model model) {
        // ��û�� �Խù��� �׽�Ʈ �Խù����� Ȯ���մϴ�.
        if (bno == 1) {
            // �׽�Ʈ �����͸� ����Ͽ� �Խù� ��ü�� �����մϴ�.
            boardVO board = new boardVO();
            board.setBno(1);
            board.setBtie("�׽�Ʈ �Խù� ����");
            board.setBwriter("�׽�Ʈ �ۼ���");
            board.setBcon("�׽�Ʈ ����");
            board.setCate("�׽�Ʈ ī�װ�");
            board.setBdate(new Date());

            // �׽�Ʈ �Խù��� �𵨿� �߰��մϴ�.
            model.addAttribute("board", board);
        } else {
            // ���񽺸� ���� ������ bno�� ������� �Խù� �� ������ �����ɴϴ�.
            boardVO board = boardService.getBoardDetail(bno);
            model.addAttribute("board", board);
        }
        
        return "detail"; // �� ���� ���ø��� ��ȯ�մϴ�.
    }

}
