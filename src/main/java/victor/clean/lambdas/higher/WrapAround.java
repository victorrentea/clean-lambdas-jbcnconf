package victor.clean.lambdas.higher;

public class WrapAround {
	public static void main(String[] args) {
		executeInTx(WrapAround::insertLanguages);
		executeInTx(WrapAround::insertCountries);
	}
	
	public static void measureTime(Runnable functionToMeasure) {
		long t0 = System.nanoTime();
		functionToMeasure.run();
		long t1 = System.nanoTime();
		System.out.println("Took " + (t1-t0));
	}
	
	public static void executeInTx(Runnable function) {
		try {
			System.out.println("Start Tx");
			function.run();
			System.out.println("Commit Tx");
		}catch (RuntimeException e) {
			System.out.println("Rollback Tx");
		} finally {
			System.out.println("Relesase Tx resource");
		}
	}

	// existing
	public static void insertLanguages() {
		System.out.println("Insert languages");
	}

	public static void insertCountries() {
		System.out.println("Insert countries");
	}
}
