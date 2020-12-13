package guru.springframework.spring5webapp.bootstrap;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;

public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author lahiru = new Author("Lahiru", "Senevirathne");
        Book springbook = new Book("learn spring", "1234");
        lahiru.getBooks().add(springbook);
        springbook.getAuthors().add(lahiru);

        authorRepository.save(lahiru);
        bookRepository.save(springbook);

        System.out.println("Started bootstrap");
        System.out.println("Number of Books " + bookRepository.count());


    }
}
