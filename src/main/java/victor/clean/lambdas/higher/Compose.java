package victor.clean.lambdas.higher;

import java.util.function.Function;

public class Compose {
	
	public static void main(String[] args) {
		String s = "a <    B";
		Function<String, String> normalize = String::toUpperCase;
		if (somt) {
			normalize = normalize.andThen(Compose::escapeHtml);
		} else {
			normalize = normalize.andThen(Compose::escapeMarkDown);
		}
		normalize = normalize.andThen(Compose::collapseSpaces);
		s = normalize.apply(s);
//		s = collapseSpaces(escapeHtml(s.toUpperCase())); // that's a lot simpler ! just do f(g(h(x)))
		System.out.println(s);
	}

	// existing function
	private static String escapeHtml(String original) {
		return original.replace("<", "&lt;");
	}

	private static String collapseSpaces(String original) {
		return original.replaceAll("\\s+", " ");
	}
	
}
