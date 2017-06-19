package victor.clean.lambdas;

public class TypeSpecificFunctionality {
	public static void main(String[] args) {
		System.out.println(new NewReleaseMovie().computePrice(4));
	}
}

abstract class Movie {
	public abstract double computePrice(int daysRented);
}
class ChildrenMovieUS extends Movie {
	public double computePrice(int daysRented) {
		return 5;
	}
}
class ChildrenMovieUK extends Movie {
	public double computePrice(int daysRented) {
		 return 6;
	}
}
class RegularMovie extends Movie {
	public double computePrice(int daysRented) {
		return 8 + 0.3 * (daysRented - 8);
	}
}
class NewReleaseMovie extends Movie {
	public double computePrice(int daysRented) {
		return 10 + 0.5 * daysRented;
	}
}
