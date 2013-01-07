package at.bmsp.bookkeeper;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.jboss.logging.Logger;

import at.bmsp.bookkeeper.persistence.InvoiceCollectorBean;

@Model
public class InvoiceController {
	@EJB
	private InvoiceCollectorBean invoiceBean;
	private Invoice newInvoice;
	private Logger logger = Logger.getLogger(InvoiceController.class);

	public InvoiceController() {
		invoiceBean = new InvoiceCollectorBean();
	}

	public void addInvoice() throws Exception {
		invoiceBean.addInvoice(newInvoice);
		logger.info("Added new invoice to list of invoices");

	}

	public List<Invoice> showInvoices() {
		return invoiceBean.getInvoices();
	}

	@PostConstruct
	public void initNewInvoice() {
		newInvoice = new Invoice();
		logger.info("Instantiated new invoice item");
		logger.info("Number of invoices in invoice bean: "
				+ invoiceBean.getInvoices().size());
	}

	@Produces
	@Named
	public Invoice getNewInvoice() {
		return newInvoice;
	}

	public void setNewInvoice(Invoice newInvoice) {
		this.newInvoice = newInvoice;
	}

}
