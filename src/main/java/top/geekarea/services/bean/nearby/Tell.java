package top.geekarea.services.bean.nearby;

import java.util.List;

/**
 * 附近模块用户动态实体类
 */
public class Tell {

    private String userName; //用户名
    private String nickName; //昵称
    private String headPictureUrl; //头像图片url
    private String dateTimeAndDistance; //时间和距离
    private int goodNum; //点赞次数
    private int speachNum; //评论次数
    private int shareNum; //分享次数
    private String postMsg; //动态主要内容
    private List<String> imgUrl; //图片内容url
    private List<Speak> speak; //评论内容

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

    public String getDateTimeAndDistance() {
        return dateTimeAndDistance;
    }

    public void setDateTimeAndDistance(String dateTimeAndDistance) {
        this.dateTimeAndDistance = dateTimeAndDistance;
    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }

    public int getSpeachNum() {
        return speachNum;
    }

    public void setSpeachNum(int speachNum) {
        this.speachNum = speachNum;
    }

    public int getShareNum() {
        return shareNum;
    }

    public void setShareNum(int shareNum) {
        this.shareNum = shareNum;
    }

    public String getPostMsg() {
        return postMsg;
    }

    public void setPostMsg(String postMsg) {
        this.postMsg = postMsg;
    }

    public List<String> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Speak> getSpeak() {
        return speak;
    }

    public void setSpeak(List<Speak> speak) {
        this.speak = speak;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userName\":\"")
                .append(userName).append('\"');
        sb.append(",\"nickName\":\"")
                .append(nickName).append('\"');
        sb.append(",\"headPictureUrl\":\"")
                .append(headPictureUrl).append('\"');
        sb.append(",\"dateTimeAndDistance\":\"")
                .append(dateTimeAndDistance).append('\"');
        sb.append(",\"goodNum\":")
                .append(goodNum);
        sb.append(",\"speachNum\":")
                .append(speachNum);
        sb.append(",\"shareNum\":")
                .append(shareNum);
        sb.append(",\"postMsg\":\"")
                .append(postMsg).append('\"');
        sb.append(",\"imgUrl\":")
                .append(imgUrl);
        sb.append(",\"speak\":")
                .append(speak);
        sb.append('}');
        return sb.toString();
    }
}
