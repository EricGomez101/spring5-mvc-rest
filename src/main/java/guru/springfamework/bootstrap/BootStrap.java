package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class BootStrap implements CommandLineRunner
{
    private CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;


    public BootStrap(CategoryRepository categoryRepository, CustomerRepository customerRepository)
    {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        Category fruits = new Category().builder().name("Fruits").build();
        Category dried = new Category().builder().name("Dried").build();
        Category fresh = new Category().builder().name("Fresh").build();
        Category exotic = new Category().builder().name("Exotic").build();
        Category nuts = new Category().builder().name("Nuts").build();

        categoryRepository.saveAll(Arrays.asList(fruits, dried, fresh, exotic, nuts));

        log.debug("Loaded category data. Category count: " + categoryRepository.count());

        Customer dave = new Customer().builder().fname("Dave").lname("Smith").build();
        Customer steve = new Customer().builder().fname("Steve").lname("Smith").build();
        Customer john = new Customer().builder().fname("John").lname("Doe").build();

        customerRepository.saveAll(Arrays.asList(dave, steve, john));

        log.debug("Loaded Customer Data. Customer count: " + customerRepository.count());
    }
}
