public class CentralBankTester {
  public static void main (String[] args )  {

  CentralBank bank = new CentralBank();
  GroundForces groundForcesA = new GroundForces();
  Country countryA = new Country(groundForcesA);

  System.out.println (bank.betLoan(countryA,12));
  System.out.println (bank.betLoan(countryA,40000000));
  System.out.println (bank.betLoan(countryA,12000000));
  System.out.println (bank.betLoan(countryA,36000000));
  System.out.println (bank.betLoan(countryA,10000000));


  System.out.println(bank.labourMarket(countryA));
  System.out.println(bank.labourMarket(countryA));
  System.out.println(bank.labourMarket(countryA));
  System.out.println(bank.labourMarket(countryA));
  System.out.println(bank.labourMarket(countryA));



  }

}