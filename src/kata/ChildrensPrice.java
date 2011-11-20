package kata;

public class ChildrensPrice extends Price {

	@Override
	public double getPrice(int daysRented) {
	
		if (daysRented <= 3)
			return 1.5;
		else
			return 1.5 + ((daysRented - 3) * 1.5);
	}

}
