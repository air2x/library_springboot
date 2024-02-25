package ru.maxima.library_springboot.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Column(name = "name_of_book")
    @NotEmpty(message = "Назавние не должно быть пустым")
    @Getter
    @Setter
    private String nameOfBook;

    @Column(name = "author_of_book")
    @NotEmpty(message = "Автор не должен быть пустым")
    @Getter
    @Setter
    private String authorOfBook;

    @Column(name = "year_of_writing_book")
    @Getter
    @Setter
    private int yearOfWritingBook;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    @Getter
    @Setter
    private Person owner;

    public Book() {
    }

    public Book(int id, String nameOfBook, String authorOfBook, int yearOfWritingBook, Person owner) {
        this.id = id;
        this.nameOfBook = nameOfBook;
        this.authorOfBook = authorOfBook;
        this.yearOfWritingBook = yearOfWritingBook;
        this.owner = owner;
    }
}
