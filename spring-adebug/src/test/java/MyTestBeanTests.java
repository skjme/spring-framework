import cn.shukejian.springsource.test.bean.MyTestBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


public class MyTestBeanTests {

	@Test
	public void test1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("myBeanFactoryTest.xml");
		MyTestBean myTestBean = applicationContext.getBean("myTestBean", MyTestBean.class);
		System.out.println(myTestBean.getTestStr());
		Assert.assertEquals(myTestBean.getTestStr(), "1");
	}

	@Test
	public void testSimpleLoad(){

		ClassPathResource classPathResource = new ClassPathResource("myBeanFactoryTest.xml");
		BeanFactory bf = new XmlBeanFactory(classPathResource);
		MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
		Assert.assertEquals(myTestBean.getTestStr(), "testStr");
		System.out.println(myTestBean);

	}
}
