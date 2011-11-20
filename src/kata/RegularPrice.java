package kata;

public final class RegularPrice extends Price {

	@Override
	public double getPrice(int daysRented) {
		// TODO Auto-generated method stub
		int resultado = 2;
		
		if (daysRented <= 2)
			return 2;
		else 
			return 2 + ((daysRented - 2) * 1.5);
		
	}

	
}
