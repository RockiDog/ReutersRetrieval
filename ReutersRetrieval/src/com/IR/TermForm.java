package com.IR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Rex on 15/6/11.
 */

public class TermForm {

    private HashMap<String, Integer> docFrequency = new HashMap<String, Integer>();
    private HashMap<String, ArrayList<TermFreqItem>> termFrequency = new HashMap<String, ArrayList<TermFreqItem>>();
    private HashMap<String, LinkedList<DocAppearItem>> docAppearPosition = new HashMap<String, LinkedList<DocAppearItem>>();

    /**
     * Add term into tf table.
     * If term does not exist,
     * create it.
     * @param docID number of document
     * @param parsedArticle parsed terms
     * @return docPos after adding
     */
    public void addTerm(int docID, LinkedList<ParsedTermItem> parsedArticle){

        for (ParsedTermItem termItem : parsedArticle){
            String rawString = termItem.term;
            int docPos = termItem.docPos;
            if (null == termFrequency.get(rawString)){
                docFrequency.put(rawString, 1);
                termFrequency.put(rawString, new ArrayList<TermFreqItem>());
                termFrequency.get(rawString).add(new TermFreqItem(docID, 1));
                docAppearPosition.put(rawString, new LinkedList<DocAppearItem>());
                docAppearPosition.get(rawString).addLast(new DocAppearItem(docID, docPos));
            } else {
                docAppearPosition.get(rawString).addLast(new DocAppearItem(docID, docPos));
                if (termFrequency.get(rawString).get(termFrequency.get(rawString).size() - 1).docID != docID){
                    termFrequency.get(rawString).add(new TermFreqItem(docID, 1));
                    int currDocFrequency = docFrequency.get(rawString);
                    docFrequency.put(rawString, currDocFrequency + 1);
                } else {
                    termFrequency.get(rawString).get(termFrequency.get(rawString).size() - 1).freq++;
                }
            }
        }
    }

    /**
     * Print info of class for debugging.
     */
    public void printTable(){
        for (String term : termFrequency.keySet()){
            System.out.print(term + " => df = " + docFrequency.get(term) + " tf = " + termFrequency.get(term).get(0).freq + "\n\t");
            for (DocAppearItem item : docAppearPosition.get(term)){
                System.out.print(item.docID + ":" + item.docPos + " ");
            }
            System.out.println();
        }
        System.out.println("Total number of terms = " + termFrequency.size());
    }
}
