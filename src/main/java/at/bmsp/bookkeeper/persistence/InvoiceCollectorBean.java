package at.bmsp.bookkeeper.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;

import at.bmsp.bookkeeper.Invoice;

@ManagedBean
@Stateless
public class InvoiceCollectorBean {
	List<Invoice> invoices;

	public InvoiceCollectorBean() {
	}

	public void addInvoice(Invoice invoice) {
		invoices.add(invoice);
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	@PostConstruct
	public void initInvoices() {
		invoices = new ArrayList<Invoice>();
	}

}
