package cn.wwq.dubbo;

import cn.wwq.dubbo.pojo.User;
import cn.wwq.dubbo.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboTest {

    @Reference
    private UserService userService;

    @Test
    public void dubboTest(){
        while (true){

            List<User> userList = userService.queryAll();
            for (User user : userList) {
                System.out.println(user);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
