package com.example.shop.exception;

public class ErrorInfo<E> {
    private int status;
    private String errType;
    private String msgTitle;
    private String msgDetail;
    private String url;
    private E Data;

    public ErrorInfo() {}

    public ErrorInfo(int status, String errType, String msgTitle, String msgDetail, String url, E data) {
        this.status = status;
        this.errType = errType;
        this.msgTitle = msgTitle;
        this.msgDetail = msgDetail;
        this.url = url;
        Data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrType() {
        return errType;
    }

    public void setErrType(String errType) {
        this.errType = errType;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgDetail() {
        return msgDetail;
    }

    public void setMsgDetail(String msgDetail) {
        this.msgDetail = msgDetail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public E getData() {
        return Data;
    }

    public void setData(E data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "status=" + status +
                ", errType='" + errType + '\'' +
                ", msgTitle='" + msgTitle + '\'' +
                ", msgDetail='" + msgDetail + '\'' +
                ", url='" + url + '\'' +
                ", Data=" + Data +
                '}';
    }
}