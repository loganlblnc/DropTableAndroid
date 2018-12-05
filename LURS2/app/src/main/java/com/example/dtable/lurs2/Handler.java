package com.example.dtable.lurs2;

public class Handler {
    ReviewDao db;
    public Handler(ReviewDao db){
        this.db=db;
    }
    public void delete(){
        db.deleteAll();
    }
    public void createDB(){
        Review Mcdonalds=new Review("McDonalds","123 Johnston","FastFood");
        Review bKing=new Review("BurgerKing","125 Johnston","FastFood");
        Review Zeus=new Review("Zeus","103 McKinley","Restaurant");
        Zeus.Reviews="Best food in UL";
        db.insertAll(Mcdonalds,bKing,Zeus);
    }

}
