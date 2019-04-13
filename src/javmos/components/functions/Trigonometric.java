/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javmos.components.functions;

import javmos.JavmosGUI;

/**
 *
 * @author user
 */
public abstract class Trigonometric extends Function {

    protected double a;
    protected double k;

    public Trigonometric(JavmosGUI gui, String function, String name) {
        super(gui);
        if (function.charAt(0) == name.charAt(0)){
            a = 1;
        } else if (function.charAt(0) == '-' && function.charAt(1) == name.charAt(0)) {
            a = -1;
        } else if (function.charAt(0) != function.charAt(function.indexOf(Character.toString(name.charAt(0))) - 1)) {
            a = Integer.parseInt(function.substring(0, function.indexOf(Character.toString(name.charAt(0)))));
        } else {
            a = Integer.parseInt(Character.toString(function.charAt(0)));
        }
        
        if (function.charAt(function.indexOf("(") + 1) == 'x') {
            k = 1;
        } else if (function.charAt(function.indexOf("(") + 1) == '-' && function.charAt(function.indexOf("(") + 1) == function.charAt(function.indexOf(Character.toString('x')))) {
            k = -1;
        } else if (function.charAt(function.indexOf("(") + 1) != function.charAt(function.indexOf("x") - 1)) {
            k = Integer.parseInt(function.substring(function.indexOf("(") + 1, function.indexOf(Character.toString('x'))));
        } else {
            k = Integer.parseInt(Character.toString(function.charAt(function.indexOf("(") + 1)));
        }
    }

}