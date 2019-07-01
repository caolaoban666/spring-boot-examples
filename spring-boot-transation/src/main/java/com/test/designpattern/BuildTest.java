package com.test.designpattern;

/**
 * @author cyf
 * @description   建造者模式
 * @create 2019-04-29 9:29
 **/
public class BuildTest {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Product aProduct = manager.getAProduct();
        aProduct.showProduct(aProduct.getName(), aProduct.getAge());
        Product bProduct = manager.getBProduct();
        bProduct.showProduct(bProduct.getName(), bProduct.getAge());
    }
}

class Product {
    private String name;
    private int age;

    public void showProduct(String name, int age) {
        System.out.println("name is :" + name);
        System.out.println("age is :" + age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}


abstract class Builder {
    protected abstract void setPara(String name, int age);

    protected abstract Product getProduct();
}


class ConcreteBuilder extends Builder {

    private Product product = new Product();

    @Override
    protected void setPara(String name, int age) {
        product.setAge(age);
        product.setName(name);
    }

    @Override
    protected Product getProduct() {
        return product;
    }
}

class Manager {
    private Builder builder = new ConcreteBuilder();

    public Product getAProduct() {
        builder.setPara("a", 10);
        return builder.getProduct();
    }

    public Product getBProduct() {
        builder.setPara("b", 20);
        return builder.getProduct();
    }
}






