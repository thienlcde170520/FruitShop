package Model;

import java.util.concurrent.atomic.AtomicInteger;
public class IdGenerator {
	private String prefix;
	private String suffix;
	private AtomicInteger lastId;
	public IdGenerator() {
		this.lastId = new AtomicInteger();
		this.prefix = "";
		this.suffix = "";
	}
	public void init(String prefix, String suffix, int lastId) {
		this.prefix = prefix;
		this.suffix = suffix;
		this.lastId.set(lastId); 
	}
	public String generate() {
		return this.prefix + this.lastId.incrementAndGet() + this.suffix;
	}
}