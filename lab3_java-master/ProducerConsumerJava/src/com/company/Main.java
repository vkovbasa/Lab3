package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int storageSize = 10;
        int itemNumbers = 30;
        main.starter(storageSize, itemNumbers);
    }

    private void starter(int storageSize, int itemNumbers) {
        Manager manager = new Manager(storageSize);
        int itemProd =0;
        int itemCons =0;

        int i=0;
        while (itemProd<itemNumbers){
            int col=(int)Math.round(Math.random()*storageSize);
            if (itemNumbers-itemProd>col){
                new  Producer(col,manager,i);
                itemProd+=col;
            }
            else {
                new  Producer(itemNumbers-itemProd,manager,i);
                break;
            }
            i+=1;
            if(i==20){break;}
        }
        while (itemCons<itemNumbers){
            int col=(int)Math.round(Math.random()*storageSize);
            if (itemNumbers-itemCons>col){
                new  Consumer(col,manager,i);
                itemCons+=col;
            }
            else {
                new  Consumer(itemCons-itemProd,manager,i);
                break;
            }
            i+=1;
            if(i==20){break;}
        }
    }
}