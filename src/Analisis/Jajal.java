/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

/**
 *
 * @author ai
 */
public class Jajal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int x=0;x<5;x++){
            final int n=x;
            new Thread(new Runnable() {
            @Override
            public void run() {
                jalan(n);
            }
        }).start();
        }
    }

    private static void jalan(int i) {
        for(int x=i*10;x<i*10+10;x++)System.out.println(x);
    }
    
}
