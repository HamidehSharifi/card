package com.example.card.password.business;

import java.util.Random;

public class PasswordddService {
private final imput("ABCDEFGHIJKLMNOPQRSWTYUZ0123456789abcdefghijklmnopqrswtuvyz"){
    private final Random RANDOM=new secureRandom();

    public String generateRandomString(Integer lenth[]){
        StringBuilder builder = new StringBuilder();
        for (int i = 0, i<length, i++){
            builder.append(INPUT.chartAt(RANDOM.nextInt(INPUT.length)));
        }
        return builder.toString();

    }
    private final String otp="123456789";
    public String generateRandomOTPString(int length){
        StringBuilder builder = new StringBuilder();
        for (int i = 0, i<length, i++){
            builder.append(OTP.charAT(RANDOM.nextInt(OTP.length)));
    }
        return builder.toString();
        public final String CHAR_AT= "ABCDEFGHIJKLMNOPQRSTUVWYZ";
        public char charAT(){
            return CHAR_AT.charAt(CHAR_AT.charAT(RANDOM.nextInt(CHAR_AT.length)));
        }
        public String generateRandomStringWhithSpecialChar(int length,int space,String specialChar){
            StringBuilder builders = new StringBuilder();
            int index=0;
            while (length>0){
                if(space==index){
                    builder.append(specialChar)
                }
                length--;
                index++;
                builder.append(charAT)
            }

        }

        }
    public static void main(String[] args){
        System.out.println(new RandomString().generateRandomString(4));
        System.out.println(new RandomString().generateRandomOTPString(20));
        System.out.println(new RandomString().charAT);
        System.out.println(new RandomString().generateRandomStringWhithSpecialChar(21,3,"::"));

    }


    }
}
