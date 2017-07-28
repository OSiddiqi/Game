package Game2;

import java.util.Scanner;
import java.util.Random;


public class BattleManager {
	
		int playerHealth = player.health;
		int attackDamage = player.attackDamage;
		
		private void battle() {
			
			Scanner choice = new Scanner(System.in);
			Random rand = new Random();
			int maxEnemyHealth = 0;
			int enemyHealth = rand.nextInt (maxEnemyHealth);
			System.out.println("Oh no! An " +enemies.enemy + "has appeared!");
			
			while (enemyHealth > 0) {
				System.out.println("\tYour HP:" +player.health);
				System.out.println("\t" + enemies.enemy + "'s Hp: " + enemyHealth);
				System.out.println("\nWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Run");
				
				String input = choice.nextLine();
				if (choice.equals("1")) {
					int damageDealt = rand.nextInt(player.attackDamage);
					int damageTaken = rand.nextInt(enemies.enemyAttackDamage);
					
					enemyHealth -= damageDealt;
					player.health -= damageTaken;
					
					System.out.println("\tYou deal the " + enemies.enemy + " a mighty blow, dealing them " + damageDealt + "damage");
					System.out.println("\tYou receive " + damageTaken +" damage in response. Ruddy " + enemies.enemy);
					
					if (player.health < 1) {
						System.out.println("You are fatally wounded and spend your last breath cursing the " + enemies.enemy);
						break;
					}
					
				} else if (choice.equals("2")) {
					System.out.println("You run like a coward away from the " + enemies.enemy);
					continue;
				
				} else {
					System.out.println("Try again, bucko! That's not an option!");
				}
			}
			System.out.println("You breathe heavily after felling the " +enemies.enemy + " and stagger on");
			System.out.println("Which way would you like to go now?");
			
			System.out.println("\n\t1. North");
			System.out.println("\t2. East");
			System.out.println("\t3. South");
			System.out.println("\t4. West");
			
			/*String input = choice.nextLine();
			if (choice.equals("1")) {
				
				
			}*/
		}
	}


