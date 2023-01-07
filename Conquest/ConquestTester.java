import java.util.Scanner;
import java.math.BigInteger;
import java.util.*;

public class ConquestTester {
  public static void main(String[] args) {

    String userInput = " ";
    String weaponInput = " ";
    String nameInput1 = " ";
    String nameInput2 = " ";

    int count = 0;
    int countA = 0;
    int countB = 0;
    int countZ = 0;
    double growthRate = 0;

    Scanner scan = new Scanner(System.in);

    AirForces airForcesA = new AirForces();
    AirForces airForcesB = new AirForces();

    GroundForces groundForcesA = new GroundForces();
    GroundForces groundForcesB = new GroundForces();

    Economy economyA = new Economy();
    Economy economyB = new Economy();

    CentralBank centralBankA = new CentralBank();
    CentralBank centralBankB = new CentralBank();

    RifleForces Ak47A = new RifleForces(501.4, "Medium Fatality", 39);
    RifleForces ShotgunA = new RifleForces(15.3, "High Fatality At Close Range", 19.5);
    RifleForces M24A = new RifleForces(1051, "High Fatality", 51);

    RifleForces Ak47B = new RifleForces(501.4, "Medium Fatality", 39);
    RifleForces ShotgunB = new RifleForces(15.3, "High Fatality At Close Range", 19.5);
    RifleForces M24B = new RifleForces(1051, "High Fatality", 51);

    ArrayList<String> attackListA = new ArrayList<String>();
    ArrayList<String> victoryListA = new ArrayList<String>();
    ArrayList<String> attackListB = new ArrayList<String>();
    ArrayList<String> victoryListB = new ArrayList<String>();

    Country[] countryArray = new Country[2];

    System.out.println("Insert Player 1 username: ");
    nameInput1 = scan.nextLine();

    System.out.println("Insert Player 2 username: ");
    nameInput2 = scan.nextLine();

    Country countryA = new Country(groundForcesA, airForcesA, Ak47A, ShotgunA, M24A, economyA, centralBankA, userInput,
        nameInput1);
    Country countryB = new Country(groundForcesB, airForcesB, Ak47B, ShotgunB, M24B, economyB, centralBankB, userInput,
        nameInput2);

    if (countryA.getArmySize().compareTo(new BigInteger("2000000")) != 0) {
      countryA.setArmySize(new BigInteger("2000000"));
      countryB.setArmySize(new BigInteger("2000000"));
    }

    // inital stats
    System.out.println("\n--------" + countryA.getNameInput() + "'s intial Stats--------");
    System.out.println("Current wealth: " + countryA.wealthRange());
    System.out.println("Current land: " + countryA.landRange());
    System.out.println("Remaining soldiers: " + countryA.getArmySize());
    System.out.println("Airforce Size: " + countryA.getAirForceSize());
    System.out.println("Buildings Left: " + countryA.getTotalBuild());
    System.out.println("Population Size: " + countryA.getPopulation());
    System.out.println("-----------------------------------------\n");

    System.out.println("\n--------" + countryB.getNameInput() + "'s intial Stats--------");
    System.out.println("Current wealth: " + countryB.wealthRange());
    System.out.println("Current land: " + countryB.landRange());
    System.out.println("Remaining soldiers: " + countryB.getArmySize());
    System.out.println("Airforce Size: " + countryB.getAirForceSize());
    System.out.println("Buildings Left: " + countryB.getTotalBuild());
    System.out.println("Population Size: " + countryB.getPopulation());
    System.out.println("-----------------------------------------\n");

    while (count <= 3) {
      System.out.println("---" + nameInput1
          + " NOW PLAYING---\nWould you like to invade Player 2's country(a) or grow your economy(b)? (Insert a or b)");
      userInput = scan.nextLine();

      if (userInput.equals("a")) {
        System.out.println("Would you like to attack by Air or Ground (Insert a or b)");
        userInput = scan.nextLine();

        if (userInput.equals("a")) {
          System.out.println("How would you like to attack? d: Bombers e: Stealth Planes");
          userInput = scan.nextLine();
          attackListA.add(userInput);
          countryA.getAirForces().AirAttack(countryA, countryB, userInput);
        } else if (userInput.equals("b")) {
          System.out.println("How would you like to attack? a: Stealth b: Blitzkrieg c: Charge");
          userInput = scan.nextLine();
          attackListA.add(userInput);

          System.out.println(
              "Would you like to purchase a weapon? \na: Ak-47------800 \nb: Shotgun----600 \nc: M24--------200 \nInsert any other letter to skip\n");

          weaponInput = scan.nextLine();

          if (weaponInput.equals("a")) {
            countryA.setWealth(countryA.getWealth() - 800);
            countryA.getAk47().fatality(countryA, countryB, userInput, 1);
          }

          else if (weaponInput.equals("b")) {
            countryA.setWealth(countryA.getWealth() - 600);
            countryA.getShotgun().fatality(countryA, countryB, userInput, 1);
          }

          else if (weaponInput.equals("c")) {
            countryA.setWealth(countryA.getWealth() - 200);
            countryA.getM24().fatality(countryA, countryB, userInput, 1);
          }

          countryA.getGroundForces().attack(countryA, countryB, userInput);
          victoryListA.add(countryA.getGroundForces().getVictory());
        }
      }

      else if (userInput.equals("b")) {

        growthRate = countryA.getEco().labourMarket(countryA);
        countryA.getCenBank().betLoan(countryA, growthRate);
      }

      System.out.println("\n--------" + countryA.getNameInput() + "'s Stats--------");
      System.out.println("Current wealth: " + countryA.getWealth());
      System.out.println("Current land: " + countryA.getLand());
      System.out.println("Remaining soldiers: " + countryA.getArmySize());
      System.out.println("Airforce Size: " + countryA.getAirForceSize());
      System.out.println("Buildings Left: " + countryA.getTotalBuild());
      System.out.println("Population Size: " + countryA.getPopulation());
      System.out.println("------------------------------\n");

      System.out.println("\n--------" + countryB.getNameInput() + "'s Stats--------");
      System.out.println("Current wealth: " + countryB.getWealth());
      System.out.println("Current land: " + countryB.getLand());
      System.out.println("Remaining soldiers: " + countryB.getArmySize());
      System.out.println("Airforce Size: " + countryB.getAirForceSize());
      System.out.println("Buildings Left: " + countryB.getTotalBuild());
      System.out.println("Population Size: " + countryB.getPopulation());
      System.out.println("------------------------------\n");

      System.out.println("---" + nameInput2
          + " NOW PLAYING---\nWould you like to invade Player 1's country(a) or grow your economy(b)? (Insert a or b)");
      userInput = scan.nextLine();

      if (userInput.equals("a")) {
        System.out.println("Would you like to attack by Air or Ground (Insert a or b)");
        userInput = scan.nextLine();
        if (userInput.equals("a")) {
          System.out.println("How would you like to attack? d: Bombers e: Stealth Planes");
          userInput = scan.nextLine();
          attackListB.add(userInput);
          countryA.getAirForces().AirAttack(countryB, countryA, userInput);
          victoryListB.add(countryB.getGroundForces().getVictory());
        }

        else if (userInput.equals("b")) {
          System.out.println("How would you like to attack? a: Stealth b: Blitzkrieg c: Charge");
          userInput = scan.nextLine();
          attackListB.add(userInput);

          System.out.println(
              "Would you like to purchase a weapon? \na: Ak-47------80 \nb: Shotgun----60 \nc: M24--------20 \nInsert any other letter to skip\n");

          weaponInput = scan.nextLine();

          if (weaponInput.equals("a")) {
            countryB.setWealth(countryB.getWealth() - 80);
            countryB.getAk47().fatality(countryB, countryA, userInput, 2);
          }

          else if (weaponInput.equals("b")) {
            countryB.setWealth(countryB.getWealth() - 60);
            countryB.getShotgun().fatality(countryB, countryA, userInput, 2);
          }

          else if (weaponInput.equals("c")) {
            countryB.setWealth(countryB.getWealth() - 20);
            countryB.getM24().fatality(countryB, countryA, userInput, 2);
          }

          countryB.getGroundForces().attack(countryB, countryA, userInput);
          victoryListB.add(countryB.getGroundForces().getVictory());
        }
      }

      else if (userInput.equals("b")) {
        growthRate = countryB.getEco().labourMarket(countryB);
        countryB.getCenBank().betLoan(countryB, growthRate);
      }

      System.out.println("\n--------" + countryA.getNameInput() + "'s Stats--------");
      System.out.println("Current wealth: " + countryA.getWealth());
      System.out.println("Current land: " + countryA.getLand());
      System.out.println("Remaining soldiers: " + countryA.getArmySize());
      System.out.println("Airforce Size: " + countryA.getAirForceSize());
      System.out.println("Buildings Left: " + countryA.getTotalBuild());
      System.out.println("Population Size: " + countryA.getPopulation());
      System.out.println("------------------------------\n");

      System.out.println("\n--------" + countryB.getNameInput() + "'s Stats--------");
      System.out.println("Current wealth: " + countryB.getWealth());
      System.out.println("Current land: " + countryB.getLand());
      System.out.println("Remaining soldiers: " + countryB.getArmySize());
      System.out.println("Airforce Size: " + countryB.getAirForceSize());
      System.out.println("Buildings Left: " + countryB.getTotalBuild());
      System.out.println("Population Size: " + countryB.getPopulation());
      System.out.println("------------------------------\n");
      count++;
    }

    countryArray[0] = countryA;
    countryArray[1] = countryB;

    System.out.println("\n----" + nameInput1 + "'s Choices----");
    for (int j = 0; j < attackListA.size(); j++) {
      System.out.println(countryA.toStringAttack(attackListA.get(j), countryA.toStringVictory(victoryListA.get(j))));
    }
    System.out.println("-------------------------------------");

    System.out.println("\n----" + nameInput2 + "'s Choices----");
    for (int j = 0; j < attackListB.size(); j++) {
      System.out.println(countryB.toStringAttack(attackListB.get(j), countryB.toStringVictory(victoryListB.get(j))));
    }
    System.out.println("-------------------------------------");

    countZ = 0;

    System.out.println("\n----High Score LeaderBoard Wealth----");
    for (int j = 0; j < countryArray.length; j++) {
      countZ++;

      countryA.setScoreChoice(1);
      countryB.setScoreChoice(1);
      Arrays.sort(countryArray);
      System.out.println(countryArray[j].toString(countZ, 1));
    }

    System.out.println("-------------------------------------");

    countZ = 0;

    System.out.println("\n-----High Score LeaderBoard Land-----");
    for (int j = 0; j < countryArray.length; j++) {
      countZ++;

      countryA.setScoreChoice(2);
      countryB.setScoreChoice(2);
      Arrays.sort(countryArray);
      System.out.println(countryArray[j].toString(countZ, 2));
    }
    System.out.println("-------------------------------------");

    countZ = 0;

    System.out.println("\n---High Score LeaderBoard Soldiers---");
    for (int j = 0; j < countryArray.length; j++) {
      countZ++;

      countryA.setScoreChoice(3);
      countryB.setScoreChoice(3);
      Arrays.sort(countryArray);
      System.out.println(countryArray[j].toString(countZ, 3));
    }
    System.out.println("-------------------------------------");

    countZ = 0;

    System.out.println("\n---High Score LeaderBoard AirForce---");
    for (int j = 0; j < countryArray.length; j++) {
      countZ++;

      countryA.setScoreChoice(4);
      countryB.setScoreChoice(4);
      Arrays.sort(countryArray);
      System.out.println(countryArray[j].toString(countZ, 4));
    }
    System.out.println("-------------------------------------");

    countZ = 0;

    System.out.println("\n---High Score LeaderBoard Buildings Left---");
    for (int j = 0; j < countryArray.length; j++) {
      countZ++;

      countryA.setScoreChoice(5);
      countryB.setScoreChoice(5);
      Arrays.sort(countryArray);
      System.out.println(countryArray[j].toString(countZ, 5));
    }
    System.out.println("-------------------------------------");

    if (countryA.getWealth() > countryB.getWealth()) {
      countA++;
    } else {
      countB++;
    }
    if (countryA.getLand() > countryB.getLand()) {
      countA++;
    } else {
      countB++;
    }
    if (countryA.getArmySize().compareTo(countryB.getArmySize()) > 0) {
      countA++;
    } else {
      countB++;
    }

    if (countryA.getAirForceSize().compareTo(countryB.getAirForceSize()) > 0) {
      countA++;
    } else {
      countB++;
    }
    if (countryA.getTotalBuild() > countryB.getTotalBuild()) {
      countA++;
    } else {
      countB++;
    }

    if (countA > countB) {
      System.out.println(nameInput1 + " has won.");
    } else if (countB > countA) {
      System.out.println(nameInput2 + " has won.");
    } else if (countA == countB) {
      System.out.println("There has been a tie.");
    }
  }
}