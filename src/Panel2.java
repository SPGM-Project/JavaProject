import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Panel2 extends JPanel {
    int cnt = 0;
    JPanel upperPanel = new JPanel();
    JPanel lowerPanel = new JPanel();
    JPanel middlePanel = new JPanel();
    Panel2() {
        setLayout(new BorderLayout());

        // LinkedList linkedList = new LinkedList();


        JTextField jf = new JTextField(10);
        upperPanel.add(new JLabel("LinkedList"));
        upperPanel.add(jf);
        upperPanel.add(new JLabel("<-정수값 입력"));
        JButton formBTN = new JButton("추가");
        upperPanel.add(formBTN);
        JButton delBTN = new JButton("삭제");
        upperPanel.add(delBTN);
        JTextField jfU = new JTextField(10);
        upperPanel.add(jfU);
        upperPanel.add(new JLabel("<-update"));
        JButton updateBTN = new JButton("Node Update");
        upperPanel.add(updateBTN);
        JLabel alert = new JLabel("알림");
        lowerPanel.add(alert);
        JButton initBTN = new JButton("초기화");
        lowerPanel.add(initBTN);
        
        add(upperPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(lowerPanel, BorderLayout.SOUTH);
        setVisible(false);
        ActionListener listener = new ActionListener() {
        
        ArrayList<JButton> jbtns = new ArrayList<JButton>();
        ArrayList<JLabel> jlbs = new ArrayList<JLabel>();

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(e.getSource() == formBTN){
                    try {
                        String jft = jf.getText();
                        int intj = Integer.valueOf(jft);

                        // linkedList.insert(intj);

                        jbtns.add(new JButton(jft));
                        middlePanel.add(jbtns.get(cnt));
                        jlbs.add(new JLabel("=>"));
                        middlePanel.add(jlbs.get(cnt++));
                        alert.setText(String.valueOf(cnt));
                    } catch (Exception events) {
                        // TODO: handle exception
                        alert.setText("넣을 값이 없음");
                        return;
                    }
                } else if(e.getSource() == updateBTN){
                    try {
                        String jft = jf.getText();
                        int intj = Integer.valueOf(jft);
                        String jfUt = jfU.getText();
                        int jfutj = Integer.valueOf(jfUt);
                        for(int i = 0; i < jbtns.size(); i++){
                            String bjft = jbtns.get(i).getText();
                            if(bjft.equals(jft)){
                                jbtns.get(i).setText(jfUt);
                            }
                        }
                        // // linkedList.update(intj, jfutj);
                    } catch (Exception event){
                        alert.setText("업데이트 값이 없음");
                        return;
                    }                    
                } else if(e.getSource() == delBTN){
                    try {
                        String jft = jf.getText();
                        int intj = Integer.valueOf(jft);
                        for(int i = 0; i < jbtns.size(); i++){
                            String bjft = jbtns.get(i).getText();
                            if(bjft.equals(jft)){
                                remove(middlePanel);
                                jbtns.remove(i);
                                jlbs.remove(i);
                                middlePanel = new JPanel();
                                add(middlePanel, BorderLayout.CENTER);
                                for(int j = 0; j < jbtns.size(); j++){
                                    middlePanel.add(jbtns.get(j));
                                    middlePanel.add(jlbs.get(j));
                                }
                                cnt--;
                                i--;
                            }
                        }
                        // linkedList.delete(intj);
                        alert.setText(String.valueOf(cnt));
                    } catch (Exception events) {
                        alert.setText("지울 값이 없음");
                        return;
                    }
                } else if(e.getSource() == initBTN){
                    for(int j = 0; j<3; j++){
                        remove(middlePanel);
                        for(int i = 0; i < jbtns.size(); i++){
                            jbtns.remove(i);
                            jlbs.remove(i);
                        }
                        middlePanel = new JPanel();
                        add(middlePanel, BorderLayout.CENTER);
                        cnt = 0;
                    }
                    alert.setText("비어있음");
                }
            }
        };
        formBTN.addActionListener(listener);
        delBTN.addActionListener(listener);
        updateBTN.addActionListener(listener);
        initBTN.addActionListener(listener);
    }

}