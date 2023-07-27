import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Node
{
    String item;
    float price;
    Node next;
    Node(String item , float price)
    {
        this.item = item;
        this.price = price;
    }
}

class Queue
{
    Node front;
    Node rear;
    Queue()
    {
        this.front = null;
        this.rear = null;
    }
    void insert(Queue queue,String item,float price)
    {
        Node newnode = new Node(item, price);
        if(queue.front == null)
        {
            queue.rear = newnode;
            queue.front = newnode;
        }else
        {
            queue.rear.next = newnode;
            queue.rear = newnode;
        }
    }
}
class Main
{
    Queue queue= new Queue();
    JFrame frame,frame2,frame3,frame4;
    JLabel name,itemss;
    JButton l1;
    JButton vegbtn,vegstarters,vegbiryani,vegchinese;
    JButton desserts,billing,back,exit;
    JButton nonvegbtn,nonvegstarters,nonvegbiryani,nonvegchinese;
    JPanel panel1,panel2;
    Color c = new Color(255, 255, 194);

    void menu()
    {
        frame = new JFrame("Restaurant menu");
        JLabel bg = new JLabel(new ImageIcon("C:\\Restaurant_Bill_Generator\\betchlogo.png")); 
        frame.add(bg);
        bg.setBounds(400, 0, 750, 300);
        frame.getContentPane().setBackground(Color.black);

        JLabel chefbg = new JLabel(new ImageIcon("C:\\Restaurant_Bill_Generator\\chef.png")); 
        frame.add(chefbg);
        chefbg.setBounds(350, 60, 200, 200);

        JLabel rest = new JLabel("R  E  S  T  A  U  R  A  N  T");
        rest.setFont(new Font("Arial", Font.BOLD, 50));
        rest.setBounds(450,275,800,60);
        rest.setForeground(c);
        frame.add(rest);

        JLabel info = new JLabel(" Mail : btechboyz@gmail.com  ,  Contact : 9876543210");
        info.setBounds(1100,750, 3000, 30);
        info.setForeground(c);
        frame.add(info);

        LocalDateTime currentLocalDateTime = LocalDateTime.now();
 
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String date_now = currentLocalDateTime.format(dateTimeFormatter);
        JLabel date = new JLabel(date_now);
        date.setBounds(1300, 200, 150, 20);
        date.setForeground(c);
        frame.getContentPane().setBackground(Color.black);

        vegbtn = new JButton("VEG");
        vegbtn.setBackground(c);
        vegbtn.setBounds(400, 400, 150, 80);
        vegbtn.setFont(new Font("Arial", Font.BOLD, 20));
        vegbtn.setBorder(null);

        nonvegbtn = new JButton("NON-VEG");
        nonvegbtn.setBackground(c);
        nonvegbtn.setBounds(400, 550, 150, 80);
        nonvegbtn.setFont(new Font("Arial", Font.BOLD, 20));
        nonvegbtn.setBorder(null);

        billing = new JButton("BILLING");
        billing.setBounds(1000, 400, 150, 80);
        billing.setFont(new Font("Arial", Font.BOLD, 20));
        billing.setBackground(c);

        exit = new JButton("EXIT");
        exit.setBounds(1000, 550, 150, 80);
        exit.setFont(new Font("Arial", Font.BOLD, 20));
        exit.setBackground(c);

        frame.add(date);
        frame.add(vegbtn);
        frame.add(nonvegbtn);
        frame.add(billing);
        frame.add(exit);

        vegbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                veg_menu();
            }
        });
        nonvegbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                nonveg_menu();
            }
        });
        billing.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(queue.rear == null){
                    JOptionPane.showMessageDialog(frame,"Please Select some item for Billing");
                }
                else{
                    billing_menu();
                }
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(2100, 1000);
        frame.setVisible(true);
    }
    void veg_menu()
    {
        frame2 = new JFrame(" VEG ");
        Color c = new Color(255, 255, 194);
        frame2.getContentPane().setBackground(Color.black);

        back = new JButton("BACK");
        back.setBackground(c);
        back.setBounds(100, 20, 150, 50);
        frame2.add(back);

        vegstarters = new JButton("VEG - STARTERS ");
        vegstarters.setBackground(c);
        vegstarters.setBounds(300, 20, 150, 50);
        frame2.add(vegstarters);

        vegbiryani = new JButton("VEG - BIRYANIS ");
        vegbiryani.setBackground(c);
        vegbiryani.setBounds(500, 20, 150, 50);
        frame2.add(vegbiryani);

        vegchinese = new JButton("VEG - CHINESE ");
        vegchinese.setBackground(c);
        vegchinese.setBounds(700, 20, 150, 50);
        frame2.add(vegchinese);

        desserts = new JButton("DESSERTS ");
        desserts.setBackground(c);
        desserts.setBounds(900, 20, 150, 50);
        frame2.add(desserts);

        billing = new JButton("BILLING");
        billing.setBackground(c);
        billing.setBounds(1100, 20, 150, 50);
        frame2.add(billing);

        vegstarters.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                veg_starters();
            }
        });
        vegbiryani.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                veg_biryani();
            }
        });
        vegchinese.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                veg_chinese();
            }
        });
        desserts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                desserts();
            }
        });
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                menu();
            }
        });
        billing.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(queue.rear == null){
                    JOptionPane.showMessageDialog(frame,"Please Select some item for Billing");
                }
                else{
                    billing_menu();
                }
            }
        });
        JLabel l1 = new JLabel("SELECT SOME ITEM");
        l1.setFont(new Font("Arial",Font.BOLD,20));
        l1.setForeground(c);
        panel1 = new JPanel();
        panel1.setBackground(Color.black);
        panel1.setBounds(100,150,1300,450);
        frame2.add(panel1);
        panel1.add(l1);

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLayout(null);
        frame2.setSize(2100, 1000);
        frame2.setVisible(true);
    }
    void veg_starters()
    {
        panel1.removeAll();
        panel1.revalidate();
        panel1.repaint();
        panel1.setVisible(false);
        int j=140,k=140,l=140;
        String[] startersItems = {
            "Veg Corn Soup", "Veg Sweet Corn Soup", "Veg Manchurian Dry", 
            "Paneer 65", "Paneer Chilli", "Mushroom Chilli", "Mushroom 65","Paneer Cutlet","Aloo Tikki","Mushroom Manchurian"
        };
        float[] startersPrices = {250, 260, 220, 310, 170, 180, 300, 320, 320, 310};

        panel1.setVisible(false);
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        frame2.add(panel);
        panel.setBounds(300,100,800,800);

        JLabel title = new JLabel("VEG STARTERS ");
        title.setBounds(330, 10, 250, 50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        title.setForeground(Color.white);
        panel.add(title);
        JLabel itm = new JLabel("ITEM");
         itm.setFont(new Font("Times New Roman", Font.BOLD, 15));
         itm.setBounds(100, 100, 100, 30);
         itm.setForeground(Color.white);
         JLabel prc = new JLabel("PRICE(Rs)");
         prc.setFont(new Font("Times New Roman", Font.BOLD, 15));
         prc.setBounds(400, 100, 100, 30);
         prc.setForeground(Color.white);
         panel.add(itm);
         panel.add(prc);

        for(int i=0;i<startersItems.length;i++){
            String item = startersItems[i];
             float price = startersPrices[i];
             JButton addButton = new JButton("Add to billing");
             addButton.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     int quantity = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Quantity:"));
                     String itemWithQuantity = item + " x " + quantity;
                     float itemTotalPrice = price * quantity;
                     JOptionPane.showMessageDialog(frame3," item added to billing !");
                     queue.insert(queue, itemWithQuantity, itemTotalPrice);
                 }
             });
            itemss = new JLabel(item);
            itemss.setBounds(100, j, 200, 20);
            itemss.setForeground(Color.white);
             j += 40;
             panel.add(itemss);
             JLabel pricess = new JLabel(Float.toString(price));
             pricess.setBounds(400, k, 100, 20);
             pricess.setForeground(Color.white);
             k += 40;
             panel.add(pricess);
             addButton.setBounds(600, l, 140, 20);
             addButton.setBackground(c);
             l += 40;
             panel.add(addButton);

            panel.setLayout(null);
        }
        frame2.add(panel);
        panel.setVisible(true);
    }
    void veg_biryani()
    {
        panel1.removeAll();
        panel1.revalidate();
        panel1.repaint();
        panel1.setVisible(false);
        int j=140,k=140,l=140;
        String[] biryanisItems = {
            "South Indian Thali", "Special Curd Rice", "Paneer Biryani", 
            "Veg Biryani", "Curd Rice", "Cashew Biryanis","Special Veg Biryani","Paneer Tikka Biryani","Mixed Veg Biryani"
            ,"Mushroom Biryani"
        };
        float[] biryanisPrices = {270, 190, 340, 260, 140, 360, 320,300, 350, 300};

        panel1.setVisible(false);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.black);
        frame2.add(panel2);
        panel2.setBounds(300,100,800,800);

        JLabel title = new JLabel("VEG BIRYANIS ");
        title.setBounds(330, 10, 250, 50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        title.setForeground(Color.white);
        panel2.add(title);
        JLabel itm = new JLabel("ITEM");
         itm.setFont(new Font("Times New Roman", Font.BOLD, 15));
         itm.setBounds(100, 100, 100, 30);
         itm.setForeground(Color.white);
         JLabel prc = new JLabel("PRICE(Rs)");
         prc.setFont(new Font("Times New Roman", Font.BOLD, 15));
         prc.setBounds(400, 100, 100, 30);
         prc.setForeground(Color.white);
         panel2.add(itm);
         panel2.add(prc);

        for(int i=0;i<biryanisItems.length;i++){
            String item = biryanisItems[i];
             float price = biryanisPrices[i];
             JButton addButton = new JButton("Add to billing");
             addButton.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     int quantity = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Quantity:"));
                     String itemWithQuantity = item + " x " + quantity;
                     float itemTotalPrice = price * quantity;
                     JOptionPane.showMessageDialog(frame3," item added to billing !");
                     queue.insert(queue, itemWithQuantity, itemTotalPrice);
                 }
             });
            itemss = new JLabel(item);
            itemss.setBounds(100, j, 200, 20);
            itemss.setForeground(Color.white);
             j += 40;
             panel2.add(itemss);
             JLabel pricess = new JLabel(Float.toString(price));
             pricess.setBounds(400, k, 100, 20);
             pricess.setForeground(Color.white);
             k += 40;
             panel2.add(pricess);
             addButton.setBounds(600, l, 140, 20);
             addButton.setBackground(c);
             l += 40;
             panel2.add(addButton);

            panel2.setLayout(null);
        }
        frame2.add(panel2);
        panel2.setVisible(true);

    }
    void veg_chinese()
    {
        panel1.removeAll();
        panel1.revalidate();
        panel1.repaint();
        panel1.setVisible(false);
        int j=140,k=140,l=140;
        String[] chineseItems = { "Veg Noodles", "Veg Schezwan Noodles",
            "Paneer Noodles", "Corn Noodles","Mushroom Fried Rice",
            "Vegetable Fried Rice", "Schezwan Vegetable Fried Rice", "Paneer Fried Rice", 
            "Cashew Fried Rice", "Corn Fried Rice"
        };
        float[] chinesePrices = { 320, 290, 340, 250, 260, 290, 310, 350, 320, 280};

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.black);
        frame2.add(panel3);
        panel3.setBounds(300,100,800,800);

        JLabel title = new JLabel("VEG CHINESE ");
        title.setBounds(330, 10, 250, 50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        title.setForeground(Color.white);
        panel3.add(title);
        JLabel itm = new JLabel("ITEM");
         itm.setFont(new Font("Times New Roman", Font.BOLD, 15));
         itm.setBounds(100, 100, 100, 30);
         itm.setForeground(Color.white);
         JLabel prc = new JLabel("PRICE(Rs)");
         prc.setFont(new Font("Times New Roman", Font.BOLD, 15));
         prc.setBounds(400, 100, 100, 30);
         prc.setForeground(Color.white);
         panel3.add(itm);
         panel3.add(prc);

        for(int i=0;i<chineseItems.length;i++){
            String item = chineseItems[i];
             float price = chinesePrices[i];
             JButton addButton = new JButton("Add to billing");
             addButton.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     int quantity = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Quantity:"));
                     String itemWithQuantity = item + " x " + quantity;
                     float itemTotalPrice = price * quantity;
                     JOptionPane.showMessageDialog(frame3," item added to billing !");
                     queue.insert(queue, itemWithQuantity, itemTotalPrice);
                 }
             });
            itemss = new JLabel(item);
            itemss.setBounds(100, j, 200, 20);
            itemss.setForeground(Color.white);
             j += 40;
             panel3.add(itemss);
             JLabel pricess = new JLabel(Float.toString(price));
             pricess.setBounds(400, k, 100, 20);
             pricess.setForeground(Color.white);
             k += 40;
             panel3.add(pricess);
             addButton.setBounds(600, l, 140, 20);
             addButton.setBackground(c);
             l += 40;
             panel3.add(addButton);

            panel3.setLayout(null);
        }
        frame2.add(panel3);
        panel3.setVisible(true);
    }
    void desserts()
    {
        panel1.removeAll();
        panel1.revalidate();
        panel1.repaint();
        panel1.setVisible(false);
        int j=140,k=140,l=140;
        String[] dessertsItems = {
            "Dry Fruit Ice Cream", "Double Flavour Ice Cream", "Vanilla Ice Cream", 
            "ButterScotch Ice Cream", "American Dry Fruit Ice Cream", "Thumbs up","Sprite","Fanta","Pulpy Orange"
            ,"Water Bottle"
        };
        float[] dessertsPrices = {90, 80, 80, 80, 100, 25,25,25,25,25};

        panel1.setVisible(false);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.black);
        frame2.add(panel2);
        panel2.setBounds(300,100,800,800);

        JLabel title = new JLabel("DESSERTS ");
        title.setBounds(330, 10, 250, 50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        title.setForeground(Color.white);
        panel2.add(title);
        JLabel itm = new JLabel("ITEM");
         itm.setFont(new Font("Times New Roman", Font.BOLD, 15));
         itm.setBounds(100, 100, 100, 30);
         itm.setForeground(Color.white);
         JLabel prc = new JLabel("PRICE(Rs)");
         prc.setFont(new Font("Times New Roman", Font.BOLD, 15));
         prc.setBounds(400, 100, 100, 30);
         prc.setForeground(Color.white);
         panel2.add(itm);
         panel2.add(prc);

        for(int i=0;i<dessertsItems.length;i++){
            String item = dessertsItems[i];
             float price = dessertsPrices[i];
             JButton addButton = new JButton("Add to billing");
             addButton.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     int quantity = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Quantity:"));
                     String itemWithQuantity = item + " x " + quantity;
                     float itemTotalPrice = price * quantity;
                     JOptionPane.showMessageDialog(frame3," item added to billing !");
                     queue.insert(queue, itemWithQuantity, itemTotalPrice);
                 }
             });
            itemss = new JLabel(item);
            itemss.setBounds(100, j, 200, 20);
            itemss.setForeground(Color.white);
             j += 40;
             panel2.add(itemss);
             JLabel pricess = new JLabel(Float.toString(price));
             pricess.setBounds(400, k, 100, 20);
             pricess.setForeground(Color.white);
             k += 40;
             panel2.add(pricess);
             addButton.setBounds(600, l, 140, 20);
             addButton.setBackground(c);
             l += 40;
             panel2.add(addButton);

            panel2.setLayout(null);
        }
        frame2.add(panel2);
        panel2.setVisible(true);

    }
    void nonveg_menu()
    {
        frame3 = new JFrame("NON VEG ");
        Color c = new Color(255, 255, 194);
        frame3.getContentPane().setBackground(Color.black);

        back = new JButton("BACK");
        back.setBounds(100, 20, 150, 50);
        back.setBackground(c);
        frame3.add(back);

        nonvegstarters = new JButton("NONVEG-STARTERS ");
        nonvegstarters.setBounds(300, 20, 160, 50);
        nonvegstarters.setBackground(c);
        frame3.add(nonvegstarters);

        nonvegbiryani = new JButton("NONVEG-BIRYANIS ");
        nonvegbiryani.setBounds(500, 20, 150, 50);
        nonvegbiryani.setBackground(c);
        frame3.add(nonvegbiryani);

        nonvegchinese = new JButton("NONVEG-CHINESE ");
        nonvegchinese.setBounds(700, 20, 150, 50);
        nonvegchinese.setBackground(c);
        frame3.add(nonvegchinese);

        desserts = new JButton("DESSERTS ");
        desserts.setBounds(900, 20, 150, 50);
        desserts.setBackground(c);
        frame3.add(desserts);

        billing = new JButton("BILLING");
        billing.setBounds(1100, 20, 150, 50);
        billing.setBackground(c);
        frame3.add(billing);

        nonvegstarters.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                nonveg_starters();
            }
        });
        nonvegbiryani.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                nonveg_biryanis();
            }
        });
        nonvegchinese.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                nonveg_chinese();
            }
        });
        desserts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                dessertsNV();
            }
        });
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                menu();
            }
        });
        billing.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(queue.rear == null){
                    JOptionPane.showMessageDialog(frame,"Please Select some item for Billing");
                }
                else{
                    billing_menu();
                }
            }
        });
        JLabel l1 = new JLabel("SELECT SOME ITEM");
        l1.setFont(new Font("Arial",Font.BOLD,20));
        l1.setForeground(c);
        panel1 = new JPanel();
        panel1.setBackground(Color.black);
        panel1.setBounds(100,150,1300,450);
        panel1.add(l1);

        frame3.add(panel1);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setLayout(null);
        frame3.setSize(2100, 1000);
        frame3.setVisible(true);
    }
    void nonveg_starters()
    {
        panel1.setVisible(false);
        int j=140,k=140,l=140;
        String[] nvStartersItems = {
            "Chilli Chicken", "Dragon Chicken", "Chicken Manchurian ", 
            "Chicken 65", "Chicken Fry Wet", "Chicken Lollipop Wet","Prawns Chilly","Prawns Manchurian","Mutton Fry "
            ,"Mutton Manchurian"
        };
        float[] nvStartersPrices = {340, 350, 370, 360, 320, 400,350,380,450,460};

        panel1.setVisible(false);
        Color c = new Color(255, 255, 194);
        JPanel panel10 = new JPanel();
        panel10.setBackground(Color.black);
        frame3.add(panel10);
        panel10.setBounds(300,100,800,800);

        JLabel title = new JLabel("NONVEG - STARTERS ");
        title.setBounds(330, 10, 300, 50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        title.setForeground(Color.white);
        panel10.add(title);
        JLabel itm = new JLabel("ITEM");
         itm.setFont(new Font("Times New Roman", Font.BOLD, 15));
         itm.setBounds(100, 100, 100, 30);
         itm.setForeground(Color.white);
         JLabel prc = new JLabel("PRICE(Rs)");
         prc.setFont(new Font("Times New Roman", Font.BOLD, 15));
         prc.setBounds(400, 100, 100, 30);
         prc.setForeground(Color.white);
         panel10.add(itm);
         panel10.add(prc);

        for(int i=0;i<nvStartersItems.length;i++){
            String item = nvStartersItems[i];
             float price = nvStartersPrices[i];
             JButton addButton = new JButton("Add to billing");
             addButton.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     int quantity = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Quantity:"));
                     String itemWithQuantity = item + " x " + quantity;
                     float itemTotalPrice = price * quantity;
                     JOptionPane.showMessageDialog(frame3," item added to billing !");
                     queue.insert(queue, itemWithQuantity, itemTotalPrice);
                 }
             });
            itemss = new JLabel(item);
            itemss.setBounds(100, j, 200, 20);
            itemss.setForeground(Color.white);
             j += 40;
             panel10.add(itemss);
             JLabel pricess = new JLabel(Float.toString(price));
             pricess.setBounds(400, k, 100, 20);
             pricess.setForeground(Color.white);
             k += 40;
             panel10.add(pricess);
             addButton.setBounds(600, l, 140, 20);
             addButton.setBackground(c);
             l += 40;
             panel10.add(addButton);

             panel10.setLayout(null);
        }
        frame3.add(panel10);
        panel10.setVisible(true);
    }
    void nonveg_biryanis()
    {
        panel1.setVisible(false);
        int j=140,k=140,l=140;
        String[] nvBiryanisItems = {
            "Chicken Biryani", "Chicken Dum Biryani", "Special Chicken Dilkush Biryani ", 
            "Special Egg Biryani", "Prawn Biryani", "Chicken Punjabi Biryani","Mutton Biryani","Mixed Biryani","Chicken Tikka Biryani"
            ,"Mutton Mandi"
        };
        float[] nvBiryanisPrices = {280, 260, 600, 240, 320, 300,450,480,250,460};

        panel1.setVisible(false);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.black);
        frame3.add(panel2);
        panel2.setBounds(300,100,800,800);

        JLabel title = new JLabel("NONVEG - BIRYANIS ");
        title.setBounds(330, 10, 300, 50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        title.setForeground(Color.white);
        panel2.add(title);
        JLabel itm = new JLabel("ITEM");
         itm.setFont(new Font("Times New Roman", Font.BOLD, 15));
         itm.setBounds(100, 100, 100, 30);
         itm.setForeground(Color.white);
         JLabel prc = new JLabel("PRICE(Rs)");
         prc.setFont(new Font("Times New Roman", Font.BOLD, 15));
         prc.setBounds(400, 100, 100, 30);
         prc.setForeground(Color.white);
         panel2.add(itm);
         panel2.add(prc);

        for(int i=0;i<nvBiryanisItems.length;i++){
            String item = nvBiryanisItems[i];
             float price = nvBiryanisPrices[i];
             JButton addButton = new JButton("Add to billing");
             addButton.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     int quantity = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Quantity:"));
                     String itemWithQuantity = item + " x " + quantity;
                     float itemTotalPrice = price * quantity;
                     JOptionPane.showMessageDialog(frame3," item added to billing !");
                     queue.insert(queue, itemWithQuantity, itemTotalPrice);
                 }
             });
            itemss = new JLabel(item);
            itemss.setBounds(100, j, 200, 20);
            itemss.setForeground(Color.white);
             j += 40;
             panel2.add(itemss);
             JLabel pricess = new JLabel(Float.toString(price));
             pricess.setBounds(400, k, 100, 20);
             pricess.setForeground(Color.white);
             k += 40;
             panel2.add(pricess);
             addButton.setBounds(600, l, 140, 20);
             addButton.setBackground(c);
             l += 40;
             panel2.add(addButton);

            panel2.setLayout(null);
        }
        frame3.add(panel2);
        panel2.setVisible(true);
    }
    void nonveg_chinese()
    {
        panel1.setVisible(false);
        int j=140,k=140,l=140;
        String[] nvChineseItems = {
            "Egg Noodles", "Chicken Noodles", "Prawn Noodles", 
            "Mixed Noodles ", "Schewam Prawn Fried Rice", "Chicken Fried Rice","Roasted Chicken Fried Rice ","Mutton Fried Rice","Mixed Fried Rice "
            ,"Egg Fried Rice"
        };
        float[] nvChinesePrices = {120, 140, 180, 200, 240, 180,200 ,300,340,140};

        panel1.setVisible(false);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.black);
        frame3.add(panel2);
        panel2.setBounds(300,100,800,800);

        JLabel title = new JLabel("NONVEG - CHINESE ");
        title.setBounds(330, 10, 250, 50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        title.setForeground(Color.white);
        panel2.add(title);
        JLabel itm = new JLabel("ITEM");
         itm.setFont(new Font("Times New Roman", Font.BOLD, 15));
         itm.setBounds(100, 100, 100, 30);
         itm.setForeground(Color.white);
         JLabel prc = new JLabel("PRICE(Rs)");
         prc.setFont(new Font("Times New Roman", Font.BOLD, 15));
         prc.setBounds(400, 100, 100, 30);
         prc.setForeground(Color.white);
         panel2.add(itm);
         panel2.add(prc);

        for(int i=0;i<nvChineseItems.length;i++){
            String item = nvChineseItems[i];
             float price = nvChinesePrices[i];
             JButton addButton = new JButton("Add to billing");
             addButton.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     int quantity = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Quantity:"));
                     String itemWithQuantity = item + " x " + quantity;
                     float itemTotalPrice = price * quantity;
                     JOptionPane.showMessageDialog(frame3," item added to billing !");
                     queue.insert(queue, itemWithQuantity, itemTotalPrice);
                 }
             });
            itemss = new JLabel(item);
            itemss.setBounds(100, j, 200, 20);
            itemss.setForeground(Color.white);
             j += 40;
             panel2.add(itemss);
             JLabel pricess = new JLabel(Float.toString(price));
             pricess.setBounds(400, k, 100, 20);
             pricess.setForeground(Color.white);
             k += 40;
             panel2.add(pricess);
             addButton.setBounds(600, l, 140, 20);
             addButton.setBackground(c);
             l += 40;
             panel2.add(addButton);

            panel2.setLayout(null);
        }
        frame3.add(panel2);
        panel2.setVisible(true);
    }
    void dessertsNV(){
        panel1.removeAll();
        panel1.revalidate();
        panel1.repaint();
        panel1.setVisible(false);
        int j=140,k=140,l=140;
        String[] dessertsItems = {
            "Dry Fruit Ice Cream", "Double Flavour Ice Cream", "Vanilla Ice Cream", 
            "ButterScotch Ice Cream", "American Dry Fruit Ice Cream", "Thumbs up","Sprite","Fanta","Pulpy Orange"
            ,"Water Bottle"
        };
        float[] dessertsPrices = {90, 80, 80, 80, 100, 25,25,25,25,25};

        panel1.setVisible(false);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.black);
        frame3.add(panel2);
        panel2.setBounds(300,100,800,800);

        JLabel title = new JLabel("DESSERTS ");
        title.setBounds(330, 10, 250, 50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        title.setForeground(Color.white);
        panel2.add(title);
        JLabel itm = new JLabel("ITEM");
         itm.setFont(new Font("Times New Roman", Font.BOLD, 15));
         itm.setBounds(100, 100, 100, 30);
         itm.setForeground(Color.white);
         JLabel prc = new JLabel("PRICE(Rs)");
         prc.setFont(new Font("Times New Roman", Font.BOLD, 15));
         prc.setBounds(400, 100, 100, 30);
         prc.setForeground(Color.white);
         panel2.add(itm);
         panel2.add(prc);

        for(int i=0;i<dessertsItems.length;i++){
            String item = dessertsItems[i];
             float price = dessertsPrices[i];
             JButton addButton = new JButton("Add to billing");
             addButton.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                     int quantity = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Quantity:"));
                     String itemWithQuantity = item + " x " + quantity;
                     float itemTotalPrice = price * quantity;
                     JOptionPane.showMessageDialog(frame3," item added to billing !");
                     queue.insert(queue, itemWithQuantity, itemTotalPrice);
                 }
             });
            itemss = new JLabel(item);
            itemss.setBounds(100, j, 200, 20);
            itemss.setForeground(Color.white);
             j += 40;
             panel2.add(itemss);
             JLabel pricess = new JLabel(Float.toString(price));
             pricess.setBounds(400, k, 100, 20);
             pricess.setForeground(Color.white);
             k += 40;
             panel2.add(pricess);
             addButton.setBounds(600, l, 140, 20);
             addButton.setBackground(c);
             l += 40;
             panel2.add(addButton);

            panel2.setLayout(null);
        }
        frame3.add(panel2);
        panel2.setVisible(true);
    }
    void billing_menu()
    {
        float sum = 0.0f; 
        String bill_item = "";
        float bill_price = 0.0f;
        int m = 120,n = 120;
        frame4 = new JFrame("BILLING");
        frame4.getContentPane().setBackground(Color.black);
        JLabel chefimg = new JLabel(new ImageIcon("C:\\Restaurant_Bill_Generator\\billChef.png")); 
        chefimg.setBounds(350, 0, 100, 100);
        frame4.add(chefimg);

        JLabel resimg = new JLabel(new ImageIcon("C:\\Restaurant_Bill_Generator\\resImg.png")); 
        resimg.setBounds(400, 0, 500, 80);
        frame4.add(resimg);

        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm");
        String date_now = currentLocalDateTime.format(dateTimeFormatter);

        JLabel dates = new JLabel(date_now);
        dates.setBounds(780, 90, 150, 10);
        dates.setForeground(c);

        JLabel line1 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------");
        line1.setBounds(350, 100, 650, 10);
        line1.setForeground(c);

        frame4.add(line1);
        // frame4.add(name);
        frame4.add(dates);

        Node temp = queue.front;
        while(temp != null)
        {
            bill_item = temp.item;
            JLabel billitem = new JLabel(bill_item);
            billitem.setBounds(400, m, 350, 20);
            billitem.setForeground(Color.white);
            billitem.setFont(new Font("Arial", Font.BOLD, 17));
            m += 40;
            frame4.add(billitem);
            bill_price = temp.price;
            sum += bill_price;
            JLabel billprice = new JLabel(Float.toString(bill_price));
            billprice.setBounds(800, n, 350, 20);
            billprice.setForeground(Color.white);
            billprice.setFont(new Font("Arial", Font.BOLD, 17));
            n += 40;
            frame4.add(billprice);
            temp = temp.next;
        }
        JLabel line2 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------");
        line2.setBounds(350, m+10, 650, 10);
        line2.setForeground(c);
        frame4.add(line2);
        JLabel tt1 = new JLabel("TOTAL  ");
        tt1.setBounds(400, m+40, 350, 20);
        tt1.setFont(new Font("Arial", Font.BOLD, 17));
        tt1.setForeground(c);
        tt1.setFont(new Font("Arial", Font.BOLD, 17));
        JLabel total = new JLabel(Float.toString(sum));
        total.setBounds(800,n+40,350,20);
        total.setForeground(c);
        total.setFont(new Font("Arial", Font.BOLD, 17));
        JLabel thnk = new JLabel("-- THANK YOU VISIT AGAIN -- ");
        thnk.setBounds(550, m+100, 300, 20);
        thnk.setForeground(c);
        JButton menu = new JButton("MENU ");
        menu.setBounds(450, m+150, 100, 30);
        menu.setFont(new Font("Arial", Font.BOLD, 14));
        menu.setBackground(c);

        JButton exit = new JButton("EXIT");
        exit.setBounds(700, m+150, 100, 30);
        exit.setFont(new Font("Arial", Font.BOLD, 14));
        exit.setBackground(c);
        frame4.add(exit);
        frame4.add(menu);
        frame4.add(thnk);
        frame4.add(tt1);
        frame4.add(total);
        
        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                menu();
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        frame4.setSize(2100, 1000);
        frame4.setLayout(null);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setVisible(true);
    }
}
class Restaurant_Gui 
{
    public static void main(String[] args) {
        Main obj = new Main();
        obj.menu();
    }
}