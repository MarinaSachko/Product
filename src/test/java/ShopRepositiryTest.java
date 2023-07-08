import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositiryTest {
    @Test
    public void ShouldRemoveProducExist() {

        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(25, "хлеб", 26);
        Product product2 = new Product(26, "яблоко", 30);
        Product product3 = new Product(27, "помидор", 80);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(26);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveProducNotExist() {

        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(25, "хлеб", 26);
        Product product2 = new Product(26, "яблоко", 30);
        Product product3 = new Product(27, "помидор", 80);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(29));

        // repo.remove(29);

//        Product[] expected = {product1, product2, product3};
//        Product[] actual = repo.findAll();
//        Assertions.assertArrayEquals(expected, actual);
    }
}
