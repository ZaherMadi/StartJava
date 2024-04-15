import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
public class EmailTest {
    public static void main(String[] args) {
        try {
            SimpleEmail email = new SimpleEmail();
            email.setHostName("mail.gmx.com");
            email.setSmtpPort(587);
            email.setAuthentication("cinqun@gmx.fr", "PBFVRE26W4DR7WD354ET");
            email.setSSLOnConnect(true);
            email.setStartTLSEnabled(true);
            email.setFrom("cinqun@gmx.fr");
            email.setSubject("Test Mail");
            email.setMsg("Oui c'est ENCORE un test");
            email.addTo("guirri06510@gmail.com");
            email.send();
            System.out.println("Email sent!");

        } catch (EmailException e) {
            throw new RuntimeException(e);
        }

    }
}

