package com.productservice.productservice;

import com.productservice.productservice.inheritancerelations.singletable.*;
import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.PriceRepository;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     ProductRepository productRepository,
                                     PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }

    /*private MentorRepository mentorRepository;

    private UserRepository userRepository;

    private StudentRepository studentRepository;

    ProductServiceApplication(@Qualifier("st_mentorRepository") MentorRepository mentorRepository, @Qualifier("st_userRepository")
                              UserRepository userRepository,@Qualifier("st_studentRepository")
                              StudentRepository studentRepository){
        this.mentorRepository=mentorRepository;
        this.userRepository=userRepository;
        this.studentRepository=studentRepository;
    }*/
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*Mentor mentor=new Mentor();
        mentor.setAverageRating(4.5);
        mentor.setName("Danial");
        mentor.setEmail("asaddanial@gmail.com");

        mentorRepository.save(mentor);

        User user=new User();
        user.setEmail("user@gmail.com");
        user.setName("User");

        userRepository.save(user);

        Student student=new Student();
        student.setPsp(75.5);
        student.setEmail("student@gmail.com");
        student.setName("Student");

        studentRepository.save(student);*/

        /*List<User> users=userRepository.findAll();

        for(User user1:users){
            System.out.println(user1.toString());
        }*/


       /* Optional<Category> optionalCategory=categoryRepository.findById(UUID.fromString("58ecc631-bc2f-4652-82c0-652e84ebb56e"));
        if(optionalCategory.isEmpty())
            throw new Exception("Category was null");

        Category category=optionalCategory.get();

        List<Product> products=category.getProducts();
        for(Product product:products)
            System.out.println(product.getTitle());*/
        Price price=new Price();
        price.setCurreny("INR");
        price.setValue(100000);
       // Price savedPrice=priceRepository.save(price);

        Category category=new Category();
        category.setName("Apple Devies");
        Category savedCategory=categoryRepository.save(category);


        Product product=new Product();
        product.setTitle("iphone 15 prod");
        product.setDescription("best iPhone");
        product.setCategory(savedCategory);
        product.setPrice(price);

        Product savedProduct=productRepository.save(product);
        /*Optional<Price> optionalPrice=priceRepository.findById(UUID.fromString("272d56af-8430-4c6d-ad84-c06d9e7cb33f"));
        if(optionalPrice.isEmpty())
            throw new Exception("Price is empty");
        Price price =optionalPrice.get();
        priceRepository.deleteById(UUID.fromString("272d56af-8430-4c6d-ad84-c06d9e7cb33f"));*/

        /*Optional<Product> optionalProduct=productRepository.findById(UUID.fromString("158dea1b-58ae-4d45-9add-d29f81b4e9c1"));
        if(optionalProduct.isEmpty())
            throw new Exception("Product is empty");
        Product product=optionalProduct.get();
        productRepository.deleteById(UUID.fromString("158dea1b-58ae-4d45-9add-d29f81b4e9c1"));*/

    }
}