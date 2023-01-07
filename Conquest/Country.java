import java.math.BigInteger;
import java.util.*;

class Country implements Comparable<Country>, action {
  // Declared instance variables.
  private double wealth;
  private double land;
  private String userInput;
  private String nameInput;
  private int scoreChoice;
  private BigInteger army1;
  private BigInteger AirForceSize;
  private int RemBuild = 2000;
  private int population = 40000000;
  private GroundForces gf;
  private AirForces af;
  private RifleForces Ak;
  private RifleForces Sg;
  private RifleForces M24;
  private Military Mil;
  private Economy eco;
  private CentralBank CenBank;
  private double growthRate;

  public Country(GroundForces gf, AirForces af, RifleForces Ak, RifleForces Sg, RifleForces M24, Economy eco,
      CentralBank CenBank, String userInput, String nameInput) {

    this.gf = gf;
    this.af = af;
    this.Ak = Ak;
    this.Sg = Sg;
    this.M24 = M24;
    this.eco = eco;
    this.CenBank = CenBank;
    this.userInput = userInput;
    this.nameInput = nameInput;
  }

  public Country(GroundForces gf, RifleForces Ak, RifleForces Sg, RifleForces M24) {
    this.Sg = Sg;
    this.gf = gf;
    this.Ak = Ak;
    this.M24 = M24;

  }

  public double getWealth() {
    return wealth;
  }

  public void setWealth(double wea) {
    wealth = wea;
  }

  public double getLand() {
    return land;
  }

  public void setLand(double lan) {
    land = lan;
  }

  public void setTotalBuild(int totalbuild) {
    RemBuild = totalbuild;
  }

  public int getTotalBuild() {
    return RemBuild;
  }

  public void setPopulation(int pop) {
    population = pop;
  }

  public int getPopulation() {
    return population;
  }

  public String getNameInput() {
    return nameInput;
  }

  public void setNameInput(String name) {
    nameInput = name;
  }

  public Military getMilitary() {
    return Mil;
  }

  public GroundForces getGroundForces() {
    return gf;
  }

  public AirForces getAirForces() {
    return af;
  }

  public RifleForces getAk47() {
    return Ak;
  }

  public RifleForces getShotgun() {
    return Sg;
  }

  public RifleForces getM24() {
    return M24;
  }

  public Economy getEco() {
    return eco;
  }

  public CentralBank getCenBank() {
    return CenBank;
  }

  public void setArmySize(BigInteger arm) {
    army1 = arm;
    gf.setArmyA(army1);
  }

  public BigInteger getArmySize() {
    return gf.getArmyA();
  }

  public BigInteger getAirForceSize() {

    return af.getAirForce();
  }

  public void setAirForceSize(BigInteger af1) {

    AirForceSize = af1;
    af.setAirForce(AirForceSize);
  }

  public double wealthRange() {
    wealth = Math.random() * (maxChange * 3 - minChange * 10) + minChange * 80;
    return wealth;
  }

  public double landRange() {
    land = Math.random() * (maxChange * 3 - minChange * 10) + minChange * 50;
    return land;
  }

  public double economy() {
    wealth = wealth + Math.random() * (maxChange * 1.5 - minChange) + minChange;
    return wealth;
  }

  public int getScoreChoice() {
    return scoreChoice;
  }

  public void setScoreChoice(int choice) {
    scoreChoice = choice;
  }

  public int compareTo(Country country) {

    if (getScoreChoice() == 1) {
      if ((getWealth() - country.getWealth()) != 0) {

        if (getWealth() > country.getWealth()) {
          return -1;
        }

        else {
          return 1;
        }
      }

      else {
        return 1;
      }
    }

    else if (getScoreChoice() == 2) {
      if ((getLand() - country.getLand()) != 0) {

        if (getLand() > country.getLand()) {
          return -1;
        }

        else {
          return 1;
        }
      }

      else {
        return 0;
      }
    }

    else if (getScoreChoice() == 3) {
      if ((getArmySize().equals(country.getArmySize())) == false) {

        if (getArmySize().compareTo(country.getArmySize()) > 0) {
          return -1;
        }

        else {
          return 1;
        }
      }

      else {
        return 0;
      }
    }

    else if (getScoreChoice() == 4) {
      if ((getAirForceSize().equals(country.getAirForceSize())) == false) {

        if (getAirForceSize().compareTo(country.getAirForceSize()) > 0) {
          return -1;
        }

        else {
          return 1;
        }
      }

      else {
        return 0;
      }
    }

    else if (getScoreChoice() == 5) {
      if ((getTotalBuild() - country.getTotalBuild()) != 0) {

        if (getTotalBuild() > country.getTotalBuild()) {
          return -1;
        }

        else {
          return 1;
        }
      }

      else {
        return 0;
      }
    }

    else {
      System.out.println("error -- compareTo");
      return 1;
    }
  }

  public String toString(int count, int choice) {

    if (choice == 1) {
      return count + ". " + getNameInput() + ".....Wealth: " + getWealth();
    }

    else if (choice == 2) {
      return count + ". " + getNameInput() + ".....Land: " + getLand();
    }

    else if (choice == 3) {
      return count + ". " + getNameInput() + ".....Soldiers: " + getArmySize();
    }

    else if (choice == 4) {
      return count + ". " + getNameInput() + ".....AirForce: " + getAirForceSize();
    }

    else if (choice == 5) {
      return count + ". " + getNameInput() + ".....Buildings Left: " + getTotalBuild();
    }

    else {
      return "error";
    }
  }

  public String toStringVictory(String victory) {
    if (victory == "a") {
      return "Success";
    } else {
      return "Failed";
    }
  }

  public String toStringAttack(String attack, String victory) {
    if (attack.equals("a")) {
      return "Stealth....." + victory;
    } else if (attack.equals("b")) {
      return "Blitzkrieg....." + victory;
    } else if (attack.equals("c")) {
      return "Charge....." + victory;
    } else if (attack.equals("d")) {
      return "Bombers....." + victory;
    } else if (attack.equals("e")) {
      return "Stealth Planes....." + victory;
    } else {
      return "Nothing chosen....." + victory;
    }
  }

}