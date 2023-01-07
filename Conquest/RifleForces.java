
import java.math.BigInteger;

class RifleForces extends GroundForces {

  protected double gunRange;
  protected String gunFatality;
  protected double BulletSize;
  public BigInteger store;

  public RifleForces(double Grange, String Gfatality, double BS) {

    // super(army);
    gunRange = Grange;
    gunFatality = Gfatality;
    BulletSize = BS;
  }

  public double getGunRange() {
    return gunRange;
  }

  public String getFatality() {
    return gunFatality;
  }

  public double getBS() {
    return BulletSize;
  }

  public BigInteger fatality(Country ally, Country enemy, String att, int round) {

    String attack = att;
    if (round == 1) {
      if (attack.compareTo("a") == 0) {

        if (gunRange == 15.3 || gunRange == 1051) {
          store = enemy.getArmySize().subtract(new BigInteger("7000"));
          enemy.setArmySize(enemy.getArmySize().subtract(new BigInteger("7000")));
          System.out.println(store);

          store = ally.getArmySize().subtract(new BigInteger("500"));
          ally.setArmySize(ally.getArmySize().subtract(new BigInteger("500")));
          System.out.println(store);
        } else {
          enemy.setArmySize(enemy.getArmySize().subtract(new BigInteger("500")));
          ally.setArmySize(ally.getArmySize().subtract(new BigInteger("400")));
        }

        if (BulletSize == 19.5 || BulletSize == 51) {
          enemy.setArmySize(enemy.getArmySize().subtract(new BigInteger("3000")));
          ally.setArmySize(ally.getArmySize().subtract(new BigInteger("1000")));
        } else {
          enemy.setArmySize(enemy.getArmySize().subtract(new BigInteger("200")));
          ally.setArmySize(ally.getArmySize().subtract(new BigInteger("150")));
        }
      } else if (attack.compareTo("b") == 0) {
        if (gunRange <= 501.4) {
          enemy.setArmySize(enemy.getArmySize().subtract(new BigInteger("70000")));
          ally.setArmySize(ally.getArmySize().subtract(new BigInteger("30000")));
        } else {
          enemy.setArmySize(enemy.getArmySize().subtract(new BigInteger("14000")));
          ally.setArmySize(ally.getArmySize().subtract(new BigInteger("13000")));
        }

        if (BulletSize <= 39) {
          enemy.setArmySize(enemy.getArmySize().subtract(new BigInteger("20000")));
          ally.setArmySize(ally.getArmySize().subtract(new BigInteger("1500")));
        } else {
          enemy.setArmySize(enemy.getArmySize().subtract(new BigInteger("4000")));
          ally.setArmySize(ally.getArmySize().subtract(new BigInteger("2000")));
        }
      } else if (attack.compareTo("c") == 0) {
        if (gunRange < 1051) {
          enemy.setArmySize(enemy.getArmySize().subtract(new BigInteger("40000")));
          ally.setArmySize(ally.getArmySize().subtract(new BigInteger("20000")));
        } else {
          enemy.setArmySize(enemy.getArmySize().subtract(new BigInteger("7000")));
          ally.setArmySize(ally.getArmySize().subtract(new BigInteger("6500")));
        }

        if (BulletSize < 51) {
          enemy.setArmySize(enemy.getArmySize().subtract(new BigInteger("30000")));
          ally.setArmySize(ally.getArmySize().subtract(new BigInteger("12000")));
        } else {
          enemy.setArmySize(enemy.getArmySize().subtract(new BigInteger("12000")));
          ally.setArmySize(ally.getArmySize().subtract(new BigInteger("9000")));
        }
      }
    }
    return ally.getArmySize();

  }
}
