
package dbms_assign2;



import static dbms_assign2.browse.*;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;



public final class cart{
    
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
    String cartItems[] = new String[100];
    
    
    
    String imgURL [] = new String[100];
    String furnitureName[] = new String[100];
    String furnitureDesc[] = new String[100];
    String furniturePrice[] = new String[100];
    
    JFrame cartFrame;
    JLabel furnitureImg[] = new JLabel[50];
    
    public JButton removeBtn[] = new JButton[50];
    JLabel furnitureNameDisp[] = new JLabel[50];
    
    JTextArea furnitureDescDisp[] = new JTextArea[50];
    
    
    cart(String custEmail, browse br) throws SQLException{
        
        this.br = br;
        
        this.listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    String btnName = ((JButton) e.getSource()).getName();
                    
                    try {
                        if(btnName.equals("paymentBtn")){
                            goToCheckOut();
                        }
                        if(btnName.equals("orderList")){
                            goToOrderList();
                        }
                        if(btnName.equals("goBack")){
                            cartFrame.dispose();
                        }else{
                            removeItemFromCart(btnName);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        
       this.emailID = custEmail;
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tt?autoReconnect=true&useSSL=false","root","toor");
       getFurnitureInfo();
      
       initComponents();
   cartFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("tt.png")));        
        
    }
    
    void goToOrderList() throws SQLException{
        
        
        br.setVisible(false);
        cartFrame.setVisible(false);
        new UserOrder(this.emailID, br);
        
    }
    
