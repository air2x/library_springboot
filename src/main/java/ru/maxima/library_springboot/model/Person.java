package ru.maxima.library_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;


@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "ФИО не должно быть пустым")
    @Size(min = 2, max = 50, message = "Имя должно быть не меньше 2 и не больше 50 символов")
    @Getter
    @Setter
    @Column(name = "full_name")
    private String fullName;

    @Min(value = 1900, message = "Год рождения не может быть меньше 1900 г.")
    @Getter
    @Setter
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
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
