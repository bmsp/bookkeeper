package at.bmsp.bookkeeper.persistence;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import at.bmsp.bookkeeper.Bill;

@ManagedBean
@RequestScoped
public class BillListProducer {

	@Inject
	private BillCollectorBean billBean;
	
	private List<Bill> bills;

	public List<Bill> getBills() {
		return bills;
	}
	
	@PostConstruct
	public void initBills() {
		bills = billBean.getBills();
	}
	
	
	
}
