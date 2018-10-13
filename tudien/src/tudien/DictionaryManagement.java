package tudien;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DictionaryManagement extends Dictionary
{
    //Ham doc du lieu nhap vao
    public void insertFromCommandline() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập từ muốn thêm: ");
        int n =input.nextInt();
        input.nextLine();
        for(int i=0; i<n; i++) {
            Word newWord = new Word(null,null);
            System.out.println("Nhập từ: ");
            newWord.setWordTarget(input.nextLine());
            System.out.println("Nhập nghĩa của từ: ");
            newWord.setWordExplain(input.nextLine());
            this.container.add(newWord);
        }
    }

    //Ham doc du lieu tu file
    public void insertFromFile() {
        try{
            File apath = new File("C:\\Users\\Administrator\\IdeaProjects\\tudien\\src\\tudien\\wordsData.txt");
            try (Scanner sc = new Scanner(apath)) {
                String content ;
                while(sc.hasNextLine()) {
                    content = sc.nextLine();
                    String[] contentsplit=content.split("\\t");
                    Word newWord = new Word(null,null);
                    newWord.setWordTarget(contentsplit[0]);
                    newWord.setWordExplain(contentsplit[1]);
                    this.container.add(newWord);
                }   }
        }
        catch(FileNotFoundException e) {
            System.out.println("Lỗi!");
        }
    }

    //Ham tra cuu tu
    public void dictionaryLookup(){
        Scanner input = new Scanner(System.in);
        String lookup;
        boolean check = false;
        System.out.println("Nhập từ muốn tìm: ");
        lookup=input.nextLine();
        for(int i=0; i<this.container.size(); i++) {
            if(this.container.get(i).getWordTarget().equals(lookup)) {
                check = true;
                System.out.printf("%-5s| %-20s | %s\n", i+1, this.container.get(i).getWordTarget(),this.container.get(i).getWordExplain());
            }
        }
        if (check == false){
            System.out.println("Không tìm thấy từ!");
            System.out.println("Bạn có muốn thêm từ này vào từ điển không?! Nhập y nếu có, n nếu không");
            String guess = input.next();
            if (guess.equals("y")){
                Word newWord = new Word(null,null);
                newWord.setWordTarget(lookup);
                System.out.println("Nhập nghĩa của từ: ");
                newWord.setWordExplain(input.next());
                this.container.add(newWord);
                dictionaryExportToFile();
                System.out.println("Thêm từ thành công");
            }

        }
    }

    //Ham xoa du lieu tu dien
    public void delete() {
        Scanner input = new Scanner(System.in);
        String del;
        System.out.println("Nhập từ muốn xóa: ");
        del=input.nextLine();
        boolean check = false;
        for(int i=0; i<this.container.size(); i++) {
            if(this.container.get(i).getWordTarget().equals(del)) {
                check = true;
                this.container.remove(i);
            }
        }
        if (check == true) System.out.println("Xóa thành công!");
        else System.out.println("Thất bại!");
    }

    //Ham thay the  tu
    public void replaceExplain() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập từ muốn thay thế: ");
        String replacedWord = input.nextLine();
        boolean check = false;
        for(int i=0; i<this.container.size(); i++) {
            if(this.container.get(i).getWordTarget().equals(replacedWord)) {
                String explain;
                System.out.println("Nhập nghĩa mới của từ: ");
                explain=input.nextLine();
                this.container.get(i).setWordExplain(explain);
                check = true;
            }
        }
        if(!check) System.out.println("Không tìm thấy từ!");
        else System.out.println("Thay thế thành công!");
    }

    //Ham xuat tu dien hien tai ra File
    public void dictionaryExportToFile() {
        try {
            try (Formatter f = new Formatter("C:\\Users\\Administrator\\IdeaProjects\\tudien\\src\\tudien\\wordsData.txt")) {
                for(int i=0; i<this.container.size(); i++) {
                    {
                        f.format(this.container.get(i).getWordTarget());
                        f.format("\t");
                        f.format(this.container.get(i).getWordExplain());
                        f.format("%n");
                    }
                }   }

        } catch (FileNotFoundException e) {
            System.out.println("Lỗi");
        }

    }
}

