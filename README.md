# SOAP_Web_Service
A web service , the client send a request with some informations about a student who applied for un internship or a master degree registration.
The criteria of acceptation is realted in the age , lastYearScore, LastYearJavaScore and numberOfCertifications 

After running the application try to access :   http://localhost:9090/ws/reg.wsdl
to more understand the contract 

Note: Using the plugin jaxb2 may cause some problems if you are using a JDKversion>1.8 because some classes used by the plugin are removed from the core of JDK in latest versions

I used SOAPUI to test the service :

![image](https://user-images.githubusercontent.com/53187839/115641824-c633ff00-a311-11eb-9f8f-63d637c7954e.png)
