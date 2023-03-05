# BookMySeat
BookMySeat is a webapp for seat booking in the movie hall.
ABOUT
bookmyseat.com is a movie ticket booking web-app prototype. The users can select the
movie and book a seat of their choice.
TECHNOLOGIES USED
The following technologies were used in building of this web-application:
Front-End designing
1. HTML5
2. CSS3
3. Bootstrap
4. Javascript
5. 
Back-End programming
1. Java (core)
2. Servlet
3. MySQL
4. 
HOW TO RUN THIS ON YOUR COMPUTER?

Pre-requisites: JDK, Netbeans IDE (Version 8.2), Sublime Text (optional), Tomcat Server
(Version 8.5), MySQL database (Version 8.0), mysql-java-connector.jar (Version 8.0.27)

● Unzip the project folder.

● Open the project on Netbeans.

● Go to libraries and add mysql-java-connector.jar file (if not present previously).

● Go to Source Package -> ‘com.bookmyseat.connection’ package -> ConnectionDB
class and update the password.

● Open MySQL and create a database named ‘bookmyseat’ and create the following
tables with mentioned attributes:

I. movie (ID int primary key, name varchar (100) unique not null, director
varchar(100) not null, releasing_date varchar(100) not null, casts
varchar(100) not null, description varchar(100) not null, poster
varchar(100) not null, duration varchar(100) not null, trailer varchar(100)
not null, category int)

II. user (ID int primary key, name varchar (100), email varchar(100) unique
not null, password varchar(100) not null, dob varchar(100) not null, gender
varchar(100) not null, bookings varchar(250) not null)

III. premiumseats (ID int not null unique, p1 varchar(10), p2 varchar(10), p3
varchar(10)…, p20 varchar(10), foreign key (id) references movie(ID))

IV. standardseats (ID int not null unique, s1 varchar(10), s2 varchar(10), s3
varchar(10)…, s80 varchar(10), foreign key (id) references movie(ID))
2

● Since the project is a prototype it can display only 6 movies at a time for the
purpose of booking. Henceforth, entering the details of 6 different movies into the
respective table is essential.

● Additionally there exists a folder named image for storing the movie’s poster.

Love & Regards,
Sagar Dutta
