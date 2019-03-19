package com.example.network.api;

import com.example.network.dto.ProductUserDto;
import com.example.network.service.ProductUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductUserController {

    private ProductUserService productUserService;

    public ProductUserController(ProductUserService productUserService) {
        this.productUserService = productUserService;
    }

    /**
     *
     * @param userId
     * @return one user with product info
     */
    @GetMapping("product/productForUser/{userId}")
    public ResponseEntity<ProductUserDto> getOne(@PathVariable int userId) {
        ProductUserDto productUser;
        try {
            productUser = productUserService.findActiveProductForUser(userId);
            return new ResponseEntity<>(productUser, HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @return all products with their users
     */
    @GetMapping("product/productsForAllUsers")
    public ResponseEntity<List<ProductUserDto>> findAll() {
        List<ProductUserDto> productUsers;
        try {
            productUsers = productUserService.findActiveProductForAllUsers();
            return new ResponseEntity<>(productUsers, HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("payment/addPayment/")
    public ResponseEntity<ProductUserDto> addPayment(@RequestParam("userId") int userId,
                                                     @RequestParam ("price") float price)
    {
        try {
            productUserService.addPayment(userId, price);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("payment/editPayment/")
    public ResponseEntity<ProductUserDto> editPayment(@RequestParam("userId") int userId,
                                                      @RequestParam ("paymentId") int paymentId,
                                                      @RequestParam ("price") float price)
    {
        try {
            productUserService.editPayment(userId, paymentId, price);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("payment/deletePayment/")
    public ResponseEntity<ProductUserDto> deletePayment(@RequestParam("userId") int userId,
                                                      @RequestParam ("paymentId") int paymentId)
    {
        try {
            productUserService.deletePayment(userId, paymentId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
