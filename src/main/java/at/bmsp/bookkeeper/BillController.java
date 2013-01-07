package at.bmsp.bookkeeper;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.jboss.logging.Logger;

import at.bmsp.bookkeeper.persistence.BillCollectorBean;

@Model
public class BillController {
	@EJB
	private BillCollectorBean billBean;
	private Bill newBill;
	private Logger logger = Logger.getLogger(BillController.class);

	public BillController() {
		billBean = new BillCollectorBean();
	}
	
	public void addBill() throws Exception {
		logger.info("Added new invoice to list of invoices");
		billBean.addBill(newBill);
		logger.info("Added new invoice to list of invoices");
		
	}

	public List<Bill> showBills() {
		return billBean.getBills();
	}
	
	@PostConstruct
  public void initNewBill() {
     newBill = new Bill();
     logger.info("Instantiated new invoice item");
     logger.info("Number of bills in bill bean: " + billBean.getBills().size());
  }

	@Produces
	@Named
	public Bill getNewBill() {
		return newBill;
	}

	public void setNewBill(Bill newBill) {
		this.newBill = newBill;
	}
	
}
