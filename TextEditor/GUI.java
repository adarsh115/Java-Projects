import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.*; //ActionListener library

import java.awt.Color;

 


public class GUI implements ActionListener{

    // we are importing fucntion here, and using 'this' to send GUI across
    FunctionFile file = new FunctionFile(this);
    FunctionFormat format = new FunctionFormat(this);
    
    /*Jframe: It works like main window where components
    like labels, buttons, texfield are added to a GUI */ 
    JFrame window;
    
    /*A JTextArea is a multi-line area that displays plain text.
     It will alow user to type text. In given 800 X 600 window */
    JTextArea textArea;
    boolean wordWrapOn = false;
    /*This will add scroll bar to the textarea. So when user can scroll
    up or down when text goes out of window */
    JScrollPane scrollPane;

    /*Menu bar: It will inculde various menu like file, edit etc */
    JMenuBar menuBar;

    /*Menu */
    JMenu menuFile, menuEdit, menuFormat, menuColor;

    /*File menue items */
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

    /*Format Menu */
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    JMenu menuFont, menuFontSize;









    

    public void createWindow(){
        window = new JFrame("Quick Pad"); //Display name on top of window
        window.getContentPane().setBackground(new Color(70,80,70));
        window.setSize(800, 600); //size of lauch window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close windwo properly


    }

    public void createTextArea(){
        textArea = new JTextArea();


        // textArea.setForeground(Color.BLUE);
        JTextField myText = new JTextField();


        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        
        window.add(myText);
        window.add(scrollPane);
        // window.add(textArea);
    }
    //Menu bar function
    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);
        // menuEdit = new JMenu("Edit");
        // menuBar.add(menuEdit);
        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

    }
    // File menu function
    public void createFileMenu(){
        
        
        
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);
        
        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);
        
        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");
        menuFile.add(iSaveAs);
        
        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    //Format font

    public void CreatFormatMenu(){
        iWrap = new JMenuItem("Word Wrap: OFF");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);


        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Verdana");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Verdana");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);



        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);


 
        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("12");
        menuFontSize.add(iFontSize12);
 
        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("16");
        menuFontSize.add(iFontSize16);
 
        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("20");
        menuFontSize.add(iFontSize20);
 
        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("24");
        menuFontSize.add(iFontSize24);
       
        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("28");
        menuFontSize.add(iFontSize28);
 
        
    }
    //





    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();

        switch(command){
            case "New": {
                System.out.print("New");
                file.newFile(); }
            break;

            case "Open":
                System.out.print("Open");
                file.open();
            break;

            case "Save":
                System.out.print("Save");
                file.save();
            break;

            case "SaveAs":
                System.out.print("SaveAs");
                file.saveAs();
            break;
            case "Exit":
                System.out.print("Exit");
                file.exit();
            break;
            case "Word Wrap":
                System.out.print("Word Wrap");
                format.wordWrap();
            break;

            case "Arial":
                System.out.print("Arial");
                format.setFont("Arial");
            break;
            case "Verdana":
                System.out.print("Verdana");
                format.setFont("Verdana");
            break;
            case "Times New Roman":
                System.out.print("Times New Roman");
                format.setFont("Times New Roman");
            break;


            case "16":
                System.out.print("16");
                format.createFront(16);
            break;
            case "12":
                System.out.print("12");
                format.createFront(12);
            break;
            case "20":
                System.out.print("20");
                format.createFront(20);
            break;
            case "24":
                System.out.print("24");
                format.createFront(24);
            break;
            case "28":
                System.out.print("28");
                format.createFront(28);
            break;


        }
    }

    // constructor
    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        CreatFormatMenu();

        // Deafut Font Properties
        format.selectedFont = "Verdana";
        format.createFront(20);
        format.wordWrap();

        window.setVisible(true);
    }




    
    public static void main(String[] args) {

        new GUI();

    }
}
