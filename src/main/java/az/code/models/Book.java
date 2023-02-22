package az.code.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_book", allocationSize = 1)
    private int bookId;
    @Column(name = "book_name")
    private String bookName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_author",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    List<Author> authorList;
    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Publisher> publishers;

    @OneToOne
    @JoinColumn(name = "book_instance_id")
    private BookInstance bookInstance;
}