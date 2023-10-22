import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingFrame extends JFrame implements ActionListener {
    private JTextField balanceField;
    private JLabel balanceLabel;
    private JTextField depositField;
    private JLabel depositLabel;
    private JTextField withdrawField;
    private JLabel withdrawLabel;
    private JTextField finalBalanceField;
    private JLabel finalBalanceLabel;
    private JButton processButton;
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
        balanceField.setText("0");

        withdrawField = new JTextField(15);
        withdrawField.setEditable(true);
        withdrawField.setText("0");

        depositField = new JTextField(15);
        depositField.setEditable(true);
        depositField.setText("0");

        finalBalanceField = new JTextField(15);
        finalBalanceField.setEditable(false);
        finalBalanceField.setText("0");

        processButton = new JButton("Process transactions");
        processButton.addActionListener(this);

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));

        panel.add(balanceLabel);
        panel.add(balanceField);
        panel.add(depositLabel);
        panel.add(depositField);
        panel.add(withdrawLabel);
        panel.add(withdrawField);
        panel.add(processButton);
        panel.add(finalBalanceLabel);
        panel.add(finalBalanceField);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String balanceInput;
        String depositInput;
        String withdrawInput;
        double balanceVal;
        double depositVal;
        double withdrawVal;
        double finalBalance;

        balanceInput = balanceField.getText();
        depositInput = depositField.getText();
        withdrawInput = withdrawField.getText();

        balanceVal = Double.parseDouble(balanceInput);
        depositVal = Double.parseDouble(depositInput);
        withdrawVal = Double.parseDouble(withdrawInput);

        finalBalance = (balanceVal + depositVal) - withdrawVal;

        finalBalanceField.setText(Double.toString(finalBalance));

    }

}
