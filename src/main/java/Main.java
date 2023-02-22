import az.code.models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("az.code.test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("start");
        entityManager.getTransaction().begin();

//        Store store = Store.builder().storeName("Ali&Nino").build();
//        List<Branch> branchList = List.of(Branch.builder().branchName("28may").store(store).build(), Branch.builder().branchName("Genclik").store(store).build());
//        List<Publisher> publisherList = List.of(Publisher.builder().publisherName("publisher1").build(), Publisher.builder().publisherName("publisher2").build());
//        List<Author> authorList = List.of(Author.builder().authorName("author1").build(), Author.builder().authorName("author2").build());
//        Book book = Book.builder().build();
//        book.setBookName("book1");
//        book.setAuthorList(authorList);
//        book.setPublishers(publisherList);
//        Branch branch1 = Branch.builder().branchName("28may").store(store).build();
//        BookInstance bookInstance = BookInstance.builder().build();
//        bookInstance.setBranch(branch1);
//        bookInstance.setBarcode("1212");

        Book book1 = Book.builder().bookName("book1").build();
        Store store = Store.builder().storeName("Ali&Nino").build();
        BookInstance bookInstance = BookInstance.builder()
                .barcode("1234barkod")
                .branch(Branch.builder().branchName("28may").store(store).build())
                .build();
        bookInstance.setBook(book1);
        book1.setBookInstance(bookInstance);
        List<Branch> branchList = List.of(Branch.builder().branchName("Genclik")
                .store(store).build());
        store.setBranches(branchList);
        List<Author> authorList = List.of(
                Author.builder().authorName("author1").build());
        List<Publisher> publisherList = List.of(
                Publisher.builder().publisherName("publisher").book(book1).build());
        book1.setAuthorList(authorList);
        book1.setPublishers(publisherList);
        entityManager.persist(bookInstance);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}