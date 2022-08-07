package RAUproblem;

import java.util.Scanner;

public class code {
	
	static Scanner input= new Scanner(System.in);
	
	public static void main(String args[]) {
		int num_soldiers, num_attacks, soldier_hp;
		
		num_soldiers=input.nextInt();
		num_attacks=input.nextInt();
		soldier_hp=input.nextInt();
		
		int[] soldier_array;
		
		soldier_array=new int[num_soldiers];
		
		for(int i=0; i<soldier_array.length; i++)
			soldier_array[i]=soldier_hp;
		
		int current_attack=0;
		while(num_attacks!=0) {
			current_attack++;
			soldier_array=calculate_attack(soldier_array, current_attack);
			num_attacks--;
			System.out.println(" ");
		}
		
		int num_soldiers_alive=check_soldiers_alive(soldier_array);
		
		if(num_soldiers_alive==soldier_array.length)
			System.out.print("All soldiers survived");
		else if (num_soldiers_alive==0)
			System.out.print("All soldiers died");
		else  {
			int dead_soldiers;
			if (num_soldiers_alive>soldier_array.length)
				dead_soldiers=num_soldiers_alive-soldier_array.length;
			else
				dead_soldiers=soldier_array.length-num_soldiers_alive;
			System.out.print(num_soldiers_alive + " soldiers survived and " + dead_soldiers + " died");
			
		}
		input.close();
	}
	

	public static int[] calculate_attack (int[] soldier_data, int attack_number) {
		int inf_limit, sup_limit, attack_dmg;
			inf_limit=input.nextInt();
			sup_limit=input.nextInt();
			attack_dmg=input.nextInt();
			for(int i=inf_limit; i<=sup_limit; i++) 
				soldier_data[i]-=attack_dmg;
			System.out.print("Attack #" + attack_number + ":");
			for(int num : soldier_data)
				System.out.print(num + " ");
			
		return soldier_data;
		
	}

	public static int check_soldiers_alive(int[] soldier_data) {
		int num_alive=0;
		for(int i=0; i<soldier_data.length; i++)
			if(soldier_data[i]>0)
				num_alive++;
		return num_alive;
	}
	
}

