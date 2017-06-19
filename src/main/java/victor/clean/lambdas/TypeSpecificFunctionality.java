package victor.clean.lambdas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import lombok.Getter;
import lombok.Setter;
import victor.clean.lambdas.Movie.Type;

public class TypeSpecificFunctionality {
	public static void main(String[] args) {
		System.out.println(new Movie().setType(Type.NEW_RELEASE).computePrice(4));
	}
}

class Movie {
	enum Type {
		CHILDREN, REGULAR, NEW_RELEASE
	}
	@Getter @Setter private Type type;
	
	public static Map<Type, Function<Integer, Double>> priceAlgo = new HashMap<>();
	static {
		priceAlgo.put(Type.CHILDREN, daysRented -> 5d);
		priceAlgo.put(Type.REGULAR, daysRented -> 8 + 0.3 * (daysRented - 8));
		priceAlgo.put(Type.NEW_RELEASE, daysRented -> 10 + 0.5 * daysRented);
	}
	
	public double computePrice(int daysRented) {
		return priceAlgo.get(type).apply(daysRented);
	}
}
