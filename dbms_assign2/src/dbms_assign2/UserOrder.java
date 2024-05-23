
package dbms_assign2;




import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;



public final class UserOrder{
    
    JPanel pane;
    Connection con;
    PreparedStatement st;
    ResultSet rt;
    ActionListener listener;
    
    
    int i =0;
    int q = 0;
    int buttonNumber;
    int itemCount = 0;
    int purchaseItemCount = 0;
    int imgWidth = 214;
    int imgHeight = 236;
    
    int furNameWidth = 250;
    int furNameHeight = 20;
    
    int descWidth = 700;
    int descHeight= 120;
    
    int removeBtnWidth = 100;
    int removeBtnHeight = 40;
    
    int distNameAndDesc = 30;
    int distDescAndRemoveBtn = 30;
    int xStart = 50;
    int yStart = 50;
    
    int z;
    
    browse br;
    
    String emailID;
    String purchasedCartItems[] = new String[100];
    
    
    
    String imgURL [] = new String[100];
    String purchasedFurnitureName[] = new String[100];
    String purchasedFurnitureDesc[] = new String[100];
    String purchasedFurniturePrice[] = new String[100];
    String purchasedTime[] = new String[500];
    JFrame OrderFrame;
    JLabel furnitureImg[] = new JLabel[50];
    JLabel furnitureDate[] = new JLabel[500];
    
    public JButton removeBtn[] = new JButton[50];
    JLabel purchasedFurnitureNameDisp[] = new JLabel[50];
    
    JTextArea purchasedFurnitureDescDisp[] = new JTextArea[50];
    
    
    UserOrder(String custEmail, browse br) throws SQLException{
        
        this.br = br;
        
        this.listener = (ActionEvent e) -> {
            if (e.getSource() instanceof JButton) {
                String btnName = ((JButton) e.getSource()).getName();
                
                try {
                    if(btnName.equals("goback")){
                        goToCheckOut();
                    }else{
                     
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
       this.emailID = custEmail;
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tt?autoReconnect=true&useSSL=false","root","toor");
       getFurnitureInfo();
      
       initComponents();
   OrderFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("tt.png")));        
        
    }
    
    
    void initComponents() throws SQLException{
         
     
        OrderFrame = new JFrame("Orders");
       OrderFrame.setLayout(new BorderLayout());
       OrderFrame.setResizable(false);
        OrderFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        pane = new JPanel(null);
        JButton goback = new JButton("Go Back");
        
        
        goback.setBounds(850, 3,125, 40);
        goback.addActionListener(listener);
        
        goback.setName("goback");
       
        pane.add(goback);
       
        
        if(this.itemCount == 0){

            JLabel annanPic  = new JLabel();
            annanPic.setIcon(new ImageIcon("C:\\Users\\meshr\\OneDrive\\Documents\\NetBeansProjects\\dbms_assign2\\src\\dbms_assign2\\cryDudeVenkatAnna.png"));
            JLabel annanDialogue = new JLabel("Maga Yenadhru Buy Maado!!!!");
            annanPic.setSize (460, 345);
            annanPic.setLocation(600/2 - 50, 200/2);
            
            annanDialogue.setBounds(600/2 + 90, 200/2 + 350, 200, 50);
            pane.add(annanPic);
            pane.add(annanDialogue);
            
        }
        JLabel orderHeading = new JLabel("Your Orders");
        
        orderHeading.setBounds(this.xStart,  this.yStart -15, 400, 35);
        
        this.yStart += this.yStart;
        
        orderHeading.setFont(new Font("Courier Std Bold", Font.BOLD | Font.ITALIC,40));
        
        pane.add(orderHeading);
        
        
        for(int j = 0 ; j < this.i ; j++){
            String dateToParse = "2016-05-23 07:24:59";
            LocalDateTime dateTime = LocalDateTime.parse(dateToParse, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDate localDate = dateTime.toLocalDate();
            LocalTime localTime = dateTime.toLocalTime();
            furnitureDate[j] = new JLabel("purchased On:  "+localDate);
            furnitureImg[j] = new JLabel("fur_"+j);
            purchasedFurnitureNameDisp[j] = new JLabel(this.purchasedFurnitureName[j]);
            furnitureImg[j].setIcon(getFurniturePhoto(this.imgURL[j]));
            furnitureImg[j].setBounds(this.xStart, this.yStart,this.imgWidth, this.imgHeight);
            purchasedFurnitureNameDisp[j].setBounds(2 * this.xStart + this.imgWidth, this.yStart, this.furNameWidth, this.furNameHeight);
         
            
            furnitureDate[j].setBounds(2 * this.xStart + this.imgWidth, this.yStart + distNameAndDesc, this.furNameWidth, this.furNameHeight);
            this.yStart = this.yStart + this.imgHeight + this.xStart;
            
             pane.add(furnitureImg[j]);
             pane.add(purchasedFurnitureNameDisp[j]);
             //pane.add(purchasedFurnitureDescDisp[j]);
             pane.add(furnitureDate[j]);
            
        }
        if(this.yStart <= 600){
        pane.setPreferredSize(new Dimension(0, 0));
        }else{ 
            pane.setPreferredSize(new Dimension(0, yStart));
            
        } 
        
        
       
        JScrollPane scroll = new JScrollPane(pane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
    
        OrderFrame.setSize(1053, 600);
        OrderFrame.add(scroll);
        
        OrderFrame.add(scroll);
        OrderFrame.setName("Tressure Oak");
        OrderFrame.setLocationRelativeTo(null);
        OrderFrame.setVisible(true);
        
       
             
      
}
            
    
    
    
    void getFurnitureInfo() throws SQLException{
        
    int j =0;
    
    st = con.prepareCall("SELECT * FROM userorder where emailID = ? ORDER BY purchased_time DESC");
    
    st.setString(1, this.emailID);
    
    rt = st.executeQuery();
      
      while(rt.next()){
   
          this.purchasedCartItems[i] = rt.getString("furniture_id");
          this.purchasedTime[i] = rt.getString("purchased_time");
          this.itemCount++;
          i++;
          
      }
        
        
        
   
            getImgSrc();
        
    }
    
        
    
    
   Icon getFurniturePhoto(String imgsrc){
        
        
        
        ImageIcon icon = new ImageIcon(imgsrc);
        
        
        return icon;
    }
   
   
   
   void getImgSrc() throws SQLException{
    
    int j =0;
    int k =0;

    for(int p = 0 ; p < this.i ; p++){
    
        st = con.prepareCall("SELECT * FROM furniture where furniture_id = ?");
        st.setString(1, this.purchasedCartItems[j++]);
        rt  = st.executeQuery();
        while(rt.next()){
            this.purchasedFurniturePrice[k] = rt.getString("furniture_price");
            this.purchasedFurnitureDesc[k] = rt.getString("furniture_desc");
            this.imgURL[k] =rt.getString("furniture_img_link");
            this.purchasedFurnitureName[k++] = rt.getString("furniture_name");
        }
    }
}
    

 

    private void goToCheckOut() throws SQLException {
        
        
       br.setVisible(true);
       OrderFrame.dispose();
       
    }

    
  
    
}
