package example.ejb3;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorldBean
 */
@Stateless
public class HelloWorldBean implements HelloWorldBeanRemote {

	public HelloWorldBean() {
    }
 
    public String sayHello() {
    return "Hello World !!!";
    }

}
