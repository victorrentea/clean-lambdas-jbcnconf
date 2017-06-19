package victor.clean.lambdas;

import java.util.Random;
import java.util.function.Consumer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Sevice 
class EmailService {
//	@Autowired
//	private MyRepo myRepo;

	public void sendEmail(String emailAddress, Consumer<Email> fillEmail ) {
		EmailContext context = new EmailContext(/*smtpConfig,etc*/);
		int MAX_RETRIES = 3;
		for (int i = 0; i < MAX_RETRIES; i++ ) {
			Email email = new Email(); // constructor generates new unique ID
			email.setSender("noreply@corp.com");
			email.setReplyTo("/dev/null");
			email.setTo(emailAddress);
			fillEmail.accept(email);
			boolean success = context.send(email);
			if (success) break;
		}
	}
}
class ClientCode {
	protected static void fillReceivedEmail(Email email) {
		email.setSubject("Order Received");
		email.setBody("Thank you for your order");
	}
	protected static void fillShippedEmail(Email email) {
		email.setSubject("Order Shipped");
		email.setBody("Your order has been shipped (with a bird)");
	}
	
	public static void main(String[] args) {
		new EmailService().sendEmail("a@b.com", ClientCode::fillReceivedEmail);
		new EmailService().sendEmail("a@b.com", ClientCode::fillShippedEmail);
	}
}









class EmailContext {
	public boolean send(Email email) {
		System.out.println("Trying to send " + email);
		return new Random(System.nanoTime()).nextBoolean();
	}
}


@ToString
class Email {
	@Getter private long id = new Random(System.nanoTime()).nextLong();
	@Getter @Setter private String sender;
	@Getter @Setter private String subject;
	@Getter @Setter private String body;
	@Getter @Setter private String replyTo;
	@Getter @Setter private String to;
}
