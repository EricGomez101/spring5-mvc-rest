package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class BootStrap implements CommandLineRunner
{
    private CategoryRepository categoryRepository;

    public BootStrap(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
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

        log.debug("Loaded bootstrap data. Category count: " + categoryRepository.count());

    }
}
