package s3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Author: matthew
 * @ClassName PersonTest
 * @Date: 2019-10-02 15:33
 * @Version: 1.0.0
 * @description:
 */
public class PersonTest {

    @Test
    public void useAxe() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = null;
        person = (Person) ctx.getBean("chinese");
        person.useAxe();
    }
}