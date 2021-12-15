/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManagerInfrastructure;

/**
 *
 * @author PC
 */
public class InfrasQuality extends Infras{
    private String quality;
    private String state;

    public InfrasQuality(String name, int count,String quality, String state) {
        super(name, count);
        this.quality = quality;
        this.state = state;
    }

    public String getQuality() {
        return quality;
    }

    public String getState() {
        return state;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public void setState(String state) {
        this.state = state;
    }

}
