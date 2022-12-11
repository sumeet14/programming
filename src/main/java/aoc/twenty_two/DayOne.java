package aoc.twenty_two;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DayOne {

    int processInput(){
        List<Integer> calories = new ArrayList<>();
        File myObj = new File("/Users/sumeetkoli/IdeaProjects/programming/src/main/resources/aoc/day_one_input_2.txt");
        Scanner myReader = null;
        int maxCalories=0;
        try {
            myReader = new Scanner(myObj);
            int calorieSum = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data != "" && data !=null)
                    calorieSum += Integer.parseInt(data);
                else{
                    calories.add(calorieSum);
                    if(calorieSum>maxCalories) maxCalories=calorieSum;
                    calorieSum=0;
                }
            }
            calories.add(calorieSum);
            if(calorieSum>maxCalories) maxCalories=calorieSum;
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Collections.sort(calories, Collections.reverseOrder());
        System.out.println(calories);
        return calories.get(0)+calories.get(1)+calories.get(2);
    }

    public static void main(String[] args) {
        DayOne dayOne = new DayOne();
        //List calories = dayOne.processInput();
        System.out.println(dayOne.processInput());
    }
}
