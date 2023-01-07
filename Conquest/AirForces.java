import java.math.BigInteger;
import java.lang.Math;

class AirForces extends Military {
  int temBuildingsDestroyed = 0;
  int temPop = 0;
  double temWealth = 0;
  String victory = "";
  BigInteger Airforce = new BigInteger("5000");
  
  
  public double AirAttack (Country ally, Country enemy, String airAtt) {

    String AirAttack = airAtt;
    int luck = 0;
    int max = 10;
    int min = 1;

    if (AirAttack.compareTo("d") == 0) {

      luck =  (int) (Math.random() * (max - min)) + min;

      if (luck <= 4 && luck > 0) {
        
        temWealth = ally.getWealth() * 0.05 + 50;
        enemy.setTotalBuild(enemy.getTotalBuild() - 50);
        temBuildingsDestroyed = temBuildingsDestroyed + 50;
        ally.setWealth(ally.getWealth() + temWealth);
        enemy.setWealth(enemy.getWealth() - temWealth*1.2);

        temPop = (int) Math.round(enemy.getPopulation()*0.08);
        enemy.setPopulation(enemy.getPopulation() - temPop);
        
        victory = "a";
        super.win();
        ally.setAirForceSize(ally.getAirForceSize().subtract(new BigInteger("500")));
        System.out.println(toStringWealth(victory));
        System.out.println(toStringBuildingDestroyed(victory));
        temBuildingsDestroyed = 0;
      }
        
      else {
        temBuildingsDestroyed = 0;
        temWealth = ally.getWealth() * 0.07 - 200;
        ally.setWealth(ally.getWealth() - temWealth);
        enemy.setWealth(enemy.getWealth() - temWealth * 0.3);
        super.lose();
        victory = " ";
        System.out.println(toStringWealth(victory));
        System.out.println(toStringBuildingDestroyed(victory));
      }
    }
    else if (AirAttack.compareTo("e") == 0) {

      luck =  (int) (Math.random() * (max - min)) + min;

      if(luck <= 4 && luck > 0) {

        temWealth = ally.getWealth() * 0.10 + 150;
        enemy.setTotalBuild(enemy.getTotalBuild() - 100);
        temBuildingsDestroyed = temBuildingsDestroyed + 100;
        ally.setWealth(ally.getWealth() + temWealth);
        enemy.setWealth(enemy.getWealth() - temWealth * 1.1);
        
        temPop = (int) Math.round(enemy.getPopulation()*0.12);
        enemy.setPopulation(enemy.getPopulation() - temPop);
        
        victory = "a";
        super.win();
        ally.setAirForceSize(ally.getAirForceSize().subtract(new BigInteger("700")));
        System.out.println(toStringWealth(victory));
        System.out.println(toStringBuildingDestroyed(victory));
        temBuildingsDestroyed = 0;
      }
      else {
        temBuildingsDestroyed = 0;
        temWealth = ally.getWealth() * 0.09 - 200;
        ally.setWealth(ally.getWealth() - temWealth);
        enemy.setWealth(enemy.getWealth() - temWealth*0.5);
        super.lose();
        victory = " ";
        System.out.println(toStringWealth(victory));
        System.out.println(toStringBuildingDestroyed(victory));
      }
    }
    
    return ally.getTotalBuild();
  }
  
  public String toStringWealth(String victory) {
    
    if (victory.equals("a")) {
      return "Wealth: You have gained " + temWealth;
    }

    else {
      return "Wealth: You have lost " + temWealth;
    }
  }
  public String toStringBuildingDestroyed(String victory) {

    if (victory.equals("a")) {

      return "Enemy Buildings destroyed:" + temBuildingsDestroyed;
    }
    else {
      return "You have not destroyed any buildings.";
    }
  }

  public BigInteger getAirForce() {

    return Airforce;
  }
  public void setAirForce(BigInteger af) {
    Airforce = af;
  }
}