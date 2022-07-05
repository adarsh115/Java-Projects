
import java.awt.Font;

 

public class FunctionFormat {
    GUI gui;
    Font arial;
    Font verdana;
    Font timesNewRoman;
    String selectedFont;

    FunctionFormat(GUI gui){
        this.gui = gui;
    }

    public void wordWrap(){
        if(gui.wordWrapOn == false){
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap: On");
        }
        else if(gui.wordWrapOn == true){
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap: Off");
        }
    }

    public void createFront(int fontSize){

        arial = new Font("Arial", Font.PLAIN, fontSize);
        verdana = new Font("Verdana", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
 

        setFont(selectedFont);
    }

    public void setFont(String font){
        selectedFont = font;

        switch(selectedFont){
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "Verdana":
                gui.textArea.setFont(verdana);
                break;
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
                break;
        }
    }
}
