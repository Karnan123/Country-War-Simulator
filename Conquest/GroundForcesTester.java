
;
public class GroundForcesTester {
  public static void main(String[] args) {

    GroundForces groundForcesA = new GroundForces();
    GroundForces groundForcesB = new GroundForces();

    RifleForces Ak47A = new RifleForces(501.4, "Medium Fatality", 39);
    RifleForces ShotgunA = new RifleForces(15.3, "High Fatality At Close Range", 19.5);
    RifleForces M24A = new RifleForces(1051, "High Fatality", 51);

    RifleForces Ak47B = new RifleForces(501.4, "Medium Fatality", 39);
    RifleForces ShotgunB = new RifleForces(15.3, "High Fatality At Close Range", 19.5);
    RifleForces M24B = new RifleForces(1051, "High Fatality", 51);

    Country countryA = new Country(groundForcesA, Ak47A, ShotgunA, M24A);
    Country countryB = new Country(groundForcesB, Ak47B, ShotgunB, M24B);

    System.out.println(countryA.getGroundForces().attack(countryA, countryB, "a"));
    System.out.println(countryA.getGroundForces().attack(countryA, countryB, "b"));
    System.out.println(countryA.getGroundForces().attack(countryA, countryB, "c"));
    System.out.println(countryB.getGroundForces().attack(countryB, countryA, "a"));
    System.out.println(countryB.getGroundForces().attack(countryB, countryA, "b"));
    System.out.println(countryB.getGroundForces().attack(countryB, countryA, "c"));

    System.out.println(countryA.getAk47().fatality(countryA, countryB, "a", 1));
    System.out.println(countryA.getShotgun().fatality(countryA, countryB, "b", 1));
    System.out.println(countryA.getM24().fatality(countryA, countryB, "c", 1));

    System.out.println(countryB.getAk47().fatality(countryB, countryA, "a", 1));
    System.out.println(countryB.getShotgun().fatality(countryB, countryA, "b", 1));
    System.out.println(countryB.getM24().fatality(countryB, countryA, "c", 1));

    System.out.println(countryA.getAk47().attack(countryA, countryB, "a"));
    System.out.println(countryA.getShotgun().attack(countryA, countryB, "b"));
    System.out.println(countryA.getM24().attack(countryA, countryB, "c"));

    System.out.println(countryB.getAk47().attack(countryB, countryA, "a"));
    System.out.println(countryB.getShotgun().attack(countryB, countryA, "b"));
    System.out.println(countryB.getM24().attack(countryB, countryA, "c"));

  }

}