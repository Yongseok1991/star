package com.erp.star;

import com.erp.star.com.user.KwareUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class StarApplicationTests {

	@Test
	@DisplayName("생성 테스트")
	void contextLoads() {


		List<KwareUser> userList = new ArrayList<>();

		for(int i=1; i<= 100; i++) {
			KwareUser user = KwareUser.builder()
							.userId("kware1234" + i)
							.approveAt("N")
							.telNo("01050232463")
							.passWd("*******")
							.email("kware2463@naver.com"+ i)
							.userNm("김용석" + i)
							.build();

			userList.add(user);
		}

		userList.forEach(System.out::println);

	}

}
