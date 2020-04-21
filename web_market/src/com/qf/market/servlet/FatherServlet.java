package com.qf.market.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
*   公共servlet,重写HttpServlet的service()
 *  @author sx
 *  @version 1.0 2020-04-03
*/
@WebServlet("/FatherServlet")
public class FatherServlet extends HttpServlet {
    /**
    *重写父类HttpServlet的service方法
    */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码和响应的编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        try {
            //接收请求中方法名
            String methodName=request.getParameter("method");

            //得到当前请求Servlet的反射对象,this指代是请求的Servlet
            Class servletClass=this.getClass();

            //通过方法名得到方法的反射对象
            Method methodObject=servletClass.getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            //设置方法的权限
            methodObject.setAccessible(true);
            //用方法的反射对象调用对应Servlet中方法,将方法返回结果转换为String接收,因为我们设定servlet中所有方法返回String.  this指代是请求的Servlet
            String result= methodObject.invoke(this,request,response).toString();

            //根据方法返回结果来判断是转发还是重定向还是ajax
            //result="url" 转发
            //result="redirect:url"   实现重定向
            //result="ajax:String"  响应字符串给ajax引擎
            if (result.startsWith("redirect:")){//重定向
                //将重定向的url从result拆分出来
                String url=result.substring(result.indexOf(":")+1);
                System.out.println("*****"+url);
                //重定向
                response.sendRedirect(url);
            }else if(result.startsWith("ajax:")){//响应给ajax引擎
                //将响应的内容拆分出来
                String content=result.substring(result.indexOf(":")+1);
                //将内容响应给ajax引擎对象
                response.getWriter().write(content);
            }else{//转发
                request.getRequestDispatcher(result).forward(request,response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    *用一个对象接收请求中参数的数据
    *@param clazz, request, response
    *@return
    */
    public <T> T requestMap(Class<T> clazz,HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        //1.用请求对象接收请求中所有参数
        Map<String,String[]> values= request.getParameterMap();
        /*2.处理请求中数据,将请求中接收value值转换String*/
        //声明一个新集合存请求中处理数据
        Map<String,String> hmap=new HashMap<String, String>();
        //遍历原来的集合,将原来的数据处理完后复制新集合中
        for (String key:values.keySet()){
            if (key!=""){
                //将参数的value值String[]转换为string,[eat,sleep]
                String newValue=Arrays.toString(values.get(key));
                System.out.println("###"+newValue.substring(1,newValue.length()-1));
                //将接收值存新集合中
                hmap.put(key, newValue.substring(1,newValue.length()-1));
            }
        }

        /*3.将接收值用反射封装到实例对象中,前提条件是实例对象的属性名与接收参数的key值一一对应*/
        //用反射对象获得实例对象
        T t1=clazz.newInstance();
        //获得当前对象的所有属性的反射对象,通过属性名与Key名相同,这样属性名就存在,不会报异常
        Field[] fields=clazz.getDeclaredFields();
        //遍历属性的反射对象,将属性值设置到实例对象中
        for (Field f1:fields){
            //属性名与参数的key名一致,如果属性值没传过来就不用设置
            if (hmap.get(f1.getName())!=null&&!hmap.get(f1.getName()).equals("")){
                //设置属性权限
                f1.setAccessible(true);
                //用属性的反射对象,将属性值设置到实例对象 null,""," "
                f1.set(t1,hmap.get(f1.getName()));
            }
        }

        return t1;
    }
}
