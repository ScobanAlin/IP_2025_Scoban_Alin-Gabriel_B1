import java.util.ArrayList;
import java.util.List;

interface Details {
    String getDetails();
}

abstract class Produs {
    protected int price;
    protected int stock;

    public abstract int getStock();
    public abstract int getPrice();
    public abstract String getType();
}

enum Model {
    LAPTOP, PHONE, TV
}

class Electronice extends Produs implements Details {
    private Model model;

    public Electronice(int price, int stock, Model model) {
        this.price = price;
        this.stock = stock;
        this.model = model;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return "Electronice";
    }

    public String getType()
    {
        return 
    }

    @Override
    public String getDetails() {
        return "Electronic -> Model: " + model + ", Price: " + price + " $";
    }
    
}

class Clothes extends Produs implements Details {
    private String size;

    public Clothes(int price, int stock) {
        this.price = price;
        this.stock = stock;
        this.size = "XS";
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return "Clothes";
    }

    @Override
    public String getDetails() {
        return "Clothing -> Size: " + size + ", Price: " + price + " $";
    }
}

class Cosmetics extends Produs implements Details {
    private int volume;

    public Cosmetics(int price, int stock) {
        this.price = price;
        this.stock = stock;
        this.volume = 30;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return "Cosmetics";
    }

    @Override
    public String getDetails() {
        return "Cosmetics -> Volume: " + volume + " ml, Price: " + price + " $";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Produs> produse = new ArrayList<>();

        produse.add(new Electronice(3000, 5, Model.LAPTOP));
        produse.add(new Clothes(50, 20));
        produse.add(new Cosmetics(100, 15));

        for (Produs p : produse) {
            if (p instanceof Details) {
                Details details = (Details) p;
                System.out.println("Details: " + details.getDetails());
            }

        }
    }
}
