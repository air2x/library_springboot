package ru.maxima.library_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.List;


@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Column(name = "full_name")
    @NotEmpty(message = "ФИО не должно быть пустым")
    @Size(min = 2, max = 50, message = "Имя должно быть не меньше 2 и не больше 50 символов")
    @Getter
    @Setter
    private String fullName;

    @Column(name = "year_of_birth")
    @Min(value = 1900, message = "Год рождения не может быть меньше 1900 г.")
    @Getter
    @Setter
    private int yearOfBirth;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    @Getter
    @Setter
    private List<Book> books;

    public Person() {
    }

    public Person(int id, String fullName, int yearOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }
}
