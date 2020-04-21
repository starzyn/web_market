package com.qf.market.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/baseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        //接受请求中的方法名
        String methodName = req.getParameter("method");
        //得到当前请求的servlet的反射对象
        Class clazz = this.getClass();
        //通过方法名得到方法的反射对象
        try {
            Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //用方法的反射对象调用对应的servlet的方法
            method.setAccessible(true);
            //接受返回结果
            String res = (String) method.invoke(this, req, resp);
            //根据结果来判断转发还是重定向或者是ajax
            String route = res.split(":")[0];
            String urlOrStr = res.split(":")[1];
            if ("dis".equals(route)) {//是转发
                req.getRequestDispatcher(urlOrStr).forward(req, resp);
            } else if ("red".equals(route)) {//是重定向
                resp.sendRedirect(urlOrStr);
            } else if ("ajax".equals(route)) {//是ajax
                resp.getWriter().write(urlOrStr);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author starzyn
     * @Description 实现Javabean的作用
     * @Date 10:15 2020/4/16
     * @Param [clazz, req, resp]
     * @return T
     **/
    public <T> T requestMap(Class<T> clazz, HttpServletRequest req, HttpServletResponse resp) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Map<String, String[]> vals = req.getParameterMap();
        //处理请求中数据，将请求接受的values值转化为String
        Map<String, String> hmap = new HashMap<>();
        for (String key : vals.keySet()) {
            //参数的key名对应的值转化为字符串
            String newVal = Arrays.toString(vals.get(key));
            hmap.put(key, newVal.substring(1, newVal.length() - 1));
        }
        //将接收值用反射封装到实例对象中，前提条件是实例对象的属性名与接收参数的value值一一对相应
        T t1 = clazz.newInstance();
        //获得当前对象的所有属性，然后再进行赋值
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            String res = hmap.get(f.getName());
            if (res !=null && !("".equals(res))) {
                f.set(t1, hmap.get(f.getName()));
            }
        }
//        for(String key:hmap.keySet()){
//            //将反射对象获得属性的反射对象，key名与对象属性名一一对应
//            Field f = clazz.getDeclaredField(key);
//            f.setAccessible(true);
//            f.set(t1,hmap.get(key));
//        }
        return t1;
    }
}