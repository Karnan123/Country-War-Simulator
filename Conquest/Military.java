import java.math.BigInteger;

abstract class Military {

  protected Country country1;

  BigInteger army1 = new BigInteger("2000000");
  BigInteger army2 = new BigInteger("2000000");

  // public Military() {

  // // this.army = army;
  // }
  // protected BigInteger army = new BigInteger("2000000");

  public Military() {
  }

  public BigInteger getArmyA() {
    return army1;
  }

  public void setArmyA(BigInteger arm) {
    army1 = arm;
  }

  public BigInteger getArmyB() {
    return army2;
  }

  public void setArmyB(BigInteger arm) {
    army2 = arm;
  }

  public void win() {
    System.out.println("\nAttack was successful");
  }

  public void lose() {
    System.out.println("\nAttack has failed");
  }
}