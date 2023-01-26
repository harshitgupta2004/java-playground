public class GetterandSetter {
    public static void main(String args[]) {
        Pen p1 = new Pen(); //created a pen object called p1
        p1.setColor("Blue");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());

        p1.setColor("Yellow");
        System.out.println(p1.getColor());
    }
}

class Pen {
    
    private String color;
    private int tip;

    // Getters
    String getColor(){
        return this.color; //this keyword means current object
    }

    int getTip(){
        return this.tip;
    }
    
    // Setters
    void setColor(String newColor){ //color is set
        this.color = newColor; //jiss bhi onject me call kiya hai uska color
    }

    void setTip(int newTip){ //tip is set
        this.tip = newTip;
    }
}
