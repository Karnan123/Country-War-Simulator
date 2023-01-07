class Economy {
    
  private double growthRate;
  
  public Economy() {
    
  }

  public double labourMarket(Country country) {
    
    if (country.getPopulation() > 39000000) {
      growthRate = country.getPopulation() * 0.8 + 600;
      System.out.println(growthRate);
    }

    else if (country.getPopulation() > 35000000 && country.getPopulation() < 39000000) {
      growthRate = country.getPopulation() * 0.6 + 300;
    }

    else if (country.getPopulation() > 30000000 && country.getPopulation() < 35000000) {
      growthRate = country.getPopulation() * 0.3 + 100;
    }
    else if (country.getPopulation() < 30000000) {

      growthRate = country.getPopulation() * 0.1 + 50;
    }

    
    return growthRate;
  }


  public double getGrowthRate() {

    return growthRate;
  }
  public void setGrowthRate(double gr) {

    growthRate = gr;
  }
}


