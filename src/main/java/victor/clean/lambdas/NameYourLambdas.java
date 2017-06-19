package victor.clean.lambdas;

import static java.util.stream.Collectors.toList;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
public class NameYourLambdas {

	//@Autowired
	private ARepo aRepo;

	private List<B> getAllA() {
		List<A> allA = aRepo.findAll();
		return allA.stream()
			.map(B::new)
			.collect(toList());
	}

	
}

// -------- fake code ---------
interface ARepo {
	List<A> findAll(); 
}

class A {
	@Getter @Setter private String firstNameA;
	@Getter @Setter private String lastNameA;
}
class B {
	public B(A a) {
		setFirstNameB(a.getFirstNameA());
		setLastNameB(a.getLastNameA());
	}
	@Getter @Setter private String firstNameB;
	@Getter @Setter private String lastNameB;
}
