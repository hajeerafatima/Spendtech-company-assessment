package e_commerce.ecommerce.site.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import e_commerce.ecommerce.site.model.Category;
import e_commerce.ecommerce.site.model.Product;
import e_commerce.ecommerce.site.repository.CategoryRepository;
import e_commerce.ecommerce.site.repository.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner{

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		//clear all existing data
		productRepository.deleteAll();
		categoryRepository.deleteAll();
		
		//create categories
		Category electronics = new Category();
		electronics.setName("Electronics");
		
		Category clothing = new Category();
		clothing.setName("Clothing");
		
		Category shoes = new Category();
		shoes.setName("Running and Normal shoes");
		
		Category home = new Category();
		home.setName("Home and Kitchen");
		
		categoryRepository.saveAll(Arrays.asList(electronics, clothing, home,shoes));
		
		//create products
		Product phone = new Product();
		phone.setName("SmartPhone ");
		phone.setDescription("Latest Model smart phone with amazing feature Experience speed, style, and performance with this feature-rich smartphone. Designed with a stunning display, powerful processor, and long-lasting battery.");
		phone.setImageUrl("https://image.made-in-china.com/2f0j00DNVcylpIrKkL/2024-New-Smart-Phone-3GB-64GB-6-5-Inch-Original-Smart-Mobile-Phones-Android9-Cell-Phone-cellular-Low-Price-Mobile-Phone.webp");
		phone.setPrice(699.99);
		phone.setCategory(electronics);
		
		Product laptop = new Product();
		laptop.setName("Laptop");
		laptop.setDescription("High performance Laptop user friendly work and play Stay productive and entertained wherever you go with this sleek, high-performance laptop. Equipped with the latest processor, ample RAM, and fast SSD storage.");
		laptop.setImageUrl("https://images.pexels.com/photos/18105/pexels-photo.jpg");
		laptop.setPrice(999.99);
		laptop.setCategory(electronics);
		
		Product hpLaptop = new Product();
		hpLaptop.setName("Laptop");
		hpLaptop.setDescription("HP Laptop user friendly work and play Stay productive and entertained wherever you go with this sleek, high-performance laptop. Equipped with the latest processor, ample RAM, and fast SSD storage.");
		hpLaptop.setImageUrl("https://images.unsplash.com/photo-1517336714731-489689fd1ca8");
		hpLaptop.setPrice(500.99);
		hpLaptop.setCategory(electronics);
		
		//clothes
		Product jacket = new Product();
		jacket.setName("Winter jacket");
		jacket.setDescription("worm amd cozy jacket for winters Crafted for ultimate comfort and protection, this insulated jacket features a windproof outer shell and soft fleece lining to shield you from harsh winter conditions. ");
		jacket.setImageUrl("https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcSNoxgMmw0FWmrNuvx5DN9XMDVF7CjRxo6cklbHTr9B3Ndx4oYyl15UU0uveaaLYVkC74DlRaMYQcHRLxAV39ouH9047_cK5RM1cNORLb5DQx-I5KvLGxyg6A");
		jacket.setPrice(223.99);
		jacket.setCategory(clothing);
		
		Product jacket1 = new Product();
		jacket1.setName("Winter jacket ");
		jacket1.setDescription("worm amd cozy jacket for winters Crafted for ultimate comfort and protection, this insulated jacket features a windproof outer shell and soft fleece lining to shield you from harsh winter conditions.");
		jacket1.setImageUrl("https://rukminim2.flixcart.com/image/550/650/xif0q/jacket/t/m/s/3xl-1-no-ef-jkt-ellipse-original-imah52cfx8scqt2g.jpeg?q=90&crop=false");
		jacket1.setPrice(129.99);
		jacket1.setCategory(clothing);
		
		
		//Home and kitchen
		Product spoonsSet = new Product();
		spoonsSet.setName("Spoon Set");
		spoonsSet.setDescription("High-speed blender for smoothies and more Upgrade your dining experience with this premium stainless steel spoon set. Designed for both style and durability, each spoon features a smooth.");
		spoonsSet.setImageUrl("https://thetablecompany.in/cdn/shop/products/IMG_3046_ae9e2f43-b065-42e0-a6f2-686a4b2cc116_1000x1000.jpg?v=1632833469");
		spoonsSet.setPrice(89.99);
		spoonsSet.setCategory(home);
		
		//shoes
		Product shoe = new Product();
		shoe.setName("Shoes");
		shoe.setDescription("Running Shoes Step into all-day comfort with these versatile shoes, designed to keep up with your lifestyle. Whether you're heading to work, going for a walk, or hanging out with friends.");
		shoe.setImageUrl("https://images.unsplash.com/photo-1542291026-7eec264c27ff?auto=format&fit=crop&w=600&q=80");
		shoe.setPrice(589.99);
		shoe.setCategory(shoes);
		
		Product shoe1 = new Product();
		shoe1.setName("Shoes ");
		shoe1.setDescription("Running Shoes Step into all-day comfort with these versatile shoes, designed to keep up with your lifestyle. Whether you're heading to work, going for a walk, or hanging out with friends.");
		shoe1.setImageUrl("https://rukminim2.flixcart.com/image/850/1000/xif0q/shoe/1/m/l/4-kc128-purple-4-k-footlance-purple-original-imah6dhz7mq9gz9e.jpeg?q=90&crop=false");
		shoe1.setPrice(199.99);
		shoe1.setCategory(shoes);
		
		productRepository.saveAll(Arrays.asList(phone,laptop,jacket,spoonsSet,hpLaptop,shoe,shoe1,jacket1));
	}
}
