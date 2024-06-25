package com.example.elasticsearch;

import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class MTest {
    @Test
    public void mTest(){
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(random.nextInt(60 - 18) + 18);
//            System.out.println(random.nextBoolean());
//        }

        int randomY1 = RandomUtil.randomInt(2005,2020);
        int randomY2 = RandomUtil.randomInt(randomY1+1,2023);
        System.out.println(randomY1);
        System.out.println(randomY2);

    }


}
