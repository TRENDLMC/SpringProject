package ezen.pro.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class boardVO {
    private int bno;          // ��ȣ
    private String bcon;      // ����
    private String btie;      // ����
    private String bwriter;   // �۾���
    private String cate;      // ī�װ�
    private Date bdate;       // �����
    private String imageurl;  // �̹��� URL �߰�
    
    // imageurl�� getter �޼��� �߰�
    public String getImageurl() {
        return imageurl;
    }
}
