# Description

A point-of-sale desktop application for a friend's cake store, developed as the final assignment for one of my college courses. The app features a user-friendly interface and includes useful functionalities such as reporting and receipt generation.

## Screenshots

### Homepage (List of Products)
![Home](https://github.com/ihsansfd/proyek-assyifa-cakes-final/blob/main/screenshots/1.png)

### Transaction List
![Transaction List](https://github.com/ihsansfd/proyek-assyifa-cakes-final/blob/main/screenshots/2.png)

### Customers List
![Customers List](https://github.com/ihsansfd/proyek-assyifa-cakes-final/blob/main/screenshots/3.png)

### Reporting
![Reporting](https://github.com/ihsansfd/proyek-assyifa-cakes-final/blob/main/screenshots/4.png)

### Transaction Making
![Transaction Making](https://github.com/ihsansfd/proyek-assyifa-cakes-final/blob/main/screenshots/5.png)

### Receipt
![Receipt](https://github.com/ihsansfd/proyek-assyifa-cakes-final/blob/main/screenshots/6.png)

## How to Run

The `production` directory is where the app directory is located.

Because the database is empowered by MySQL (sadly, not SQLite), you need to configure your database settings located at `production/db/KonfigurasiDatabase.properties`.

To login, you need to set up your user by going into the MySQL table `user` for the database and inserting a new user row. The schema would look like this:
+------------+--------------+------+-----+---------------------+----------------+
| Field      | Type         | Null | Key | Default             | Extra          |
+------------+--------------+------+-----+---------------------+----------------+
| id         | int(11)      | NO   | PRI | NULL                | auto_increment |
| username   | varchar(50)  | NO   | UNI | NULL                |                |
| nama       | varchar(50)  | NO   |     | NULL                |                |
| password   | varchar(255) | NO   |     | NULL                |                |
| created_at | datetime     | NO   |     | current_timestamp() |                |
| updated_at | datetime     | NO   |     | current_timestamp() |                |
+------------+--------------+------+-----+---------------------+----------------+

You can then login using the `username` and `password` field of the row you've added.

## Contributors
Here is the list of my colleagues that contribute to this project:  Ibu Alfitra Salam (also the owner of the cake store), Wahyu Rahayu, Hilal Shafwanto, Muhammad Heru Widiyanto
