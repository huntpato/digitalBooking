package com.dh.proyectointegradorctd.model;

import com.dh.proyectointegradorctd.util.StringListConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    /*============= Atributos =============== */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productName;

    private String productDescription;
    private LocalDate publicationDate;

    @Convert(converter = StringListConverter.class)
    @Column(length = 2000)
    private List<String> photoGallery;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Convert(converter = StringListConverter.class)
    private List<String> coordinates;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category productCategory;

    private Integer maxGuess;
    private Integer rooms;

    @Convert(converter = StringListConverter.class)
    private List<String> services;

    private Integer minNights;
    private Integer maxNights;
    private Double score;
    private Integer review;
    private Double pricePerNight;
    private Boolean productAvailable;

    /* =========== Getters y Setters ============= */

    public Integer getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<String> getPhotoGallery() {
        return photoGallery;
    }

    public void setPhotoGallery(List<String> photoGallery) {
        this.photoGallery = photoGallery;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<String> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<String> coordinates) {
        this.coordinates = coordinates;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getMaxGuess() {
        return maxGuess;
    }

    public void setMaxGuess(Integer maxGuess) {
        this.maxGuess = maxGuess;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public Integer getMinNights() {
        return minNights;
    }

    public void setMinNights(Integer minNights) {
        this.minNights = minNights;
    }

    public Integer getMaxNights() {
        return maxNights;
    }

    public void setMaxNights(Integer maxNights) {
        this.maxNights = maxNights;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Boolean getProductAvailable() {
        return productAvailable;
    }

    public void setProductAvailable(Boolean productAvailable) {
        this.productAvailable = productAvailable;
    }

    /* =============== Constructor ================= */

    public Product(String productName, String productDescription, LocalDate publicationDate, List<String> photoGallery, User user, City city, List<String> coordinates, Category productCategory, Integer maxGuess, Integer rooms, List<String> services, Integer minNights, Integer maxNights, Double score, Integer review, Double pricePerNight, Boolean productAvailable) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.publicationDate = publicationDate;
        this.photoGallery = photoGallery;
        this.user = user;
        this.city = city;
        this.coordinates = coordinates;
        this.productCategory = productCategory;
        this.maxGuess = maxGuess;
        this.rooms = rooms;
        this.services = services;
        this.minNights = minNights;
        this.maxNights = maxNights;
        this.score = score;
        this.review = review;
        this.pricePerNight = pricePerNight;
        this.productAvailable = productAvailable;
    }

    public Product() {
    }
}
