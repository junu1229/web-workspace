package servlet.controller;

import servlet.controller.component.FindController;

public class ControllerFactory {
	
	// 싱글톤 패턴
	private static ControllerFactory controllerFactory = new ControllerFactory();
	private ControllerFactory() {}
	public static ControllerFactory getInstance() {
		return controllerFactory;
	}
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("find")) {
			controller = new FindController();
		} 
		return controller;
	}
}
