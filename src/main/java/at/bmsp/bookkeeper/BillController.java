package at.bmsp.bookkeeper;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import at.bmsp.bookkeeper.persistence.BillCollectorBean;

@Model
public class BillController {
	@Inject
	private BillCollectorBean billBean;
	private Bill newBill;

	public BillController() {
		billBean = new BillCollectorBean();
	}
	
	public void addBill() {
		billBean.addBill(newBill);
	}

	public List<Bill> showBills() {
		return billBean.getBills();
	}
	
	@PostConstruct
  public void initNewBill() {
     newBill = new Bill();
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
