package com.company;

 class TextArea {
     private String text;

     public void set(String text) {
         text = text;
     }
     public Memento takeSnapshot(){
         return new Memento(this.text);
     }
     public void restore(Memento memento){
         this.text = memento.getSavedText();
     }
     public  static class Memento{
         private final String text;

         private Memento (String textToSave){
             text = textToSave;
         }
         private String getSavedText(){
             return text;
         }
     }
 }


