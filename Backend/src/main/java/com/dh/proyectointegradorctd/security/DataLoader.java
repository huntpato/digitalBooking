package com.dh.proyectointegradorctd.security;

import com.dh.proyectointegradorctd.model.*;
import com.dh.proyectointegradorctd.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    /* ================== Atributos ====================== */

    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final CityService cityService;
    private final AssetService assetService;

    /* ==================== Métodos ===================== */

    @Override
    public void run(ApplicationArguments args) {

        assetService.initAssetDatabase();

        User us1 = new User("admin","admin", "admin@dh.com", "admin", Role.ADMIN);
        User us2 = new User("user","user" ,"user@dh.com", "user", Role.USER);
        userService.save(us1);
        userService.save(us2);

        Category cat1 = new Category("Hoteles", "https://images.unsplash.com/photo-1496417263034-38ec4f0b665a?ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8aG90ZWx8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "Hoteles");
        Category cat2 = new Category("Cabañas", "https://media.istockphoto.com/photos/triangular-modern-lake-house-picture-id1296723838?b=1&k=20&m=1296723838&s=170667a&w=0&h=ypMLh0bMVdTYbeaYwUe6HhLVsxEmtHkz42zlAJWWBsU=", "Cabañas");
        Category cat3 = new Category("Casas del árbol", "https://images.unsplash.com/photo-1519378045141-f05b62faa055?ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8dHJlZSUyMGhvdXNlfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "Casas del árbol");
        Category cat4 = new Category("Islas", "https://media.istockphoto.com/photos/young-woman-walks-towards-beautiful-beach-picture-id1311063862?b=1&k=20&m=1311063862&s=170667a&w=0&h=ai-8qth6hlECiFoQR4g9Wt1cZHdrvsCsSAnyzGP2d3E=", "Islas");
        Category cat5 = new Category("Departamentos de lujo", "https://media.istockphoto.com/photos/modern-living-room-interior-design-in-3d-picture-id1266344111?b=1&k=20&m=1266344111&s=170667a&w=0&h=BA3pRBcHDybIXYXMrwXFeNQm8c73BsZJCQklQAFlWNg=", "Departamentos de lujo");
        Category cat6 = new Category("Castillos", "https://images.unsplash.com/photo-1435265796918-0e3d3e4af435?ixid=MnwxMjA3fDB8MHxzZWFyY2h8OTF8fGNhc3RsZXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "Castillos");
        Category cat7 = new Category("Barcos", "https://images.unsplash.com/photo-1605472075651-a1f8d550f508?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NjV8fGJvYXR8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "Barcos");
        Category cat8 = new Category("Contenedores", "https://images.unsplash.com/photo-1628394029749-ea3dcce4caa6?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8Y29udGFpbmVyJTIwaG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "Contenedores");

        categoryService.save(cat1);
        categoryService.save(cat2);
        categoryService.save(cat3);
        categoryService.save(cat4);
        categoryService.save(cat5);
        categoryService.save(cat6);
        categoryService.save(cat7);
        categoryService.save(cat8);

        City city1 = new City("Buenos Aires, Capital Federal", "Argentina");
        City city2 = new City("Highclere Park, Highclere", "Reino Unido");
        City city3 = new City("Bogotá", "Colombia");
        City city4 = new City("Boa Vista, Río de Janeiro", "Brasil");
        City city5 = new City("San Francisco, Cundinamarca", "Colombia");
        City city6 = new City("Islas San Blas", "Panamá");
        City city7 = new City("Villa La Angostura, Neuquén", "Argentina");
        City city8 = new City("Villa General Belgrano, Córdoba", "Argentina");
        City city9 = new City("Córdoba, Córdoba", "Argentina");
        City city10 = new City("Medellín, Antioquia", "Colombia");
        City city11 = new City("Huasca de Ocampo, Hidalgo", "México");
        City city12 = new City("Provincia de Cartagena, Bolívar", "Colombia");
        City city13 = new City("Bolton, Nueva York", "Estados Unidos");
        City city14 = new City("Gran Roque, Caribe", "Venezuela");
        City city15 = new City("Valdivia, Los Ríos", "Chile");

        cityService.save(city1);
        cityService.save(city2);
        cityService.save(city3);
        cityService.save(city4);
        cityService.save(city5);
        cityService.save(city6);
        cityService.save(city7);
        cityService.save(city8);
        cityService.save(city9);
        cityService.save(city10);
        cityService.save(city11);
        cityService.save(city12);
        cityService.save(city13);
        cityService.save(city14);
        cityService.save(city15);

        Product pd1 = new Product("Amazing Luxurious Apt-Palermo Soho", "Luxury building in the heart of the trendy Palermo Soho. 24-hour security", LocalDate.of(2009,4,13), Arrays.asList("https://a0.muscache.com/im/pictures/19357696/b1de16cb_original.jpg","https://a0.muscache.com/im/pictures/2701386/d6e3b047_original.jpg","https://a0.muscache.com/im/pictures/4608986/75ff6129_original.jpg", "https://a0.muscache.com/im/pictures/4597328/84c0ef1c_original.jpg", "https://a0.muscache.com/im/pictures/4597364/9ca9e689_original.jpg"), us1, city1, Arrays.asList("-34.58184","-58.42415"), cat4, 2, 2, Arrays.asList("Wifi", "Cable TV", "kitchen","parking", "jacuzzi"), 3, 30, 4.7, 4, 6408.0, true);
        Product pd2= new Product("Castillo de Highclere", "El castillo de Highclere es una mansión de campo victoriana de estilo Isabelino, con un parque diseñado por Capability Brown.", LocalDate.of( 2021, 10,25), Arrays.asList("https://news.airbnb.com/wp-content/uploads/sites/4/2019/09/DA_PDP_listing_A_1440x960.jpg"), us1, city2, Arrays.asList("51.3265901","-1.360666"), cat6, 12, 20, Arrays.asList("Wifi", "Pool", "Cable TV", "kitchen","petsallowed", "jacuzzi"), 3, 30, 9.7, 10, 15800.0, true);
        Product pd3= new Product("Hermoso Apartaestudio", " Apartaestudio exterior con vista y muy iluminado. Excelente ubicación cerca a restaurantes, vías principales y comercios.", LocalDate.of( 2021, 10,25), Arrays.asList("https://a0.muscache.com/im/pictures/miso/Hosting-52565080/original/e74b6feb-092e-41c0-b8a5-f47048f5685f.jpeg"), us1, city3, Arrays.asList("4.72079677649355", "-74.04773038930063"), cat8, 12, 20, Arrays.asList("Wifi", "kitchen"," parking", "airconditioning"), 3, 30, 7.8, 9, 15800.0, true);
        Product pd4= new Product("Charmoso Barco para hospedagem", " Venha conhecer Paraty a bordo de uma charmosa e confortável traineira.", LocalDate.of( 2021, 10,25), Arrays.asList("https://a0.muscache.com/im/pictures/miso/Hosting-52452495/original/f17529bf-a47e-4fdf-b201-d51ea3c5073a.jpeg"), us1, city4, Arrays.asList("2.8011959522175727", "-60.669441776269906"), cat7, 12, 20, Arrays.asList("Wifi", "kitchen","breakfast", "smokingallowed"), 3, 30, 9.7, 7, 15800.0, true);
        Product pd5= new Product("Selva Luxury Cabin - San Francisco", " Disfruta de la naturaleza en esta cabaña ubicada en medio de la selva! A una hora de Bogota, a 9km del pueblo.", LocalDate.of( 2021, 10,25), Arrays.asList("https://a0.muscache.com/im/pictures/b3e42215-36e0-4bf0-8b6b-1688a02e24eb.jpg"), us1, city5, Arrays.asList("4.976127", "-74.293675"), cat3, 12, 20, Arrays.asList("Wifi", "Cable TV", "kitchen","petsallowed", "breakfast"), 3, 30, 9.7, 10, 18800.0, true);
        Product pd6= new Product("San Blas Islands, Dad Igwa", " Discover our Dad Igwa all-inclusive cabins at Isla Diablo,San Blas Islands.", LocalDate.of( 2021, 10,25), Arrays.asList("https://a0.muscache.com/im/pictures/99eb047e-9a9b-43ac-baf4-0a9c24c35b13.jpg"), us1, city6, Arrays.asList("9.569049", "-78.822618"), cat4, 12, 20, Arrays.asList("Wifi", "kitchen","breakfast", "jacuzzi"), 3, 30, 9.7, 10, 26900.0, true);
        Product pd7= new Product("La Estancia Casa Del Parque", " Excelente cabaña con todos los servicios y equipamiento ,con detalles de calidad y confort..", LocalDate.of( 2021, 10,25), Arrays.asList("https://a0.muscache.com/im/pictures/99eb047e-9a9b-43ac-baf4-0a9c24c35b13.jpg"), us1, city7, Arrays.asList("-40.764326", "-71.645748"), cat2, 12, 20, Arrays.asList("Wifi", "Cable TV", "kitchen","petsallowed", "parking"), 3, 30, 9.7, 9, 18900.0, true);
        Product pd8= new Product("Hotel Howard Johnson", " Contamos con 46 habitaciones de 35 m², con vista hacia las sierras chicas o a nuestro majestuoso parque.", LocalDate.of( 2021, 10,25), Arrays.asList("https://a0.muscache.com/im/pictures/802bc9bd-dc64-4b02-bf80-e7e67d66de93.jpg"), us1, city8, Arrays.asList("-31.993200", "-64.558006"), cat1, 12, 20, Arrays.asList("Wifi", "Pool", "breakfast", "jacuzzi", "parking"), 3, 30, 9.7, 8, 10800.0,true);
        Product pd9= new Product("Selina Deluxe Room", "Selina is located in Nueva Córdoba, one of the cultural and commercial centers of the city.", LocalDate.of( 2021, 10,25), Arrays.asList("https://a0.muscache.com/im/pictures/miso/Hosting-39111169/original/ac77e141-bf14-4d2e-a315-ff450660f021.jpeg"), us1, city9, Arrays.asList("-31.423701", "-64.185071"), cat1, 4, 30, Arrays.asList("Wifi", "Pool", "breakfast", "kitchen","parking"), 3, 30, 9.7, 8, 5800.0,true);
        Product pd10= new Product("Chalet Cocuyos Santa Elena.", "Sobre la montaña y bajo las estrellas podrás habitar un espacio acogedor y autentico rodeado de bosque y flores.", LocalDate.of( 2021, 10,25), Arrays.asList("https://a0.muscache.com/im/pictures/miso/Hosting-50045592/original/a535c125-3138-45f6-9c49-d399f1d6afa1.jpeg"), us1, city10, Arrays.asList("6.258841", "-75.546055"), cat2, 4, 1, Arrays.asList("Wifi", "Pool", "Cable TV", "petsallowed"), 3, 30, 9.7, 10, 15700.0,true);
        Product pd11= new Product("Casa del Árbol Pinochueco.", "La casa del árbol Pinochueco es un lugar distinto en el que podrás disfrutar de un descanso entre los árboles.", LocalDate.of( 2021, 10,25), Arrays.asList("https://a0.muscache.com/im/pictures/d5d015a1-1427-4c3c-99c1-20d79b136691.jpg?"), us1, city11, Arrays.asList("20.202231", "-98.575312"), cat3, 4, 2, Arrays.asList("Wifi", "Cable TV", "kitchen"), 3, 30, 9.7, 8, 8700.0,true);
        Product pd12= new Product("Oasis Kalua", "Enjoy our exclusive private island located in the Rosario Islands.", LocalDate.of( 2021, 10,25), Arrays.asList("https://a0.muscache.com/im/pictures/miso/Hosting-49227437/original/5b50ac57-8eca-4b8b-be51-43a7155ed37a.jpeg"), us1, city12, Arrays.asList("10.425877", "-75.506332"), cat4, 4, 2, Arrays.asList("Wifi", "Pool", "kitchen","petsawolled"), 3, 30, 9.7, 10, 9700.0,true);
        Product pd13= new Product("Apartamento de Super Lujo en Av Alvear", "Espectacular piso en el mejor sector de Av. Alvear entre Montevideo y Parera.", LocalDate.of( 2021, 10,25), Arrays.asList("https://a0.muscache.com/im/pictures/3cbbb50a-5f01-4c23-8ef8-4cc6901b2a67.jpg"), us1, city1, Arrays.asList("-34.588392", "-58.387988"), cat5, 4, 1, Arrays.asList("Wifi", "Cable TV", "kitchen","jacuzzi", "parking"), 3, 30, 9.7, 7, 12700.0,true);
        Product pd14= new Product("Highlands Castle", "Poised on a graceful mountaintop overlooking majestic Lake George, your castle awaits you...", LocalDate.of( 2021, 10,25), Arrays.asList("https://a0.muscache.com/im/pictures/a57ab9ea-80d5-4ed0-aa15-ce536039778d.jpg"), us1, city13, Arrays.asList("-43.553649", "-73.656716"), cat6, 10, 1, Arrays.asList("Wifi", "Pool", "jacuzzi","kitchen", "petsallowed"), 3, 30, 9.7, 9, 25700.0,true);
        Product pd15= new Product("Catamaran Charter Todo Incluido", "Entre a bordo de nuestro catamaran para escapar a unas vacaciones excepcional.", LocalDate.of( 2021, 10,25), Arrays.asList("https://a0.muscache.com/im/pictures/86e41cf2-76de-4744-9305-0f3b4cc697d7.jpg"), us1, city14, Arrays.asList("11.953442", "-66.674499"), cat7, 10, 1, Arrays.asList("kitchen","petsallowed","breakfast"), 3, 30, 9.7, 8, 15500.0, true);
        Product pd16= new Product("Refugio bosque/lago Outscape P. Fuy", "El Refugio es perfecto para una pareja, aunque también puede recibir 1 o 2 niños pequeños.", LocalDate.of( 2021, 10,25), Arrays.asList("https://a0.muscache.com/im/pictures/b3c484f7-11b6-490b-90e1-6a5749c3993f.jpg"), us1, city15, Arrays.asList("-39.835615", "-73.253001"), cat8, 5, 1, Arrays.asList("Wifi", "kitchen","Refrigerator", "petsallowed", "parking"), 3, 30, 9.7, 9, 9500.0, true);


        productService.save(pd1);
        productService.save(pd2);
        productService.save(pd3);
        productService.save(pd4);
        productService.save(pd5);
        productService.save(pd6);
        productService.save(pd7);
        productService.save(pd8);
        productService.save(pd9);
        productService.save(pd10);
        productService.save(pd11);
        productService.save(pd12);
        productService.save(pd13);
        productService.save(pd14);
        productService.save(pd15);
        productService.save(pd16);

    }

    /* =================== Constructor =====================*/

    @Autowired
    public DataLoader(UserService userService, CategoryService categoryService, ProductService productService, CityService cityService, AssetService assetService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.cityService = cityService;
        this.assetService = assetService;
    }
}
