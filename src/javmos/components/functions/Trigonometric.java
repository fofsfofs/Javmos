/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javmos.components.functions;

import javmos.JavmosGUI;

public abstract class Trigonometric extends Function {

    protected double a;
    protected double k;

    //Parses the trigonometric function to obtain the a and k values
    public Trigonometric(JavmosGUI gui, String function, String name) {
        super(gui);
        function = function.contains("=") ? function.substring(function.indexOf("=") + 1, function.length()) : function;

        //Extracts the numbers that exist before the specified name variable
        if (function.substring(0, 1).equals(Character.toString(name.charAt(0)))) {
            a = 1;
        } else if (function.substring(0, 2).equals("-" + name.charAt(0))) {
            a = -1;
        } else {
            a = Double.parseDouble(function.substring(0, function.indexOf(Character.toString(name.charAt(0)))));
        }

        //Extracts the numbers prior to 'x' and after '('
        if (function.contains("(x")) {
            k = 1;
        } else if (function.contains("(-x")) {
            k = -1;
        } else {
            k = Double.parseDouble(function.substring(function.indexOf("(") + 1, function.indexOf("x")));
        }
    }
}
