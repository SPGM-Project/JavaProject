public class ArrayList{
    int[] List;
    int numOfDatas;
    int List_Size;

    int rdSize = 0;

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

    int[] search(int searchData[]){
        int returnData[] = new int[List_Size];
        rdSize = 0;
        for (int i = 0; i < List_Size; i++){
            if(List[i] == searchData[0]) {
                returnData[rdSize++] = i;
            }
        }
        return returnData;
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
            }
    }
}