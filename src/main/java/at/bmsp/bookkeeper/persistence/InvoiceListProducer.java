package at.bmsp.bookkeeper.persistence;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import at.bmsp.bookkeeper.Invoice;

@ManagedBean
@RequestScoped
public class InvoiceListProducer {

	@EJB
	private InvoiceCollectorBean invoiceBean;

	private List<Invoice> invoices;

	@Produces
	@Named
	public List<Invoice> getInvoices() {
		return invoices;
	}

	@PostConstruct
	public void initInvoices() {
		invoices = invoiceBean.getInvoices();
	}

}
