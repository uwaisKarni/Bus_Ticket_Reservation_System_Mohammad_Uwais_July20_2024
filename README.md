# Bus_Ticket_Reservation_System_Mohammad_Uwais_July20_2024


1) Create user by calling 
     
	  curl --location --request POST 'http://localhost:8080/user/add?username=user1&password=password1'
	  
  2) Fexh all users
     
      curl --location --request GET 'http://localhost:8080/user'

  3) Fetch Sinlge User 
     
       curl --location --request GET 'http://localhost:8080/user/user1'	 
	   
  4) Loging User  
     
     curl --location --request POST 'http://localhost:8080/login?username=user1&password=password1'

  5) Hard Coded created 2 buses with seats to perform search operation on them
     
  6) Created Endpoint for  Search Bus Arrival-departure Basis
  
    curl --location --request GET 'http://localhost:8080/search/basedon-arr-dep?departureLocation=Delhi&arrivalLocation=Jaipur'   	

  7) Created  Endpoint for  Get Bus Routes
     curl --location --request GET 'http://localhost:8080/search/buses-routes' 
   
  8) Created Endpoint for viewing all avalible seats
     curl --location --request GET 'http://localhost:8080/search/availabeSeats?busId=1'

  9)	Created Endpoint for seat reserve 
     
      curl --location --request POST 'http://localhost:8080/resevre/seat?userId=1&busId=1&seatId=5'	 
  
  
  
  
  
  Note:: As I'm working on aws cognito auth , curretly on rember spring security configuration,
        I remeber we  need to mark enpoint in security configuration  related to role and isAuthenticated() , 
		 so as of now I just added only annotation as I'm running out of time as well .
   ** I missed Junit as I'm lack of time.I know about Unit testing.
    

