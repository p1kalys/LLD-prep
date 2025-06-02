interface Burger {
    void prepare();
}

class BasicBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing a basic burger with bun and patty.");
    }
}

class StandardBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing a standard burger with bun, patty, cheese, lettuce, and tomato.");
    }
}

class PremiumBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing a premium burger with gourmet bun, patty, cheese, lettuce, tomato, and special sauce.");
    }
}

class BasicWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing a basic wheat burger with bun, patty, and cheese.");
    }
}
class StandardWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing a standard wheat burger with bun, patty, cheese, lettuce, and tomato.");
    }
}
class PremiumWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing a premium wheat burger with gourmet bun, patty, cheese, lettuce, tomato, and special sauce.");
    }
}

interface GarlicBread {
    void prepare();
}

class BasicGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing basic garlic bread with butter and garlic.");
    }
}

class CheeseGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing cheese garlic bread with butter, garlic, and cheese.");
    }
}

class BasicWheatGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing basic wheat garlic bread with butter and garlic.");
    }
}
class CheeseWheatGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing cheese wheat garlic bread with butter, garlic, and cheese.");
    }
}

interface FoodFactory {
    Burger createBurger(String type);
    GarlicBread createGarlicBread(String type);
}

class SinghBakery implements FoodFactory {
    public Burger createBurger(String type) {
        if (type.equals("basic")) {
            return new BasicBurger();
        } else if (type.equals("standard")) {
            return new StandardBurger();
        } else if (type.equals("premium")) {
            return new PremiumBurger();
        }
        return null;
    }

    public GarlicBread createGarlicBread(String type) {
        if (type.equals("basic")) {
            return new BasicGarlicBread();
        } else if (type.equals("cheese")) {
            return new CheeseGarlicBread();
        }
        return null;
    }
}

class KingBakery implements FoodFactory {
    public Burger createBurger(String type) {
        if (type.equals("basic")) {
            return new BasicWheatBurger();
        } else if (type.equals("standard")) {
            return new StandardWheatBurger();
        } else if (type.equals("premium")) {
            return new PremiumWheatBurger();
        }
        return null;
    }

    public GarlicBread createGarlicBread(String type) {
        if (type.equals("basic")) {
            return new BasicWheatGarlicBread();
        } else if (type.equals("cheese")) {
            return new CheeseWheatGarlicBread();
        }
        return null;
    }
}

public class AbstractFactoryPattern {

    public static void main(String[] args) {
        FoodFactory singhBakery = new SinghBakery();
        Burger singhBurger = singhBakery.createBurger("premium");
        GarlicBread singhGarlicBread = singhBakery.createGarlicBread("cheese");

        singhBurger.prepare();
        singhGarlicBread.prepare();

        FoodFactory kingBakery = new KingBakery();
        Burger kingBurger = kingBakery.createBurger("standard");
        GarlicBread kingGarlicBread = kingBakery.createGarlicBread("basic");

        kingBurger.prepare();
        kingGarlicBread.prepare();
    }
}