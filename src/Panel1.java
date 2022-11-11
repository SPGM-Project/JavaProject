import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel1 extends JPanel {
    Panel1() {
        add(new JButton("버튼1"));
        add(new JButton("버튼2"));
        add(new JButton("버튼3"));
        
        setVisible(false);
    }
}