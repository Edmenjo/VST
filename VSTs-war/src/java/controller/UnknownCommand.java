/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

/**
 *
 * @author zuzu
 */
public class UnknownCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        
                File file = new File("C:\\Users\\zuzu\\Documents\\NetBeansProjects\\VSTs\\VSTs-war\\src\\java\\controller\\log.txt");
        FileWriter fileWriter = new FileWriter("C:\\Users\\zuzu\\Documents\\NetBeansProjects\\VSTs\\VSTs-war\\src\\java\\controller\\log.txt");
        
        
        try (PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.println("El comando " + request.getParameter("command") + " no existe.");

        }

        
        forward("/unknown.jsp");
    }
    
}
