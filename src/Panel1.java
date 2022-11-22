import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel1 extends JPanel implements ActionListener{
    JButton enterBtn = new JButton("등록");
    JButton listInitBtn = new JButton("배열 초기화");

    String[] feature = {"Insert", "Search", "Update", "Delete"};
    JComboBox dropdownBox = new JComboBox<>(feature);

    JTextField textField = new JTextField(10);
    JTextField updateTextField = new JTextField(10);

    JPanel upperPanel = new JPanel();
    JPanel middlePanel = new JPanel();
    JPanel lowerPanel = new JPanel();

    JLabel updateLabel = new JLabel("<- TargetData / UpdateData ->");
    JLabel arrayLabel = new JLabel();
    JLabel explainLabel = new JLabel();

    JOptionPane aa = new JOptionPane();
	String number = aa.showInputDialog("ArrayList의 Size 입력");
    int num = Integer.valueOf(number);
    ArrayList arrayList = new ArrayList(num);

    Panel1() {
        setLayout(new BorderLayout());

        upperPanel.add(new JLabel("ArrayList"));
        upperPanel.add(dropdownBox);
        upperPanel.add(textField);
        upperPanel.add(updateLabel);
        upperPanel.add(updateTextField);
        upperPanel.add(new JLabel("정수값 입력"));
        upperPanel.add(enterBtn);
        upperPanel.add(listInitBtn);
        add(upperPanel, BorderLayout.NORTH);

        updateLabel.setVisible(false);
        updateTextField.setVisible(false);
        setVisible(false);
        
        middlePanel.add(arrayLabel);
        add(middlePanel, BorderLayout.CENTER);

        lowerPanel.add(explainLabel);
        add(lowerPanel, BorderLayout.SOUTH);

        enterBtn.addActionListener(this);
        listInitBtn.addActionListener(this);
        dropdownBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String dropdownFeature = dropdownBox.getSelectedItem().toString();

        if (e.getSource() == enterBtn) {
            switch (dropdownBox.getSelectedIndex()) {
                case 0:
                if (arrayList.numOfDatas == arrayList.List_Size) {
                    explainLabel.setText("배열이 꽉 참.");
                    return;
                }
                arrayList.insert(Integer.parseInt(textField.getText()));
                int nod = arrayList.numOfDatas - 1;
                String str = Integer.toString(nod);
                printAll();
                explainLabel.setText(String.valueOf(str) + "번째 인덱스에 데이터 " + String.valueOf(arrayList.List[nod]) + " 값을 삽입함.");
                break;

                case 1:
                if (arrayList.search(Integer.parseInt(textField.getText())) != -1) {
                    explainLabel.setText("찾으려는 데이터가 " + arrayList.search(Integer.parseInt(textField.getText())) + "번째 " + "인덱스에 있음.");
                }
                else {
                    explainLabel.setText("찾으려는 데이터가 배열에 존재하지 않음.");
                }
                break;

                case 2:
                arrayList.update(Integer.parseInt(textField.getText()), Integer.parseInt(updateTextField.getText()));
                printAll();
                break;

                case 3:
                arrayList.delete(Integer.parseInt(textField.getText()));
                printAll();
                break;
            }
        }
        else if (e.getSource() == listInitBtn) {
            arrayList.init();
            printAll();
        }

        if (dropdownFeature.equals("Update")) {
            updateLabel.setVisible(true);
            updateTextField.setVisible(true);
        }
        else {
            updateLabel.setVisible(false);
        updateTextField.setVisible(false);
        }
    }

    void printAll() {
        arrayLabel.setText("");
        if (arrayList.numOfDatas == 0) {
            explainLabel.setText("배열에 데이터가 존재하지 않음");
        }
        else {
            for (int i =0;i<arrayList.numOfDatas;i++) {
                arrayLabel.setText(arrayLabel.getText() + " [" +arrayList.List[i] + "] ");
            }
        }
    }
}