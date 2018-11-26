package tudelft.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

public class DiscountApplierTest {

    @Test
    void applyDiscount() {
        Product home = new Product("home", 10.0, "HOME");
        Product business = new Product("business", 10.0, "BUSINESS");

        ProductDao dao = mock(ProductDao.class);
        List<Product> results = Arrays.asList(home, business);
        Mockito.when(dao.all()).thenReturn(results);

        DiscountApplier discountApplier = new DiscountApplier(dao);
        discountApplier.setNewPrices();

        Assertions.assertEquals(9.0, home.getPrice());
        Assertions.assertEquals(11.0, business.getPrice());
    }
}
