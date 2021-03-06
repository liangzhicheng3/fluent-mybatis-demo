package com.liangzhicheng.common.page;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    /**
     * 当前页码
     */
    private int page;

    /**
     * 页面大小(每页数量)
     */
    private int pageSize;

    /**
     * 结果输出列表
     */
    private List<T> records;

    /**
     * 总数量
     */
    private int total;

    /**
     * 总页数
     */
    private int pages;

    /**
     * 上一页
     */
    private int prevPage;

    /**
     * 下一页
     */
    private int nextPage;

    /**
     * @description 分页处理
     * @param page
     * @param pageSize
     * @param records
     * @param total
     */
    public PageResult(int page, int pageSize, List<T> records, int total) {
        this.page = page;
        this.pageSize = pageSize;
        this.records = records;
        this.total = total;
        if(total <= pageSize){
            this.pages = 1;
            this.prevPage = 1;
            this.nextPage = 1;
            return;
        }
        this.pages = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        this.prevPage = this.page - 1 >= 1 ? this.page - 1 : 1;
        this.nextPage = this.page + 1  <= this.pages ? this.page + 1 : this.pages;
    }

}
