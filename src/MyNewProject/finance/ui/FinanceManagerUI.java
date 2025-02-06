package MyNewProject.finance.ui;

import MyNewProject.DataBaseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinanceManagerUI extends JFrame {
    private JTextField amountField;
    private JTextField categoryField;
    private JComboBox<String> typeBox;
    private JButton addButton;
    private JTextArea transactionsArea;


    public FinanceManagerUI(){
        setTitle("Personal Finance Manager");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new GridLayout(4,2));

    inputPanel.add(new JLabel("Amount"));
    amountField = new JTextField();
    inputPanel.add(amountField);

    inputPanel.add(new JLabel("Category"));
    categoryField = new JTextField();
    inputPanel.add(categoryField);

    inputPanel.add(new JLabel("Type"));
    typeBox = new JComboBox<>(new String[]{"income","expence"});
    inputPanel.add(typeBox);

    addButton = new JButton("Add transaction");
    inputPanel.add(addButton);

    add(inputPanel,BorderLayout.NORTH);

    transactionsArea = new JTextArea();
    transactionsArea.setEditable(false);
    add(new JScrollPane(transactionsArea),BorderLayout.CENTER);

    addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            addTransactions();
        }
    });
    setVisible(true);
    }
    private void addTransactions(){
        try {
            double amount = Double.parseDouble(amountField.getText());
            String category = categoryField.getText();
            String type = (String) typeBox.getSelectedItem();

            DataBaseManager.addTransaction(amount,category,type);

            transactionsArea.append("Append" + type + " " + amount + " (" + category + ")\n" );

            amountField.setText("");
            categoryField.setText("");
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,
                    "Invalid amount!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
