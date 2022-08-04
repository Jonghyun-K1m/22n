package hello.basic.singleton;

public class statefulService {
	
/*	private int Manager;
	public void check(String name, int Manager) {		
		System.out.println(name +" " +Manager);
		this.setManager(Manager);
	}
*/
	public int check(String name, int Manager) {		
		System.out.println(name +" " +Manager);
	//	this.setManager(Manager);
		return Manager;
	}
	

	public void getManager() {
	//	return Manager;
	}


	public void setManager(int manager) {
//		Manager = manager;
	}
	
}
