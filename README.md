# networkapp
Installation
1. Download https://dev.mysql.com/downloads/mysql/5.7.html if don't have
2. Run this database script:
	CREATE DATABASE IF NOT EXISTS network;
3. Get app from git on local
4. Go to app folder and run this script from console
		./gradlew bootRun
5. App is running now on localhost:8080

Api:
	localhost:8080/product/productForUser/{userId} - To get one active product for user
	localhost:8080/product/productsForAllUsers - To get all products for all users
	localhost:8080/payment/addPayment/ - To add payment on product for user. Parameters (int userId, float price)
	localhost:8080/payment/editPayment/ - To edit payment on product for user Parameters (int userId, int paymentId, float price)
	localhost:8080/payment/deletePayment/ - To delete payment on product for user Parameters (int userId, int paymentId)