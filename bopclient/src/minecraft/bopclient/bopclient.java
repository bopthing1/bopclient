package bopclient;

import bopclient.event.EventManager;
import net.minecraft.client.Minecraft;

public class bopclient {
	public String name = "bopclient", version = "1.0.0", author = "bop";
	public EventManager eventManager;
	public static bopclient instance = new bopclient();
	Minecraft mc = Minecraft.getMinecraft();
	
	public void startup() {
		
		eventManager = new EventManager();
		System.out.println("starting " + name + " " + version + " by " + author);
		eventManager.register(this);
	} 
	
	public void shutdown() {
		System.out.println("shut up");
		eventManager.unregister(this);
	}
	
	public void joinedWorld() {
	}
}
