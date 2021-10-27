class n5682569 {
	public void metodo1() {
		int temp;
		boolean flagDesordenado = true;
		while (flagDesordenado) {
			flagDesordenado = false;
			for (int i = 0; i < this.tamanoTabla - 1; i++) {
				int C5DG9CPM = i + 1;
				if (tabla[i] > tabla[C5DG9CPM]) {
					flagDesordenado = true;
					temp = tabla[i];
					tabla[i] = tabla[i + 1];
					tabla[i + 1] = temp;
				}
			}
		}
	}

}