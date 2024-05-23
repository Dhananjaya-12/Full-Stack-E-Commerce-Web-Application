
package dbms_assign2;


import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class CheckOut {
    
    JFrame CheckOutFrame;
    JPanel pane;
    JScrollPane scroll;
    
    ActionListener listener;
    
    Connection con;
    PreparedStatement st;
    ResultSet rt;
    
    String emailID;
    
    int totalOrder;
    int xCurrentCordinate = 30;
    int yCurrentCordinate = 30;
    int distBetweenNameAndPrice = 300;
    int distBetweenOrderList = 30;
    int nameLabelWidth = 150;
    int nameLabelHeight = 30;
    int priceLabelWidth = 70;
    int priceLabelHeight = 30;
    int xAddressFieldCordinate = 30;
    int yAddressFieldCordinate = 350;
    private int totalAmount = 0;
    String[] FurnitureName = new String[100];
    String[] FurniturePrice = new String[100];
    String customerFirstName;
    String customerLastName;
    String customerPhonenumber;
    static String customerAddress;
    String customerPhoneNumber;
    JLabel[] furnitureNameDisp = new JLabel[100];
    JLabel[] furniturePriceDisp = new JLabel[100];
    JLabel orderSummary;
    JButton makePayment;
    JLabel totalName;
    JLabel totalNumValue;
    JLabel deliveryAddress;
    JSeparator line;
    JTextArea custAddress;
    JLabel deliveryHeading;
    browse br;
    
    CheckOut(String emailID, browse br) throws SQLException{
        
        this.br = br;
                
        
        this.emailID = emailID;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tt?autoReconnect=true&useSSL=false","root","toor");
        
        this.listener = (ActionEvent e) -> {
            if (e.getSource() instanceof JButton) {
                String makePayment = ((JButton) e.getSource()).getName();
              
                callPaymentMethods();
                
               
            }
                
        };
        initComponents();
       CheckOutFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("tt.png")));
       
    }
    
    
    
    
    
    void initComponents() throws SQLException {
        
       
        CheckOutFrame = new JFrame("Tressure Oak");
        CheckOutFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        totalName = new JLabel("Total");
        deliveryHeading = new JLabel("Delivery Details:");
        deliveryHeading.setFont(new Font("Bodoni", Font.BOLD | Font.ITALIC | Font.ROMAN_BASELINE, 14));
        orderSummary = new JLabel("Order Summary: ");
        makePayment  = new JButton("Proceed to Payment");
        
        
        makePayment.addActionListener(listener);
        makePayment.setBounds(0, 465, 450, 50);
        orderSummary.setBounds(xCurrentCordinate - 10, yCurrentCordinate, nameLabelWidth, nameLabelHeight);
        orderSummary.setFont(new Font("Bodoni", Font.BOLD | Font.ITALIC | Font.ROMAN_BASELINE, 14));
        yCurrentCordinate += distBetweenOrderList + 20;
        
        totalNumValue = new JLabel();
        line = new JSeparator();
        pane = new JPanel(null);
        
        scroll = new JScrollPane(pane,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        pane.add(orderSummary);
        pane.add(makePayment);
        getOrderDetails(this.emailID);
        custAddress = new JTextArea("Customer Name:  " + this.customerFirstName+" "+this.customerLastName+"\n"+"Delivery Address: " + this.customerAddress+"\n"+"Phone Number: "+this.customerPhoneNumber+"\n"+"Email Address: "+this.emailID);
        custAddress.setLineWrap(true);
        custAddress.setName("custAddress");
        
        for(int i = 0 ; i < this.totalOrder ; i++){
            
            furnitureNameDisp[i] = new JLabel(this.FurnitureName[i]);
            furniturePriceDisp[i] = new JLabel(":  " + this.FurniturePrice[i]+ " Rs");
            furnitureNameDisp[i].setBounds(xCurrentCordinate, yCurrentCordinate, nameLabelWidth, nameLabelHeight);
            furniturePriceDisp[i].setBounds(xCurrentCordinate + distBetweenNameAndPrice, yCurrentCordinate, priceLabelWidth, priceLabelHeight);
            yCurrentCordinate +=  distBetweenOrderList;
            totalAmount += Integer.parseInt(this.FurniturePrice[i]);
            pane.add(furnitureNameDisp[i]);
            pane.add(furniturePriceDisp[i]);
            
        }
        
        
        
        line.setOrientation(SwingConstants.HORIZONTAL); 
        line.setBounds(xCurrentCordinate ,yCurrentCordinate,365, 2);
        pane.add(line);
      
        
        totalName.setBounds(xCurrentCordinate + 450/2 - 5, yCurrentCordinate, nameLabelWidth, nameLabelHeight);
        totalNumValue.setBounds(xCurrentCordinate + distBetweenNameAndPrice, yCurrentCordinate, priceLabelWidth, priceLabelHeight);
        totalNumValue.setText(":  "+Integer.toString(totalAmount)+ " Rs");
        pane.add(totalName);
        pane.add(totalNumValue);
        
        deliveryHeading.setBounds(xCurrentCordinate-20, yAddressFieldCordinate - 45, 200, 50);
        custAddress.setBounds(xCurrentCordinate-22, yAddressFieldCordinate, 415, 100);
        custAddress.setEditable(false);
        pane.add(custAddress);
        pane.add(deliveryHeading);
        CheckOutFrame.add(scroll);
        CheckOutFrame.setSize(450, 550);
        CheckOutFrame.setLocationRelativeTo(null);
        
        CheckOutFrame.setVisible(true);
        
        
    }

    void getOrderDetails(String emailID) throws SQLException {
        int orderTablePointer = 0;
        st = con.prepareStatement("SELECT furniture_name, furniture_price FROM furniture "
                + "INNER JOIN cart "
                + "ON furniture.furniture_id = cart.furnitureID "
                + "WHERE cart.emailID = ?");
        
        
        st.setString(1, this.emailID);
        
        rt = st.executeQuery();
        
        while(rt.next()){
            
            this.FurnitureName[orderTablePointer] = rt.getString(1);
            this.FurniturePrice[orderTablePointer++] = rt.getString(2);
                    
        }

        this.totalOrder = orderTablePointer;
        
        st = con.prepareStatement("SELECT first_name, last_name, address, phone_number FROM userdata WHERE email_addr = ?");
        
        st.setString(1, this.emailID);
        
        rt = st.executeQuery();
        
        while(rt.next()){
            this.customerFirstName = rt.getString(1);
            this.customerLastName = rt.getString(2);
            this.customerAddress = rt.getString(3);
            this.customerPhoneNumber = rt.getString(4);
            
            
            
        }                
        
        
        
    }
  

    private void callPaymentMethods() {
        
        new PaymentGateways(this.emailID, Integer.toString(this.totalAmount), br).setVisible(true);
        CheckOutFrame.setVisible(false);

    }
}
