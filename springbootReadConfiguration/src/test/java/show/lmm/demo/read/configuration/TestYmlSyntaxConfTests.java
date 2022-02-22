package show.lmm.demo.read.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import show.lmm.demo.read.configuration.core.conf.PersonInfoConf;
import show.lmm.demo.read.configuration.core.conf.TestYmlSyntaxConf;

import javax.annotation.Resource;

@EnableAutoConfiguration
@SpringBootTest
class TestYmlSyntaxConfTests {

	@Resource
	private TestYmlSyntaxConf testYmlSyntaxConf;
	@Resource
	private PersonInfoConf personInfo;

	/**
	 * 测试yml语法
	 */
	@Test
	void testYmlSyntaxConf() {
		System.out.println(testYmlSyntaxConf.toString());
		System.out.println(personInfo.toString());
	}

}
