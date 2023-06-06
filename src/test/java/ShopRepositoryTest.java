import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void TestRemoveVenExist(){
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11,"телефон", 30_000);
        Product product2 = new Product(22,"книга", 300);
        Product product3 = new Product(300,"машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(22);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void TestRemoveVenNotExist(){
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11,"телефон", 30_000);
        Product product2 = new Product(22,"книга", 300);
        Product product3 = new Product(300,"машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(30);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3,product2};

        Assertions.assertArrayEquals(expected,actual);
    }

}