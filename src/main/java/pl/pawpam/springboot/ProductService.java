package pl.pawpam.springboot;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.round;

@Service
public class ProductService {

    List<Product> shoppingCart = new ArrayList<>();
    private double summary = 0;

    public ProductService()
    {
        Product p1 = new Product("Shampoo", round(50 + Math.random() * 250));
        Product p2 = new Product("Pampers", round(50 + Math.random() * 250));
        Product p3 = new Product("Toilet paper", round(50 + Math.random() * 250));
        Product p4 = new Product("Cream", round(50 + Math.random() * 250));
        Product p5 = new Product("Shower Gel", round(50 + Math.random() * 250));

        shoppingCart.add(p1);
        shoppingCart.add(p2);
        shoppingCart.add(p3);
        shoppingCart.add(p4);
        shoppingCart.add(p5);

        summary = summaryPrice(shoppingCart);
    }

    public void showProducts()
    {
        System.out.println("-----------------------");
        System.out.println("In shopping cart are: ");
        System.out.println("-----------------------");
        for(int i = 0; i<shoppingCart.size(); i++)
        {
            System.out.println(shoppingCart.get(i).getProductName() + " - " + shoppingCart.get(i).getPrice());
        }
        System.out.println("-----------------------");
        System.out.println("Summary: "+summary);
    }

    public double summaryPrice(List<Product> products)
    {
        double result = 0;
        for(int i = 0; i<products.size(); i++)
        {
            result +=products.get(i).getPrice();
        }
        return result;
    }
    public void addVatToSummaryPrice(double vat)
    {
        System.out.println("-----------------------");
        summary = (summary*vat)+summary;
        System.out.println("Summary + Vat: "+summary);
    }
    public void addDiscountToSummaryPrice(double discount)
    {
        System.out.println("-----------------------");
        summary = summary - discount;
        System.out.println("Summary + Vat - Discount: "+summary);
    }

}