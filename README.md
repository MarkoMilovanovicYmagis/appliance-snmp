# emulator-snmp-example
Example of application snmp.

Expose Spring beans using SNMP (Currently the library supports SNMP v1)

Spring application (using annotations)
--------------------------------------

- Annotate your beans using @MibBean and @MibProperty.
- Create spring XML configuration file (e.g. applicationContext.xml) and define your beans, SNMP agent and MibAnnotationsProcessor, which inspects all spring bean and automatically creates appropriate MibEntries. 
Note that snmpAgent bean should have init-method="start" in order to start the agent upon context creation.

`   @MibProperty(oid = "1.3.6.1.4.1.119.2.3.123.1.3", writable = true, requiredType = AsnOctetString.class)
     public String getEmulatorStatus() {
         return emulatorStatus;
     }`

And the configuration goes like this
` @Bean
     public JvmStatAnnotated jvmStatAnnotated() {
         return new JvmStatAnnotated("JVM Statistics with Spring (Annotated)", 20);
     }
 
     @Bean(initMethod = "start", destroyMethod = "stop")
     public SnmpAgent snmpAgent() {
         return new SnmpAgent(161, "public", "private", mib2System(), new String[]{"1.3.6.1.2.1", "1.3.6.1.4.1.119.2.3"});
     }
 
     @Bean
     public Mib2System mib2System() {
         return new Mib2System("Emulator service", "1.3.6.1.4.1.119.2.3.123", "Marko M", "Belgrade Office", false, false, false, true, true);
     }
 
     @Bean
     public MibAnnotationsProcessor mibAnnotationsProcessor() {
         return new MibAnnotationsProcessor(snmpAgent());
     }`
     

###Docker
Commands for build and deploy the app
```
gradlew build docker
docker-compose up
```
The app can be tested trough the SMNP Client 

/resources/smnp.png