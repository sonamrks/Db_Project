Name: Kamala Sonam Rudraraju
Student ID: 00001079642

Note: My oracle user account is locked. I have executed the project in my friend's oracle account. And mentioned her credentials.
      My files are located in the folder /home/asahu/sonamHW3
Username: asahu
Password=SONIAJAZZ91

List of files in the attachment
-------------------------------
createdb.sql, dropdb.sql, populate.java
HW3(Folder)= Hw3.java, ImagePanel.java, ImagePanel2.java, ImagePanel3.java, ImagePanel4.java, RangeQuery.java, RangeQuery2.java,
	     RImagePanel2.java, RImagePanel22.java, RImagePanel32.java, WholeQuery.java, WholeQuery2.java, WholeQuery3.java

Steps to execute 
================
1) Create tables
@createdb.sql
 
2) Execute populate
javac -classpath /home/asahu/sonamHW3/ populate.java

java -classpath /home/asahu/sonamHW3/:/home/asahu/sonamHW3/ojdbc6.jar populate photographer.xy photo.xy building.xy

Note: I have removed the last blank line in photo.xy file as it is giving null error and not required.

3) Execute Hw3
javac -classpath /home/asahu/sonamHW3/HW3/ Hw3.java

java -classpath /home/asahu/sonamHW3/HW3/:/home/asahu/sonamHW3/ojdbc6.jar:/home/asahu/sonamHW3/sdoapi.jar Hw3


Important notes
----------------
a) Please wait for sometime, while populating buildings option in the whole region in the GUI. It takes sometime.
b) Please close and reopen the GUI when switching from Whole region Query to Range Query or from Range Query to Point Query.
c) I have written the query code in the text area (for the one's without GUI).


4) Drop tables
@drop.sql