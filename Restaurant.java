import java.util.Scanner;
class Node{
    String item;
    float price;
    Node next;
    Node(String item,float price){
        this.item = item;
        this.price = price;
    }
}
class Queue{
    Node front;
    Node rear ;
    Queue(){
        this.front = null;
        this.rear = null;
    }
    void insert(Queue queue,String item,float price){
        Node newnode = new Node(item,price);
        if(queue.front == null){
            queue.rear = newnode;
            queue.front = newnode;
        }
        else{
            queue.rear.next = newnode;
            queue.rear = newnode;
        }
    }
    void billing(Queue queue){
        float sum = 0.0f;
        Scanner sc = new Scanner(System.in);
        Node temp = queue.front;
        while(temp != null){
            sum += temp.price;
            temp = temp.next;
        }
        System.out.println("Do you have student ID : ");
        System.out.println("1.Yes \n2.No");
        int ch = sc.nextInt();
        float discount = 0.0f;
        if(ch == 1 && sum>=500){
            String name="",rollno="",phoneno="",college="";
            System.out.println("Enter Student name : ");
            name += sc.next();
            System.out.println("Enter Student Roll No : ");
            rollno += sc.next();
            System.out.println("Enter Student Phone Number : ");
            phoneno += sc.next();
            System.out.println("Enter Student College : ");
            college += sc.next();
            if(rollno.length()==10 && phoneno.length()==10){
                System.out.println("Student ID discount applied successfully");
                discount = sum/10;
                sum -= sum/10;
            }
            else{
                System.out.println("!!!Sorry You are not eligible for Student ID discount");
            }
        }
        else if(sum<500){
            System.out.println("Bill is less than 500");
        }
        temp = queue.front;
        while(temp != null){
            System.out.printf("\n%30s - %f\n",temp.item,temp.price);
            temp = temp.next;
        }
        if(ch==1 && sum>=500){
            String dis = "Discount";
            System.out.printf("\n%30s - %f\n",dis,discount);
        }
        String total = "Total";
        System.out.printf("\n%30s - %f\n",total,sum);
        System.exit(0);
    }
}
class Veg
{
    Scanner sc = new Scanner(System.in);
    void mainVeg(Veg vegObj,Queue queue)
    {
        System.out.println(" -------------------------------------------------------------------------------------------------------");
        System.out.println(" | 1. STARTERS \t 2.BIRYANIS \t 3.CHINESE \t 4.DESSERTS \t 5.BACK \t 6.BILLING |");
        System.out.println(" -------------------------------------------------------------------------------------------------------");
        System.out.println("Enter choice : ");
        int ch = sc.nextInt();
        switch(ch)
        {
            case 1:
                vegObj.vegStarters(vegObj,queue);
                break;
            case 2:
                vegObj.vegBiryanis(vegObj,queue);
                break;
            case 3:
                vegObj.vegChinese(vegObj,queue);
                break;
            case 4:
                vegObj.desserts(vegObj,queue);  
                break;
            case 5:
                Restaurant resObj = new Restaurant();
                resObj.selection(queue);
                break;
            case 6:
                queue.billing(queue);
                break;
        }
    }
    void vegStarters(Veg vegObj,Queue queue)
    {
        String item ="";
        String qnt="";
        float price;
        System.out.println(" ---------------- VEG STARTERS ------------");
        System.out.println(" |       ITEM            |    PRICE       |");
        System.out.println(" | 1.Veg Corn Soup       |     Rs.170/-   |");
        System.out.println(" | 2.Veg Sweet Corn Soup |     Rs.180/-   |");
        System.out.println(" | 3.Veg Manchurian Dry  |     Rs.300/-   |");
        System.out.println(" | 4.Paneern 65          |     Rs.320/-   |");
        System.out.println(" | 5.Paneer Chilli       |     Rs.320/-   |");
        System.out.println(" | 6.Mushroom Chilli     |     Rs.310/-   |");
        System.out.println(" | 7.Mushroom 65         |     Rs.310/-   |");
        System.out.println(" ------------------------------------------");
        System.out.println(" | 8.Back              |       9.Billing |");
        System.out.println(" ------------------------------------------");
        System.out.println("\n\n");
        System.out.println(" enter the item number : ");
        int item_no = sc.nextInt();
        int quantity;
        switch(item_no){
            case 1:
                item = "Veg Corn Soup x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 170 *quantity;
                queue.insert(queue, item, price);
                break;
            case 2:
                item = "Veg Sweet Corn Soup x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 180 *quantity;
                queue.insert(queue, item, price);
                break;
            case 3:
                item = "Veg Manchurian Dry x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 300 *quantity;
                queue.insert(queue, item, price);
                break;
            case 4:
                item = "Paneern 65 x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 320 *quantity;
                queue.insert(queue, item, price);
                break;
            case 5:
                item = "Paneer Chilli x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 320 *quantity;
                queue.insert(queue, item, price);
                break;
            case 6:
                item = "Mushroom Chilli  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 310 *quantity;
                queue.insert(queue, item, price);
                break;
            case 7:
                item = "Mushroom 65 x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 310 *quantity;
                queue.insert(queue, item, price);
                break;
            case 8:
                vegObj.mainVeg(vegObj,queue);
                break;
            case 9:
                queue.billing(queue);
                break;
            default:
                System.out.println("!! wrong Input Please Try Again");
                vegObj.vegStarters(vegObj,queue);
                break;
        }
        vegObj.vegStarters(vegObj,queue);
    }
    void vegBiryanis(Veg vegObj,Queue queue)
    {
        String item ="";
        String qnt="";
        float price;
        System.out.println(" ---------------- VEG BIRYANI ------------");
        System.out.println(" |       ITEM            |    PRICE       |");
        System.out.println(" | 1.South Indian Thali  |     Rs.270/-   |");
        System.out.println(" | 2.Special Curd Rice   |     Rs.190/-   |");
        System.out.println(" | 3.Paneer Biryani      |     Rs.340/-   |");
        System.out.println(" | 4.Veg Biryani         |     Rs.260/-   |");
        System.out.println(" | 5.Curd Rice           |     Rs.140/-   |");
        System.out.println(" | 6.Cashew Biryanis     |     Rs.360/-   |");
        System.out.println(" ------------------------------------------");
        System.out.println(" | 7.Back                |     8.Billing  |");
        System.out.println(" ------------------------------------------");
        System.out.println("\n\n");
        System.out.println(" enter the item number : ");
        int item_no = sc.nextInt();
        int quantity;
        switch(item_no){
            case 1:
                item = "South Indian Thali x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 270 *quantity;
                queue.insert(queue, item, price);
                break;
            case 2:
                 item = "Special Curd Rice x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 190 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 3:
                item = "Paneer Biryani  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 340 *quantity;
                queue.insert(queue, item, price);
                break;
            case 4:
                 item = "Veg Biryani x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 260 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 5:
                item = "Curd Rice x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 140 *quantity;
                queue.insert(queue, item, price);
                break;
            case 6:
                 item = "Cashew Biryanis x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 310 *quantity;
                queue.insert(queue, item, price);
                break;
            case 7:
                vegObj.mainVeg(vegObj,queue);
                break;
            case 8:
                queue.billing(queue);
                break;
            default:
                System.out.println("!! wrong Input Please Try Again");
                vegObj.vegBiryanis(vegObj,queue);
                break;
        }
         vegObj.vegBiryanis(vegObj,queue);
    }
    void vegChinese(Veg vegObj,Queue queue)
    {
        String item ="";
        String qnt="";
        float price;
        System.out.println(" --------------------- VEG CHINESE --------------------");
        System.out.println(" |       ITEM                        |    PRICE       |");
        System.out.println(" | 1.Chilly Garlic Noodles           |     Rs.250/-   |");
        System.out.println(" | 2.Veg Noodles                     |     Rs.260/-   |");
        System.out.println(" | 3.Veg Schezwan Noodles            |     Rs.220/-   |");
        System.out.println(" | 4.Paneern Noodles                 |     Rs.310/-   |");
        System.out.println(" | 5.Corn Noodles                    |     Rs.320/-   |");
        System.out.println(" | 6.Mushroom Fried Rice             |     Rs.290/-   |");
        System.out.println(" | 7.Special Veg Fried Rice          |     Rs.340/-   |");
        System.out.println(" | 8.Vegetable Fried Rice            |     Rs.250/-   |");
        System.out.println(" | 9.Schezwan Vegetable  Fried Rice  |     Rs.260/-   |");
        System.out.println(" | 10.Veg Singapore Fried Rice       |     Rs.290/-   |");
        System.out.println(" | 11.Paneern Fried Rice             |     Rs.310/-   |");
        System.out.println(" | 12.Special Paneer Fried Rice      |     Rs.350/-   |");
        System.out.println(" | 13.Cashew Fried Rice              |     Rs.320/-   |");
        System.out.println(" | 14.Corn Fried Rice                |     Rs.280/-   |");
        System.out.println(" ------------------------------------------------------");
        System.out.println(" | 15.Back                           |    16.Billing  |");
        System.out.println(" ------------------------------------------------------");
        System.out.println("\n\n");
        System.out.println(" enter the item number : ");
        int item_no = sc.nextInt();
        int quantity;
        switch(item_no){
            case 1:
                item = "Chilly Garlic Noodles x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 250 *quantity;
                queue.insert(queue, item, price);
                break;
            case 2:
                 item = "Veg Noodles x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 260 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 3:
                item = "Veg Schezwan Noodles x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 220 *quantity;
                queue.insert(queue, item, price);
                break;
            case 4:
                 item = "Paneern Noodles x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 310 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 5:
                item = "Corn Noodles x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 320 *quantity;
                queue.insert(queue, item, price);
                break;
            case 6:
                 item = "Mushroom Fried Rice  x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 290 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 7:
                item = "Special Veg Fried Rice x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 340 *quantity;
                queue.insert(queue, item, price);
                break;
            case 8:
                item = "Vegetable Fried Rice x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 250 *quantity;
                queue.insert(queue, item, price);
                break;
            case 9:
                 item = "Schezwan Vegetable  Fried Rice x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 260 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 10:
                item = "Veg Singapore Fried Rice x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 290 *quantity;
                queue.insert(queue, item, price);
                break;
            case 11:
                 item = "Paneer Fried Rice x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 310 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 12:
                item = "Special Paneer Fried Rice x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 350 *quantity;
                queue.insert(queue, item, price);
                break;
            case 13:
                 item = "Cashew Fried Rice  x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 320 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 14:
                item = "Corn Fried Rice x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 280 *quantity;
                queue.insert(queue, item, price);
                break;
            case 15:
                vegObj.mainVeg(vegObj,queue);
                break;
            case 16:
                queue.billing(queue);
                break;
            default:
                System.out.println("!! wrong Input Please Try Again");
                vegObj.vegChinese(vegObj,queue);
                break;
        }
        vegObj.vegChinese(vegObj,queue);
    }
    void desserts(Veg vegObj,Queue queue)
    {
        String item ="";
        String qnt="";
        float price;
        System.out.println(" --------------- DESSEERTS & COOL DRINKS ----------------");
        System.out.println(" |       ITEM                        |    PRICE         |");
        System.out.println(" | 1.Chocolate Lava Cake             |     Rs.70/piece- |");
        System.out.println(" | 2.Lemon Sponge Cake               |     Rs.80/piece- |");
        System.out.println(" | 3.Vanilla Panna Cotta             |     Rs.140/piece-|");
        System.out.println(" | 4.ButterScotch Pudding            |     Rs.300/Piece-|");
        System.out.println(" | 5.Red Velvet Cake                 |     Rs.80/Piece- |");
        System.out.println(" | 6.Dry Fruit Ice Cream             |     Rs.90/cup-   |");
        System.out.println(" | 7.Double Flavour Ice Cream        |     Rs.80/cup-   |");
        System.out.println(" | 8.Vanilla Ice Cream               |     Rs.80/cup-   |");
        System.out.println(" | 9.ButterScotch Ice Cream          |     Rs.80/cup-   |");
        System.out.println(" | 10.American Dry Fruit Ice Cream   |     Rs.100/cup-  |");
        System.out.println(" | 11.Thumbs up                      |     Rs.25/-      |");
        System.out.println(" | 12.Sprite                         |     Rs.25/-      |");
        System.out.println(" | 13.Fanta                          |     Rs.25/-      |");
        System.out.println(" | 14.Pulpy Orange                   |     Rs.25/-      |");
        System.out.println(" | 15.Water Bottle                   |     Rs.25/-      |");
        System.out.println(" --------------------------------------------------------");
        System.out.println(" | 16.Back                           |    17.Billing    |");
        System.out.println(" --------------------------------------------------------");
        System.out.println("\n\n");
        System.out.println(" enter the item number : ");
        int item_no = sc.nextInt();
        int quantity;
        switch(item_no){
            case 1:
                item = "Chocolate Lava Cake x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 70 *quantity;
                queue.insert(queue, item, price);
                break;
            case 2:
                 item = "Lemon Sponge Cake  x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 80 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 3:
                item = "Vanilla Panna Cotta x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 140 *quantity;
                queue.insert(queue, item, price);
                break;
            case 4:
                 item = "ButterScotch Pudding x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 300 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 5:
                item = "Red Velvet Cake x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 80 *quantity;
                queue.insert(queue, item, price);
                break;
            case 6:
                 item = "Dry Fruit Ice Cream  x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 90 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 7:
                item = "Double Flavour Ice Cream x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 80 *quantity;
                queue.insert(queue, item, price);
                break;
            case 8:
                item = "Vanilla Ice Cream x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 80 *quantity;
                queue.insert(queue, item, price);
                break;
            case 9:
                 item = "ButterScotch Ice Cream x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 80 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 10:
                item = "American Dry Fruit Ice Cream x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 100 *quantity;
                queue.insert(queue, item, price);
                break;
            case 11:
                 item = "Thumbs up  x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 25 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 12:
                item = "Sprite  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 25 *quantity;
                queue.insert(queue, item, price);
                break;
            case 13:
                 item = "Fanta  x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 25 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 14:
                item = "Pulpy Orange x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 25 *quantity;
                queue.insert(queue, item, price);
                break;
            case 15:
                item = "Water Bottle  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
               item += qnt;
                price = 25 *quantity;
                queue.insert(queue, item, price);
               break;
            case 16:
               vegObj.mainVeg(vegObj,queue);
               break;
           case 17:
               queue.billing(queue);
               break;
            default:
                System.out.println("!! wrong Input Please Try Again");
                vegObj.desserts(vegObj,queue);
                break;
        }
        vegObj.desserts(vegObj,queue);
    }
}
class NonVeg
{
    Scanner sc = new Scanner(System.in);
    void mainNonVeg(NonVeg nonVegObj,Queue queue)
    {
        System.out.println(" -------------------------------------------------------------------------------------------------------");
        System.out.println(" | 1. STARTERS \t 2.BIRYANIS \t 3.CHINESE \t 4.DESSERTS \t 5.BACK \t 6.BILLING |");
        System.out.println(" -------------------------------------------------------------------------------------------------------");
        int ch = sc.nextInt();
        switch(ch)
        {
            case 1:
                nonVegObj.nonVegStarters(nonVegObj,queue);
                break;
            case 2:
                nonVegObj.nonVegBiryanis(nonVegObj,queue);
                break;
            case 3:
                nonVegObj.nonVegChinese(nonVegObj,queue);
                break;
            case 4:
                nonVegObj.desserts(nonVegObj,queue);  
                break;
            case 5:
                Restaurant resObj = new Restaurant();
                resObj.selection(queue);
                break;
            case 6:
                queue.billing(queue);
                break;
        }
    }
    void nonVegStarters(NonVeg nonVegObj,Queue queue)
    {
        String item ="";
        String qnt="";
        float price;
        System.out.println(" ----------------NON VEG STARTERS -------------");
        System.out.println("  ____________________________________________");
        System.out.println(" |       ITEM                -       PRICE    |");
        System.out.println(" |____________________________________________|");
        System.out.println(" | 1.Chilli Chicken          -     Rs.340/-   |");
        System.out.println(" | 2.Dragon Chicken          -     Rs.360/-   |");
        System.out.println(" | 3.Chicken Manchurian      -     Rs.350/-   |");
        System.out.println(" | 4.Bhutan Wings            -     Rs.370/-   |");
        System.out.println(" | 5.Chicken 65              -     Rs.340/-   |");
        System.out.println(" | 6.Chicken Fry Wet         -     Rs.320/-   |");
        System.out.println(" | 7.Chicken Lollipop Wet    -     Rs.310/-   |");
        System.out.println(" | 8.Prawns Chilly           -     Rs.400/-   |");
        System.out.println(" | 9.Prawns Fry              -     Rs.410/-   |");
        System.out.println(" | 10.Prawns Manchurian      -     Rs.430/-   |");
        System.out.println(" | 11.Prawns 65              -     Rs.470/-   |");
        System.out.println(" | 12.Mutton Fry             -     Rs.460/-   |");
        System.out.println(" | 13.Mutton Chilly          -     Rs.470/-   |");
        System.out.println(" | 14.Mutton Manchurian      -     Rs.500/-   |");
        System.out.println(" | 15.Ginger Mutton          -     Rs.450/-   |");
        System.out.println(" |____________________________________________|");
 
        
        System.out.println("16.Back ");
        System.out.println("17.Billing");

        System.out.println("\n\n");
        System.out.println(" enter the item number : ");
        int item_no = sc.nextInt();
        int quantity;
        switch(item_no){
            case 1:
                item = "Chilli Chicken  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 340 *quantity;
                queue.insert(queue, item, price);
                break;
            case 2:
                item = "Dragon Chicken  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 360 *quantity;
                queue.insert(queue, item, price);
                break;
            case 3:
                item = "Chicken Manchurian x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 350 *quantity;
                queue.insert(queue, item, price);
                break;
            case 4:
                item = "Bhutan Wing x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 370 *quantity;
                queue.insert(queue, item, price);
                break;
            case 5:
                item = "Chicken 65  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 340 *quantity;
                queue.insert(queue, item, price);
                break;
            case 6:
                item = "Chicken Fry Wet  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 320 *quantity;
                queue.insert(queue, item, price);
                break;
            case 7:
                item = "Chicken Lollipop Wet x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 310 *quantity;
                queue.insert(queue, item, price);
                break;
            case 8:
                item = "Prawns Chilly x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 400 *quantity;
                queue.insert(queue, item, price);
                break;
            case 9:
                item = "Prawns Fry x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 410 *quantity;
                queue.insert(queue, item, price);
                break;
            case 10:
                item = "Prawns Manchurian x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 343000 *quantity;
                queue.insert(queue, item, price);
                break;
            case 11:
                item = "Paneern 65 x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 470 *quantity;
                queue.insert(queue, item, price);
                break;
            case 12:
                item = "Mutton Fry x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 460 *quantity;
                queue.insert(queue, item, price);
                break;
            case 13:
                item = "Mutton Chilly  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 470 *quantity;
                queue.insert(queue, item, price);
                break;
            case 14:
                item = "Mutton Manchurian x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 500 *quantity;
                queue.insert(queue, item, price);
                break;
            case 15:
                item = "Ginger Mutton x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 450 *quantity;
                queue.insert(queue, item, price);
                break;
            case 16:
                nonVegObj.mainNonVeg(nonVegObj,queue);
                break;
            case 17:
                queue.billing(queue);
                break;
            default:
                System.out.println("!! wrong Input Please Try Again");
                nonVegObj.nonVegStarters(nonVegObj,queue);
        }
        nonVegObj.nonVegStarters(nonVegObj, queue);
    }
    void nonVegBiryanis(NonVeg nonVegObj,Queue queue)
    {      
        String item ="";
        String qnt="";
        float price;
        System.out.println(" -------------------- NON-VEG BIRYANI -----------------");
        System.out.println(" |       ITEM                       |    PRICE       |");
        System.out.println(" | 1.Chicken Biryani                |     Rs.320/-   |");
        System.out.println(" | 2.Chicken Dum Biryani            |     Rs.350/-   |");
        System.out.println(" | 3.Special Chicken Biryani        |     Rs.350/-   |");
        System.out.println(" | 4.Special Mutton Biryani         |     Rs.490/-   |");
        System.out.println(" | 5.Special Chicken Dilkush Biryani|     Rs.590/-   |");
        System.out.println(" | 6.Special Egg Biryani            |     Rs.300/-   |");
        System.out.println(" | 7.Prawn Biryani                  |     Rs.390/-   |");
        System.out.println(" | 8.Chicken Punjabi Biryani        |     Rs.380/-   |");
        System.out.println(" | 9.Chicken Kabab Biryani          |     Rs.350/-   |");
        System.out.println(" | 10.Chandrika Special KababBiryani|     Rs.490/-   |");
        System.out.println(" | 11.Chicken Pot Birtyani          |     Rs.430/-   | ");
        System.out.println(" | 12.Chicken Joint Birtyani        |     Rs.350/-   |");
        System.out.println(" | 13.Special Prawn Biryani         |     Rs.400/-   |");
        System.out.println(" ------------------------------------------");
        System.out.println(" | 14.Back              |       15.Billing |");
        System.out.println(" ------------------------------------------");
        System.out.println("\n\n");
        System.out.println(" enter the item number : ");
        int item_no = sc.nextInt();
        int quantity;
        switch(item_no){
            case 1:
                item = "Chicken Biryani  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 320 *quantity;
                queue.insert(queue, item, price);
                break;
            case 2:
                item = "Chicken Dum Biryani    x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 350 *quantity;
                queue.insert(queue, item, price);
                break;
            case 3:
                item = "Special Chicken Biryani   x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 350 *quantity;
                queue.insert(queue, item, price);
                break;
            case 4:
                item = "Special Mutton Biryani   x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 490 *quantity;
                queue.insert(queue, item, price);
                break;
            case 5:
                item = "Special Chicken Dilkush Biryani  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 590 *quantity;
                queue.insert(queue, item, price);
                break;
            case 6:
                item = "Special Egg Biryani  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 300 *quantity;
                queue.insert(queue, item, price);
                break;
            case 7:
                item = "Prawn Biryani x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 390 *quantity;
                queue.insert(queue, item, price);
                break;
            case 8:
                item = "Chicken Punjabi Biryani  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 380 *quantity;
                queue.insert(queue, item, price);
                break;
            case 9:
                item = "Chicken Kabab Biryani x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 380 *quantity;
                queue.insert(queue, item, price);
                break;
            case 10:
                item = "Chandrika Special KababBiryani  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 490 *quantity;
                queue.insert(queue, item, price);
                break;
            case 11:
                item = "Chicken Pot Birtyani x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 430 *quantity;
                queue.insert(queue, item, price);
                break;
            case 12:
                item = "Chicken Joint Biryani  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 350 *quantity;
                queue.insert(queue, item, price);
                break;
            case 13:
                item = "Special Prawn Biryani x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 400 *quantity;
                queue.insert(queue, item, price);
                break;
            case 14:
                nonVegObj.mainNonVeg(nonVegObj, queue);
                break;
            case 15:
                queue.billing(queue);
                break;
            default:
                System.out.println("!! wrong Input Please Try Again");
                nonVegObj.nonVegBiryanis(nonVegObj,queue);
                break;
        }
        nonVegObj.nonVegBiryanis(nonVegObj,queue);
        
    }
    void nonVegChinese(NonVeg nonVegObj,Queue queue)
    {
        String item ="";
        String qnt="";
        float price;
        System.out.println(" -------------------- NON VEG CHINESE -----------------");
        System.out.println(" |       ITEM                        |    PRICE       |");
        System.out.println(" | 1.Egg Noodles                     |     Rs.260/-   |");
        System.out.println(" | 2.Schewan Egg Noodles             |     Rs.270/-   |");
        System.out.println(" | 3.Chicken Noodles                 |     Rs.290/-   |");
        System.out.println(" | 4.Schzewan Chicken Noodles        |     Rs.320/-   |");
        System.out.println(" | 5.Prawn Noodles                   |     Rs.300/-   |");
        System.out.println(" | 6.Mixed Noodles                   |     Rs.350/-   |");
        System.out.println(" | 7.Prawn Fried Rice                |     Rs.340/-   |");
        System.out.println(" | 8.Schewam Prawn Fried Rice        |     Rs.400/-   |");
        System.out.println(" | 9.Egg Fried Rice                  |     Rs.270/-   |");
        System.out.println(" | 10.Shewan Egg Fried Rice          |     Rs.280/-   |");
        System.out.println(" | 11.Chicken Fried Rice             |     Rs.320/-   |");
        System.out.println(" | 12.Special Chicken Fried Rice     |     Rs.355/-   |");
        System.out.println(" | 13.Roasted Chicken Fried Rice     |     Rs.400/-   |");
        System.out.println(" | 14.Mutton Fried Rice              |     Rs.410/-   |");
        System.out.println(" | 15.Special Mutton Fried Rice      |     Rs.450/-   |");
        System.out.println(" | 16.Mixed Fried Rice               |     Rs.400/-   |");
        System.out.println(" ------------------------------------------------------");
        System.out.println(" | 17.Back                            |    18.Billing  |");
        System.out.println(" ------------------------------------------------------");
        System.out.println("\n\n");
        System.out.println(" enter the item number : ");
        int item_no = sc.nextInt();
        int quantity;
        switch(item_no){
            case 1:
                item = "Egg Noodles x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 260 *quantity;
                queue.insert(queue, item, price);
                break;
            case 2:
                 item = "Schewan Egg Noodles x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 270 *quantity;
                queue.insert(queue, item, price);
                break;
            case 3:
                item = "Chicken Noodles x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 290 *quantity;
                queue.insert(queue, item, price);
                break;
            case 4:
                 item = "Schzewan Chicken Noodles x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 320 *quantity;
                queue.insert(queue, item, price);
                break;
            case 5:
                item = "Prawn Noodles x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 300 *quantity;
                queue.insert(queue, item, price);
                break;
            case 6:
                 item = "Mixed Noodles  x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 350 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 7:
                item = "Prawn Fried Rice x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 340 *quantity;
                queue.insert(queue, item, price);
                break;
            case 8:
                item = "Schewam Prawn Fried Rice x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 400 *quantity;
                queue.insert(queue, item, price);
                break;
            case 9:
                 item = "Egg Fried Rice x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 270 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 10:
                item = "Shewan Egg Fried Rice x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 280 *quantity;
                queue.insert(queue, item, price);
                break;
            case 11:
                 item = "Chicken Fried Rice x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 320 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 12:
                item = "Special Chicken Fried Rice x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 355 *quantity;
                queue.insert(queue, item, price);
                break;
            case 13:
                 item = "Roasted Chicken Fried Rice  x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 400 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 14:
                item = "Mutton Fried Rice x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 410 *quantity;
                queue.insert(queue, item, price);
                break;
            case 15:
                item = "Special Mutton Fried Rice  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
               item += qnt;
                price = 450 *quantity;
                queue.insert(queue, item, price);
               break;
            case 16:
               item = "Mixed Fried Rice x ";
               System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
               qnt = Integer.toString(quantity);
               item += qnt;
               price = 400 *quantity;
               queue.insert(queue, item, price);
               break;
            case 17:
                nonVegObj.mainNonVeg(nonVegObj, queue);
                break;
            case 18:
                queue.billing(queue);
                break;
            default:
                System.out.println("!! wrong Input Please Try Again");
                nonVegObj.nonVegChinese(nonVegObj, queue);
        }
        nonVegObj.nonVegChinese(nonVegObj,queue);
    }
    void desserts(NonVeg nonVegObj,Queue queue)
    {
        String item ="";
        String qnt="";
        float price;
        System.out.println(" --------------- DESSEERTS & COOL DRINKS ----------------");
        System.out.println(" |       ITEM                        |    PRICE         |");
        System.out.println(" | 1.Chocolate Lava Cake             |     Rs.70/piece- |");
        System.out.println(" | 2.Lemon Sponge Cake               |     Rs.80/piece- |");
        System.out.println(" | 3.Vanilla Panna Cotta             |     Rs.140/piece-|");
        System.out.println(" | 4.ButterScotch Pudding            |     Rs.300/Piece-|");
        System.out.println(" | 5.Red Velvet Cake                 |     Rs.80/Piece- |");
        System.out.println(" | 6.Dry Fruit Ice Cream             |     Rs.90/cup-   |");
        System.out.println(" | 7.Double Flavour Ice Cream        |     Rs.80/cup-   |");
        System.out.println(" | 8.Vanilla Ice Cream               |     Rs.80/cup-   |");
        System.out.println(" | 9.ButterScotch Ice Cream          |     Rs.80/cup-   |");
        System.out.println(" | 10.American Dry Fruit Ice Cream   |     Rs.100/cup-  |");
        System.out.println(" | 11.Thumbs up                      |     Rs.25/-      |");
        System.out.println(" | 12.Sprite                         |     Rs.25/-      |");
        System.out.println(" | 13.Fanta                          |     Rs.25/-      |");
        System.out.println(" | 14.Pulpy Orange                   |     Rs.25/-      |");
        System.out.println(" | 15.Water Bottle                   |     Rs.25/-      |");
        System.out.println(" --------------------------------------------------------");
        System.out.println(" | 16.Back                           |    17.Billing    |");
        System.out.println(" --------------------------------------------------------");
        System.out.println("\n\n");
        System.out.println(" enter the item number : ");
        int item_no = sc.nextInt();
        int quantity;
        switch(item_no){
            case 1:
                item = "Chocolate Lava Cake x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 70 *quantity;
                queue.insert(queue, item, price);
                break;
            case 2:
                 item = "Lemon Sponge Cake  x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 80 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 3:
                item = "Vanilla Panna Cotta x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 140 *quantity;
                queue.insert(queue, item, price);
                break;
            case 4:
                 item = "ButterScotch Pudding x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 300 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 5:
                item = "Red Velvet Cake x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 80 *quantity;
                queue.insert(queue, item, price);
                break;
            case 6:
                 item = "Dry Fruit Ice Cream  x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 90 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 7:
                item = "Double Flavour Ice Cream x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 80 *quantity;
                queue.insert(queue, item, price);
                break;
            case 8:
                item = "Vanilla Ice Cream x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 80 *quantity;
                queue.insert(queue, item, price);
                break;
            case 9:
                 item = "ButterScotch Ice Cream x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 80 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 10:
                item = "American Dry Fruit Ice Cream x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 100 *quantity;
                queue.insert(queue, item, price);
                break;
            case 11:
                 item = "Thumbs up  x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 25 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 12:
                item = "Sprite  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 25 *quantity;
                queue.insert(queue, item, price);
                break;
            case 13:
                 item = "Fanta  x ";
                 System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                 qnt = Integer.toString(quantity);
                item += qnt;
                 price = 25 *quantity;
                 queue.insert(queue, item, price);
                break;
            case 14:
                item = "Pulpy Orange x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
                item += qnt;
                price = 25 *quantity;
                queue.insert(queue, item, price);
                break;
            case 15:
                item = "Water Bottle  x ";
                System.out.println("Enter Quantity:");
                quantity = sc.nextInt();
                qnt = Integer.toString(quantity);
               item += qnt;
                price = 25 *quantity;
                queue.insert(queue, item, price);
               break;
            case 16:
               nonVegObj.mainNonVeg(nonVegObj,queue);
               break;
           case 17:
               queue.billing(queue);
               break;
            default:
                System.out.println("!! wrong Input Please Try Again");
                nonVegObj.desserts(nonVegObj,queue);
                break;
        }
        nonVegObj.desserts(nonVegObj,queue);
    }
}
class Restaurant
{
    void selection(Queue queue)
    {
            System.out.println("--------------");
            System.out.println(" | 1.veg    | \n | 2.nonveg | \n | 3.Exit/Bill| ");
            System.out.println("--------------");
            System.out.print(" select from above : ");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                    Veg vegObj = new Veg();
                    vegObj.mainVeg(vegObj,queue);
                    break;
                case 2:
                    NonVeg nonVegObj = new NonVeg();
                    nonVegObj.mainNonVeg(nonVegObj,queue);
                    break;
                case 3:
                    if(queue.front==null){
                        System.exit(0);
                    }
                    else{
                        queue.billing(queue);
                    }
                default:
                    System.out.println("!! Wrong Input !! Please Try Again");
                    Restaurant obj = new Restaurant();
                    obj.selection(queue);
            }
    }
    public static void main(String[] args) {
        Restaurant obj = new Restaurant();
        Queue queue = new Queue();
        obj.selection(queue);
    }
}