package com.quanment.app.model;

/**
 * Created by Family on 2019/2/8
 */
public class ChatDetailsBean {

    private int MsgType;
    private String MsgTime;
    private String MsgHeadIcon;
    private String MsgName;
    private String MsgContent;

    public int getMsgType() {
        return MsgType;
    }

    public void setMsgType(int msgType) {
        MsgType = msgType;
    }

    public String getMsgTime() {
        return MsgTime;
    }

    public void setMsgTime(String msgTime) {
        MsgTime = msgTime;
    }

    public String getMsgHeadIcon() {
        return MsgHeadIcon;
    }

    public void setMsgHeadIcon(String msgHeadIcon) {
        MsgHeadIcon = msgHeadIcon;
    }

    public String getMsgName() {
        return MsgName;
    }

    public void setMsgName(String msgName) {
        MsgName = msgName;
    }

    public String getMsgContent() {
        return MsgContent;
    }

    public void setMsgContent(String msgContent) {
        MsgContent = msgContent;
    }
}
