/*
Name: Susan Pinchiaroli
Assignment 3
Problem 1


In this problem, I created an array called "hand" that holds 5 elements.
This is going to hold the 5 cards that we will pull and will be used in 
the later methods to test if the hand is a straight flush.

I then imported Random and made r a random object.
After this, i declared randomSeed as an int because this will hold the 
new seed after each straight flush is found. 
Then I declared a value called randomValue and this is going to store the 
new randomValue in the outer for loop that will serve to find the actual 
random card. 

Then I created an array called tries that will hold ten values, for the tend seeds
and count how many hands it took to get a straight flush for each seed. 

There is an outer for loop that iterates up to 10, for 10 seeds. 
In this for loop, we use the randomSeed integer variable and pull a random value
this will be our seed.
This randomSeed will be used as the seed for randomValue. 

Then there is an inner while loop that will iterate until we get a straight flush
This whle loop has an inner for loop in it. This will iterate through "hand" length
This for loop will also pull a random card value from 1-52. 
There is an inner while loop in this for loop to ensure that we aren't pulling duplicates
This for loop sends the current card value and the array hand to the method handCard()

handCard is a method that returns a boolean value and takes an array and integer as its parameters
Inside the method, it uses a for loop to iterate through hand array to find if there are duplicates of the value card
it does this by using a boolean condition. If we do find a duplicate, it returns true. If we do not find a duplicate, we return false

This boolean value will determine whether or not the program will exit out of the while loop,
this way we don't test the hand until we're sure there are not duplicates. 

After this, i used the Arrays.sort function to sort the array hand. This way I can easily find if values are sequential
After this, I accumulated tries array at at whatever value seed is because we've pulled one hand. 
After this, there is an if statement that sends the hand array to the method isFlush.

isFlush returns a boolean value and accepts an array as its parameters. It checks if values are sequential by using a for loop
to iterate until length of the array hand. It checks if values are sequential. If they aren't, it immediately returns false. 
After this, we have to check that it is among the same suits. We do this by checking if certain values are in the array.
If 13 and 14 are together, then we know that there is not a straight flush because two suits are in the sequence. If values like this are together,
we return false. else, we return true. This true statement is going to determine whether or not the hand is a straight flush. If it is, then we break out of for loop
and pick a new seed and start all over. Once we find a straight flush for each seed, then we iterate through tries array and find the sum of all hand tries.
Then, we divide this value by 10 to fin average hands per seed.  


*/



import java.util.Arrays;
import java.util.Random;
public class Assign3Problem1{
	public static void main(String[] args){

		int hand[]= new int[5];

		Random r = new Random();
		int randomSeed;
		Random randomValue;
		int card;

		int[] tries = new int[10];


		for (int seed = 0; seed<10;seed++)
		{
			randomSeed = r.nextInt();
			randomValue = new Random(randomSeed);
			

			while (true)//outer loop that will iterate until you get a hand
			{
				for (int i = 0; i<hand.length; i++)
				{
					card = randomValue.nextInt(52)+1;
					while (handCard(hand,card)){//while loop checking to see if there's a duplicate
						card = randomValue.nextInt(52)+1;

					}
					hand[i] = card;
				}
				Arrays.sort(hand);
				tries[seed]+=1;

				if (isFlush(hand))
				{
					break;


		}




	}
}
	int sum=0;
	for (int x =0; x<tries.length;x++){
		sum+=tries[x];

	}
	sum = sum/10;
	System.out.println("The average hands pulled per seed to get a straight flush is "+ sum);
	}
	public static boolean handCard(int[] hand, int card)
	{
		for (int i =0; i<hand.length;i++)
		{
			if (hand[i] ==card)
			{
				return true;
			}
		}
		return false;
	}

public static boolean isFlush(int[] hand)
{
	for (int c=0;c<hand.length-1;c++)
	{
		if (hand[c] !=hand[c+1] -1 )
		{
			return false;
		}
	}

	if ((handCard(hand,13) && (handCard(hand,14))))
	{
		return false;
	}
	if ((handCard(hand,26)&&handCard(hand,27)))
	{
		return false;
	}
	if (handCard(hand,39)&& handCard(hand,40)){
		return false;
	}
	return true;
}


}

