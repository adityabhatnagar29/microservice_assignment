# PORTS :
EUREKA-SERVER: http://localhost:8080

API-GATEWAY: http://localhost:8083

CUSTOMER-SERVICE: http://localhost:8081

ACCOUNT-SERVICE: http://localhost:8082



# CUSTOMER-SERVICE :


# 1.)  Add Customer

 http://localhost:8083/customer/addCustomer

    JSON Request Body:
   
      {
    "customerId":1,
    "name":"Adi",
    "address":"Punjab",
    "phoneNumber": 9209878097,
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



 # ACCOUNT-SERVICE :


  # 1.) Add Account 

    http://localhost:8083/account/createAccount

     JSON Request Body

      {
    "accNo":1,
    "accType": "save",
    "balance":300
      }

  # 2.) Get Account Details 

     http://localhost:8083/account/getDetails/{accNo}

  # 3.) Add Balance 

    http://localhost:8083/account/addMoney/{accNo}

     Request Parameter : Key = amount , Value = 400

 #  4.) Withdraw Balance 

       http://localhost:8083/account/debitMoney/{accNo}

          Request Parameter : Key = amount , Value = 400

  # 5.) Delete Account 

        http://localhost:8083/account/deleteCust/{id}



# Confi-Server Properties : https://github.com/adityabhatnagar29/microservice-assignment-configuration

       

      


      

      
