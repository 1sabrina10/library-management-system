/*

package com.sabrina.librarymanagementsystem.config;

import com.sabrina.librarymanagementsystem.entity.*;
import com.sabrina.librarymanagementsystem.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(
            UserRepository userRepository,
            AuthorRepository authorRepository,
            CategoryRepository categoryRepository,
            BookRepository bookRepository,
            LoanRepository loanRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        System.out.println("DATA INITIALIZER START");

        // ================= USERS =================

        User admin = userRepository.findByEmail("admin@library.com")
                .orElseGet(() -> {
                    User u = new User();
                    u.setFirstname("Emma");
                    u.setLastname("Johnson");
                    u.setEmail("admin@library.com");
                    u.setPassword(passwordEncoder.encode("password123"));
                    u.setRole(Role.ADMIN);
                    return userRepository.save(u);
                });

        User sabrina = userRepository.findByEmail("yamo@gmail.com")
                .orElseGet(() -> {
                    User u = new User();
                    u.setFirstname("yamo");
                    u.setLastname("Moufok");
                    u.setEmail("yamo@gmail.com");
                    u.setPassword(passwordEncoder.encode("yamo123"));
                    u.setRole(Role.USER);
                    return userRepository.save(u);
                });


        // ================= AUTHORS =================

        Author bloch = new Author();
        bloch.setFirstname("ggg");
        bloch.setLastname("Blochggg");
        bloch.setBiography("aaa of Effective Java.");

        Author fowler = new Author();
        fowler.setFirstname("rrrrr");
        fowler.setLastname("Fowlrrrrer");
        fowler.setBiography("dddd engineering expert.");

        if(authorRepository.count() == 0) {
            authorRepository.save(bloch);
            authorRepository.save(fowler);
        } else {
            bloch = authorRepository.findAll().get(0);
            fowler = authorRepository.findAll().get(1);
        }


        // ================= CATEGORIES =================

        Category java;

        if(categoryRepository.count() == 0) {

            java = new Category();
            java.setName("Java");
            java.setDescription("Java ffffff books");

            Category software = new Category();
            software.setName("ffffffff Engineering");
            software.setDescription("Software ffffffffff books");

            categoryRepository.save(java);
            categoryRepository.save(software);

        } else {
            java = categoryRepository.findAll().get(0);
        }


        // ================= BOOKS =================

        Book effectiveJava;

        if(bookRepository.count() == 0) {

            effectiveJava = new Book();
            effectiveJava.setTitle("rr Java");
            effectiveJava.setIsbn("97801324685991");
            effectiveJava.setPublicationYear(2018);
            effectiveJava.setAvailable(false);
            effectiveJava.setAuthor(bloch);
            effectiveJava.setCategory(java);


            Book refactoring = new Book();
            refactoring.setTitle("azer");
            refactoring.setIsbn("9780134757599");
            refactoring.setPublicationYear(2019);
            refactoring.setAvailable(true);
            refactoring.setAuthor(fowler);
            refactoring.setCategory(java);


            bookRepository.save(effectiveJava);
            bookRepository.save(refactoring);

        } else {
            effectiveJava = bookRepository.findAll().get(0);
        }


        // ================= LOAN =================

        if(loanRepository.count() == 0) {

            Loan loan = new Loan();
            loan.setUser(sabrina);
            loan.setBook(effectiveJava);
            loan.setBorrowDate(LocalDate.now().minusDays(3));
            loan.setLoanStatus(LoanStatus.BORROWED);

            loanRepository.save(loan);
        }


        System.out.println("Sample data initialized successfully.");
    }
}
*/
