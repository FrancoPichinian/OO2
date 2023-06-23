package pichiñan.main;

import pichiñan.framework.Menu;

public class Main {

	public static void main(String[] args) {
		Menu framework = new Menu("/pichiñan/utilizacion/config.properties");
		framework.run();
	}
}
