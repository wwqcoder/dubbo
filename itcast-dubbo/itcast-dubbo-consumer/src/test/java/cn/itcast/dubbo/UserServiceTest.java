package cn.itcast.dubbo;

import cn.itcast.dubbo.pojo.User;
import cn.itcast.dubbo.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Reference(version = "1.0.0", loadbalance = "roundrobin")
    private UserService userService;

    @Test
    public void testQueryAll() {
        for (int i = 0; i < 100; i++) {

            System.out.println("开始调用远程服务 >>>>>" + i);

            List<User> users = this.userService.queryAll();
            for (User user : users) {
                System.out.println(user);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
