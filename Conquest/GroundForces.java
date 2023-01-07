import java.math.BigInteger;

class GroundForces extends Military implements action {

  double temWealth = 0;
  double temLand = 0;
  int temPop = 0;
  private String victory = " ";

  public GroundForces() {
    // super(army);
  }

  // Attack techniques the player can choose from
  public double attack(Country ally, Country enemy, String att) { // Interface method cause it has a common name?
    String attack = att;
    int luck = 0;
    int max = 10;
    int min = 1;

    if (attack.compareTo("a") == 0) {

      luck = (int) (Math.random() * (max - min)) + min;

      if (luck <= 8 && luck > 0) {

        temWealth = (Math.random() * (maxChange - minChange * 2) + minChange);
        ally.setWealth(ally.getWealth() + temWealth);
        enemy.setWealth(enemy.getWealth() - temWealth);

        super.win();
        victory = "a";
        setVictory(victory);
        temLand = 0;
        System.out.println(toStringWealth(victory));
        System.out.println(toStringLand(victory));
      }

      else {
        temWealth = (Math.random() * (maxChange * 2 - minChange * 2) + minChange);
        ally.setWealth(ally.getWealth() - temWealth);
        enemy.setWealth(enemy.getWealth() - temWealth * 0.3);
        super.lose();
        temLand = 0;
        setVictory(" ");
        System.out.println(toStringWealth(victory));
        System.out.println(toStringLand(victory));
      }
    }
    if (attack.compareTo("b") == 0) {

      luck = (int) (Math.random() * (max - min)) + min;

      if (luck < 4 && luck > 0) {
        temWealth = (Math.random() * (maxChange * 3 - minChange * 10) + minChange * 10);
        ally.setWealth(ally.getWealth() + 400 + temWealth);
        enemy.setWealth(enemy.getWealth() - 400 - temWealth - (Math.random() * (maxChange - minChange) + minChange));

        temLand = (Math.random() * (maxChange * 3 - minChange * 3) + minChange * 11);
        ally.setLand(ally.getLand() + temLand);
        enemy.setLand(enemy.getLand() - temLand - (Math.random() * (maxChange - minChange) + minChange));

        temPop = (int) (Math.random() * (maxChange * 11 - minChange * 10) + minChange * 40);
        enemy.setPopulation(enemy.getPopulation() - temPop);

        super.win();
        victory = "a";
        setVictory(victory);
        System.out.println(toStringWealth(victory));
        System.out.println(toStringLand(victory));
      }

      else {
        temWealth = (Math.random() * (maxChange * 2 - minChange * 5) + minChange * 1.7);
        ally.setWealth(ally.getWealth() - temWealth);
        enemy.setWealth(enemy.getWealth() - temWealth * 0.9);

        super.lose();
        temLand = 0;
        setVictory(" ");
        System.out.println(toStringWealth(victory));
        System.out.println(toStringLand(victory));
      }
    }
    if (attack.compareTo("c") == 0) {

      luck = (int) (Math.random() * (max - min)) + min;

      if (luck < 6 && luck > 0) {

        temWealth = (Math.random() * (maxChange * 2 - minChange * 5) + minChange * 3);
        ally.setWealth(ally.getWealth() + temWealth);
        enemy.setWealth(enemy.getWealth() - 300 - temWealth);

        temLand = (Math.random() * (maxChange * 2 - minChange * 1.5) + minChange * 3);
        ally.setLand(ally.getLand() + temLand);
        enemy.setLand(enemy.getLand() - 200 - temLand);

        temPop = (int) (Math.random() * (maxChange * 9 - minChange * 17) + minChange * 30);
        enemy.setPopulation(enemy.getPopulation() - temPop);

        super.win();
        victory = "a";
        setVictory(victory);
        System.out.println(toStringWealth(victory));
        System.out.println(toStringLand(victory));
      }

      else {
        temWealth = (Math.random() * (maxChange * 3 - minChange * 8) + minChange * 4);
        ally.setWealth(ally.getWealth() - temWealth);
        enemy.setWealth(enemy.getWealth() - temWealth * 0.6);
        super.lose();
        temLand = 0;
        setVictory(" ");
        System.out.println(toStringWealth(victory));
        System.out.println(toStringLand(victory));
      }
    }

    return ally.getWealth(); // Do we rlly need a return?
  }

  public String toStringWealth(String victory) {

    if (victory.equals("a")) {
      return "Wealth: You have gained " + temWealth;
    }

    else {
      return "Wealth: You have lost " + temWealth;
    }
  }

  public String toStringLand(String victory) {
    if (victory.equals("a")) {
      return "Land: You have gained " + temLand;
    }

    else {
      return "Land: You have lost " + temLand;
    }
  }

  public String getVictory() {
    return victory;
  }

  public void setVictory(String vic) {
    victory = vic;
  }
}
