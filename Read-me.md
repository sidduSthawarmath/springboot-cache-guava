metrics
-----------------
GET -  http://localhost:5050/metrics

find all
-----------------
GET -  http://localhost:5050/ticket/findAll


findBy Ticket Id
---------------------
GET - http://localhost:5050/ticket/getById?ticketId=1



deleteById Ticket Id
---------------------
DELETE -  http://localhost:5050/ticket/deleteById?ticketId=1


update Ticket Details
-----------------------
PUT -  http://localhost:5050/ticket/update

Request body:
		{
			"ticketId":"1",
			"passengerName":"Siddu",
			"bookingDate":"01-01-2018",
			"sourceStation" : "test"
		}
		
		
		
		
reference:
https://www.youtube.com/watch?v=XNaaol4YFjc&list=PLzS3AYzXBoj-oq5jP6isGbPqexKtmHsRI
