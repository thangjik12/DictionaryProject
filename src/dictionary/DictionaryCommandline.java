/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DictionaryCommandline extends DictionaryManagement{
    public void showAllWords()
    {
        int i=1;
        System.out.printf("%-5s| %-20s | Vietnamese\n", "No", "English");
        while(i<=this.container.size()) {
            int j = i-1;
            System.out.printf("%-5s| %-20s | %s\n", i, this.container.get(j).getWordTarget(),this.container.get(j).getWordExplain());
            i++;
        }
        
        
    }
    public void dictionaryBasic()
        {
           // insertFromCommandline();
            insertFromFile();
            showAllWords();
        }
    
    public void dictionaryAdvanced() {
        insertFromFile();
        showAllWords();
       // dictionaryLookup();
       //dictionarySearcher();
    } 
    
    public void dictionarySearcher() {
        Scanner input = new Scanner(System.in);
        String lookup;
        lookup=input.nextLine();
        boolean check = false;
        for(int i=0; i<this.container.size(); i++) {
            String sub = this.container.get(i).getWordTarget().substring(0,lookup.length());
            if(sub.equals(lookup)) {
                check = true;
                System.out.printf("%-5s| %-20s | %s\n", i+1, this.container.get(i).getWordTarget(),this.container.get(i).getWordExplain());
            }
             
        } 
        if(!check) System.out.println("Word not found");
        }
    
     
    public static void main(String[] args) {
        DictionaryCommandline s = new DictionaryCommandline();
          
      //  s.dictionaryBasic();
          s.dictionaryAdvanced();
          s.replaceExplain();
          s.showAllWords();
          s.dictionaryExportToFile();
          
    }
}
