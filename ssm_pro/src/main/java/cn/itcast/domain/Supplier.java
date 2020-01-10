package cn.itcast.domain;

import java.io.Serializable;
//name,email,address,phoneNum,status
public class Supplier implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private String address;
    private String phoneNum;
    private Integer status;
    private String statusStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        if (status != null) {
            if (status == 0) {
                statusStr = "不正常";
            }

            if (status == 1) {
                statusStr = "正常";
            }
        }
        return statusStr;
    }


    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }
}
