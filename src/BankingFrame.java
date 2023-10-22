import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingFrame extends JFrame implements ActionListener {
    private double balance = -100;
    private JTextField balanceField;
    private JLabel balanceLabel;
    private JTextField depositField;
    private JLabel depositLabel;
    private JTextField withdrawField;
    private JLabel withdrawLabel;
    private JTextField finalBalanceField;
    private JLabel finalBalanceLabel;
    private JButton depositButton;
    private JButton withdrawButton;
    private JPanel panel;

    BankingFrame() {
        GridBagConstraints layoutConst = null;

        setTitle("Bank Balance App");

        balanceLabel = new JLabel("Enter the beginning balance:");
        depositLabel = new JLabel("Enter the deposit amount:");
        withdrawLabel = new JLabel("Enter the withdrawal amount:");
        finalBalanceLabel = new JLabel("Final balance:");

        balanceField = new JTextField(15);
        balanceField.setEditable(true);
        balanceField.setText("0.00");

        withdrawField = new JTextField(15);
        withdrawField.setEditable(true);
        withdrawField.setText("0.00");

        depositField = new JTextField(15);
        depositField.setEditable(true);
        depositField.setText("0.00");

        finalBalanceField = new JTextField(15);
        finalBalanceField.setEditable(false);
        finalBalanceField.setText("0.00");

        depositButton = new JButton("Deposit");

        withdrawButton = new JButton("Withdraw");

        depositButton.addActionListener(new ActionListener() {

            public void actionPerformed (ActionEvent e){
                balance = updateBalance();
                double depositAmount = Double.parseDouble(depositField.getText());
                balance += depositAmount;
                depositField.setText("0.00");
                updateFinalBalance();

            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                balance = updateBalance();
                double withdrawAmount = Double.parseDouble(withdrawField.getText());

                if (withdrawAmount <= balance){
                    balance -= withdrawAmount;
                }
                else {
                    JOptionPane.showMessageDialog(panel, "Insufficient funds.");
                }
                balanceField.setText(String.valueOf(balance));
                withdrawField.setText("0.00");
                updateFinalBalance();

            }
        });

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 3, 10, 10));

        panel.add(balanceLabel);
        panel.add(balanceField);
        panel.add(new JLabel(""));
        panel.add(depositLabel);
        panel.add(depositField);
        panel.add(depositButton);
        panel.add(withdrawLabel);
        panel.add(withdrawField);
        panel.add(withdrawButton);
        panel.add(finalBalanceLabel);
        panel.add(finalBalanceField);

        add(panel);
    }

    public void updateFinalBalance() {
        finalBalanceField.setText(String.valueOf(balance));
    }

    public double updateBalance(){
        if (balance == -100){
            balance = Double.parseDouble(balanceField.getText());
        }
        return balance;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

    }

}
