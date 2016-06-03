Configure mail session
----------------------

In standalone.xml add these to appropriate sections:

        <subsystem xmlns="urn:jboss:domain:mail:2.0">
            ...
            <mail-session name="mailtrap" debug="true" jndi-name="java:jboss/mail/Mailtrap">
                <smtp-server outbound-socket-binding-ref="mailtrap-smtp" username="..." password="..."/>
            </mail-session>
        </subsystem>
        ...
        <socket-binding-group name="standard-sockets" default-interface="public" port-offset="${jboss.socket.binding.port-offset:0}">
            ...           
            <outbound-socket-binding name="mailtrap-smtp">
                <remote-destination host="mailtrap.io" port="25"/>
            </outbound-socket-binding>
        </socket-binding-group>

        

Run the Arquillian Tests 
------------------------

        JBOSS_HOME=/path/to/wildfly-X.Y.Z.Final mvn clean test -Parq-wildfly-managed


