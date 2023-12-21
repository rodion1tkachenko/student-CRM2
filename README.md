the task is to create student-crm system. 

enabled features: 
-role system
-create user
-login user
-show groupmates at account page
-delete user(enabled only for admin)

I did "create user" feature using StudentController. After valid login and password(checked by Spting Validation)
service layer creates a user and redirect to account page, where rookie can see him groupmates and visit their page.

"Login user" can redirect at admin's page or user's page depends on input data. 
i check input data from table using spring data jpa

"delete user" is feature of admin's page. after input student's id(unique for each user) 
student is removed from table Student Table Account according to CascadeType  
