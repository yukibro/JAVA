
class Heap2{
	int count;
	public Heap2() {
		count = 0;
	}
	
	void makeTreeHeap(int H[]) {
		int p = 0;
		int tmpData;
		count = H.length-1;
		
		for(int i = count/2; i>=1; i--) {
			p = i;
			for(int j=2*p; j<=count; j=2*j) {
				if(j<count) {
					if(H[j] < H[j+1]) {
						j = j+1;
					}
				}
				if(H[p] >= H[j]) {
					break;
				}
				tmpData = H[p];
				H[p] = H[j];
				H[j] = tmpData;
				p=j;
			}
		}
		for(int i = 1; i<=count; i++) {
			System.out.print(" " + H[i]);
		}
		System.out.println();
	}
}
public class Heap2main {

	public static void main(String[] args) {
		
		int a[] = {0, 15, 11, 7, 5, 13, 50};
		Heap2 hp2 = new Heap2();
		hp2.makeTreeHeap(a);

	}

}
