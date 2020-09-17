package supermarket;

import supermarket.CashRegister;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class CashRegisterUI extends JFrame {

    CashRegister cashRegister;

    //total items button
    private BufferedImage icon_cart = ImageIO.read(new File("src/img/shoppingcart.png"));
    private JButton btn_allItems = new JButton(new ImageIcon(icon_cart));
    private JLabel l_items = new JLabel(/*all items*/"0 items");

    //search section
    private JPanel section_search = new JPanel(new GridBagLayout());
    private JLabel l_search = new JLabel("Search for product:");
    private JTextField tf_search = new JTextField(10);// accepts upto 10 characters
    private JButton btn_search = new JButton("Search");

    //product section
    private JPanel section_products = new JPanel(new GridBagLayout());
    private BufferedImage img_soap = ImageIO.read(new File("src/img/soap.png"));
    private BufferedImage img_cereal = ImageIO.read(new File("src/img/cereal.png"));
    private BufferedImage img_chinesevegetables = ImageIO.read(new File("src/img/chinesevegetables.png"));
    private BufferedImage img_yoghurt = ImageIO.read(new File("src/img/yoghurt.png"));
    private BufferedImage img_diapers = ImageIO.read(new File("src/img/diapers.png"));
    private BufferedImage img_hagelslag = ImageIO.read(new File("src/img/hagelslag.png"));

    JLabel pic_soap = new JLabel(new ImageIcon(img_soap));
    JLabel pic_cereal = new JLabel(new ImageIcon(img_cereal));
    JLabel pic_chinesevegetables = new JLabel(new ImageIcon(img_chinesevegetables));
    JLabel pic_yoghurt = new JLabel(new ImageIcon(img_yoghurt));
    JLabel pic_diapers = new JLabel(new ImageIcon(img_diapers));
    JLabel pic_hagelslag = new JLabel(new ImageIcon(img_hagelslag));

    private JLabel l_qtySoap = new JLabel("Qty:");
    private JLabel l_qtyCereal = new JLabel("Qty:");
    private JLabel l_qtyChinesevegetables = new JLabel("Qty:");
    private JLabel l_qtyYoghurt = new JLabel("Qty:");
    private JLabel l_qtyDiapers = new JLabel("Qty:");

    private JTextField tf_qtySoap = new JTextField(10);
    private JTextField tf_qtyCereal = new JTextField(10);
    private JTextField tf_qtyChinesevegetables = new JTextField(10);
    private JTextField tf_qtYoghurt = new JTextField(10);
    private JTextField tf_qtyDiapers = new JTextField(10);

    //totals section
    private JPanel section_totals = new JPanel(new GridBagLayout());
    private JLabel l_text_subtotal = new JLabel("Subtotal: ");
    private JLabel l_subtotal = new JLabel(/*subtotal*/);
    private JLabel l_text_total = new JLabel("Total: ");
    private JLabel l_total = new JLabel(/*total*/);

    private JButton btn_pay = new JButton("Checkout");

    public CashRegisterUI() throws IOException {
        super("Supermarket");
        super.setPreferredSize(new Dimension(500, 500));

        btn_allItems.setBackground(Color.white);

        setLocationRelativeTo(null);
        section_search.setLayout(new GridBagLayout());
        section_search.setBackground(Color.white);

        //search
        GridBagConstraints constraints_search = new GridBagConstraints();

        constraints_search.fill = constraints_search.BOTH;

        constraints_search.anchor = GridBagConstraints.NORTHWEST;
        constraints_search.insets = new Insets(30, 20, 20, 20);

        constraints_search.gridx = 0;
        constraints_search.gridy = 1;
        section_search.add(l_search, constraints_search);

        constraints_search.gridx = 1;
        section_search.add(tf_search, constraints_search);

        constraints_search.gridx = 2;
        section_search.add(btn_search, constraints_search);

        constraints_search.insets = new Insets(20, 20, 0, 20);

        //products
        GridBagConstraints constraints_product = new GridBagConstraints();

        constraints_product.anchor = GridBagConstraints.CENTER;
        constraints_product.insets = new Insets(10, 20, 10, 20);

        constraints_search.gridx = 2;
        constraints_search.gridy = 0;
        section_search.add(btn_allItems, constraints_search);

        constraints_search.gridy = 1;
        section_search.add(l_items, constraints_search);

        constraints_search.gridx = 0;
        constraints_search.gridy = 5;
        section_search.add(pic_soap, constraints_search);

        constraints_search.gridx = 1;
        section_search.add(pic_cereal, constraints_search);

        constraints_search.gridx = 2;
        section_search.add(pic_diapers, constraints_search);

        constraints_search.gridx = 0;
        constraints_search.gridy = 6;
        section_search.add(pic_chinesevegetables, constraints_search);

        constraints_search.gridx = 1;
        section_search.add(pic_yoghurt, constraints_search);

        constraints_search.gridx = 2;
        section_search.add(pic_hagelslag, constraints_search);

        constraints_search.gridy = 7;
        section_search.add(l_text_subtotal, constraints_search);

        constraints_search.gridx = 3;
        section_search.add(l_subtotal, constraints_search);

        constraints_search.gridy = 8;
        constraints_search.gridx = 2;
        section_search.add(l_text_total, constraints_search);

        constraints_search.gridx = 3;
        section_search.add(l_total, constraints_search);

        constraints_search.gridy = 9;
        constraints_search.gridx = 2;
        section_search.add(btn_pay, constraints_search);

        add(section_search);
   //     add(section_products);


        pack();
        setLocationRelativeTo(null);
/*
        mi_newaddressbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addressBook = new AddressBook();
                tf_firstname.setEditable(true);
                tf_lastname.setEditable(true);
                tf_address.setEditable(true);
                tf_city.setEditable(true);
                tf_state.setEditable(true);
                tf_zip.setEditable(true);
                tf_phonenumber.setEditable(true);

                Person p1 = new Person("John", "Holcomb", "123 Lane", "Frankfurt", "Hessen", "1234AB", 12345678, firstnames.size());
                firstnames.put(p1.getPerson_id(), p1.getFirstName());

                Person p2 = new Person("Brenda", "Tyler", "456 Lane", "Eindhoven", "Noord-Brabant", "3214PA", 56985472, firstnames.size());
                firstnames.put(p2.getPerson_id(), p2.getFirstName());

                Person p3 = new Person("Michelle", "Tyler", "456 Lane", "Eindhoven", "Noord-Brabant", "3214PA", 56985472, firstnames.size());
                firstnames.put(p3.getPerson_id(), p3.getFirstName());
                //Person p4 = new Person("Peter", "Tyler", "456 Lane", "Eindhoven", "Noord-Brabant", "3214PA", 56985472, 4);
                // Person p5 = new Person("Lee", "Tyler", "456 Lane", "Eindhoven", "Noord-Brabant", "3214PA", 56985472, 5);
                // Person p6 = new Person("Lilian", "Tyler", "456 Lane", "Eindhoven", "Noord-Brabant", "3214PA", 56985472, 6);

                addressBook.addPerson(p1);
                addressBook.addPerson(p2);
                addressBook.addPerson(p3);
                //   addressBook.addPerson(p4);
///                addressBook.addPerson(p6);

                //      firstnames.put(index++, "Michelle");
                //    firstnames.put(index++, "Peter");
                //    firstnames.put(index++, "Lee");
                //    firstnames.put(index++, "Lilian");
                System.out.println(addressBook.showList().size());
            }
        });

        mi_open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //open addressbookfile
            }
        });

        mi_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //save addressbookfile
            }
        });

        mi_saveas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //save addressbookfile as
            }
        });

        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String firstName = tf_firstname.getText();
                String lastName = tf_lastname.getText();
                String address = tf_address.getText();
                String state = tf_state.getText();
                String city = tf_city.getText();
                String zip = tf_zip.getText();
                int phonenumber = Integer.parseInt(tf_phonenumber.getText());

                //add new person to list
                Person person = new Person(firstName, lastName, address, city, state, zip, phonenumber, firstnames.size());
                firstnames.put(person.getPerson_id(), person.getFirstName());

                addressBook.addPerson(person);
                addressBook.showList(); //console check


                //prompt
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), person.getFirstName() + " was successfully added to Addressbook");

                //clear textfields
                tf_firstname.setText("");
                tf_lastname.setText("");
                tf_address.setText("");
                tf_city.setText("");
                tf_state.setText("");
                tf_zip.setText("");
                tf_phonenumber.setText("");
            }
        });

        button_openlist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAddressBookList();
            }
        });
    }

    public void openAddressBookList() {
        AddressBookList list = new AddressBookList(firstnames);
        list.setVisible(true);
    }

    public void fillPersonInformation(Person person) {
        tf_firstname.setText(person.getFirstName());
        tf_lastname.setText(person.getLastName());
        tf_address.setText(person.getAddress());
        tf_city.setText(person.getCity());
        tf_state.setText(person.getState());
        tf_zip.setText(person.getZip());
        tf_phonenumber.setText(String.valueOf(person.getPhonenumber()));
    }*/

    }
}

