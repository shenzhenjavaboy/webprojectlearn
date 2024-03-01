package com.javaman.webprojectlearn.service.impl;

import com.javaman.webprojectlearn.dao.impl.UserDaoImpl;
import com.javaman.webprojectlearn.pojo.User;
import com.javaman.webprojectlearn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDaoImpl userDao;

    //查询用户
    @Override
    public List<User> query() throws Exception {
        return userDao.query();
    }

    //增加用户
    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    //修改用户
    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    //删除用户
    public Integer deleteUser(User user){
        return userDao.deleteUser(user);
    }

    @Override
    public void getExcel() {

      /*  //创建Excel文件
        String[] title= {"姓名","课程名","分数"};
        File file=new File("f:/sheet1.xls");
        try {
            file.createNewFile();
            //创建工作簿
            WritableWorkbook  workbook=Workbook.createWorkbook(file);
            //创建Sheet
            WritableSheet sheet=workbook.createSheet("表格一", 20);
            //第一行设置列名
            Label label=null;
            for (int i = 0; i < title.length; i++) {
                label=new Label(i, 0, title[i]);//第一个参数为列,第二个为行
                sheet.addCell(label);
            }
            Data data=new Data();
            ResultSet rs=data.getString();
            while(rs.next()) {
                System.out.println(rs.getString(1));
                label=new Label(0,rs.getRow(),rs.getString(1));
                sheet.addCell(label);
                label=new Label(1,rs.getRow(),rs.getString(2));
                sheet.addCell(label);
                label=new Label(2,rs.getRow(),rs.getString(3));
                sheet.addCell(label);
            }
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/


    }
}
