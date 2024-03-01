package com.javaman.webprojectlearn.utils;


import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /**
        * 1.	张三和李四工作日中午去面馆吃面，面馆的价格如下：
	大碗	中碗	小碗
牛肉面	18元	16元	14元
肥肠面	20元	18元	16元
牛肉饼	10元
奶茶	12元
套餐1	38元（1大碗牛肉面+1个牛肉饼+1杯奶茶）
套餐2	40元（1大碗肥肠面+1个牛肉饼+1杯奶茶）

张三吃了套餐1+1个牛肉饼，李四吃了一碗中碗的肥肠面+2杯奶茶（面馆工作日不打折，节假日会有满减或者折扣之类的活动），
* 请用java程序实现张三和李四分别要向面馆付款多少钱。

        * */
        List<Product> zhangsanProducts = Arrays.asList(new Product(4, 0, 1),new Product(2,0,1));
        System.out.println("张三支付价格为"+pay(zhangsanProducts,0));

        List<Product> lisiProducts = Arrays.asList(new Product(1, 1, 1),new Product(3,0,2));
        System.out.println("李四支付价格为"+pay(lisiProducts,0));
    }

    /**
     * @param products 表示买的食品参数
     * @param activityType 表示活动类型
     * */
    public static double pay(List<Product> products,int activityType){
        // 定义面馆的价格
        double[][] prices = {
                {18, 16, 14},   // 牛肉面的价格，依次为大碗、中碗、小碗
                {20, 18, 16},   // 肥肠面的价格，依次为大碗、中碗、小碗
                {10},           // 牛肉饼的价格
                {12},          // 奶茶的价格
                {38},           //套餐1的价格
                {40}            //套餐2的价格
        };
        double price=0;
        for (Product product:products
             ) {
            int food = product.getFood();
            int size = product.getSize();
            price=price+prices[food][size]*product.getCount();
        }

        //满减或者折扣活动
        if (1==activityType){
            //1表示开启满减活动,这里满减直接写死，也可以直接传进来
            if (price>30){
                price=price-2;
            }
        }else if (2==activityType){
            //2表示开启折扣，这里折扣直接写死，也可以传进来
            price=price*0.9;
        }
        return price;

    }


    public static class Product{
        /**
         * 食品类型: 0表示牛肉面  1表示肥肠面 2表示牛肉饼 3表示奶茶 4表示套餐1 5表示套餐2
         * */
        int food;

        // 食品大小
        int size;

        // 数量
        int count;

        public Product(int food, int size, int count) {
            this.food = food;
            this.size = size;
            this.count = count;
        }

        public int getFood() {
            return food;
        }

        public void setFood(int food) {
            this.food = food;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
