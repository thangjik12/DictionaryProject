package dictionary;

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
        int n =input.nextInt();
        input.nextLine();
        for(int i=0; i<n; i++) {
            Word newWord = new Word();
            newWord.setWordTarget(input.nextLine());
            newWord.setWordExplain(input.nextLine());
            this.container.add(newWord);
        }
    }

    //Ham doc du lieu tu file
    public void insertFromFile() {
        try{
            File apath = new File("D:\\Code\\Java\\Dictionary\\dictionaries.txt");
            Scanner sc = new Scanner(apath);
            String content ;
            while(sc.hasNextLine()) {
                content = sc.nextLine();
                String[] contentsplit=content.split("\\t");
                Word newWord = new Word();
                newWord.setWordTarget(contentsplit[0]);
                newWord.setWordExplain(contentsplit[1]);
                this.container.add(newWord);
            }
            sc.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    //Ham tra cuu tu
    public void dictionaryLookup(){
        Scanner input = new Scanner(System.in);
        String lookup;
        lookup=input.nextLine();
        for(int i=0; i<this.container.size(); i++) {
            if(this.container.get(i).getWordTarget().equals(lookup)) {
                System.out.printf("%-5s| %-20s | %s\n", i+1, this.container.get(i).getWordTarget(),this.container.get(i).getWordExplain());
                break;
            }
            else {
                System.out.println("Word not found!");
                System.out.println("Do you want to add this new word to dictionary?! y = yes, n = no ");
                String guess = input.nextLine();
                if (guess == "y") add();
                else break;
            }
        }
    }

    //Ham xoa du lieu tu dien
    public void delete() {
        Scanner input = new Scanner(System.in);
        String del;
        del=input.nextLine();
        for(int i=0; i<this.container.size(); i++) {
            if(this.container.get(i).getWordTarget().equals(del)) {
                this.container.remove(i);

            }
        }
    }

    //Ham them du lieu tu dien
    public void add() {
        Scanner input = new Scanner(System.in);
        String target, explain;
        target=input.nextLine();
        explain=input.nextLine();
        Word newWord = new Word();
        newWord.setWordTarget(target);
        newWord.setWordExplain(explain);
        this.container.add(newWord);
    }

    //Ham thay the tu
    public void replaceWord() {
        Scanner input = new Scanner(System.in);
        String replacedWord = input.nextLine();
        boolean check = false;
        for(int i=0; i<this.container.size(); i++) {
            if(this.container.get(i).getWordTarget().equals(replacedWord)) {
                String target, explain;
                target=input.nextLine();
                explain=input.nextLine();
                this.container.get(i).setWordTarget(target);
                this.container.get(i).setWordExplain(explain);
                check = true;
            }
        }
        if(!check) System.out.println("Word not found");
    }

    //Ham thay the tu
    public void replaceExplain() {
        Scanner input = new Scanner(System.in);
        String replacedWord = input.nextLine();
        boolean check = false;
        for(int i=0; i<this.container.size(); i++) {
            if(this.container.get(i).getWordTarget().equals(replacedWord)) {
                String explain;
                explain = input.nextLine();
                this.container.get(i).setWordExplain(explain);
                check = true;
            }
        }
        if(!check) System.out.println("Word not found");
    }

    //Ham xuat tu dien hien tai ra File
    public void dictionaryExportToFile() {
        try {
            Formatter f = new Formatter("D:\\Code\\Java\\Dictionary\\newdictionaries.txt");
            for(int i=0; i<this.container.size(); i++) {
                {
                    f.format(this.container.get(i).getWordTarget());
                    f.format("\t");
                    f.format(this.container.get(i).getWordExplain());
                    f.format("%n");
                }
            }
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

    }
}