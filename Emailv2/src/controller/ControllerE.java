
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ModelE;
import view.ViewE;

public final class ControllerE {

    ModelE modelE;
    ViewE viewE;
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
            if (e.getSource() == viewE.jb_primero) {
                try {
                    jb_primero_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerE.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == viewE.jb_anterior) {
                try {
                    jb_anterior_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerE.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == viewE.jb_siguiente) {
                try {
                    jb_siguiente_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerE.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == viewE.jb_ultimo) {
                try {
                    jb_ultimo_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerE.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(e.getSource() == viewE.jb_guardar){
                try {
                    jb_guardar();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerE.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }else if(e.getSource() == viewE.jb_nuevo){
                jb_nuevo();
            }

        }

    };

    public ControllerE(ModelE modelE, ViewE viewE) {
        this.modelE = modelE;
        this.viewE = viewE;
        initComponents();
        setActionListener();
        initDB();
    }    

    public void initDB(){
        modelE.conectarDB();
        viewE.jtf_nombre.setText(modelE.getNombre());
        viewE.jtf_email.setText(modelE.getEmail());
    }

    public void initComponents() {
        viewE.setLocationRelativeTo(null);
        viewE.setTitle("Agenda MVC");
        viewE.setVisible(true);
    }


    public void setActionListener() {
        viewE.jb_primero.addActionListener(actionListener);
        viewE.jb_anterior.addActionListener(actionListener);
        viewE.jb_siguiente.addActionListener(actionListener);
        viewE.jb_ultimo.addActionListener(actionListener);
        viewE.jb_guardar.addActionListener(actionListener);
        viewE.jb_nuevo.addActionListener(actionListener);
    }

 
    private void jb_primero_actionPerformed() throws SQLException {
        System.out.println("Action del boton jb_primero");
        modelE.primerRegistro();
        viewE.jtf_nombre.setText(modelE.getNombre());
        viewE.jtf_email.setText(modelE.getEmail());

    }


    private void jb_anterior_actionPerformed() throws SQLException {
        System.out.println("Action del boton jb_anterior");
        modelE.anteriorRegistro();
        viewE.jtf_nombre.setText(modelE.getNombre());
        viewE.jtf_email.setText(modelE.getEmail());
    }


    private void jb_ultimo_actionPerformed() throws SQLException {
        System.out.println("Action del boton jb_ultimo");
        modelE.ultimoRegistro();
        viewE.jtf_nombre.setText(modelE.getNombre());
        viewE.jtf_email.setText(modelE.getEmail());
 
    }
    private void jb_siguiente_actionPerformed() throws SQLException {
        System.out.println("Action del boton jb_siguiente");
        modelE.siguienteRegistro();
        viewE.jtf_nombre.setText(modelE.getNombre());
        viewE.jtf_email.setText(modelE.getEmail());
       
  
    }
    private void jb_guardar() throws SQLException {
        System.out.println("Action del boton jb_guardar");
        modelE.setNombre(viewE.jtf_nombre.getText());
        modelE.setEmail(viewE.jtf_email.getText());
        modelE.guardarRegistro(modelE.getNombre(),modelE.getEmail());
        JOptionPane.showMessageDialog(viewE, "Registro guardado correctamente");
        }

        private void jb_nuevo() {
            System.out.println("Action del boton jb_nuevo");
            modelE.setEmail(null);
            modelE.setNombre(null);
            viewE.jtf_email.setText(modelE.getEmail());
            viewE.jtf_nombre.setText(modelE.getNombre());
            
        }
}
