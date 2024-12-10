package com.mproduits.mproduitsapplication.web.exceptions;

public class ProductNotFoundException extends  Exception{

    public ProductNotFoundException(String message) {
        super(message);
        System.out.println(super.getMessage());
    }

    public void printMessage(){
        System.out.println(super.getMessage());
    }


}
