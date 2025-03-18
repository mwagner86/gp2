package taschenrechner;

/*
  Programmname:    GUI
  Beschreibung:    Oberflaeche und Eventbehandlung des Taschenrechners. Hier wird noch die aeltere Bibliothek AWT verwendet. AWT hat den Vorteil, dass AWT zum Standard gehoert und nichts zusaetzlich installiert werden muss. In Programmieren II werden Sie mit dem modernen JavaFX arbeiten.
  Thema:           Sequenz und Selektion (SEQ)
  Copyright:       Copyright (c) 2002 TFH Berlin. All Rights Reserved.
  Organisation:    TFH-Berlin (Projektgruppe VFH)
  @author          Nico Wybranietz
 * @version         1.0
 * @date            31.12.01
 */

import java.awt.*;
import java.awt.event.*;

public class Gui extends Frame implements ActionListener {

    // Panels fuer das Layout
    Panel pnDisplay = new Panel(new BorderLayout()); // Rechnerdisplay oben
    Panel pnTasten1 = new Panel(new GridLayout(1, 4)); // Zahlenreihe 7-9 und /
    Panel pnTasten2 = new Panel(new GridLayout(1, 4)); // Zahlenreihe 4-6 und *
    Panel pnTasten3 = new Panel(new GridLayout(1, 4)); // Zahlenreihe 1-3 und -
    Panel pnTasten4 = new Panel(new GridLayout(1, 4)); // Leer, 0, C und +
    Panel pnGleich = new Panel(new BorderLayout()); // = Taste

    // Alle Buttons des Rechners
    Button btn1 = new Button("1");
    Button btn2 = new Button("2");
    Button btn3 = new Button("3");
    Button btn4 = new Button("4");
    Button btn5 = new Button("5");
    Button btn6 = new Button("6");
    Button btn7 = new Button("7");
    Button btn8 = new Button("8");
    Button btn9 = new Button("9");
    Button btn0 = new Button("0");
    Button btnPlus = new Button("+");
    Button btnMinus = new Button("-");
    Button btnMal = new Button("*");
    Button btnDurch = new Button("/");
    Button btnGleich = new Button("=");
    Button btnLeer1 = new Button("");
    Button btnC = new Button("C");

    // Label fuer die Aenderungen im Display
    Label display = new Label();

    // Erzeugung eines RW Objektes (von den Studenten zu schreiben)
    Rechenwerk rw = new Rechenwerk();

    // zur Verarbeitung genutzte Variablen
    private int z1 = 0; // 1. eingegebene Zahl
    private int z2 = 0; // 2. eingegebene Zahl
    private char operation = ' '; // Zeichen fuer die Rechenoperation
    private boolean zFlag = false; // Flag ob 1. Zahl
    private boolean berechnet = false; // Flag ob das Ergebnis berechnet wurde
    private boolean zPressed = false; // Flag ob zuerst auf eine Zahl getippt wurde
    private String input; // fuer die Verarbeitung des Displays

    // Schrifttypen fuer den Rechner
    Font fDisplay = new Font("fDisplay", Font.BOLD, 27); // fuer das Display
    Font fBtn = new Font("fBtn", Font.BOLD, 16); // fuer die Buttons

