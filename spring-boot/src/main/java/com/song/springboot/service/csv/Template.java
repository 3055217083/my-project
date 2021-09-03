package com.song.springboot.service.csv;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.9.1 13:49
 */
public class Template {
    @FieldWithCSV(num = 0, title = "档期")
    private String scheduleNo;
    @FieldWithCSV(num = 1, title = "款号", isOkNull = false)
    private Integer styleNo;
    @FieldWithCSV(num = 2, title = "促销进价")
    private BigDecimal price;
    @FieldWithCSV(num = 3, title = "门店")
    private String store;
    @FieldWithCSV(num = 4, title = "备注")
    private String remark;
    @FieldWithCSV(num = 5, title = "riQi",dateFormat = "yyyy-MM-dd")
    private Date date;

    public Template() {
    }

    public String getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(String scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    public Integer getStyleNo() {
        return styleNo;
    }

    public void setStyleNo(Integer styleNo) {
        this.styleNo = styleNo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
