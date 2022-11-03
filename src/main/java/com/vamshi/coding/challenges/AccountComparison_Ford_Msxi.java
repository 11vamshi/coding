package com.vamshi.coding.challenges;


class AccountComparison_Ford_Msxi implements OnlineAccount, Comparable<AccountComparison_Ford_Msxi> {
    int noOfRegularMovies, noOfExclusiveMovies;
    String ownerName;
    // 1) Add a parameterized constructor that initializes the attributes
//    noOfRegularMovies and noOfExclusiveMovies.
    public AccountComparison_Ford_Msxi(String ownerName, int noOfRegularMovies,
                   int noOfExclusiveMovies){
        this.ownerName=ownerName;
        this.noOfExclusiveMovies=noOfExclusiveMovies;
        this.noOfRegularMovies=noOfRegularMovies;
    }

    // 2. This method returns the monthly cost for the account.
    public int monthlyCost() {
        return basePrice+(noOfRegularMovies*regularMoviePrice) +
                (noOfExclusiveMovies*exclusiveMoviePrice);
    }

//    // 3. Override the compareTo method of the Comparable interface such that
//    two accounts can be compared based on their monthly cost.
    @Override
    public int compareTo(AccountComparison_Ford_Msxi account){
        return this.monthlyCost()>account.monthlyCost()? 1 : -1;
    }

// 4. Returns "Owner is [ownerName] and monthly cost is [monthlyCost]
//    USD."
    public String toString() {
//Overring toString Method to return coustom output as requested
        return "Owner is " + this.ownerName + " and monthly cost is "
                +this.monthlyCost() + " USD." ;
    }

}