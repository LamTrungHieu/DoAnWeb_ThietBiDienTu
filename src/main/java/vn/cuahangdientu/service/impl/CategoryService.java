package vn.cuahangdientu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.cuahangdientu.entity.Category;
import vn.cuahangdientu.repository.CategoryRepository;
import vn.cuahangdientu.service.ICategoryService;

public class CategoryService implements ICategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return this.categoryRepository.findAll();
	}

	@Override
	public Category findCategoryById(Integer id_category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.getReferenceById(id_category);
	}
}
