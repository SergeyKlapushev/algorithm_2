import java.util.Iterator;

public class Task1{

  public static void main(String[] args) {
    SingleLinkList<Contact> contactList = new SingleLinkList<>();

    contactList.addToEnd(new Contact(1, "Клапышев Сергей Михайлович", "+71641651845"));
    contactList.addToEnd(new Contact(2, "Кораблёва Мария Александровна", "+79469911431"));
    contactList.addToEnd(new Contact(3, "Трухин Матвей Владимирович", "+76864375454"));
    contactList.addToEnd(new Contact(4, "Мигунова Мария Евгеньевна", "+74123422048"));
    contactList.addToEnd(new Contact(5, "Соколов Илья Дмитриевич", "+74345453427"));

    System.out.println("До: ");
    for (Object contact : contactList) {
      System.out.println(contact);
    }
    contactList.reverse();


    System.out.println("\nПосле: ");
    for (Object contact : contactList) {
      System.out.println(contact);
    }
  }

  static class Contact {

    int id;
    String name;
    String phone;

    public Contact(int id, String name, String phone) {
      this.id = id;
      this.name = name;
      this.phone = phone;
    }

    @Override
    public String toString() {
      return "id: " + id + ", имя:" + name + ", телефон: " + phone;
    }
  }


  public static class SingleLinkList<T> implements Iterable {

    ListItem<T> head;
    ListItem<T> tail;

    @Override
    public Iterator iterator() {
      return new Iterator<T>() {
        ListItem<T> current = head;

        @Override
        public boolean hasNext() {
          return current != null;
        }

        @Override
        public T next() {
          T data = current.data;
          current = current.next;
          return data;
        }
      };
    }


    private static class ListItem<T> {

      T data;
      ListItem<T> next;
    }


    public boolean isEmpty() {
      return head == null;
    }


    public void addToEnd(T item) {


      ListItem<T> newItem = new ListItem<>();
      newItem.data = item;

    
      if (isEmpty()) {
        head = newItem;
        tail = newItem;
      } else { 
        tail.next = newItem;
        tail = newItem;
      }
    }


    public void reverse() {
      if (!isEmpty() && head.next != null) {
        tail = head;
        ListItem<T> current = head.next;
        head.next = null;
        while (current != null) {
          ListItem<T> next = current.next;
          current.next = head;
          head = current;
          current = next;
        }
      }
    }
  }
}