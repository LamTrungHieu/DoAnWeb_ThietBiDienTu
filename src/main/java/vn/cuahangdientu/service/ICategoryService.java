package vn.cuahangdientu.service;

import java.util.List;

import vn.cuahangdientu.entity.Category;

public interface ICategoryService {
	List<Category> findAllCategory();
	Category findCategoryById(Integer id_category);
}
