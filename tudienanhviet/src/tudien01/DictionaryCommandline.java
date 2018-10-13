package tudien01;

import java.util.Scanner;

public class DictionaryCommandline extends DictionaryManagement{
    public void showAllWords()//in ra toàn bộ từ điển
    {
        int i=1;
        System.out.printf("%-5s| %-20s | Vietnamese\n", "No", "English");
        while(i<=this.container.size()) {
            int j = i-1;
            System.out.printf("%-5s| %-20s | %s\n", i, this.container.get(j).getWordTarget(),this.container.get(j).getWordExplain());
            i++;
        }


    }

    public void dictionaryBasic(){
        insertFromFile();
        showAllWords();
    }

    public void dictionaryAdd() //thêm từ mới
    {

        insertFromFile();
        insertFromCommandline();
        dictionaryExportToFile();
    }

    public void dictionarySearcher() {// tìm kiếm
        insertFromFile();
        dictionaryLookup();
    }

    public void dictionaryDelete(){//xóa từ
        insertFromFile();
        delete();
        dictionaryExportToFile();
    }

    public void dictionaryReplace(){//sửa từ
        insertFromFile();
        replaceExplain();
        dictionaryExportToFile();
    }


    public static void main(String[] args) {
        boolean check = true;
        while (check == true){
            Scanner sc = new Scanner(System.in);
            DictionaryCommandline a = new DictionaryCommandline();
            System.out.println("XIN CHÀO CÁC BẠN ĐẾN VỚI PHIÊN BẢN COMMANDLINE TỪ ĐIỂN");
            System.out.println("Chọn thao tác: ");
            System.out.println("Nhập 1 để xem dữ liệu từ điển.");
            System.out.println("Nhập 2 để tìm kiếm từ.");
            System.out.println("Nhập 3 để thêm từ mới.");
            System.out.println("Nhập 4 để xóa từ.");
            System.out.println("Nhập 5 để thay thế định nghĩa của từ.");

            int chosen = sc.nextInt();

            switch (chosen){
                case 1:{
                    a.dictionaryBasic();
                    break;
                }

                case 2:{
                    a.dictionarySearcher();
                    break;
                }

                case 3:{
                    a.dictionaryAdd();
                    break;
                }

                case 4:{
                    a.dictionaryDelete();
                    break;
                }

                case 5:{
                    a.dictionaryReplace();
                    break;
                }

                default:{
                    break;
                }
            }
        }
    }
}

