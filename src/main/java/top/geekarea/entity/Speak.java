package top.geekarea.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 动态评论实体类
 */
@Entity
@Table(name = "speak")
public class Speak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //主键
    @OneToOne
    @JoinColumn(name = "uid")
    private User user; //外键
    @ManyToOne
    @JoinColumn(name = "tid")
    @JsonBackReference
    private Tell tell; //外键（与用户实体类是多对一关系）
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate; //回复的创建时间
    private String message; //回复的消息

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Tell getTell() {
        return tell;
    }

    public void setTell(Tell tell) {
        this.tell = tell;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"user\":")
                .append(user);
        sb.append(",\"tell\":")
                .append(tell);
        sb.append(",\"createDate\":\"")
                .append(createDate).append('\"');
        sb.append(",\"message\":\"")
                .append(message).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
