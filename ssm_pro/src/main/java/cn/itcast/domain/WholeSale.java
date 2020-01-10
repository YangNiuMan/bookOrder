package cn.itcast.domain;

import cn.itcast.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class WholeSale implements Serializable {

    private Integer id;
    private String cover;
    private String name;
    private String producter;
    private Integer number;
    private Integer submit;
 /*   private Date time;
    private String timeStr;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducter() {
        return producter;
    }

    public void setProducter(String producter) {
        this.producter = producter;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

/*    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTimeStr() {
        if(time!=null){
            timeStr = DateUtils.data2String(time,"yyyy-mm-dd");
        }
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }*/

    public Integer getSubmit() {
        return submit;
    }

    public void setSubmit(Integer submit) {
        this.submit = submit;
    }
}
