package org.openxava.test.actions;

import org.openxava.actions.*;

/**
 * tmp
 * 
 * @author Javier Paniza
 */
public class MarkInvoice4AsPaidAction extends BaseAction implements IOptionalRowAction  {

	@Override
	public void execute() throws Exception {
		System.out.println("[MarkInvoice4AsPaidAction.execute] "); // tmp
		
	}

	@Override
	public boolean isApplicableForRow(Object object) {
		System.out.println("[MarkInvoice4AsPaidAction.isApplicableForRow] object=" + object); // tmp
		if (object != null) {
			System.out.println("[MarkInvoice4AsPaidAction.isApplicableForRow] object.getClass()=" + object.getClass()); // tmp
		}
		return false;
	}

}
