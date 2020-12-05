package com.yjf.config;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 余俊锋
 * @date 2020/12/5 11:38
 * @Description
 */
@Component
@ServerEndpoint("/xb_socket/{userId}")
public class WebSocketServer {

    public WebSocketServer() {
        System.out.println("WebSocketServer初始化了");
    }

    //当前在线人数
    private static int personCount = 0;
    //当前用户名
    private static Integer userId = 0;
    //所有会话对象
    private static Map<Integer, Session> sessions = new ConcurrentHashMap<>();

    private static DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH-mm-ss");


    public static int getPersonCount() {
        return personCount;
    }

    public static void setPersonCount(int personCount) {
        WebSocketServer.personCount = personCount;
    }

    public static Integer getuserId() {
        return userId;
    }

    public static void setuserId(Integer userId) {
        WebSocketServer.userId = userId;
    }

    public static Map<Integer, Session> getSessions() {
        return sessions;
    }

    public static void setSessions(Map<Integer, Session> sessions) {
        WebSocketServer.sessions = sessions;
    }

    public static DateFormat getDateFormat() {
        return dateFormat;
    }

    public static void setDateFormat(DateFormat dateFormat) {
        WebSocketServer.dateFormat = dateFormat;
    }

    @OnOpen()
    public void open(Session session, @PathParam("userId") Integer userId) {
        //建立连接
        personCount++;
        WebSocketServer.userId = userId;
        sessions.put(userId, session);
        String msg=userId + "上线啦" + dateFormat.format(new Date());
        System.out.println(msg);
        //this.sendMessageNot(msg);


    }

    @OnClose()
    public void close(Session session, @PathParam("userId") Integer userId) {
        //关闭连接
        personCount--;
        sessions.remove(userId);
        String msg= userId + "下线啦" + dateFormat.format(new Date());
        System.out.println(msg);
       // this.sendMessageNot(msg);
    }


    //群发消息
    public static void sendMessage(String msg) {
        Set<Integer> set = sessions.keySet();
        if (set.size()>0){
            for (Integer id : set) {
                Session session = sessions.get(id);
                session.getAsyncRemote().sendText(msg);
            }
        }

    }


    //部分发
    public static void sendMessage(List<Integer> ids, String msg) {
        if (ids!=null&&ids.size()>0){
            for (Integer id : ids) {
                Session session = sessions.get(id);
                if (session!=null){
                    session.getAsyncRemote().sendText(msg);
                }
            }
        }
    }

    //群发但是不发给自己
    //群发消息
    public static void sendMessageNot(Integer userId,String msg) {
        for (Integer id : sessions.keySet()) {
            if (id != userId) {
                Session session = sessions.get(id);
                if (session!=null){
                    session.getAsyncRemote().sendText(msg);
                }

            }
        }

    }

    //私发给userId
    public static void priSendMessage(Integer userId, String msg) {
           Session session = sessions.get(userId);
           if (session!=null){
               session.getAsyncRemote().sendText(msg);
           }
    }


}
