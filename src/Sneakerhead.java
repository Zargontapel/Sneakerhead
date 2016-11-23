import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URISyntaxException;

public class Sneakerhead  {
    private JTextField ccNumText;
    private JTextField ccvText;
    private JComboBox expDateMonthCombo;
    private JComboBox expDateYearCombo;
    private JComboBox sizeComboBox;
    private JTextField quantityText;
    private JTextField nameText;
    private JTextField addressText;
    private JTextField cityText;
    private JComboBox stateCombo;
    private JTextField zipText;
    private JTextField phoneText;
    private JTextField emailText;
    private JButton saveEventButton;
    private JButton runNowButton;
    private JTextField urlText;
    private JPanel eventCreator;
    private JButton loadFromFileButton;

    public Sneakerhead() {
        runNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //load form details into memory, then start a thread
                PaymentDetails payment = new PaymentDetails();
                EventDetails event = new EventDetails();
                getData(event, payment);

                new Thread(new EventWorker(payment, event)).start();
            }
        });
        loadFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        saveEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        JFrame frame = new JFrame("Sneakerhead");
        frame.setContentPane(new Sneakerhead().eventCreator);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

    public void setData(EventDetails data, PaymentDetails payment) {
        quantityText.setText(data.getQuantity());
        urlText.setText(data.getUrl());
        //size combo box

        //now set payment details
        ccNumText.setText(payment.getCcNum());
        ccvText.setText(payment.getCcv());
        //exp month
        //exp year
        nameText.setText(payment.getName());
        addressText.setText(payment.getAddress());
        cityText.setText(payment.getCity());
        //state combo
        zipText.setText(payment.getZip());
        phoneText.setText(payment.getPhone());
        emailText.setText(payment.getEmail());
    }

    public void getData(EventDetails data, PaymentDetails payment) {
        data.setQuantity(quantityText.getText());
        data.setUrl(urlText.getText());
        //size combo box

        //now get payment details
        payment.setCcNum(ccNumText.getText());
        payment.setAddress(addressText.getText());
        payment.setCcv(ccvText.getText());
        payment.setCity(cityText.getText());
        payment.setEmail(emailText.getText());
        //exp month
        //exp year
        //state combo
        payment.setName(nameText.getText());
        payment.setZip(zipText.getText());
        payment.setPhone(phoneText.getText());

    }
}
