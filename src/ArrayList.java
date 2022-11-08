public class ArrayList{
    int[] List;
    int numOfDatas;
    int List_Size;

    ArrayList(int List_Size){
        this.List_Size = List_Size;
        this.List = new int[List_Size];
        this.numOfDatas = 0;
    }

    void init(){
        numOfDatas = 0;
    }

    void insert(int insertData){
        if (numOfDatas < List_Size) {
            List[numOfDatas++] = insertData;
        }
        else {
            System.out.println("꽉찼습니다!");
        }
    }

    void printAll() {
        for(int i=0;i<numOfDatas; i++){
            System.out.print("[" + List[i] + "]");
        }
        System.out.println();
    }

    int search(int searchData){
        for (int i : List){
            if(List[i] == searchData)
                return i;
        }
        return -1;
    }

    void delete(int deleteData){
        if (numOfDatas == 0) {
            System.out.println("데이터 없음");
            return;
        }
        for (int i =0;i<numOfDatas;i++)
            if (List[i] == deleteData) {
                for (int j = i+1; j < numOfDatas; j++) { 
                    List[j-1] = List[j];
                }
                numOfDatas -= 1;
                i -=1;	
            }
    }

    void update(int targetData, int updateData){
        if (numOfDatas == 0) {
            System.out.println("데이터 없음");
            return;
        }
        for (int i : List)
            if (List[i] == targetData) {
                List[i] = updateData;
                return;
            }
    }
}