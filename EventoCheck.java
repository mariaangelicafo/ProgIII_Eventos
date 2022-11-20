import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class EventoCheck extends JFrame implements ItemListener {
      // frame
    static JFrame f;
      // label
    static JLabel l, l1;
      // checkbox
    static JCheckBox c1, c2;
     
    public static void main(String[] args)
    {   // create a new frame
        f = new JFrame("frame");
        // create checkbox
        c1 = new JCheckBox("Opção 1", false);
        c2 = new JCheckBox("Opção 2", false);
         // create labels
        l = new JLabel("Opção 1");
        l1 = new JLabel("Opção 2");
        // definindo color of text
        l.setForeground(Color.red);
        l1.setForeground(Color.blue);
        // criando new panel
        JPanel p = new JPanel();
        // add checkbox ao panel
        p.add(c1);
        p.add(c2);
        p.add(l);
        p.add(l1);
        // add panel no frame
        f.add(p);
        // set o tamanho do frame
        f.setSize(600, 300);
        f.setVisible(true);
        // add ItemListener
        EventoCheck s= new EventoCheck();
        c1.addItemListener(s);
        c2.addItemListener(s);
  
    }
    public void itemStateChanged(ItemEvent e)
    {
        // se o estado do checkbox é mudado
        if (e.getSource() == c1) {
            if (e.getStateChange() == 1)
                l.setText("Opção 1  selected");
            else
                l.setText("");
        }
          // se o estado do checkbox é mudado
        else {
            if (e.getStateChange() == 1)
                l1.setText("Opção 2  selected");
            else
                l1.setText("");
        }
    }
}