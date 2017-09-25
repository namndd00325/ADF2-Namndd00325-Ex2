/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.adf2.javaswing.ex2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Nam Nguyen
 */
public class LoginForm extends JFrame {

    private JLabel lblID;
    private JLabel lblName;
    private JLabel lblEmail;
    private JLabel lblPhone;
    private JLabel lblDate;
    private JTextField txtID;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JSpinner txtDate;
    private JButton btnSubmit;
    private JButton btnReset;
    

    public LoginForm() {
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        this.lblID = new JLabel("ID Student");
        this.lblName = new JLabel("Name");
        this.lblDate = new JLabel("Birthday");
        this.lblEmail = new JLabel("Email");
        this.lblPhone = new JLabel("Phone");
        this.txtID = new JTextField();
        this.txtName = new JTextField();
        //this.txtDate = new JTextField();
        this.txtEmail = new JTextField();
         this.txtPhone = new JTextField();
        this.btnSubmit = new JButton("Submit");
        this.btnReset = new JButton("Reset");

        this.lblID.setBounds(100, 40, 100, 30);
        this.txtID.setBounds(230, 40, 250, 30);

        this.lblName.setBounds(100, 80, 100, 30);
        this.txtName.setBounds(230, 80, 250, 30);
        
        // check date
        SpinnerDateModel spinnerDate = new SpinnerDateModel();
        this.txtDate = new JSpinner(spinnerDate);
        this.txtDate.setEditor(new JSpinner.DateEditor(this.txtDate, "dd/MM/yyyy"));
        this.lblDate.setBounds(100, 120, 100, 30);
        this.txtDate.setBounds(230, 120, 250, 30);

        this.lblEmail.setBounds(100, 160, 100, 30);
        this.txtEmail.setBounds(230, 160, 250, 30);
        
          //check phone
        MaskFormatter maskPhone = null;
        try {
            maskPhone = new MaskFormatter("#### ### ###");
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        maskPhone.setPlaceholderCharacter('_');
        txtPhone = new JFormattedTextField(maskPhone);
        this.lblPhone.setBounds(100, 200, 100, 30);
        this.txtPhone.setBounds(230, 200, 250, 30);

        this.btnSubmit.setBounds(250, 240, 90, 30);
        this.btnReset.setBounds(370, 240, 90, 30);

        this.btnSubmit.addActionListener(new SubmitHandle());
        this.btnReset.addActionListener(new ResetHandle());

        

      

        this.add(lblID);
        this.add(lblName);
        this.add(txtID);
        this.add(txtName);
        this.add(lblEmail);
        this.add(txtEmail);
        this.add(lblPhone);
        this.add(txtPhone);
        this.add(btnReset);
        this.add(btnSubmit);
        this.add(lblDate);
        this.add(txtDate);

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class SubmitHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(null, "Submit Succsess! " + txtID.getText());

        }
    }

    class ResetHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            txtID.setText("");
            txtName.setText("");
            //   txtDate.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
        }
    }
}
