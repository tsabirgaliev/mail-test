package io.tair.javaee.test;

import io.tair.javaee.mail.MailService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class MailServiceTest {
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(MailService.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    MailService mailService;

    @Test
    public void testEncodeTextQ() throws Exception {

        String result = mailService.encodeText("ü_and_ä_šč", "UTF-8", null);

        System.out.println(result);
    }

    @Test
    public void testEncodeTextB() throws Exception {

        String result = mailService.encodeText("ü_and_ä_šč", "UTF-8", "B");

        System.out.println(result);
    }

    @Test
    public void testSend2() throws Exception {

        mailService.send( "from@example.com"
                        , "to@example.com"
                        , "ü_and_ä_šč"
                        , "ü_and_ä_šč"
                        , "ü_and_ä_šč"
                        , "ü_and_ä_šč"
        );
    }

}