    /**
     * Konstruktor aktiviert die Windows Events und startet die Initialisierung
     */
    public Gui() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        init();
    }

    /**
     * init Methode Erstellung der Oberflaeche mit GridLayout ein Display
     *
     */
    public void init() {

        // Einstellungen fuer das Frame
        this.setLayout(new GridLayout(6, 1));
        this.setSize(new Dimension(198, 295));
        this.setBackground(Color.lightGray);
        this.setTitle("taschenrechner");
        this.setResizable(false);

        // Anhaengen der Fonts, Farbe und der Actionlistener an die Buttons
        btn1.setFont(fBtn);
        btn1.addActionListener(this);

        btn2.setFont(fBtn);
        btn2.addActionListener(this);

        btn3.setFont(fBtn);
        btn3.addActionListener(this);

        btn4.setFont(fBtn);
        btn4.addActionListener(this);

        btn5.setFont(fBtn);
        btn5.addActionListener(this);

        btn6.setFont(fBtn);
        btn6.addActionListener(this);

        btn7.setFont(fBtn);
        btn7.addActionListener(this);

        btn8.setFont(fBtn);
        btn8.addActionListener(this);

        btn9.setFont(fBtn);
        btn9.addActionListener(this);

        btn0.setFont(fBtn);
        btn0.addActionListener(this);

        btnPlus.setFont(fBtn);
        btnPlus.addActionListener(this);
        btnPlus.setForeground(Color.blue);

        btnMinus.setFont(fBtn);
        btnMinus.addActionListener(this);
        btnMinus.setForeground(Color.blue);

        btnMal.setFont(fBtn);
        btnMal.addActionListener(this);
        btnMal.setForeground(Color.blue);

        btnDurch.setFont(fBtn);
        btnDurch.addActionListener(this);
        btnDurch.setForeground(Color.blue);

        btnGleich.setFont(fBtn);
        btnGleich.addActionListener(this);
        btnGleich.setForeground(Color.red);

        btnC.setFont(fBtn);
        btnC.addActionListener(this);
        btnC.setForeground(new Color(19, 140, 44));

        display.setAlignment(Label.RIGHT);
        display.setFont(fDisplay);
        display.setForeground(Color.green);
        display.setBackground(Color.black);

        // Hinzufuegen der einzelnen Komponenten zu den Panels
        pnDisplay.add(display);

        pnTasten1.add(btn7);
        pnTasten1.add(btn8);
        pnTasten1.add(btn9);
        pnTasten1.add(btnDurch);
        pnTasten2.add(btn4);
        pnTasten2.add(btn5);
        pnTasten2.add(btn6);
        pnTasten2.add(btnMal);
        pnTasten3.add(btn1);
        pnTasten3.add(btn2);
        pnTasten3.add(btn3);
        pnTasten3.add(btnMinus);
        pnTasten4.add(btnLeer1);
        pnTasten4.add(btn0);
        pnTasten4.add(btnC);
        pnTasten4.add(btnPlus);

        pnGleich.add(btnGleich);

        // Panels dem Frame hinzufuegen
        this.add(pnDisplay);
        this.add(pnTasten1);
        this.add(pnTasten2);
        this.add(pnTasten3);
        this.add(pnTasten4);
        this.add(pnGleich);

        display.setText("0");
        input = display.getText();

        // Frame anzeigen
        this.setVisible(true);
    }

    /**
     * actionPerformed Eventbehandlung der einzelnen Buttons es wird abgefangen das
     * nich mehr als 8 Zahlen eingegeben werden eine Operation kann nur erfolgen
     * wenn erst ein Zahl eigegeben wurde das Gleichheitszeichen funktioniert erst
     * bei korrekter Eingabe der Zahlen und des Operators nach jeder Rechnung muss
     * die C Taste gedrueckt werden
     * 
     * @param ActionEvent
     */
    public void actionPerformed(ActionEvent event) {
        int temp;
        try {
            temp = Integer.parseInt(display.getText());
        } catch (NumberFormatException nfe) {
            temp = -1;
        }

        if (!berechnet) { // wenn noch nich berechnet wurde
            if (input.length() < 8) { // wenn die Zahl im Display nicht mehr als 8 Stellen hat
                if (event.getSource() == btn0) { // Abfrage der einzelnen Buttons
                    if (temp == 0) {
                        input = "0";
                        zPressed = true;
                    } else {
                        input += "0";
                        zPressed = true;
                    }
                }

                if (event.getSource() == btn1) {
                    if (temp == 0) {
                        input = "1";
                        zPressed = true;
                    } else {
                        input += "1";
                        zPressed = true;
                    }
                }

                if (event.getSource() == btn2) {
                    if (temp == 0) {
                        input = "2";
                        zPressed = true;
                    } else {
                        input += "2";
                        zPressed = true;
                    }
                }

                if (event.getSource() == btn3) {
                    if (temp == 0) {
                        input = "3";
                        zPressed = true;
                    } else {
                        input += "3";
                        zPressed = true;
                    }
                }

                if (event.getSource() == btn4) {
                    if (temp == 0) {
                        input = "4";
                        zPressed = true;
                    } else {
                        input += "4";
                        zPressed = true;
                    }
                }

                if (event.getSource() == btn5) {
                    if (temp == 0) {
                        input = "5";
                        zPressed = true;
                    } else {
                        input += "5";
                        zPressed = true;
                    }
                }

                if (event.getSource() == btn6) {
                    if (temp == 0) {
                        input = "6";
                        zPressed = true;
                    } else {
                        input += "6";
                        zPressed = true;
                    }
                }

                if (event.getSource() == btn7) {
                    if (temp == 0) {
                        input = "7";
                        zPressed = true;
                    } else {
                        input += "7";
                        zPressed = true;
                    }
                }

                if (event.getSource() == btn8) {
                    if (temp == 0) {
                        input = "8";
                        zPressed = true;
                    } else {
                        input += "8";
                        zPressed = true;
                    }
                }

                if (event.getSource() == btn9) {
                    if (temp == 0) {
                        input = "9";
                        zPressed = true;
                    } else {
                        input += "9";
                        zPressed = true;
                    }
                }
                display.setText(input); // Text im Display anzeigen
            }

            if (!zFlag) { // wenn nur eine Zahl eingegeben wurde
                if (event.getSource() == btnPlus) {
                    operation = '+';
                    pOperation();
                }

                if (event.getSource() == btnMinus) {
                    operation = '-';
                    pOperation();
                }

                if (event.getSource() == btnMal) {
                    operation = '*';
                    pOperation();
                }

                if (event.getSource() == btnDurch) {
                    operation = '/';
                    pOperation();
                }
            } else { // wenn dann beide Zahlen eingegeben wurden
                if (event.getSource() == btnGleich) {
                    int erg = 0;
                    z2 = Integer.parseInt(display.getText());
                    display.setText("");
                    erg = rw.rechnen(z1, z2, operation);
                    input = "" + erg;
                    display.setText(input);
                    berechnet = true;
                }
            }
        }

        if (event.getSource() == btnC) { // beim druecken der C Taste reset
            input = "0";
            display.setText(input);
            operation = ' ';
            berechnet = false;
            zFlag = false;
            zPressed = false;
        }

    }

    /**
     * Operation wird ausgefuehrt wenn ein Operationsbutton gedrueckt wurde es wird
     * die erste eingegebene Zahl als int gespeichert das display wird geloescht und
     * das Flag fuer die erste Zahl wird gesetzt
     */
    protected void pOperation() {
        if (zPressed) {
            z1 = Integer.parseInt(display.getText());
            input = "";
            display.setText(input);
            zFlag = true;
        }
    }

    /**
     * processWindowEvent fuer die Windowsnachrichten zum Schliessen des Programmes
     * ueber den X Button
     * 
     * @param WindowEvent
     */
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }
}