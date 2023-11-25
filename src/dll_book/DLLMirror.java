package dll_book;

public class DLLMirror {
    public static void main(String[] args) {
        DLL<String> list = new DLL<String>();
        list.insertLast("ovaa");
        list.insertLast("lista");
        list.insertLast("kje");
        list.insertLast("bide");
        list.insertLast("prevrtena");

        System.out.println("Listata pred da bide prevrtena: ");
        System.out.println(list.toString());

        list.mirror();

        System.out.println("Listata otkako e prevrtena: ");
        System.out.println(list.toString());
    }
}