package pl.pawpam.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Plus")
public class ShopPlus {

    private ProductService productService;

    @Value("${vat}")
    private double vat;

    @Autowired
    public ShopPlus(ProductService productService)
    {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showProducts()
    {
        productService.showProducts();
        productService.addVatToSummaryPrice(vat);
    }
}
