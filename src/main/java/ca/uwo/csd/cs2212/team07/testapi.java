/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uwo.csd.cs2212.team07;

/**
 *
 * @author aiden
 */
public class testapi {
    
    
    public static void main(String[] args) {
        
        try {
        HeartData data = Api.getHeartSummary("2016-02-11");
        System.out.println(data.toString());
        }
        catch(Exception ex) {
            System.err.println("exception");
            
        }
    }
            
            
            
            }
