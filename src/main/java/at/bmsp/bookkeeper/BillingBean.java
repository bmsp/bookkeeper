package at.bmsp.bookkeeper;

import java.util.List;

import javax.faces.bean.ApplicationScoped;

import at.bmsp.bookkeeper.persistence.BillCollectorBean;

@ApplicationScoped
public class BillingBean {
	
	BillCollectorBean billBean;

	public BillingBean() {
		billBean = new BillCollectorBean();
	}
	
	public void addBill(String bill) {
		billBean.addBill(bill);
	}

	public List<String> showBills() {
		return billBean.getBills();
	}

}
