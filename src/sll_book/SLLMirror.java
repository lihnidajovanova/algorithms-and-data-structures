package sll_book;

public class SLLMirror {
    public static void main(String[] args) {
        SLL<String> listOfNames = new SLL<String>();
        listOfNames.insertLast("Ana");
        listOfNames.insertLast("Bojana");
        listOfNames.insertLast("Cece");
        listOfNames.insertLast("Dina");
        System.out.print("Listata pred prevrtuvanje: ");
        System.out.println(listOfNames.toString());
        listOfNames.mirror();
        System.out.print("Listata po prevrtuvanje: ");
        System.out.println(listOfNames.toString());
    }
}
