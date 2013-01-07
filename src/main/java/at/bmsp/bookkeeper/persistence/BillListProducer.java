package at.bmsp.bookkeeper.persistence;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import at.bmsp.bookkeeper.Bill;

@ManagedBean
@RequestScoped
public class BillListProducer {

	@EJB
	private BillCollectorBean billBean;

	private List<Bill> bills;

	@Produces
	@Named
	public List<Bill> getBills() {
		return bills;
	}

	@PostConstruct
	public void initBills() {
		bills = billBean.getBills();
	}

}
