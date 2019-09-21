package pl.pawpam.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Start")
public class ShopStart {

    private ProductService productService;

    @Autowired
    public ShopStart(ProductService productService)
    {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showProducts()
    {
        productService.showProducts();
    }

}
