# JavaProject

-   ### 자바로 자료구조에서 배운 구조들을 구현해보고 사용자가 사용할 수 있는 인터페이스를 만들어 자료구조를 테스트해 볼 수 있는 프로젝트입니다

*   ## 주요 기능

    -   ArrayList

        -   ```java
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String dropdownFeature = dropdownBox.getSelectedItem().toString(); // JComboBox의 선택된 기능

                if (e.getSource() == enterBtn) { // 데이터를 입력했을 때
                    switch (dropdownBox.getSelectedIndex()) { // JComboBox의 선택된 기능 인덱스 확인
                        case 0: // 0번 인덱스 : Insert
                        if (arrayList.numOfDatas == arrayList.List_Size) { // ArrayList의 배열이 꽉 찼을 때 메세지 출력
                            explainLabel.setText("배열이 꽉 참.");
                            return;
                        }
                        arrayList.insert(Integer.parseInt(textField.getText())); // textField에 적힌 값을 ArrayList에 Insert
                        String str = Integer.toString(arrayList.numOfDatas - 1); // 몇 번째 인덱스에 데이터가 Insert 되었는지 JLabel에 출력하기 위해 String으로 선언
                        printAll(); // 배열 출력
                        explainLabel.setText(String.valueOf(str) + "번째 인덱스에 데이터 " + String.valueOf(arrayList.List[nod]) + " 값을 삽입함."); // JLabel에 출력
                        break;

                        // Search 기능을 사용했을 때 중복되는 데이터가 있을 시 여러 값을 받아야 하기에 메소드, 매개변수, return값을 int형 배열로 선언
                        case 1: // 1번 인덱스 : Search
                        int searchData[] = {Integer.parseInt(textField.getText())}; // Search 메소드의 매개변수로 들어갈 int형 배열 선언
                        int findData[] = new int[arrayList.List_Size]; // Search 메소드의 return 값을 받을 int형 배열 선언
                        StringBuffer dataStr = new StringBuffer(); // 검색한 데이터가 중복됬을 경우 여러 인덱스 번호를 문자열로 이어서 저장해야 하기 때문에 StringBuffer형 변수로 선언
                        findData = arrayList.search(searchData); // Search 메소드의 return 값을 findData에 저장
                        for (int i = 0; i < arrayList.rdSize; i++) { // 검색한 데이터 수 만큼 .append를 사용해 여러 인덱스 번호를 문자열로 이어서 저장
                            if (i + 1 == arrayList.rdSize) {
                                dataStr.append(findData[i]);
                            }
                            else {
                                dataStr.append(findData[i] + ", ");
                            }
                        }
                        if (arrayList.rdSize != 0) { // 검색한 데이터가 0 이 아닐 경우 인덱스 번호 출력 0 일 경우 데이터가 존재하지 않는다는 메세지 출력
                            explainLabel.setText("찾으려는 데이터가 " + dataStr + "번째 " + "인덱스에 있음.");
                        }
                        else {
                            explainLabel.setText("찾으려는 데이터가 배열에 존재하지 않음.");
                        }
                        break;

                        case 2: // 2번 인덱스 : Update
                        arrayList.update(Integer.parseInt(textField.getText()), Integer.parseInt(updateTextField.getText())); // 기본 TextField의 값은 Target 데이터로, Update 기능 선택 시 추가되는 UpdateTextField의 값은 Update 데이터로 매개변수 설정후 메소드 실행
                        printAll();
                        break;

                        case 3: // 3번 인덱스 : Delete
                        arrayList.delete(Integer.parseInt(textField.getText())); // 기본 TextField의 값을 매개변수로 Delete 메소드 실행
                        printAll();
                        break;
                    }
                }
            }
            ```

            -   ArrayList의 기능들을 JComboBox로 선언해 드롭다운 형식으로 관리했다.  
                JComboBox에 선택되어 있는 기능에 따라 데이터를 입력했을 때 기능이 다르게  
                작동하고, 기능을 사용할 때마다 배열이 JLabel을 통해 출력되도록 하였다.

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
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (e.getSource() == enQueueBtn) { // EnQueue 버튼을 눌렀을 시
                    if ((queue.rear + 1) % queue.Queue_Size == queue.front) { // 만약 Queue가 꽉 찾다면 메세지 출력후 return
                        explainLabel.setText("큐가 꽉 참.");
                        return;
                    }
                    queue.enQueue(Integer.parseInt(textField.getText()));
                    printAll();
                } else if (e.getSource() == deQueueBtn) { // DeQueue 버튼을 눌렀을 시
                    queue.deQueue(); // DeQueue 메소드 실행
                    if (queue.front == queue.rear) { // DeQueue 메소드 실행 후 큐를 확인해 큐가 비었다면 메세지 출력후 return
                        queueLabel.setText("큐가 비어있음.");
                        return;
                    }
                    printAll();
                } else if (e.getSource() == queueInitBtn) { // Init 버튼을 눌렀을 시 Init 메소드 실행후 큐가 비어있다는 메세지 출력
                    queue.init();
                    queueLabel.setText("큐가 비어있음.");
                }
            }
            ```
            -   Queue는 기능이 3개 뿐이라 모두 버튼으로 만들었다. Queue의 경우도 기능을 사용할 때 마다 데이터가 JLabel을 통해 출력되도록 하였다.

-   ## 느낀점
    -   ### 이기환
        -   ArrayList에서 JComboBox의 기능에 따라 버튼의 글씨가 "삽입", "검색", "갱신" 등 으로 바뀌게 하거나, Queue에서 데이터를 출력할 때 좀더 이해하기 쉽게 출력하는 것 등 부족하거나 개선할 부분이 많았지만 시간이 부족했던 것이 아쉬웠다.
    -   ### 이승제
        -   자료구조를 java gui로 구현하는 활동을 하면서 자료구조와 gui에 대한 이해도가 높아졌다.  
            자료구조들을 처음 만든 사람은 고생좀 했겠다는 생각이 들었다.
