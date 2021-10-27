class n22326008 {
	@Override
	public void sortArray(int[] On8W5fJ9) {
		boolean FJ07Y6um = false;
		while (FJ07Y6um == false) {
			FJ07Y6um = true;
			for (int RikHqZdY = 0; RikHqZdY <= On8W5fJ9.length - 2; RikHqZdY++) {
				if (On8W5fJ9[RikHqZdY] > On8W5fJ9[RikHqZdY + 1]) {
					int f0Y6fkPE = On8W5fJ9[RikHqZdY];
					On8W5fJ9[RikHqZdY] = On8W5fJ9[RikHqZdY + 1];
					On8W5fJ9[RikHqZdY + 1] = f0Y6fkPE;
					FJ07Y6um = false;
				}
			}
		}
	}

}