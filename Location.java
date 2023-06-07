/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirFreightApp;

import GraphFramework.Vertex;

/**
 *
 * @author hanee
 */
public class Location extends Vertex {
    private String city;

    public Location(String label, String city) {
        super(label);
        this.city = city;
    }
    public String getCity() {
        return city;
    }


    /**
     * Displays the information about the location.
     */
    @Override
    public void displayInfo() {
        //System.out.println("Location: " + label);
        System.out.println("City: " + city);
    }
}