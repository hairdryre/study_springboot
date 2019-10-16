package com.zhoutianyu.learnspringboot.interceptor;


import com.github.pagehelper.PageRowBounds;

public final class PageHelperThreadLocal {

    private static final ThreadLocal<PageRowBounds> PAGE_INFO = new ThreadLocal<>();

    /**
     * 为调用的线程存储 线程局部变量 PageRowBounds（分页信息封装在此对象里）
     */
    public static void setPageInfo(PageRowBounds rowBounds) {
        PAGE_INFO.set(rowBounds);
    }

    /**
     * 获取调用此方法的线程的 线程局部变量 PageRowBounds
     */
    public static PageRowBounds getPageInfo() {
        return PAGE_INFO.get();
    }

    /**
     * 清除掉当前线程中的线程局部变量
     */
    public static void clean() {
        PAGE_INFO.remove();
    }
}
