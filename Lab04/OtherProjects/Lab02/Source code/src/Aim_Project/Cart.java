package Aim_Project;
public class Cart {
		public static final int MAX_NUMBERS_ORDERED = 20;
		private DigitalVideoDisc itemsOrdered[];
		private int qtyOrdered;
		public Cart() {
			itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	        qtyOrdered = 0;
		}
		public void addDigitalVideoDisc(DigitalVideoDisc disc) {
			if(qtyOrdered >= MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is almost full");
				return;
			}
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
		
		public float totalCost() {
			float total = 0;
			for (int i=0; i<qtyOrdered;i++) {
				total += itemsOrdered[i].getCost();
			}
			return total;
		}
		
		public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
			int find = -1;
			// Tìm vị trí vid cần xóa
			for (int i = 0 ; i<qtyOrdered ; i++) {
				if (itemsOrdered[i]==disc) {
					find = i;
					break;
				}
			}
			
			if (find == -1) {
				System.out.println("The dics wat not exist in the cart!");
				return;
			}
			
			// Thực hiện việc dịch chèn lên trước (vid cần xóa sẽ bị đè)
			for (int i = find ; i < qtyOrdered; i++) {
				itemsOrdered[find] = itemsOrdered[find+1];
			}
			
			// Vị trí cuối sẽ null vì bị xóa 1 vid r
			itemsOrdered[qtyOrdered - 1] = null;
			qtyOrdered--;
			System.out.println("The disc has been removed");	
		}
}
