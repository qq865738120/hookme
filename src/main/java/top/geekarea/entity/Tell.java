package top.geekarea.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户动态实体类
 * Created by Hasee on 2017/3/20.
 */
@Entity
@Table(name = "tell")
public class Tell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate; //创建时间
    @ManyToOne
    @JoinColumn(name = "uid")
    @JsonBackReference
    private User user; //外键（与用户实体类是多对一关系）
    private String data; //具体内容
    private double longitude; //经度
    private double latitude; //纬度
    private Integer goodNum; //点赞次数
    private Integer speackNum; //评论次数
    private Integer shareNum; //分享次数

    public Tell(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public Integer getSpeackNum() {
        return speackNum;
    }

    public void setSpeackNum(Integer speackNum) {
        this.speackNum = speackNum;
    }

    public Integer getShareNum() {
        return shareNum;
    }

    public void setShareNum(Integer shareNum) {
        this.shareNum = shareNum;
    }

    @Override
    public String toString() {
        return "Tell{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", user=" + user +
                ", data='" + data + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", goodNum=" + goodNum +
                ", speackNum=" + speackNum +
                ", shareNum=" + shareNum +
                '}';
    }
}
