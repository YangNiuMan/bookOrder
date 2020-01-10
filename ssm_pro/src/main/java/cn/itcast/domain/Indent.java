package cn.itcast.domain;

import cn.itcast.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class Indent implements Serializable{

    private Integer id;
    private Double total;
    private Integer status;
    private String statusStr;
    private String name;
    private String phone;
    private String address;
    private Date systime;
    private String systimeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatusStr() {
        if (status==0){
            statusStr="未发货";
        }
        if(status==1){
            statusStr="已发货";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getSystime() {
        return systime;
    }

    public void setSystime(Date systime) {
        this.systime = systime;
    }

    public String getSystimeStr() {
        if(systime!=null){
            systimeStr = DateUtils.data2String(systime,"yyyy-MM-dd");
        }
        return systimeStr;
    }

    public void setSystimeStr(String systimeStr) {
        this.systimeStr = systimeStr;
    }
}
