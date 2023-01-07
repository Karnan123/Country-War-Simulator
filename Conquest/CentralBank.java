class CentralBank extends Economy {
  
  private double grant;
  private double interestRate = 1.5;
  
  public CentralBank() {

  }

  public double betLoan(Country country, double growthRate) {
    
    if (growthRate > 31200600) {

      grant = country.getWealth() + 400 * interestRate;
      country.setWealth(grant);
      
    }

    else if (growthRate > 21000300 && growthRate < 31200600) {

      grant = country.getWealth() + 300 * interestRate;
      country.setWealth(grant);
    }

    else if (growthRate > 9000100 && growthRate < 21000300) {

      grant = country.getWealth() + 200 * interestRate;
      country.setWealth(grant);
    } 

    else if (growthRate < 9000100){
        

      grant = country.getWealth() + 100 * interestRate;
      country.setWealth(grant);
        
    }
    return grant;
      
  } 
    
    
    
    
    
    
    
    // if (userInput.equals("a")) {
    //   if (victory.equals("a")) {                                               
    //   }
    // }
    // else if (victory.equals(" ")) {
    //   country.setWealth(country.getWealth() - country.getWealth()*interestRate);
    // }
}