package pos2.test;
/**
 * 2016��10��14��
 * by lee
 * for��
 */
public class Client {  
    public static void main(String[] args){  
        Director director = new Director();  
        Product product1 = director.getAProduct();  
        product1.showProduct();  
  
        Product product2 = director.getBProduct();  
        product2.showProduct();  
    }  
} 

class Product {  
    private String name;  
    private String type;  
    public void showProduct(){  
        System.out.println("���ƣ�"+name);  
        System.out.println("�ͺţ�"+type);  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public void setType(String type) {  
        this.type = type;  
    }  
}  
  
abstract class Builder {  
    public abstract void setPart(String arg1, String arg2);  
    public abstract Product getProduct();  
}  
class ConcreteBuilder extends Builder {  
    private Product product = new Product();  
      
    public Product getProduct() {  
        return product;  
    }  
  
    public void setPart(String arg1, String arg2) {  
        product.setName(arg1);  
        product.setType(arg2);  
    }  
}  
  
  class Director {  
    private Builder builder = new ConcreteBuilder();  
    public Product getAProduct(){  
        builder.setPart("��������","X7");  
        return builder.getProduct();  
    }  
    public Product getBProduct(){  
        builder.setPart("�µ�����","Q5");  
        return builder.getProduct();  
    }  
}  
  