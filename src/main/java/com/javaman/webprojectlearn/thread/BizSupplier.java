package com.javaman.webprojectlearn.thread;

import java.time.LocalDate;
import java.util.Date;

/**
 * @Author:靓仔
 * @Since：2024/02/24
 * @Description:
 */
public class BizSupplier {
    private Date startDate;
    private Date endDate;
    private Date planDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }
}
