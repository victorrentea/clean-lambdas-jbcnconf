package victor.clean.lambdas;

import java.util.ArrayList;
import java.util.List;

public class HelloBarcelona {

	public static void main(String[] args) {
		List<Order> orders = new ArrayList<>();
		
		boolean found = orders.stream()
			.anyMatch(order -> order.isNotDelivered());
//		
//		boolean found = orders.stream()
//			.filter(order -> order.isNotDelivered())
//			.count() >= 1;
////		
//		boolean found = orders.stream()
//			.filter(order -> order.isNotDelivered())
//			.findAny()
//			.isPresent();
////		
//		boolean found = !orders.stream()
//			.filter(order -> order.isNotDelivered())
//			.collect(toList())
//			.isEmpty();
////		
//		boolean found = orders.stream()
//			.filter(order -> order.isNotDelivered())
//			.collect(toList())
//			.size() >= 1;
	}
}
