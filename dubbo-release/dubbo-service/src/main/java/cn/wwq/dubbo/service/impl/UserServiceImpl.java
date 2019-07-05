package cn.wwq.dubbo.service.impl;

import cn.wwq.dubbo.pojo.User;
import cn.wwq.dubbo.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	/**
	 * 实现查询，这里做模拟实现，不做具体的数据库查询
	 */
	public List<User> queryAll() {
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < 3; i++) {
			User user = new User();
			user.setAge(10 + i);
			user.setId(Long.valueOf(i + 1));
			user.setPassword("123456");
			user.setUsername("username_" + i);
			list.add(user);
		}
		System.out.println("---------Service 3------------");
		return list;
	}

}
