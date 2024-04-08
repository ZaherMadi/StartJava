
public class Item {
    private String name;
    private long price;

    public Item(String name, long price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public long getPrice(){
        return this.price;
    }

   
}