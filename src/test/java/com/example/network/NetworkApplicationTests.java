package com.example.network;

import static org.junit.Assert.*;

import com.example.network.dto.ProductUserDto;
import com.example.network.model.Product;
import com.example.network.model.ProductUser;
import com.example.network.repository.PaymentRepository;
import com.example.network.repository.ProductUserRepository;
import com.example.network.service.implementation.ProductUserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NetworkApplicationTests {

    @Mock
    ProductUserRepository productUserRepository;

    @Mock
    PaymentRepository paymentRepository;

    private ProductUserServiceImpl productUserService;

    @Before
    public void setUp() {
        productUserService = new ProductUserServiceImpl(productUserRepository, paymentRepository);
    }

    @Test
	public void findOneProductForUser() {
        Product product1 = new Product();
        Product product2 = new Product();

        product1.setProductId(1);
        product1.setDevice("DPU");
        product1.setDirection("Upstream");
        product1.setTechnologies("VDSL");

        product2.setProductId(2);
        product2.setDevice("DPU");
        product2.setDirection("Upstream");
        product2.setTechnologies("ISDN");

        List<ProductUser> productUsers = new ArrayList<>();
        ProductUser productUser1 = new ProductUser();

        productUser1.setPaymentActive(false);
        productUser1.setId(1);
        productUser1.setProductId(product1);
        productUser1.setUserId(1);
        productUser1.setStatus(ProductUser.Status.active);

        ProductUser productUser2 = new ProductUser();
        productUser2.setPaymentActive(false);
        productUser2.setId(1);
        productUser2.setProductId(product2);
        productUser2.setUserId(1);
        productUser2.setStatus(ProductUser.Status.inactive);

        productUsers.add(productUser1);
        productUsers.add(productUser2);
        int id = 1;

        when(productUserRepository.findByUserIdAndStatus(id, ProductUser.Status.active)).thenReturn(productUser1);
        ProductUserDto result = productUserService.findActiveProductForUser(id);

        assertTrue(productUsers.get(id).getProductId().equals(result.getProductId()));
        assertEquals(productUsers.get(id).getProductId(), result.getProductId());




    }

    @Test
    public void findAllUsersWithActiveProduct(){

        Product product1 = new Product();
        Product product2 = new Product();

        product1.setProductId(1);
        product1.setDevice("DPU");
        product1.setDirection("Upstream");
        product1.setTechnologies("VDSL");

        product2.setProductId(2);
        product2.setDevice("DPU");
        product2.setDirection("Upstream");
        product2.setTechnologies("ISDN");

        List<ProductUser> productUsers = new ArrayList<>();
        ProductUser productUser1 = new ProductUser();

        productUser1.setPaymentActive(false);
        productUser1.setId(1);
        productUser1.setProductId(product1);
        productUser1.setUserId(1);
        productUser1.setStatus(ProductUser.Status.active);

        ProductUser productUser2 = new ProductUser();
        productUser2.setPaymentActive(false);
        productUser2.setId(1);
        productUser2.setProductId(product2);
        productUser2.setUserId(1);
        productUser2.setStatus(ProductUser.Status.active);

        productUsers.add(productUser1);
        productUsers.add(productUser2);

        when(productUserRepository.findAllByStatus(ProductUser.Status.active)).thenReturn(productUsers);

        List<ProductUserDto> result = productUserService.findActiveProductForAllUsers();

        assertEquals(result.size(), productUsers.size());

    }

}
