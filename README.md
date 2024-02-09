# PORTS :
EUREKA-SERVER: http://localhost:8080

API-GATEWAY: http://localhost:8083

CUSTOMER-SERVICE: http://localhost:8081

ACCOUNT:SERVICE: http://localhost:8082

# CUSTOMER-SERVICE :

# 1.)  Add Customer

 http://localhost:8083/customer/addCustomer

    JSON Request Body:
   
      {
    "customerId":1,
    "name":"Adi",
    "address":"Punjab",
    "phoneNumber":2344445,
    "gender":"M"
      }

 # 2.) Update Customer 

       http://localhost:8083/customer/updateCustomer

        {
    "customerId":1,
    "name":"aadi",
    "address":"Jaipur",
    "phoneNumber":98765432,
    "gender":"M"
        }
        
# 3.) Get All Customers 

      http://localhost:8083/customer/getCustomers

# 4.) Get Customer By ID 

      http://localhost:8083/customer/getCustomer/{id}

# 5.) Delete Customer

      http://localhost:8083/customer/deleteCust/{id}


      

      
