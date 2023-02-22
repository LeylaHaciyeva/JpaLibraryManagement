package az.code.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "bookinstance")
public class BookInstance {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_bookinstance"
    )
    @SequenceGenerator(
            name = "seq_bookinstance",
            allocationSize = 1
    )
    private int id;

    @Column(name = "bar_code")
    String barcode;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id")
    private Branch branch;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "book_id")
   private Book book;
}
