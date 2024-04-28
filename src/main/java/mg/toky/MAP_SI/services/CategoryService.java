package mg.toky.MAP_SI.services;


import mg.toky.MAP_SI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mg.toky.MAP_SI.repositories.CategoryRepository;
import java.util.List;

@Service
public class CategoryService {


    private final CategoryRepository CategoryRepository;

    @Autowired
    public CategoryService(CategoryRepository CategoryRepository) {
        this.CategoryRepository = CategoryRepository;
    }

    public List<Category> getCategories() { return CategoryRepository.findAll();}

    public Category getCategory(Long CategoryId){
        Category category = CategoryRepository.findById(CategoryId).orElseThrow(() -> new IllegalStateException(
                "Category with id "+CategoryId+" doesn't exist"
        ));
        return category;
    }

}
