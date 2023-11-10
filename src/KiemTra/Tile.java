package KiemTra;

import java.util.Scanner;


public class Tile extends Product {
	
	public static final String TILE_TYPE = "No Tile_type";
	public static final double TILE_LONG = 0.0;
	public static final double TILE_WIDTH = 0.0;
	
	private String Tile_type;
	private double Tile_long;
	private double Tile_width;
	
	public Tile() {
		this(Tile.PRODUCT_ID, Tile.PRODUCT_NAME, Tile.PRODUCT_PRICE, Tile.PRODUCT_TOTAL, Tile.TILE_TYPE, Tile.TILE_LONG, Tile.TILE_WIDTH);
	}
	
	public Tile(long product_id, String product_name, double product_price, int product_total, String Tile_type, double Tile_long, double Tile_width) {
		super(product_id, product_name, product_price, product_total);
		this.Tile_type = Tile_type;
		this.Tile_long = Tile_long;
		this.Tile_width = Tile_width;
	}

	public String getTile_type() {
		return Tile_type;
	}

	public void setTile_type(String tile_type) {
		Tile_type = tile_type;
	}

	public double getTile_long() {
		return Tile_long;
	}

	public void setTile_long(double tile_long) {
		Tile_long = tile_long;
	}

	public double getTile_width() {
		return Tile_width;
	}

	public void setTile_width(double tile_width) {
		Tile_width = tile_width;
	}
	
	public String toString() {
		return super.toString()+" " + Tile_type + " "+ Tile_long +" " +Tile_width + "\n";
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj instanceof Tile) {
            Tile another = (Tile) obj;
            if (this.Tile_type.equals(another.Tile_type) &&
                this.Tile_long == another.Tile_long &&
                this.Tile_width == another.Tile_width) {
                    return true;
            }
        }
        return false;
    }
	public void intput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap id: ");
		setProduct_id(sc.nextLong());
		sc.nextLine();
	    System.out.println("Nhap name: ");
	    setProduct_name(sc.nextLine());
	    System.out.println("Nhap price: ");
	    setProduct_price(sc.nextLong());
	    System.out.println("Nhap total: ");
	    setProduct_total(sc.nextInt());
	    System.out.println("Nhap type: ");
	    sc.nextLine();
	    setTile_type(sc.nextLine());
	    System.out.println("Nhap long: ");
	    setTile_long(sc.nextDouble());
	    System.out.println("Nhap width: ");
	    setTile_width(sc.nextDouble());
	}
}

