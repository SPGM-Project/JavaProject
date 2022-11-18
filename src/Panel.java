import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/* 메뉴를 구성하는 일반적인 순서
 * 1. '메뉴바' (JMenuBar) 객체를 만듬
 * 2. '메뉴' (JMenu) 객체를 만듬 => '메뉴'를 '메뉴바'에 add
 * 3. '메뉴'에 포함될 '목록' (JMenuItem) 객체를 만듬 => '목록'을 '메뉴'에 add
 * 4. '메뉴바'를 에 add
 */
class Panel extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu menu1,menu2;
    JMenuItem item1, item2, item3, item4;

    JPanel mainPanel = new JPanel();
    Panel1 panel1 = new Panel1();
    Panel2 panel2 = new Panel2();
    Panel3 panel3 = new Panel3();
    Panel4 panel4 = new Panel4();

    Panel(){
        menuBar = new JMenuBar();
        menu1 = new JMenu("자료구조");
        menu2 = new JMenu("");

        menuBar.add(menu1);
        menuBar.add(menu2);

        item1 = new JMenuItem("ArrayList");
        item2 = new JMenuItem("LinkedList");
        item3 = new JMenuItem("Stack");
        item4 = new JMenuItem("Queue");

        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);
        menu1.add(item4);

        setJMenuBar(menuBar);

        add(mainPanel);
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(panel4);

        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        
        
        setSize(800,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Panel frame = new Panel();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == item1) {
            if(panel1.isVisible() == false)
                togle(0);
		} else if(e.getSource() == item2) {
                togle(1);
		} else if(e.getSource() == item3){
            togle(2);
        } else if(e.getSource() == item4){
            togle(3);
        }
	}

    void togle(int selected){
        JPanel[] ary = {panel1, panel2, panel3, panel4};
        for(int i = 0;i<ary.length; i++){
            ary[i].setVisible(false);
            if(i == selected) ary[i].setVisible(true);
        }
    }
}