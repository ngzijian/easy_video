package com.softeem.easyvideo.utils;

import java.util.ArrayList;
import java.util.List;

public class MyPagination {
    public List<Object> list = null; // ����List���Ͷ���list
    private int recordCount = 0; // ����int���ͱ���recordCount
    private int pagesize = 0; // ����int���ͱ���pagesize
    private int maxPage = 0; // ����int���ͱ���maxPage
    
    /**
     * ��ʼ����ҳ��Ϣ
     * 
     * @param list
     *            ��ǰ��¼����
     * @param Page
     *            ҳ��
     * @param pagesize
     *            ��ǰҳ��
     * @return
     */
    public List getInitPage(List list, int Page, int pagesize) {
        List<Object> newList = new ArrayList<Object>(); // ʵ����List���϶���
        this.list = list; // ��ȡ��ǰ�ļ�¼����
        recordCount = list.size(); // ��ȡ��ǰ�ļ�¼��
        this.pagesize = pagesize; // ��ȡ��ǰҳ��
        this.maxPage = getMaxPage(); // ��ȡ���ҳ����
        try {
            for (int i = (Page - 1) * pagesize; i <= Page * pagesize - 1; i++) {
                try {
                    if (i >= recordCount) { // ��ѭ��i�������ҳ���������������ֹ
                        break;
                    }
                } catch (Exception e) {
                }
                newList.add((Object) list.get(i)); // ����ѯ�Ľ�������List������
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newList; // ���ز�ѯ�Ľ��
    }
    
    /**
     * ��ȡָ��ҳ����
     * 
     * @param Page
     *            ҳ��
     * @return
     */
    public List<Object> getAppointPage(int Page) {
        List<Object> newList = new ArrayList<Object>(); // ʵ����List���϶���
        try {
            for (int i = (Page - 1) * pagesize; i <= Page * pagesize - 1; i++) {
                try {
                    if (i >= recordCount) { // ��ѭ��i�������ҳ���������������ֹ
                        break; // ������ֹ
                    }
                } catch (Exception e) {
                }
                newList.add((Object) list.get(i)); // ����ѯ�Ľ�������List������
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newList; // ����ָ��ҳ���ļ�¼
    }
    
    /**
     * ��ȡ����¼��
     * 
     * @return
     */
    public int getMaxPage() {
        // �������ļ�¼��
        int maxPage = (recordCount % pagesize == 0) ? (recordCount / pagesize)
                : (recordCount / pagesize + 1);
        return maxPage; // ͨ��return�ؼ��ַ���
    }
    
    /**
     * ��ȡ�ܼ�¼��
     * 
     * @return
     */
    public int getRecordSize() {
        return recordCount; // ͨ��return�ؼ��ַ��ؼ�¼����
    }
    
    /**
     * ��ȡ��ǰҳ��
     * 
     * @param str
     * @return
     */
    public int getPage(String str) {
        if (str == null) { // ������ֵΪnull���򽫲���str��ֵΪ0
            str = "0";
        }
        int Page = Integer.parseInt(str); // ���������ͽ���ת��������ֵΪpage����
        if (Page < 1) { // ��Page����С��1ʱ��������ֵΪ1
            Page = 1;
        } else {
            if (((Page - 1) * pagesize + 1) > recordCount) {
                Page = maxPage; // ������Page����Ϊ���ҳ������
            }
        }
        return Page; // ͨ��return�ؼ��ַ��ص�ǰҳ����
    }
    
    /**
     * �����¼����
     * 
     * @param Page
     *            ҳ����
     * @param path
     *            ҳ������
     * @param sign
     *            ҳ���в����Ĳ���ֵ
     * @return
     */
    public String printCtrl(int Page, String path, String sign) {
        // ���������һ����ҳ�еı��
        String strHtml = "<table width='370'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>��ǰҳ����["
                + Page + "/" + maxPage + "]&nbsp;&nbsp;";
        try {
            if (Page > 1) {
                strHtml = strHtml + "<a href='" + path + "?Page=1&type=" + sign
                        + "'>��һҳ</a>";
                strHtml = strHtml + "&nbsp;&nbsp;<a href='" + path + "?Page="
                        + (Page - 1) + "&type=" + sign + "'>��һҳ</a>";
                // �����ǰҳ��������1������һҳ��������һҳ���������Ӵ���
            }
            if (Page < maxPage) {
                strHtml = strHtml + "&nbsp;&nbsp;<a href='" + path + "?Page="
                        + (Page + 1) + "&type=" + sign
                        + "'>��һҳ</a>&nbsp;&nbsp; <a href='" + path + "?Page="
                        + maxPage + "&type=" + sign + "'>���һҳ&nbsp;</a>";
                // �����ǰҳ����С�����ҳ����������һҳ���������һҳ���������Ӵ���
            }
            strHtml = strHtml + "</td></tr></table>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strHtml;
    }
    
    /**
     * �����¼����
     * 
     * @param Page
     *            ��ǰҳ����
     * @param path
     *            ��ǰҳ������
     * @param id
     *            ҳ���в����Ĳ���ֵ
     * @return
     */
    public String printCtrl(int Page, String path, Integer id) {
        String strHtml = "<table width='370'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>��ǰҳ����["
                + Page + "/" + maxPage + "]&nbsp;&nbsp;";
        try {
            if (Page > 1) {
                strHtml = strHtml + "<a href='" + path + "?Page=1&id=" + id
                        + "'>��һҳ</a>";
                strHtml = strHtml + "&nbsp;&nbsp;<a href='" + path + "?Page="
                        + (Page - 1) + "&id=" + id + "'>��һҳ</a>";
            }
            if (Page < maxPage) {
                strHtml = strHtml + "&nbsp;&nbsp;<a href='" + path + "?Page="
                        + (Page + 1) + "&id=" + id
                        + "'>��һҳ</a>&nbsp;&nbsp; <a href='" + path + "?Page="
                        + maxPage + "&id=" + id + "'>���һҳ&nbsp;</a>";
            }
            strHtml = strHtml + "</td></tr></table>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strHtml;
    }
    
    /**
     * �����¼����
     * 
     * @param Page
     *            ��ǰҳ����
     * @param path
     *            ��ǰҳ������
     * @return
     */
    public String printCtrl(int Page, String path) {
        String strHtml = "<table width='370'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>��ǰҳ����["
                + Page + "/" + maxPage + "]&nbsp;&nbsp;";
        try {
            if (Page > 1) {
                strHtml = strHtml + "<a href='" + path + "?Page=1'>��һҳ</a>";
                strHtml = strHtml + "&nbsp;&nbsp;<a href='" + path + "?Page="
                        + (Page - 1) + "'>��һҳ</a>";
            }
            if (Page < maxPage) {
                strHtml = strHtml + "&nbsp;&nbsp;<a href='" + path + "?Page="
                        + (Page + 1) + "'>��һҳ</a>&nbsp;&nbsp; <a href='" + path
                        + "?Page=" + maxPage + "'>���һҳ&nbsp;</a>";
            }
            strHtml = strHtml + "</td></tr></table>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strHtml;
    }
    
}
