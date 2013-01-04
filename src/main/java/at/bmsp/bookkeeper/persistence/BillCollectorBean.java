package at.bmsp.bookkeeper.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

public class BillCollectorBean {
	List<String> bills = new ArrayList<String>();

	public BillCollectorBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void addBill(String bill) {
		bills.add(bill);
	}
	
	public List<String> getBills() {
		return bills;
	}


}
