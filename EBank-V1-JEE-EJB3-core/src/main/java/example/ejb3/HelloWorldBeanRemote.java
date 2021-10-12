package example.ejb3;

import javax.ejb.Remote;

@Remote
public interface HelloWorldBeanRemote {
	
	public String sayHello();
}
