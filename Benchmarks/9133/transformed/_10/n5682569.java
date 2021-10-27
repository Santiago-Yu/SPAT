class n5682569 {
	public void metodo1() {
		boolean flagDesordenado = true;
		int temp;
		while (flagDesordenado) {
			flagDesordenado = false;
			for (int i = 0; i < this.tamanoTabla - 1; i++) {
				if (tabla[i] > tabla[i + 1]) {
					temp = tabla[i];
					flagDesordenado = true;
					tabla[i] = tabla[i + 1];
					tabla[i + 1] = temp;
				}
			}
		}
	}

}