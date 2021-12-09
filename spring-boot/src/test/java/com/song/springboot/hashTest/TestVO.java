package com.song.springboot.hashTest;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TestVO implements Serializable {
    /**
     * 大区
     */
    private String pgSeq;

    /**
     * 类型
     */
    private String category;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;
    private String ggggg;
    public TestVO() {
    }

    public TestVO(String pgSeq, String category, Date startTime, Date endTime) {
        this.pgSeq = pgSeq;
        this.category = category;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TestVO(String pgSeq, String category, Date startTime, Date endTime, String ggggg) {
        this.pgSeq = pgSeq;
        this.category = category;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ggggg = ggggg;
    }

    public String getPgSeq() {
        return pgSeq;
    }

    public void setPgSeq(String pgSeq) {
        this.pgSeq = pgSeq;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestVO)) return false;
        TestVO testVO = (TestVO) o;
        return getPgSeq().equals(testVO.getPgSeq())
                && getCategory().equals(testVO.getCategory())
                && getStartTime().getTime() >= (testVO.getEndTime().getTime())
                && getEndTime().getTime() <= testVO.getStartTime().getTime();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPgSeq(), getCategory());
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
