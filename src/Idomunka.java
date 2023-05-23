import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Idomunka extends JFrame {
    InputPanel Megmunkalthossz;
    InputPanel Fordulatkenti;
    InputPanel Foorso;
    InputPanel Megmunkalasi;
    JPanel buttonPanel;
    JButton calcButton;
    
    public Idomunka() {
        this.initComponent();
        this.addComponent();
        this.handleEvent();
        this.setFrame();
    }
    private void initComponent() {
        this.Megmunkalthossz = new InputPanel("hossz (mm)");
        this.Fordulatkenti  = new InputPanel("elotőlas (mm)");
        this.Foorso = new InputPanel("fordulatszám (n)");
        this.buttonPanel = new JPanel();
        this.Megmunkalasi = new InputPanel("perc");
        this.calcButton = new JButton("Számít");
    }
    private void addComponent() {
        this.add(this.Megmunkalthossz);
        this.add(this.Fordulatkenti);
        this.add(this.buttonPanel);
        this.add(this.Megmunkalasi);
        this.buttonPanel.add(this.calcButton);
    }
    private void handleEvent() {
        this.calcButton.addActionListener( e -> {
            startCalc();
        });
    }
    private void startCalc() {
        String megmunkalthosszStr = this.megmunkalthosszPanel.getValue();
        if(!this.checkInput(megmunkalthosszStr)) {
            JOptionPane.showMessageDialog(this, "Csak számjegy");
            return;
        }
        double megmunkalthossz = Double.parseDouble(megmunkalthosszStr);
        String fordulatonkentiStr = this.fordulatonkentiPanel.getValue();
        if(!this.checkInput(fordulatonkentiStr)) {
            JOptionPane.showMessageDialog(this, "Csak számjegy");
            return;
        }        
        double fordulatonkenti  = Double.parseDouble(fordulatonkentiStr);
        Double megmunkalasiIndex = this.calcBodyIndex(hossz, elotolas, fordulatszam,perc);
        this.indexPanel.setValue(megmunkalasiIndex.toString());
    }

    public double calcBodyIndex(double weight, double height) {
        return weight / Math.pow(height, 2);
    }

    public boolean checkInput(String input) {
        boolean ok = false;
        if(input.matches("[0-9.]+")) {
            ok = true;
        }
        return ok;
    }

    private void setFrame() {
        this.setLayout(new BoxLayout(
            this.getContentPane(), BoxLayout.PAGE_AXIS)
        );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setSize(300, 200);
        this.pack();
        this.setVisible(true);
    }
    
}
