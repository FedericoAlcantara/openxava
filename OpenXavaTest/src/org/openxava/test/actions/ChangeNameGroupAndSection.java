package org.openxava.test.actions;

import org.openxava.actions.*;

/**
 * @author Ana Andres
 * Created on 15 abr. 2020
 */
public class ChangeNameGroupAndSection extends ViewBaseAction{

	@Override
	public void execute() throws Exception {
		// group
		getView().setTitle("My group name", "deliveryData");
		// property
		getView().setLabelId("number", "My property name");
		// section
		getView().setTitle("My section name", 1);
	}

}
