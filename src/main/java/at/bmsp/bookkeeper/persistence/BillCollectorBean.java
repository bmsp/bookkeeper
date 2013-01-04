package at.bmsp.bookkeeper.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import at.bmsp.bookkeeper.Bill;

@Stateless
public class BillCollectorBean {
	List<Bill> bills;

	public BillCollectorBean() {
	}
	
	public void addBill(Bill bill) {
		bills.add(bill);
	}
	
	public List<Bill> getBills() {
		return bills;
	}
	
	@PostConstruct
	public void initBills() {
		bills = new ArrayList<Bill>();
	}


}
