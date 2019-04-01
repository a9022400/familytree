package com.gunner.condition;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.session.RowBounds;

/**
 * @author makejava
 * @since 2019-03-26 15:58:27
 */
public class BaseCondition {

    private static final int DEFAULT_PAGE_NO = 1;
    private static final int DEFAULT_PAGE_LIMIT = 10;

    /** 默认第一页*/
    private Integer pageNo = DEFAULT_PAGE_NO;

    /** 默认每页十条*/
    private Integer pageLimit = DEFAULT_PAGE_LIMIT;


    public PageRowBounds getPageRowBounds() {
        return new PageRowBounds(getOffset(),pageLimit);
    }

    public int getOffset() {
        if(pageNo >=1) {
            return (pageNo - 1) * pageLimit;
        }
        return RowBounds.NO_ROW_OFFSET;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageLimit() {
        return pageLimit;
    }

    public void setPageLimit(Integer pageLimit) {
        this.pageLimit = pageLimit;
    }
}
