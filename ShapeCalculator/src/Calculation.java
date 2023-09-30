/**
 * This program is computing the perimeter and area of circle, rectangle or triangle
 */
public class Calculation {
    /**
     * This function is counting an area of circle based on radius.
     * @param rad - the radius of circle
     * @return circleArea - Area of circle
     */
    public double circleArea(double rad){
        double circleArea;
        circleArea = rad*rad* Math.PI;
        return circleArea;
    }

    /**
     * This function is counting the area of rectangle based od length both sides
     * @param lengthOne - length of one side of rectangle
     * @param lengthTwo - length of second side of rectangle
     * @return rectangle Area - Area of rectangle
     */
    public double rectangleArea(double lengthOne, double lengthTwo){
        double rectangleArea;
        rectangleArea = lengthOne*lengthTwo;
        return rectangleArea;
    }

    /**
     * This function is counting the area of triangle based od length three sides
     * @param oneSide - length of one side of triangle
     * @param secondSide - length of second side of triangle
     * @param thirdSide - length of third side of triangle
     * @return triangleArea - Area of triangle
     */
    public double triangleArea(double oneSide, double secondSide, double thirdSide){
        double triangleArea, p;
        Calculation c = new Calculation();
        p= (c.trianglePerimeter(oneSide,secondSide,thirdSide))/2;
        triangleArea = Math.sqrt(p*(p-oneSide)*(p-secondSide)*(p-thirdSide));
        return triangleArea;
    }

    /**
     * This function is counting the circumference of circle based on radius
     * @param rad - the radius of circle
     * @return circlePerimeter - circumference of circle
     */
    public double circlePerimeter(double rad){
        double circlePerimeter;
        circlePerimeter = 2* Math.PI*rad;
        return  circlePerimeter;
    }

    /**
     * This function is counting the perimeter of rectangle based od length both sides
     * @param lengthOne - length of one side of rectangle
     * @param lengthTwo - length of second side of rectangle
     * @return rectanglePerimeter - Perimeter of rectangle
     */
    public double rectanglePerimeter(double lengthOne, double lengthTwo){
        double rectanglePerimeter;
        rectanglePerimeter = 2*lengthOne + 2*lengthTwo;
        return rectanglePerimeter;
    }

    /**
     * This function is counting the perimeter of triangle based od length three sides
     * @param oneSide - length of one side of triangle
     * @param secondSide - length of second side of triangle
     * @param thirdSide - length of third side of triangle
     * @return trianglePerimeter - perimeter of triangle
     */
    public double trianglePerimeter(double oneSide, double secondSide, double thirdSide){
        double trianglePerimeter;
        trianglePerimeter = oneSide+secondSide+thirdSide;
        return trianglePerimeter;
    }
}
