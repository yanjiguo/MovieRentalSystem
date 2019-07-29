1，软件的基本功能

```
软件主要的功能：实现了将功能链接全部显示在index.jsp页面（包括对客户信息的增、删、查、改；以及分页信息显示）。
```

​    实现了登录的判断并将First_name保存在session中，实现了客户信息列表的展示（同时进行了分页，每页显示10条数据，可以点击任意的页码）和客户信息的添加、删除、编辑。实现了登录过滤的处理，在没有登录之前所有的链接访问之后都跳转到index.jsp页面。
​    但是对于含有login的和登录请求的LoginServlet以及静态资源不拦截。
2，运行代码的方法：安装环境，启动命令等
   项目使用的数据库：mysql5.0  用户名  root 密码  123456
   在项目的resources文件夹中的db.properties中关于数据库的配置文件
   整个项目使用的是tomcat7的插件在maven中配置： 

```
 <plugin>
           <groupId>org.apache.maven.plugins</groupId>
           <artifactId>maven-compiler-plugin</artifactId>
           <version>3.6.1</version>
           <configuration>
           <source>1.8</source>
           <target>1.8</target>
           </configuration>
           </plugin>
 <!--配置tomcat插件 -->
 <plugin>
           <groupId>org.apache.tomcat.maven</groupId>
           <artifactId>tomcat7-maven-plugin</artifactId>
           <version>2.2</version>
           <configuration>
           <path>/</path>
           <port>8080</port>
           </configuration>
 </plugin>
  <!--配置Mybatis反向代理的插件-->
      <plugin>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-maven-plugin</artifactId>
        <version>1.3.2</version>
        <configuration>
          <verbose>true</verbose>
          <overwrite>true</overwrite>
        </configuration>
      </plugin>
```

   Idea中使用maven中tomcat插件来启动服务器配置tomcat点击：Edit Configurations ——》“点击+”  ——》Maven
   ——》"填写Name”<内容为tomcat7：run>——》“填写command line”<内容为：clean tomcat7：run>

   项目的启动：点击Maven中的Run Configurations下面的tomcat7：run             
3，简要的使用说明

```
   项目启动成功之后：浏览器中输入：http://localhost:8080，显示登录页面login.jsp，点击登录输入姓名：PATRICI
```

   点击登录按钮，如果不输入或者输入错误会提示你输入的姓名错误,请从新输入；登录成功之后跳转到首页并且分页显示客户的信息。分页按钮可以实现对页面的客户信息显示。
   显示列表信息可以点击删除和编辑，删除后页面异步刷新；点击编辑后弹出编辑框，编辑失败会有提示。
   在index.jsp页面中点击新建跳转的新建页面并且可以新增客户的信息。添加成功后会有提示信息，点击左边的按钮继续到达index.jsp页面。
​             
4，代码目录结构说明，更详细点可以说明软件的基本原理
   com.yjg.controller--包含前端的请求，并且对前端请求处理。
   com.yjg.service--包含对业务层的处理的接口。
   com.yjg.service.impl--包含对业务层接口的具体实现。
   com.yjg.pojo--包含了与数据库映射的字段。
   com.yjg.vo--包含了对前端一些字段的封装

   com.yjg.mapper--包含了处理数据库增删查改的一些接口和.xml文件。

   webapp目录下面包含了所有的页面和web.xml和一些jsp页面

   resources文件夹中包含了各种对spring、spring-mybatis、springMVC的配置文件和数据库的配置文件。

   pom.xml--包含了一些插件和一些使用的jar包