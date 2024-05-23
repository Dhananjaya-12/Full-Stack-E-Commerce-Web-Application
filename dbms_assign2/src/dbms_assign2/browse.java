
package dbms_assign2;



import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class browse extends javax.swing.JFrame {

static int countCartItems = 0;


String emailID;
Connection con;
PreparedStatement st;
ResultSet rt;
String cartItems[] = new String[500];
String furnitureDesc[] = new String[500];

    public browse(String custEmail) throws SQLException {
        
        this.emailID = custEmail;
        initComponents();
     
        
      setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("tt.png")));
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tt?autoReconnect=true&useSSL=false","root","toor");

       st = con.prepareCall("SELECT first_name FROM userdata where email_addr = ?");
        
       st.setString(1, custEmail);
       
       rt =  st.executeQuery();
       
      while(rt.next()){
          
       custName.setText("Hello, "+rt.getString(1));
       
       custName.setFont(new Font("Courier Std Bold", Font.BOLD | Font.ITALIC | Font.CENTER_BASELINE,12));
       
      }
      
      st = con.prepareCall("SELECT furniture_desc from furniture");
      rt =  st.executeQuery();
      int z = 0;
      while(rt.next()){
          
          furnitureDesc[z++] = rt.getString(1);
      }
      
      
      
      
      
      st = con.prepareCall("SELECT * FROM cart where emailID = ?");
      st.setString(1, custEmail);
      rt =  st.executeQuery();
      
      
         while(rt.next()){
             
             this.cartItems[countCartItems] = rt.getString("furnitureID");
             
             countCartItems++;
             
             
      }
         if(countCartItems == 0){
             
             paymentBtn.setEnabled(false);
             
         }else{
             paymentBtn.setEnabled(true);
         }
    for (String cartItem : this.cartItems) {
  
        if(cartItem  == null)
            break;
        
        switch(Integer.parseInt(cartItem)){
            
            case 1 : item1.setEnabled(false); break;
            
            case 2 : item2.setEnabled(false);break;
            
            case 3 : item3.setEnabled(false);break;
            
            case 4 : item4.setEnabled(false);break;
            
            case 5 : item5.setEnabled(false);break;
            
            case 6 : item6.setEnabled(false);break;
        }
    }
    
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tt?autoReconnect=true&useSSL=false","root","toor");

        
         st =con.prepareCall("SELECT count(*) FROM cart WHERE emailID = ?");
        st.setString(1, this.emailID);
         rt = st.executeQuery();
         int cartNumber = 0 ;
        while(rt.next()){
            
            cartNumber = Integer.parseInt(rt.getString(1));
        }
        if(cartNumber > 0){
            
            cartBtn.setText(Integer.toString(cartNumber));
            
            
        }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        item3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        item4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cartBtn = new javax.swing.JButton();
        item5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        view5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        view3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        item2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        item1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        item6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        custName = new javax.swing.JTextField();
        view6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        view1 = new javax.swing.JButton();
        view2 = new javax.swing.JButton();
        view4 = new javax.swing.JButton();
        paymentBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tressure Oak");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1053, 600));
        setResizable(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1053, 600));

        item3.setText(" ADD TO CART");
        item3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item3ActionPerformed(evt);
            }
        });

        jLabel14.setText("MRP: 34,999");

        jLabel8.setFont(new java.awt.Font("ItalicC", 0, 36)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("TRESSURE OAK");

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\meshr\\OneDrive\\Documents\\NetBeansProjects\\dbms_assign2\\src\\dbms_assign2\\furniture5.jpg")); // NOI18N

        item4.setText("ADD TO CART");
        item4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item4ActionPerformed(evt);
            }
        });

        jLabel12.setText("COMFORT CUSION SOFA....");

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\meshr\\OneDrive\\Documents\\NetBeansProjects\\dbms_assign2\\src\\dbms_assign2\\furniture1.jpg")); // NOI18N

        cartBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\meshr\\OneDrive\\Documents\\NetBeansProjects\\dbms_assign2\\src\\dbms_assign2\\cartlogo.png")); // NOI18N
        cartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartBtnActionPerformed(evt);
            }
        });

        item5.setText("ADD TO CART");
        item5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item5ActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\meshr\\OneDrive\\Documents\\NetBeansProjects\\dbms_assign2\\src\\dbms_assign2\\furniture6.jpg")); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\meshr\\OneDrive\\Documents\\NetBeansProjects\\dbms_assign2\\src\\dbms_assign2\\furniture3.jpg")); // NOI18N
        jLabel3.setText("jLabel3");

        view5.setText("VIEW");

        jLabel11.setText("GLASS TOP TEA TABLE....");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\meshr\\OneDrive\\Documents\\NetBeansProjects\\dbms_assign2\\src\\dbms_assign2\\furniture2.jpg")); // NOI18N

        view3.setText("VIEW");
        view3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view3ActionPerformed(evt);
            }
        });

        jLabel16.setText("MRP: 29,999");

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\meshr\\OneDrive\\Documents\\NetBeansProjects\\dbms_assign2\\src\\dbms_assign2\\furniture4.jpg")); // NOI18N

        jLabel19.setText("MRP: 9,999");

        jLabel7.setText("TEAK BEDROOM SET....");

        jLabel18.setText("MRP: 15,999");

        item2.setText("ADD TO CART");
        item2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item2ActionPerformed(evt);
            }
        });

        jLabel10.setText("3+1+1 SOFA COMBO.....");

        item1.setText("ADD TO CART");
        item1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item1ActionPerformed(evt);
            }
        });

        jLabel15.setText("MRP: 12,499");

        jLabel17.setText("MRP: 7,499");

        item6.setText("ADD TO CART");
        item6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item6ActionPerformed(evt);
            }
        });

        jLabel9.setText("GOLD TEAK GOD MANDIR....");

        custName.setEditable(false);
        custName.setBorder(null);
        custName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custNameActionPerformed(evt);
            }
        });
        custName.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                custNamePropertyChange(evt);
            }
        });

        view6.setText("VIEW");

        jLabel13.setText("4 SEATED DINING TABLE....");

        view1.setText("VIEW");
        view1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view1ActionPerformed(evt);
            }
        });

        view2.setText("VIEW");
        view2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view2ActionPerformed(evt);
            }
        });

        view4.setText("VIEW");
        view4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view4ActionPerformed(evt);
            }
        });

        paymentBtn.setText("Check - Out");
        paymentBtn.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                paymentBtnStateChanged(evt);
            }
        });
        paymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(custName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel8)
                        .addGap(192, 192, 192)
                        .addComponent(cartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(paymentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(item1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(255, 255, 255)
                                .addComponent(jLabel14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(268, 268, 268)
                                .addComponent(jLabel16))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(view5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel12)))
                        .addGap(92, 92, 92)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel11)))
                        .addGap(83, 83, 83)
                        .addComponent(view2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(853, 853, 853)
                        .addComponent(jLabel17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(815, 815, 815)
                        .addComponent(item4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(814, 814, 814)
                        .addComponent(item6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(810, 810, 810)
                        .addComponent(item2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(596, 596, 596)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(view3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(view1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(813, 813, 813)
                        .addComponent(jLabel19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(540, 540, 540)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(821, 821, 821)
                        .addComponent(view6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(821, 821, 821)
                        .addComponent(view4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(item5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(780, 780, 780)
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(item3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(261, 261, 261)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(custName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paymentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cartBtn))))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(292, 292, 292)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(view2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(551, 551, 551)
                        .addComponent(jLabel17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(482, 482, 482)
                        .addComponent(item4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(724, 724, 724)
                        .addComponent(item6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(item2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(562, 562, 562)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(488, 488, 488)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(760, 760, 760)
                        .addComponent(jLabel19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(680, 680, 680)
                        .addComponent(view6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(view4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(item1)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(view1)))
                        .addGap(180, 180, 180)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(490, 490, 490)
                                .addComponent(jLabel13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(267, 267, 267)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(jLabel16)
                                .addGap(95, 95, 95)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(view5)))
                                .addGap(47, 47, 47)
                                .addComponent(jLabel12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(view3))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(372, 372, 372)
                                .addComponent(item5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(406, 406, 406)
                                .addComponent(jLabel18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(item3))))))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    void addToCart(int furtiture_id) throws SQLException{
        

       st = DrivingClass.con.prepareCall("INSERT into cart(emailID, furnitureID) values (?,?)");
       st.setString(1,this.emailID);
       st.setString(2,Integer.toString(furtiture_id));
       st.executeUpdate();

        
    }
    private void view4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view4ActionPerformed
        JOptionPane.showMessageDialog(null,this.furnitureDesc[3], "Furniture Information", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_view4ActionPerformed

    private void view1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view1ActionPerformed
       
        
        JOptionPane.showMessageDialog(null,this.furnitureDesc[0], "Furniture Information", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_view1ActionPerformed

    private void custNamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_custNamePropertyChange

    }//GEN-LAST:event_custNamePropertyChange

    private void custNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custNameActionPerformed

    }//GEN-LAST:event_custNameActionPerformed

    private void item6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item6ActionPerformed
        
        countCartItems++;
      
         paymentBtn.setEnabled(true);
                
    try {
        setCartNumber();
    } catch (SQLException ex) {
        Logger.getLogger(browse.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        addToCart(6);
    } catch (SQLException ex) {
        Logger.getLogger(browse.class.getName()).log(Level.SEVERE, null, ex);
    }
        item6.setEnabled(false);
    }//GEN-LAST:event_item6ActionPerformed

    private void item1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item1ActionPerformed
        countCartItems++;
        paymentBtn.setEnabled(true);
    try {
        setCartNumber();
    } catch (SQLException ex) {
        Logger.getLogger(browse.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        addToCart(1);
    } catch (SQLException ex) {
        Logger.getLogger(browse.class.getName()).log(Level.SEVERE, null, ex);
    }
        item1.setEnabled(false);

    }//GEN-LAST:event_item1ActionPerformed

    private void item2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item2ActionPerformed
        countCartItems++;
        paymentBtn.setEnabled(true);
    try {
        setCartNumber();
    } catch (SQLException ex) {
        Logger.getLogger(browse.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        addToCart(2);
    } catch (SQLException ex) {
        Logger.getLogger(browse.class.getName()).log(Level.SEVERE, null, ex);
    }
        item2.setEnabled(false);
        
    }//GEN-LAST:event_item2ActionPerformed

    private void view3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view3ActionPerformed
        JOptionPane.showMessageDialog(null,this.furnitureDesc[2], "Furniture Information", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_view3ActionPerformed

    private void item5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item5ActionPerformed
        countCartItems++;
        paymentBtn.setEnabled(true);
    try {
        setCartNumber();
    } catch (SQLException ex) {
        Logger.getLogger(browse.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        addToCart(5);
    } catch (SQLException ex) {
        Logger.getLogger(browse.class.getName()).log(Level.SEVERE, null, ex);
    }
        item5.setEnabled(false);
    }//GEN-LAST:event_item5ActionPerformed

    private void cartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartBtnActionPerformed
        try {
            new cart(emailID, this);
        } catch (SQLException ex) {
            Logger.getLogger(browse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cartBtnActionPerformed

    private void item4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item4ActionPerformed
        countCartItems++;
    try { 
        setCartNumber();
    } catch (SQLException ex) {
        Logger.getLogger(browse.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        addToCart(4);
    } catch (SQLException ex) {
        Logger.getLogger(browse.class.getName()).log(Level.SEVERE, null, ex);
    }
        item4.setEnabled(false);
    }//GEN-LAST:event_item4ActionPerformed

    private void item3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item3ActionPerformed
        countCartItems++;
    try {
        setCartNumber();
    } catch (SQLException ex) {
        Logger.getLogger(browse.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        addToCart(3);
    } catch (SQLException ex) {
        Logger.getLogger(browse.class.getName()).log(Level.SEVERE, null, ex);
    }
        item3.setEnabled(false);
    }//GEN-LAST:event_item3ActionPerformed

    private void paymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentBtnActionPerformed
        
    try {                                 
        CheckOut checkOut = new CheckOut(this.emailID, this);
    } catch (SQLException ex) {
        Logger.getLogger(browse.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_paymentBtnActionPerformed

    private void view2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view2ActionPerformed
               JOptionPane.showMessageDialog(null,this.furnitureDesc[1], "Furniture Information", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_view2ActionPerformed

    private void paymentBtnStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_paymentBtnStateChanged
        if(countCartItems == 0){
            paymentBtn.setEnabled(false);
        }else{
            paymentBtn.setEnabled(true);
        }
    }//GEN-LAST:event_paymentBtnStateChanged

    
    void setCartNumber() throws SQLException{
        
        if(countCartItems > 0){
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tt?autoReconnect=true&useSSL=false","root","toor");

        
         st =con.prepareCall("SELECT count(*) FROM cart WHERE emailID = ?");
        st.setString(1, this.emailID);
         rt = st.executeQuery();
        while(rt.next()){
            cartBtn.setText(Integer.toString(Integer.parseInt(rt.getString(1))+1));
                if(countCartItems == 0){
             
             paymentBtn.setEnabled(false);
             
         }else{
                     paymentBtn.setEnabled(true);
                }
        }
            
            
        }
        
        
        
    }

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton cartBtn;
    private javax.swing.JTextField custName;
    public static javax.swing.JButton item1;
    public static javax.swing.JButton item2;
    public static javax.swing.JButton item3;
    public static javax.swing.JButton item4;
    public static javax.swing.JButton item5;
    public static javax.swing.JButton item6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton paymentBtn;
    private javax.swing.JButton view1;
    private javax.swing.JButton view2;
    private javax.swing.JButton view3;
    private javax.swing.JButton view4;
    private javax.swing.JButton view5;
    private javax.swing.JButton view6;
    // End of variables declaration//GEN-END:variables
}
