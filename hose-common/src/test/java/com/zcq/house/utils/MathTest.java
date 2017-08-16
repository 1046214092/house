package com.zcq.house.utils;

import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by changqingzhou on 2017/8/16.
 */
public class MathTest {

    @Test
    public  void   fc(){
        int len=10000000;
        double[] a= new double[len];
        double[] b= new double[len];
       Random r=new Random();
        for(int i=0;i!=len;i++){
           int index=i++;
            a[index]=r.nextDouble();
            b[index]=r.nextDouble();
        }
        double[] values = new double[] { 0.33d, 1.33,0.27333, 0.3, 0.501,

                0.444, 0.44, 0.34496, 0.33,0.3, 0.292, 0.667 };
        double[] values2 = new double[] { 0.23, 1.03,0.17333, 0.13, 0.2501,

                0.144, 0.044, 0.04496, 0.233,0.23, 0.1292, 0.6647 };
                values=a;
        values2=b;
        Variance variance = new Variance();//方差
        double evaluate = variance.evaluate(values);
        System.out.print(evaluate);
        Covariance covar=new Covariance();
        double covariance = covar.covariance(values, values2);
        System.out.print(covariance);

        Mean mean=new Mean();

        System.out.print(mean.evaluate(values));

        new Thread( () -> System.out.println("In Java8!") ).start();
        List list= Arrays.asList("1231","12131","1");
        list.forEach(n ->  System.err.println(n.hashCode()));
    }

}
