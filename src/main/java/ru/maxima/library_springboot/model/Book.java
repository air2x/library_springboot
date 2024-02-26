package ru.maxima.library_springboot.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Назавние не должно быть пустым")
    @Getter
    @Setter
    @Column(name = "name_of_book")
    private String nameOfBook;

    @NotEmpty(message = "Автор не должен быть пустым")
    @Getter
    @Setter
    @Column(name = "author_of_book")
    private String authorOfBook;

    @Getter
    @Setter
    @Column(name = "year_of_writing_book")
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
