package rcpview1;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	// Actions - important to allocate these only in makeActions, and then use
	// them
	// in the fill methods. This ensures that the actions aren't recreated
	// when fillActionBars is called with FILL_PROXY.
	show customAction;
	EmployeeShow customAction1;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

protected void makeActions(IWorkbenchWindow window) {

//Custom action
 customAction = new show();
customAction.setText("Show Details Of Dog");
customAction.setAccelerator(SWT.CTRL + 'T');
register(customAction);

customAction1 = new EmployeeShow();
customAction1.setText("Show Details Of Employee");
customAction1.setAccelerator(SWT.CTRL + 'T');
register(customAction1);


}

protected void fillMenuBar(IMenuManager menuBar) {

MenuManager fileMenu = new MenuManager("&Show", "show"); //create a menuManager to take care of all submenus in "File"
fileMenu.add(customAction); //Add the "customAction" action
fileMenu.add(customAction1);
menuBar.add(fileMenu); //Add the "File" menu to the menuBar
}
}
