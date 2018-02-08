package top.geekarea.services.bean.nearby;

/**
 * 附近模块动态评论实体类
 */
public class Speak {

    private String timeout; //评论距离现在的时间
    private String userName; //用户名
    private String nickName; //昵称
    private String headPictureUrl; //用户头像
    private String speakMsg; //评论内容

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadPictureUrl() {
        return headPictureUrl;
    }

    public void setHeadPictureUrl(String headPictureUrl) {
        this.headPictureUrl = headPictureUrl;
    }

    public String getSpeakMsg() {
        return speakMsg;
    }

    public void setSpeakMsg(String speakMsg) {
        this.speakMsg = speakMsg;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"timeout\":\"")
                .append(timeout).append('\"');
        sb.append(",\"userName\":\"")
                .append(userName).append('\"');
        sb.append(",\"nickName\":\"")
                .append(nickName).append('\"');
        sb.append(",\"headPictureUrl\":\"")
                .append(headPictureUrl).append('\"');
        sb.append(",\"speakMsg\":\"")
                .append(speakMsg).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
