package KiemTra;
import java.util.*;

public interface TileManager {
	public boolean addTile(Tile t);
	public boolean editTile(Tile t);
	public boolean delTile(Tile t); 
	public List<Tile> searchTile(String name);
	public List<Tile> sortedTile(double price);
}
