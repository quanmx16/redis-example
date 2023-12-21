package com.quanmx.redisexample.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@RedisHash("Product")
public class Product implements Serializable {
    @Id
    private int id;
    private  String name;
    private int qty;
    private double price;

}
