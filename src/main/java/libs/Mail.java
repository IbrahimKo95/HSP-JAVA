package libs;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class Mail {

    public String host = "smtp.gmail.com";
    public int port = 587;

    public String username = "rhpjava@gmail.com";
    public String password = "dwjs mhlj esdc bdmu";


    public void sendMail(String to, String subject, String body) {
        Email email = EmailBuilder.startingBlank()
                .from("RHP Java", "rhpjava@gmail.com")
                .to("", "i.konate@lprs.fr")
                .withSubject("Test subject")
                .withPlainText("Test body")
                .buildEmail();
        MailerBuilder
                .withSMTPServer(host, port, username, password)
                .buildMailer()
                .sendMail(email);
    }
}
