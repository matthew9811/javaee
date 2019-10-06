package s2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Author: matthew
 * @ClassName PersonTest
 * @Date: 2019-10-02 15:23
 * @Version: 1.0.0
 * @description:
 */
public class PersonTest {

    @Test
    public void sayHello() {
    }

    @Test
    public void sayBey() {
    }

    @Test
    public void Caller1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = null;
        person = (Person) ctx.getBean("Chinese");
        person.sayHello();
        person.sayBey();
        person = (Person) ctx.getBean("American");
        person.sayHello();
        person.sayBey();
    }
}