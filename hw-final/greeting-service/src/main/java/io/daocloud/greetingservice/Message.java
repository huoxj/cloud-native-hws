package io.daocloud.greetingservice;

public class Message {
    public Message() {
        msg = "Hello there";
    }
    String msg;

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Message && (((Message) (obj)).msg.equals(msg));
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
