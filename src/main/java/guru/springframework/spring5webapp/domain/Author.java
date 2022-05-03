package guru.springframework.spring5webapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private String firstName;
    private String lastName;
    private Set<Book> books;

}
