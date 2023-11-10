package KiemTra;

import java.util.*;
import KiemTra.TileManager1;
import KiemTra.*;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TileManager1 TM = new TileManager1();
		while(true) {
			System.out.println("===============================MENU===============================");
			System.out.println("Enter 1: Add new Tile");
			System.out.println("Enter 2: Edit Tile");
			System.out.println("Enter 3: Delete Tile");
			System.out.println("Enter 4: Search Tile");
			System.out.println("Enter 5: Sort List Tile");
			System.out.println("Enter 6: Show List Tile");
			System.out.println("Enter 0: Exit");
			int number = sc.nextInt();
			switch(number) {
				case 1:{
					
					Tile newTile = new Tile();
					newTile.intput();
					TM.addTile(newTile);
					System.out.println(newTile.toString());
					break;
				}
				case 2:{
					Tile t = new Tile();
					t.intput();
					if(TM.editTile(t)) {
						System.out.println("Sua thanh cong");
					} else {
						System.out.println("Sua that bai");
					}
					break;
				}
				case 3:{
					Tile newTile = new Tile();
					newTile.intput();
					TM.delTile(newTile);
				}
				case 4:{
					sc.nextLine();
					System.out.println("Enter Name: ");
					String name = sc.nextLine();
					System.out.println("Enter price: ");
					double price = sc.nextDouble();
					sc.nextLine();
					System.out.println("Enter type: ");
					String type = sc.nextLine();
					System.out.println(TM.searchTile(name));
					System.out.println(TM.searchTile(price));
					System.out.println(TM.searchTile(type));
					break;
				}
				case 5:{
					System.out.println("Sap xep theo gia: ");
					System.out.println("Nhap price: ");
					double price = sc.nextDouble();
					System.out.println(TM.sortedTile(price));
					System.out.println("Sap xep theo size");
					double longs, width;
					System.out.println("Nhap long: ");
					longs = sc.nextDouble();
					System.out.println("Nhap width");
					width = sc.nextDouble();
					System.out.println(TM.sortedTile(longs, width));
					System.out.println("Sap xep theo cong dung");
					sc.nextLine();
					System.out.println("Nhap type");
					String type = sc.nextLine();
					System.out.println(TM.sortedTile(type));
					break;
				}
				case 6:{
					TM.inDanhSachTile();
					break;
				}
				case 0:{
					return;
				}
				default:
                    System.out.println("Invalid");
                    continue;
			}
		}
	}
}
