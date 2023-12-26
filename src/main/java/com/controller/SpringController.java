package com.controller;

import com.dao.IStu;
import com.google.gson.Gson;
import com.service.SessionUtil;
import com.vo.Stu;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SpringController {
    IStu iStu = null;
    SqlSession session = null;

    @RequestMapping(value = "findAll",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String findAll() {
        SessionUtil sessionUtil = new SessionUtil();
        session = sessionUtil.getSession();
        String json = null;
        if (session != null) {
            iStu = session.getMapper(IStu.class);//装载接口类
            List<Stu> stus = iStu.findAll();
            json = new Gson().toJson(stus);
        }
        sessionUtil.destory();
        return json;
    }

    @RequestMapping(value = "insert",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insert(@RequestBody String json) throws Exception {
        Stu stu = new Gson().fromJson(json, Stu.class);
        SessionUtil sessionUtil = new SessionUtil();
        session = sessionUtil.getSession();
        if (session != null) {
            iStu = session.getMapper(IStu.class);//装载接口类
            iStu.insert(stu);
            session.commit();
        }
        sessionUtil.destory();
        return "插入成功";

    }

    @RequestMapping(value = "update",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String update(@RequestBody String json) throws Exception {
        Stu stu = new Gson().fromJson(json, Stu.class);
        SessionUtil sessionUtil = new SessionUtil();
        session = sessionUtil.getSession();
        if (session != null) {
            iStu = session.getMapper(IStu.class);//装载接口类
            iStu.update(stu);
            session.commit();
        }
        sessionUtil.destory();
        return "更新成功";
    }

    @RequestMapping(value = "delete",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String delete(@RequestBody String json) throws Exception {
        SessionUtil sessionUtil = new SessionUtil();
        session = sessionUtil.getSession();
        if (session != null) {
            iStu = session.getMapper(IStu.class);//装载接口类
            Stu stu=new Gson().fromJson(json,Stu.class);
            iStu.delete(stu.getId());
            session.commit();
        }
        sessionUtil.destory();
        return "删除成功";
    }
}
