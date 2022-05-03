package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Address;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    public static final Logger LOGGER = LoggerFactory.getLogger("BootStrapData");

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Author eric = new Author("Eric", "Evans");
        Book ericBook = new Book("DDD", "123123");
        eric.getBooks().add(ericBook);
        ericBook.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ericBook);

        Author rod = new Author("Rod", "Johnson");
        Book rodBook = new Book("J2EE", "312312");
        rod.getBooks().add(rodBook);
        rodBook.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(rodBook);
        LOGGER.info("Started in Bootstrap");
        LOGGER.info("No of books: {}", bookRepository.count());

        Publisher publisher = new Publisher("Sample Publisher", new Address("Address Street 1","Warsaw","Poland","00-000"));
        publisherRepository.save(publisher);
        LOGGER.info("No of publishers: {}", publisherRepository.count());

    }
}
