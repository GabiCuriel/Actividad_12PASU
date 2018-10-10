
package main;

import view.ViewE;
import model.ModelE;
import controller.ControllerE;

public class MainE {
    
    
    public static void main(String[] args) {
        ModelE modelE = new ModelE();
        ViewE viewE = new ViewE();
        ControllerE controllerE = new ControllerE(modelE, viewE);
    }
}