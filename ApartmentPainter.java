/*
 * Wiktoria Cioch-Gradzik
 * 09/08/2023
 * FA23-CPSC-24500-002
 * This program is counting how much paint and primer is needed for 8 apartments
 */
public class ApartmentPainter {
	public static void main(String[] args) {
		//variables declaration
		double roomHeight = 10.0;
		double roomLongWall = 32.75;
		double roomNarrowWall = 25.62;
		double windowWidth = 14.4;
		double windowHeight = 5.5;
		double doorHeight = 8.0;
		double doorWidth = 3.25;
		int paintCoverage = 400;
		double paintCost = 34.99;
		int primerCoverage = 300;
		double primerCost = 24.49;
		
		//calculate surface to be painted
		double wallArea = 2*(roomNarrowWall*roomHeight + roomLongWall*roomHeight);
		double notPainted = windowHeight* windowWidth + doorHeight*doorWidth;
		double wallAreaPerUnit = wallArea - notPainted;
		double ceilingAreaPerUnit = roomLongWall*roomNarrowWall;
		double totalArea = 8*(wallAreaPerUnit + ceilingAreaPerUnit);
		
		//calculate amount of paint and primer
		double amountOfPaint = Math.ceil(totalArea/paintCoverage);
		double amountOfPrimer = Math.ceil(totalArea/primerCoverage);
		
		//calculate price of paint and primer
		double priceOfPaint = amountOfPaint*paintCost;
		double priceOfPrimer = amountOfPrimer*primerCost;
		double totalCost = priceOfPaint + priceOfPrimer;
		
		//print the output
		System.out.println("**********************************************************");
		System.out.printf("%-40s%10.2f\n","Wall area per unit",wallAreaPerUnit);
		System.out.printf("%-40s%10.2f\n","Ceiling area per unit",ceilingAreaPerUnit);
		System.out.printf("%-40s%10.2f\n","Total area to paint and prime",totalArea);
		System.out.println();
		System.out.printf("%-18s%1.0f%-10s%1.2f%-1s\n","You must purchase",amountOfPaint," gallons of paint for $" ,priceOfPaint,".");
		System.out.printf("%-18s%1.0f%-10s%1.2f%-1s\n","You must purchase",amountOfPrimer," gallons of primer for $" ,priceOfPrimer,".");
		System.out.println();
		System.out.printf("%-30s%1.2f%-1s\n","Your total cost to paint and prime all units is $",totalCost,".");
		System.out.println("**********************************************************");
		
		
	}

}
