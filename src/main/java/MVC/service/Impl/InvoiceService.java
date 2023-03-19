package MVC.service.Impl;

import MVC.respository.IinvoiceRepository;
import MVC.respository.impl.InvoiceRespository;
import MVC.service.IInvoiceService;

public class InvoiceService implements IInvoiceService {
    private IinvoiceRepository iinvoiceRepository = new InvoiceRespository();

    @Override
    public int numAll() {
        return iinvoiceRepository.numAll();
    }
}
