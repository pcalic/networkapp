package com.example.network.service.implementation;

import com.example.network.dto.ProductUserDto;
import com.example.network.model.Payment;
import com.example.network.model.ProductUser;
import com.example.network.repository.PaymentRepository;
import com.example.network.repository.ProductUserRepository;
import com.example.network.service.ProductUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductUserServiceImpl implements ProductUserService {

    private ProductUserRepository productUserRepository;
    private PaymentRepository paymentRepository;

    @Autowired
    public ProductUserServiceImpl(ProductUserRepository productUserRepository, PaymentRepository paymentRepository){
        this.productUserRepository = productUserRepository;
        this.paymentRepository = paymentRepository;
    }

    /**
     *
     * @param userId id of user
     * @return active product for user
     */
    @Override
    public ProductUserDto findActiveProductForUser(int userId) {

        ProductUser productUser = productUserRepository.findByUserIdAndStatus(userId, ProductUser.Status.active);

        return createUserWithActiveProduct(productUser);
    }

    /**
     *
     * @return all active product for all user
     */
    @Override
    public List<ProductUserDto> findActiveProductForAllUsers() {

        List<ProductUser> productUsers = productUserRepository.findAllByStatus(ProductUser.Status.active);
        List<ProductUserDto> productUserList = new ArrayList<>();
        for (int i=0; i< productUsers.size(); i++) {
            ProductUser productUser = productUsers.get(i);
            productUserList.add(createUserWithActiveProduct(productUser));
        }

        return productUserList;
    }

    @Override
    public void addPayment(int userId, float price) {
        ProductUser productUser = productUserRepository.findByUserIdAndStatus(userId, ProductUser.Status.active);
        Payment payment = new Payment(price);

        productUser.setPayment(payment);
        productUser.setPaymentActive(true);

        paymentRepository.save(payment);
        productUserRepository.save(productUser);

    }

    @Override
    public void editPayment(int userId, int paymentId, float price) {
        ProductUser productUser = productUserRepository.findByUserIdAndStatus(userId, ProductUser.Status.active);
        Payment payment = paymentRepository.findByPaymentId(paymentId);
        payment.setPrice(price);

        productUser.setPayment(payment);
        productUser.setPaymentActive(true);

        paymentRepository.save(payment);
        productUserRepository.save(productUser);
    }

    @Override
    public void deletePayment(int userId, int paymentId) {
        ProductUser productUser = productUserRepository.findByUserIdAndStatus(userId, ProductUser.Status.active);
        Payment payment = paymentRepository.findByPaymentId(paymentId);

        productUser.setPayment(null);
        productUser.setPaymentActive(false);
        productUserRepository.save(productUser);

        paymentRepository.delete(payment);
    }

    /**
     *
     * @param productUser from database
     * @return new ProductUser object for view
     */
    private ProductUserDto createUserWithActiveProduct(ProductUser productUser){
        ProductUserDto productUserDto = new ProductUserDto();

        productUserDto.setUserId(productUser.getUserId());
        productUserDto.setProductId(productUser.getProductId().getProductId());
        productUserDto.setPaymentActive(productUser.getPaymentActive());
        productUserDto.setDirection(productUser.getProductId().getDirection());
        productUserDto.setTechnologies(productUser.getProductId().getTechnologies());
        productUserDto.setDevice(productUser.getProductId().getDevice());
        productUserDto.setPrice(productUser.getPayment().getPrice());

        return productUserDto;
    }
    
    
}
