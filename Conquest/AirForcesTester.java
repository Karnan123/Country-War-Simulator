public class AirForcesTester {
  public static void main (String[] args )  {

    AirForces airForceA = new AirForces();
    AirForces airForceB = new AirForces();

    Country country;
    Country countryB;

    
    System.out.println(countryA.getAirForces().AirAttack(countryA, countryB, "d"));
    System.out.println(countryA.getAirForces().AirAttack(countryA, countryB, "e"));
    System.out.println(countryB.getAirForces().AirAttack(countryB, countryA, "d"));
    System.out.println(countryB.getAirForces().AirAttack(countryB, countryA, "e"));
    


    


  }

}