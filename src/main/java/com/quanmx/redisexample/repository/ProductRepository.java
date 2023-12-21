package com.quanmx.redisexample.repository;

import com.quanmx.redisexample.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private RedisTemplate template;

    @Autowired
    public ProductRepository(RedisTemplate template) {
        this.template = template;
    }

    public Product save(Product product) {
        template.opsForHash().put("Product", product.getId(), product);
        return  product;
    }
    public List<Product> findAll(){
        return template.opsForHash().values("Product");
    }
    public  Product findProductById(int id){
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAA- Get from redis -AAAAAAAAAAAAAAAAAAAAAA");
        return (Product) template.opsForHash().get("Product", id);
    }
    public  String deleteProduct(int id){
        template.opsForHash().delete("Product", id);
        return "DELETED";
    }
}
