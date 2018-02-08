package top.geekarea.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 动态图片路径
 */
@Entity
@Table(name = "tell_img")
public class TellImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //主键
    @ManyToOne
    @JoinColumn(name = "tid")
    @JsonBackReference
    private Tell tell; //外键（与用户实体类是多对一关系）
    @NotNull
    private String url; //图片路径

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tell getTell() {
        return tell;
    }

    public void setTell(Tell tell) {
        this.tell = tell;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "TellImg{" +
                "id=" + id +
                ", tell=" + tell +
                ", url='" + url + '\'' +
                '}';
    }
}
