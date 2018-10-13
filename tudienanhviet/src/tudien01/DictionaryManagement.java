package tudien01;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
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
        System.out.println("Nhập số từ muốn thêm: ");
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
    public void addword() {
        Scanner input = new Scanner(System.in);
            boolean check = true;
            Word newWord = new Word(null,null);
            System.out.println("Nhập từ: ");
            newWord.setWordTarget(input.nextLine());
            for(int i=0; i<this.container.size();i++) {
                if(newWord.getWordTarget().toLowerCase().equals(this.container.get(i).getWordTarget())) {
                    System.out.println("Từ đã tồn tại");
                    check = false;
                    break;
                }
            }
            if(check){
            System.out.println("Nhập nghĩa của từ: ");
            newWord.setWordExplain(input.nextLine());
            this.container.add(newWord);
            System.out.println("Thêm từ thành công");}

    }
    //Ham doc du lieu tu file
    public void insertFromFile() {
        try {

            Scanner sc = new Scanner(new FileInputStream("dictionaries.txt"), "UTF-8");
            String content;
            while (sc.hasNextLine()) {
                content = sc.nextLine();
                String[] contentsplit = content.split("\\t");
                Word newWord = new Word(null, null);
                newWord.setWordTarget(contentsplit[0].toLowerCase());
                newWord.setWordExplain(contentsplit[1].toLowerCase());
                this.container.add(newWord);
            }
            Collections.sort(this.container, new Comparator<Word>() {
                @Override
                public int compare(Word o1, Word o2) {
                    return o1.getWordTarget().compareTo(o2.getWordTarget());
                }
            });
        }

        catch(FileNotFoundException e) {
            System.out.println("Error");
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
            if(this.container.get(i).getWordTarget().equals(lookup.toLowerCase())) {
                check = true;
                System.out.printf("%-5s| %-20s | %s\n", i+1, this.container.get(i).getWordTarget(),this.container.get(i).getWordExplain());
            }
        }
        if (check == false){
            System.out.println("Word not found!");
            System.out.println("bạn có muốn thêm từ này vào từ điển không? Nhập y nếu có, nhập n nếu không");
            String guess = input.next();
            if (guess.equals("y")){
                Word newWord = new Word(null,null);
                newWord.setWordTarget(lookup);
                System.out.println("Nhập nghĩa của từ: ");
                newWord.setWordExplain(input.next());
                this.container.add(newWord);
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
            if(this.container.get(i).getWordTarget().equals(del.toLowerCase())) {
                check = true;
                this.container.remove(i);
            }
        }
        if (check == true) System.out.println("Xóa thành công!");
        else System.out.println("Xóa thất bại!");
    }

    //Ham thay the tu
    public void replaceWord() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập từ muốn thay thế: ");
        String replacedWord = input.nextLine();
        boolean check = false;
        for(int i=0; i<this.container.size(); i++) {
            if(this.container.get(i).getWordTarget().equals(replacedWord.toLowerCase())) {
                String target, explain;
                target=input.nextLine();
                explain=input.nextLine();
                this.container.get(i).setWordTarget(target);
                this.container.get(i).setWordExplain(explain);
                check = true;
            }
        }
        if(!check) System.out.println("Word not found!");
    }

    //Ham thay the  tu
    public void replaceExplain() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập từ muốn thay thế: ");
        String replacedWord = input.nextLine();
        boolean check = false;
        for(int i=0; i<this.container.size(); i++) {
            if(this.container.get(i).getWordTarget().equals(replacedWord.toLowerCase())) {
                String explain;
                System.out.println("Nhập nghĩa mới của từ: ");
                explain=input.nextLine();
                this.container.get(i).setWordExplain(explain);
                check = true;
            }
        }
        if(!check) System.out.println("Word not found!");
        else System.out.println("Thay thế thành công!");
    }

    //Ham xuat tu dien hien tai ra File
    public void dictionaryExportToFile() {
        try {
            try (Formatter f = new Formatter(new FileOutputStream("dictionaries.txt"))) {
                for (int i = 0; i < this.container.size(); i++) {
                    {
                        f.format(this.container.get(i).getWordTarget());
                        f.format("\t");
                        f.format(this.container.get(i).getWordExplain());
                        f.format("%n");
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

    }
}

