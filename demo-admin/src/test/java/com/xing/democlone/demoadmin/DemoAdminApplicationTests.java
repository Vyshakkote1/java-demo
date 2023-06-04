package com.xing.democlone.demoadmin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;

@SpringBootTest
class DemoAdminApplicationTests {

    @Test
    void contextLoads() {
//        String s1="bank",s2="kanb";
//        char[] ss1=s1.toCharArray(),ss2=s2.toCharArray();
//        Arrays.sort(ss1);
//        Arrays.sort(ss2);
//        System.out.println(ss1);
//        System.out.println(ss2);
////        System.out.println(ss1==ss2);
//        System.out.println(Arrays.equals(ss1,ss2));

        Integer []num = {1,2,3};
        Arrays.sort(num, Collections.reverseOrder());
        System.out.println(num.toString());

    }

}
