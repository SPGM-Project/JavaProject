# JavaProject

-   ### 자바로 자료구조에서 배운 구조들을 구현해보고 사용자가 사용할 수 있는 인터페이스를 만들어 자료구조를 테스트해 볼 수 있는 프로젝트입니다

*   ## 주요 기능

    -   ArrayList

        -   ```java
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
                int searchData[] = {Integer.parseInt(textField.getText())};
                int findData[] = new int[arrayList.List_Size];
                StringBuffer dataStr = new StringBuffer();
                findData = arrayList.search(searchData);
                for (int i = 0; i < arrayList.rdSize; i++) {
                    if (i + 1 == arrayList.rdSize) {
                        dataStr.append(findData[i]);
                    }
                    else {
                        dataStr.append(findData[i] + ", ");
                    }
                }
                if (arrayList.rdSize != 0) {
                    explainLabel.setText("찾으려는 데이터가 " + dataStr + "번째 " + "인덱스에 있음.");
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
            ```

    -   LinkedList
        -   ```java
            else if(e.getSource() == delBTN){ // LinkedList 삭제 기능 구현
                    try {
                        String jft = jf.getText(); // 텍스트 필드에서 값을 가져온다
                        int intj = Integer.valueOf(jft); // 정수형으로 바꿔준다
                        for(int i = 0; i < jbtns.size(); i++){ // 버튼 배열의 크기만큼 돌린다
                            String bjft = jbtns.get(i).getText(); // 버튼의 텍스트를 가져온다
                            if(bjft.equals(jft)){ //버튼의 텍스트가 지울 텍스트와 같은지 확인한다
                                remove(middlePanel); // 중간 펜넬을 지운다
                                jbtns.remove(i); // 버튼의 배열과 라벨의 배열에서 해당 값을 지운다
                                jlbs.remove(i);
                                middlePanel = new JPanel(); // 새롭게 펜넬을 만든다
                                add(middlePanel, BorderLayout.CENTER);
                                for(int j = 0; j < jbtns.size(); j++){ // 버튼의 배열에서 버튼들을 가져와 추가한다
                                    middlePanel.add(jbtns.get(j));
                                    middlePanel.add(jlbs.get(j));
                                }
                                cnt--;
                                i--;
                            }
                        }
                        // linkedList.delete(intj);
                        alert.setText(String.valueOf(cnt));
                    } catch (Exception events) { // 사용자가 잘못 입력하거나 입력하지 않아서 오류가 났을시
                        alert.setText("지울 값이 없음");
                        return;
                    }
                }
            ```
            -   ArrayList<>를 사용해서 버튼들의 배열을 만들어 관리했다  
                react의 useState와 같은 자동 렌더링 기술이 없어서 모두 지우고 다시 삽입하는 방법을 택하였다
    -   Stack
        -   ```java
            if(e.getSource() == formBTN){ // stack 삽입 기능 구현
                    try {
                        String jft = jf.getText(); // 텍스트필드에서 텍스트를 가져온다
                        int intj = Integer.valueOf(jft); // 정수형으로 바꿔준다
                        if(cnt==0){ // 스택이 꽉찼으면 알려줌
                            alert.setText("스택이 꽉찼음");
                            return;
                        }
                        alert.setText("");
                        if(cnt<num)
                            btns[cnt].setText(""); // 이전 스택 가리기(스택은 맨 위에만 볼 수 있음)
                        btns[--cnt].setText(jft); // stack의 텍스트 설정
                        stack.push(intj); // 자료구조 삽입
                        System.out.println(intj); // 테스트 코드
                        stack.peek(); // 삽입 확인
                    } catch (Exception events) { // 사용자가 잘못 입력하거나 입력하지 않아서 오류가 났을시
                        // TODO: handle exception
                        if(cnt == num-1){
                            return;
                        }
                        alert.setText("넣을 값이 없음");
                        return;
                    }
                }
            ```
    -   Queue

        -   ```java

            ```

-   ## 느낀점
    -   ### 이기환
        -
    -   ### 이승제
        -   자료구조를 java gui로 구현하는 활동을 하면서 자료구조와 gui에 대한 이해도가 높아졌다.  
            자료구조들을 처음 만든 사람은 고생좀 했겠다는 생각이 들었다.