    void initComponents() throws SQLException{
         
     
        cartFrame = new JFrame("Cart");
       cartFrame.setLayout(new BorderLayout());
       cartFrame.setResizable(false);
        cartFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        pane = new JPanel(null);
        JButton paymentBtn = new JButton("Check - Out");
        JButton goBack = new JButton("Back");
        JButton orderList = new JButton("Your Orders");
        orderList.setBounds(7, 3,125, 40);
        paymentBtn.setBounds(850, 3,125, 40);
        orderList.setBounds(700, 3,125, 40);
        goBack.setBounds(50, 3, 125, 40);
        paymentBtn.addActionListener(listener);
        orderList.addActionListener(listener);
        goBack.addActionListener(listener);
        goBack.setName("goBack");
        paymentBtn.setName("paymentBtn");
       orderList.setName("orderList");
        pane.add(paymentBtn);
       pane.add(orderList);
       pane.add(goBack);
        
        if(this.itemCount == 0){

            JLabel annanPic  = new JLabel();
            annanPic.setIcon(new ImageIcon("C:\\Users\\meshr\\OneDrive\\Documents\\NetBeansProjects\\dbms_assign2\\src\\dbms_assign2\\hucha_venkat.png"));
            JLabel annanDialogue = new JLabel("Nan Magandh Shopping Cart Kaali dihre Kanroo!!!!");
            annanPic.setSize (460, 345);
            annanPic.setLocation(600/2 - 50, 200/2);
            
            annanDialogue.setBounds(600/2 + 90, 200/2 + 350, 200, 50);
            pane.add(annanPic);
            pane.add(annanDialogue);
            
        }
        
        for(int j = 0 ; j < this.i ; j++){
            furnitureImg[j] = new JLabel("fur_"+j);
            furnitureNameDisp[j] = new JLabel(this.furnitureName[j]);
            removeBtn[j] = new JButton("Remove");
            removeBtn[j].setName(Integer.toString(j));
            removeBtn[j].addActionListener(listener);
            furnitureImg[j].setIcon(getFurniturePhoto(this.imgURL[j]));
            furnitureImg[j].setBounds(this.xStart, this.yStart,this.imgWidth, this.imgHeight);
            furnitureNameDisp[j].setBounds(2 * this.xStart + this.imgWidth, this.yStart, this.furNameWidth, this.furNameHeight);
            furnitureDescDisp[j] = new JTextArea(furnitureDesc[j]);
            furnitureDescDisp[j].setFont(new Font("Courier Std Bold", Font.BOLD ,15));
            furnitureDescDisp[j].setForeground(java.awt.Color.BLACK);
            furnitureDescDisp[j].setBounds(2 * this.xStart + this.imgWidth , this.distNameAndDesc+this.yStart, this.descWidth, this.descHeight);
            removeBtn[j].setBounds(2 * this.xStart + this.imgWidth ,this.furNameHeight +this.descHeight+this.distNameAndDesc+this.distDescAndRemoveBtn+this.yStart, this.removeBtnWidth, this.removeBtnHeight);
            furnitureDescDisp[j].setEnabled(false);
            this.yStart = this.yStart + this.imgHeight + this.xStart;
            
             pane.add(furnitureImg[j]);
             pane.add(furnitureNameDisp[j]);
             pane.add(furnitureDescDisp[j]);
             pane.add(removeBtn[j]);
            
        }
        if(this.yStart <= 600){
        pane.setPreferredSize(new Dimension(0, 0));
        }else{ 
            pane.setPreferredSize(new Dimension(0, yStart));
            
        } 
        
        
       
        JScrollPane scroll = new JScrollPane(pane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
    
        cartFrame.setSize(1053, 600);
        cartFrame.add(scroll);
        
        cartFrame.add(scroll);
        cartFrame.setName("Tressure Oak");
        cartFrame.setLocationRelativeTo(null);
        
        cartFrame.setVisible(true);
        
       
             
      
}
            
    
    void removeItemFromCart(String item) throws SQLException{
       
       int removeButtonPointer = Integer.parseInt(item);
       item = this.cartItems[Integer.parseInt(item)];

      st = con.prepareCall("DELETE FROM cart WHERE (emailID = ? and furnitureID = ?)");
      st.setString(1,this.emailID);
      st.setString(2, item);
     

    if(st.executeUpdate() != 0){
        
        removeBtn[removeButtonPointer].setEnabled(false);
        removeBtn[removeButtonPointer].setText(Integer.toString(--countCartItems));
        removeBtn[removeButtonPointer].setText("Removed");
        removeBtn[removeButtonPointer].setFont(new Font("Courier Std Bold", Font.BOLD | Font.ITALIC | Font.CENTER_BASELINE,12));
        browse.cartBtn.setText(Integer.toString(--itemCount));
                
        furnitureNameDisp[removeButtonPointer].setEnabled(false);
        
        
        switch(item){
          
          case "1" : item1.setEnabled(true);break;
          case "2" : item2.setEnabled(true);break;             
          case "3" : item3.setEnabled(true);break;  
          case "4" : item4.setEnabled(true);break;  
          case "5" : item5.setEnabled(true);break;
          case "6" : item6.setEnabled(true);break;
          
          
          
        }
       
        }
       
        
    
      
   

    }
    
    void getFurnitureInfo() throws SQLException{
        
    int j =0;
    
    st = con.prepareCall("SELECT * FROM cart where emailID = ?");
    
    st.setString(1, this.emailID);
    
    rt = st.executeQuery();
      
      while(rt.next()){
   
          this.cartItems[i] = rt.getString("furnitureID");
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

    for(int p = 0 ; p < 6 ; p++){
    
        st = con.prepareCall("SELECT * FROM furniture where furniture_id = ?");
        st.setString(1, this.cartItems[j++]);
        rt  = st.executeQuery();
        while(rt.next()){
            this.furniturePrice[k] = rt.getString("furniture_price");
            this.furnitureDesc[k] = rt.getString("furniture_desc");
            this.imgURL[k] =rt.getString("furniture_img_link");
            this.furnitureName[k++] = rt.getString("furniture_name");
        }
    }
}
    

 

    private void goToCheckOut() throws SQLException {
        
        
       new CheckOut(this.emailID, br);
       cartFrame.dispose();
       
    }

    
  
    
}
