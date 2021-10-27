class n8227164 {
	static int[] bubble(int[] UTTdzTU4) {
		boolean ECf5KOAR = true;
		while (ECf5KOAR) {
			ECf5KOAR = false;
			for (int xBQGwfgp = 0; xBQGwfgp < UTTdzTU4.length - 1; xBQGwfgp++) {
				if (UTTdzTU4[xBQGwfgp] > UTTdzTU4[xBQGwfgp + 1]) {
					int CcdKKuZL = UTTdzTU4[xBQGwfgp];
					UTTdzTU4[xBQGwfgp] = UTTdzTU4[xBQGwfgp + 1];
					UTTdzTU4[xBQGwfgp + 1] = CcdKKuZL;
					ECf5KOAR = true;
				}
			}
		}
		return UTTdzTU4;
	}

}