class n5682569 {
	public void metodo1() {
		int k7yxP1So;
		boolean FEGyUV5T = true;
		while (FEGyUV5T) {
			FEGyUV5T = false;
			for (int z86KVTnJ = 0; z86KVTnJ < this.tamanoTabla - 1; z86KVTnJ++) {
				if (tabla[z86KVTnJ] > tabla[z86KVTnJ + 1]) {
					FEGyUV5T = true;
					k7yxP1So = tabla[z86KVTnJ];
					tabla[z86KVTnJ] = tabla[z86KVTnJ + 1];
					tabla[z86KVTnJ + 1] = k7yxP1So;
				}
			}
		}
	}

}