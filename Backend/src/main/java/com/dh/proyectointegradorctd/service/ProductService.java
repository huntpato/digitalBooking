package com.dh.proyectointegradorctd.service;

import com.dh.proyectointegradorctd.model.Category;
import com.dh.proyectointegradorctd.model.City;
import com.dh.proyectointegradorctd.model.Product;
import com.dh.proyectointegradorctd.model.User;
import com.dh.proyectointegradorctd.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IEntityService<Product>{

    /* ======================= Atributos ====================== */

    private final IProductRepository productRepository;
    private final CategoryService categoryService;
    private final CityService cityService;
    private final UserService userService;

    /* ======================= Métodos ======================== */

    @Override
    public Product save(Product product) {

        Category cat = categoryService.findCategoryByCategory(product.getProductCategory().getName());
        User us = userService.findByEmail(product.getUser().getEmail());
        City city = cityService.findCityByCountryAndName(product.getCity().getCountry(), product.getCity().getName());

        if(cat != null){
            product.setProductCategory(cat);
        }

        if(us != null){
            product.setUser(us);
        }

        if(city != null){
            product.setCity(city);
        }

        return productRepository.save(product);

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product update(Product product) {

        Product tmp = productRepository.findById(product.getId()).orElse(null);

        City city = cityService.findCityByCountryAndName(product.getCity().getCountry(), product.getCity().getName());
        Category cat = categoryService.findCategoryByCategory(product.getProductCategory().getName());
        User us = userService.findByEmail(product.getUser().getEmail());

        if(cat != null){
            product.setProductCategory(cat);
        }

        if(us != null){
            product.setUser(us);
        }

        if(city != null){
            product.setCity(city);
        }

        if(tmp != null){

            tmp.setProductName(product.getProductName());
            tmp.setProductDescription(product.getProductDescription());
            tmp.setPublicationDate(product.getPublicationDate());
            tmp.setPhotoGallery(product.getPhotoGallery());
            tmp.setCoordinates(product.getCoordinates());
            tmp.setMaxGuess(product.getMaxGuess());
            tmp.setRooms(product.getRooms());
            tmp.setServices(product.getServices());
            tmp.setMinNights(product.getMinNights());
            tmp.setMaxNights(product.getMaxNights());
            tmp.setScore(product.getScore());
            tmp.setReview(product.getReview());
            tmp.setPricePerNight(product.getPricePerNight());
            tmp.setProductAvailable(product.getProductAvailable());

            return productRepository.save(tmp);

        }else {
            return null;
        }

    }

    @Override
    public String delete(Integer id) {
        if(productRepository.findById(id).isPresent()){
            productRepository.deleteById(id);
            return "Product with id: " + id + " was deleted";
        }else{
            return "Product with id:" + id + " don't exist";
        }
    }

    public Product findProductByName(String name){
        return productRepository.findProductByProductName(name).orElse(null);
    }

    public List<String> getLocations(){
        return productRepository.getLocations();
    }

    public List<Product> getProductsByCategory(String category){
        return productRepository.getProductsByCategory(category);
    }

    public List<Product> getProductsByCity(String city){
        return productRepository.getProductsByCity(city);
    }

    public List<Product> getProductsByCategoryAndCity(String category, String city){
        return productRepository.getProductsByCategoryAndCity(category, city);
    }

    /* ==================== Constructor ======================= */

    @Autowired
    public ProductService(IProductRepository productRepository, CategoryService categoryService, CityService cityService, UserService userService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.cityService = cityService;
        this.userService = userService;
    }
}
