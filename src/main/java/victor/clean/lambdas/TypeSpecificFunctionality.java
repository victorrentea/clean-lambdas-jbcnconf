package victor.clean.lambdas;

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
		CHILDREN {
			@Override
			public double computePrice(int daysRented) {
				return 5;
			}
		}, REGULAR {
			@Override
			public double computePrice(int daysRented) {
				return 8 + 0.3 * (daysRented - 8);
			}
		}, NEW_RELEASE {

			@Override
			public double computePrice(int daysRented) {
				return 10 + 0.5 * daysRented;
			}
		};
		public abstract double computePrice(int daysRented);
		
	}
	@Getter @Setter private Type type;
	
	public double computePrice(int daysRented) {
		return type.computePrice(daysRented);
	}
}
