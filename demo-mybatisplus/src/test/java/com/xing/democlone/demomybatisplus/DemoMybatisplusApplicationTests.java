package com.xing.democlone.demomybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xing.democlone.demomybatisplus.dao.UserDao;
import com.xing.democlone.demomybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoMybatisplusApplicationTests {

    @Autowired
    private UserDao userDao;
    @Test
    public void testGetAll() {
        List<User> userList = userDao.selectList(null);
        User user = userDao.selectById("4");
        System.out.println(userList);
        System.out.println(user);
    }

    @Test
    public void testsave(){
        User user=new User(234565665L,"xingweicheng","xj99081",23,"19117209086");
        userDao.insert(user);
    }


    @Test
    public void testdelete(){
        try {
            userDao.deleteById(234565665);
        }catch (Exception e){
            System.out.println("连接异常");
        }
    }


    //分页查询
    @Test
    void testSelectPage(){
        //1 创建IPage分页对象,设置分页参数,1为当前页码，3为每页显示的记录数
        IPage<User> page=new Page<>(1,3);
        //2 执行分页查询
        userDao.selectPage(page,null);
        //3 获取分页结果
        System.out.println("当前页码值："+page.getCurrent());
        System.out.println("每页显示数："+page.getSize());
        System.out.println("一共多少页："+page.getPages());
        System.out.println("一共多少条数据："+page.getTotal());
        System.out.println("数据："+page.getRecords());
    }



    @Test
    void testCondition() {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.select("id","name","age","tel");
        wrapper.lt("age",18);
        List<User> list=userDao.selectList(wrapper);
        System.out.println(list);
    }


    @Test
    void testLambda(){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.lambda().lt(User::getAge,18);
        List<User> list=userDao.selectList(wrapper);
        System.out.println(list);
    }
    @Test
    void testLambdaQueryWrapper(){
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<User>();
        lambdaQueryWrapper.lt(User::getAge,18).gt(User::getAge,8);
        List<User> userList = userDao.selectList(lambdaQueryWrapper);
        System.out.println(userList);
    }


   //    测试聚簇函数
   @Test
    void testGetOrder(){
        QueryWrapper<User> lqw = new QueryWrapper<User>();
        lqw.select("count(*) as count");
        //SELECT count(*) as count FROM user
        //lqw.select("max(age) as maxAge");
        //SELECT max(age) as maxAge FROM user
        //lqw.select("min(age) as minAge");
        //SELECT min(age) as minAge FROM user
        //lqw.select("sum(age) as sumAge");
        //SELECT sum(age) as sumAge FROM user
//        lqw.select("avg(age) as avgAge");
        //SELECT avg(age) as avgAge FROM user
        List<Map<String, Object>> userList = userDao.selectMaps(lqw);
        System.out.println(userList);
 }
// 测试分组查询
//SELECT count(*) as count,tel FROM user GROUP BY tel
    @Test
    void testGroup(){
        QueryWrapper<User> lqw = new QueryWrapper<User>();
        lqw.select("count(*) as count,tel");
        lqw.groupBy("tel");
        List<Map<String, Object>> list = userDao.selectMaps(lqw);
        System.out.println(list);
    }
}
