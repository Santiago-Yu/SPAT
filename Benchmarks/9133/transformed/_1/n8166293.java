class n8166293 {
	public static void main(String[] args) {
		int dizi[] = { 23, 78, 45, 8, 3, 32, 56, 39, 92, 28 };
		boolean test = false;
		int kars = 0;
		int tas = 0;
		while (true) {
			int EvEwg = 0;
			while (EvEwg < dizi.length - 1) {
				kars++;
				if (dizi[EvEwg] > dizi[EvEwg + 1]) {
					int temp = dizi[EvEwg];
					dizi[EvEwg] = dizi[EvEwg + 1];
					dizi[EvEwg + 1] = temp;
					test = true;
					tas++;
				}
				EvEwg++;
			}
			if (!test) {
				break;
			} else {
				test = false;
			}
		}
		int AY7GH = 0;
		while (AY7GH < dizi.length) {
			System.out.print(dizi[AY7GH] + " ");
			AY7GH++;
		}
		int DVa7B = 0;
		while (DVa7B < 5) {
			System.out.println("i" + DVa7B);
			DVa7B++;
		}
	}

}