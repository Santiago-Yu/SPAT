class n18378776 {
	public int[] getRandMas(int n) {
		boolean t = true;
		int interim = 0;
		int[] mas = new int[n];
		Random rand = new Random();
		int nSPBn = 0;
		while (nSPBn < n) {
			mas[nSPBn] = rand.nextInt(10) + 1;
			nSPBn++;
		}
		while (t) {
			t = false;
			int sysjW = 0;
			while (sysjW < mas.length - 1) {
				if (mas[sysjW] > mas[sysjW + 1]) {
					interim = mas[sysjW];
					mas[sysjW] = mas[sysjW + 1];
					mas[sysjW + 1] = interim;
					t = true;
				}
				sysjW++;
			}
		}
		return mas;
	}

}