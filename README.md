# organization-demo

Spring framework sample usage with PCF and DD design approach.

** pre-requisits **
- generate NEW spring project using site: [Spring Initialzr](https://start.spring.io)
- use tutorial code base: [github] (https://github.com/jakubwierzchoslawski/organization-demo)
- install Pivotal Cloud Foundry Dev tool [PCF Dev] (https://pivotal.io/pcf-dev)
- java 8


# PCF dev - usefull CLI commands

* cf dev start #run pcf dev
* cf login -a https://api.local.pcfdev.io --skip-ssl-validation (admin/admin) # login to your pcf dev instance
* cf push <app-name> -p .\target\organization-demo-1.0.jar 
* cf logs organization-demo --recent (to see deployment logs; logs can be viewd from www admin console as well)

	* after login admin page is avaliable: https://uaa.local.pcfdev.io/login
