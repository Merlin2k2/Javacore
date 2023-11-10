package KiemTra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import java.util.Comparator;
import java.util.*;
public class TileManager1 implements TileManager {
	static Scanner sc = new Scanner(System.in);
	public List<Tile> lst = new ArrayList<>(); 
	
	@Override
	public boolean addTile(Tile t) {
		if(!lst.contains(t)) {
			lst.add(t);
			return true;
		}
		return false;
	}

	@Override
	public boolean editTile(Tile t) {
	    int index = indexOfTile(t.getProduct_id());
	    t = new Tile(t.getProduct_id(), t.getProduct_name(), t.getProduct_price(), t.getProduct_total(), t.getTile_type(), t.getTile_long(), t.getTile_width());
	    if (index < 0) {
	      return false;
	    }
	    lst.set(index, t);
	    return true;

	}
	
	public int indexOfTile(long id) {
		int index = -1;
		for(int i = 0; i < lst.size(); i++) {
			if(lst.get(i).getProduct_id() == id)
				index = i;
		}
		return index;
	}
	
	@Override
	public boolean delTile(Tile t) {
		if(t == null) {
			return false;
		}
		lst.remove(t);
		return true;
	}

	@Override
	public List<Tile> searchTile(String name) {
		List<Tile> output = new ArrayList<>();
	    for (Tile tile : lst) {
	      if (tile.getProduct_name().equals(name)) {
	        output.add(tile);
	      }
	    }
	    return output;
	}

	public List<Tile> searchTile(double price) {
		List<Tile> output = new ArrayList<>();
	    for (Tile tile : lst) {
	      if (tile.getProduct_price() == price) {
	        output.add(tile);
	      }
	    }
	    return output;
	}	

	public List<Tile> searchTile1(String type) {
		List<Tile> output = new ArrayList<>();
	    for (Tile tile : lst) {
	      if (tile.getTile_type().equals(type)) {
	        output.add(tile);
	      }
	    }
	    return output;
	}	

	public void inDanhSachTile() {
		for (Tile tile : lst) {
			System.out.println(tile);
		}
	}
	@Override
	public List<Tile> sortedTile(double price) {
		List<Tile> lst1 = new ArrayList<>();
		for(Tile tile : lst) {
			if(tile.getProduct_price() >= price) {
				lst1.add(tile);
			}
		}
		System.out.println("Chon chieu sap xep|| 1: tăng dân, 2: giảm dần ");
		
		int isINC = sc.nextInt();
		if(isINC == 1) {
			Collections.sort(lst1, new SortedByPrice());
		}else {
			Collections.sort(lst1, new SortedByPrice().reversed());
		}
		return lst1;
	}

	public List<Tile> sortedTile(double longs, double width ) {
		List<Tile> lst1 = new ArrayList<>();
		for(Tile tile : lst) {
			if(tile.getTile_long()*tile.getTile_width() >= longs * width) {
				lst1.add(tile);
			}
		}
		System.out.println("Chon chieu sap xep|| 1: tăng dân, 2: giảm dần ");
	
		int isINC = sc.nextInt();
		if(isINC == 1) {
			Collections.sort(lst1, new SortedBySize());
		}else {
			Collections.sort(lst1, new SortedBySize().reversed());
		}
		return lst1;
	}
	
	public List<Tile> sortedTile(String type) {
		List<Tile> lst1 = new ArrayList<>();
		for(Tile t : lst) {
			if(t.getTile_type().compareToIgnoreCase(type) >= 0) {
				lst1.add(t);
			}
		}
		if(lst1.isEmpty()) {
			return null;
		} else {
			System.out.println("Chon chieu sap xep|| 1: tăng dân, 2: giảm dần");
			int isINC = sc.nextInt();
			if(isINC == 1) {
				Collections.sort(lst1, new SortedBySize());
			}else {
				Collections.sort(lst1, new SortedBySize().reversed());
			}
			return lst1;
		}
	}
}
class SortedByPrice implements Comparator<Tile> {
    // Ham so sanh 2 doi tuong 
    public int compare(Tile a, Tile b) {
        return (int) (a.getProduct_price() - b.getProduct_price());
    }

}
class SortedBySize implements Comparator<Tile> {
    // Ham so sanh 2 doi tuong 
    public int compare(Tile a, Tile b) {
        return (int) (a.getTile_long()*a.getTile_width() - b.getTile_long()*b.getTile_width());
    }

}
class sortedByName implements Comparator<Tile>{

	@Override
	public int compare(Tile o1, Tile o2) {
		// TODO Auto-generated method stub
		String type1 = o1.getTile_type();
		String type2 = o2.getTile_type();
		
		//Vi tri cat chi ten
		byte at = (byte)type1.lastIndexOf(" ");
		if(at!=-1) {
			type1 = type1.substring(at+1);
		}
		at = (byte)type2.lastIndexOf(" ");
		if(at!=-1) {
			type2 = type2.substring(at+1);
		}
		return type1.compareToIgnoreCase(type2);
	}
	
}
