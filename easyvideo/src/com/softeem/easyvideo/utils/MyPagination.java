package com.softeem.easyvideo.utils;

import java.util.ArrayList;
import java.util.List;

public class MyPagination {
    public List<Object> list = null; // 设置List类型对象list
    private int recordCount = 0; // 设置int类型变量recordCount
    private int pagesize = 0; // 设置int类型变量pagesize
    private int maxPage = 0; // 设置int类型变量maxPage
    
    /**
     * 初始化分页信息
     * 
     * @param list
     *            当前记录集合
     * @param Page
     *            页码
     * @param pagesize
     *            当前页数
     * @return
     */
    public List getInitPage(List list, int Page, int pagesize) {
        List<Object> newList = new ArrayList<Object>(); // 实例化List集合对象
        this.list = list; // 获取当前的记录集合
        recordCount = list.size(); // 获取当前的记录数
        this.pagesize = pagesize; // 获取当前页数
        this.maxPage = getMaxPage(); // 获取最大页码数
        try {
            for (int i = (Page - 1) * pagesize; i <= Page * pagesize - 1; i++) {
                try {
                    if (i >= recordCount) { // 当循环i大于最大页码数量，则程序中止
                        break;
                    }
                } catch (Exception e) {
                }
                newList.add((Object) list.get(i)); // 将查询的结果存放在List集合中
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newList; // 返回查询的结果
    }
    
    /**
     * 获取指定页数据
     * 
     * @param Page
     *            页码
     * @return
     */
    public List<Object> getAppointPage(int Page) {
        List<Object> newList = new ArrayList<Object>(); // 实例化List集合对象
        try {
            for (int i = (Page - 1) * pagesize; i <= Page * pagesize - 1; i++) {
                try {
                    if (i >= recordCount) { // 当循环i大于最大页码数量，则程序中止
                        break; // 程序中止
                    }
                } catch (Exception e) {
                }
                newList.add((Object) list.get(i)); // 将查询的结果存放在List集合中
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newList; // 返回指定页数的记录
    }
    
    /**
     * 获取最大记录数
     * 
     * @return
     */
    public int getMaxPage() {
        // 计算最大的记录数
        int maxPage = (recordCount % pagesize == 0) ? (recordCount / pagesize)
                : (recordCount / pagesize + 1);
        return maxPage; // 通过return关键字返回
    }
    
    /**
     * 获取总记录数
     * 
     * @return
     */
    public int getRecordSize() {
        return recordCount; // 通过return关键字返回记录总数
    }
    
    /**
     * 获取当前页数
     * 
     * @param str
     * @return
     */
    public int getPage(String str) {
        if (str == null) { // 当参数值为null，则将参数str赋值为0
            str = "0";
        }
        int Page = Integer.parseInt(str); // 将参数类型进行转换，并赋值为page变量
        if (Page < 1) { // 当Page变量小于1时将变量赋值为1
            Page = 1;
        } else {
            if (((Page - 1) * pagesize + 1) > recordCount) {
                Page = maxPage; // 将变量Page设置为最大页码数量
            }
        }
        return Page; // 通过return关键字返回当前页码数
    }
    
    /**
     * 输出记录导航
     * 
     * @param Page
     *            页码数
     * @param path
     *            页面名称
     * @param sign
     *            页面中参数的参数值
     * @return
     */
    public String printCtrl(int Page, String path, String sign) {
        // 从类中输出一个网页中的表格
        String strHtml = "<table width='370'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>当前页数：["
                + Page + "/" + maxPage + "]&nbsp;&nbsp;";
        try {
            if (Page > 1) {
                strHtml = strHtml + "<a href='" + path + "?Page=1&type=" + sign
                        + "'>第一页</a>";
                strHtml = strHtml + "&nbsp;&nbsp;<a href='" + path + "?Page="
                        + (Page - 1) + "&type=" + sign + "'>上一页</a>";
                // 如果当前页码数大于1，“第一页”及“上一页”超级链接存在
            }
            if (Page < maxPage) {
                strHtml = strHtml + "&nbsp;&nbsp;<a href='" + path + "?Page="
                        + (Page + 1) + "&type=" + sign
                        + "'>下一页</a>&nbsp;&nbsp; <a href='" + path + "?Page="
                        + maxPage + "&type=" + sign + "'>最后一页&nbsp;</a>";
                // 如果当前页码数小于最大页码数，“下一页”及“最后一页”超级链接存在
            }
            strHtml = strHtml + "</td></tr></table>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strHtml;
    }
    
    /**
     * 输出记录导航
     * 
     * @param Page
     *            当前页码数
     * @param path
     *            当前页面名称
     * @param id
     *            页面中参数的参数值
     * @return
     */
    public String printCtrl(int Page, String path, Integer id) {
        String strHtml = "<table width='370'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>当前页数：["
                + Page + "/" + maxPage + "]&nbsp;&nbsp;";
        try {
            if (Page > 1) {
                strHtml = strHtml + "<a href='" + path + "?Page=1&id=" + id
                        + "'>第一页</a>";
                strHtml = strHtml + "&nbsp;&nbsp;<a href='" + path + "?Page="
                        + (Page - 1) + "&id=" + id + "'>上一页</a>";
            }
            if (Page < maxPage) {
                strHtml = strHtml + "&nbsp;&nbsp;<a href='" + path + "?Page="
                        + (Page + 1) + "&id=" + id
                        + "'>下一页</a>&nbsp;&nbsp; <a href='" + path + "?Page="
                        + maxPage + "&id=" + id + "'>最后一页&nbsp;</a>";
            }
            strHtml = strHtml + "</td></tr></table>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strHtml;
    }
    
    /**
     * 输出记录导航
     * 
     * @param Page
     *            当前页码数
     * @param path
     *            当前页面名称
     * @return
     */
    public String printCtrl(int Page, String path) {
        String strHtml = "<table width='370'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>当前页数：["
                + Page + "/" + maxPage + "]&nbsp;&nbsp;";
        try {
            if (Page > 1) {
                strHtml = strHtml + "<a href='" + path + "?Page=1'>第一页</a>";
                strHtml = strHtml + "&nbsp;&nbsp;<a href='" + path + "?Page="
                        + (Page - 1) + "'>上一页</a>";
            }
            if (Page < maxPage) {
                strHtml = strHtml + "&nbsp;&nbsp;<a href='" + path + "?Page="
                        + (Page + 1) + "'>下一页</a>&nbsp;&nbsp; <a href='" + path
                        + "?Page=" + maxPage + "'>最后一页&nbsp;</a>";
            }
            strHtml = strHtml + "</td></tr></table>";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strHtml;
    }
    
}
