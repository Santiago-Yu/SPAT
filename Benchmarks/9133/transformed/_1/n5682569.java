class n5682569 {
	public void metodo1() {
		int temp;
		boolean flagDesordenado = true;
		while (flagDesordenado) {
			flagDesordenado = false;
			int Jc7UL = 0;
			while (Jc7UL < this.tamanoTabla - 1) {
				if (tabla[Jc7UL] > tabla[Jc7UL + 1]) {
					flagDesordenado = true;
					temp = tabla[Jc7UL];
					tabla[Jc7UL] = tabla[Jc7UL + 1];
					tabla[Jc7UL + 1] = temp;
				}
				Jc7UL++;
			}
		}
	}

}