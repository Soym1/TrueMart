package MVC.service.Impl;

import MVC.respository.ImpInvoiceRepository;
import MVC.respository.impl.InvoiceRepository;
import MVC.service.IInvoiceService;

public class InvoiceService implements IInvoiceService {
    private ImpInvoiceRepository impInvoiceRepository = new InvoiceRepository();

    @Override
    public int numAll() {
        return impInvoiceRepository.numAll();
    }
}
