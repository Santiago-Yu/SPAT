class n15568623 {
	public Resultado procesar() {
		if (resultado != null)
			return resultado;
		int[] aHt2MldP = new int[elems.size()];
		Iterator UnGZ15YK = elems.iterator();
		int kEZhk1BX = 0;
		while (UnGZ15YK.hasNext()) {
			aHt2MldP[kEZhk1BX] = ((Integer) UnGZ15YK.next()).intValue();
			kEZhk1BX++;
		}
		int dx5qSAwn = aHt2MldP.length;
		long JoIJ636U = System.currentTimeMillis();
		int CCVaxpxA, oQvS6ZoV, REIgPnWU;
		for (CCVaxpxA = 0; CCVaxpxA < dx5qSAwn - 1; CCVaxpxA++) {
			for (oQvS6ZoV = CCVaxpxA; oQvS6ZoV < dx5qSAwn - 1; oQvS6ZoV++) {
				if (aHt2MldP[CCVaxpxA] > aHt2MldP[oQvS6ZoV + 1]) {
					REIgPnWU = aHt2MldP[CCVaxpxA];
					aHt2MldP[CCVaxpxA] = aHt2MldP[oQvS6ZoV + 1];
					aHt2MldP[oQvS6ZoV + 1] = REIgPnWU;
					pasos++;
				}
			}
		}
		long wGtjK7ej = System.currentTimeMillis();
		resultado = new Resultado((int) (wGtjK7ej - JoIJ636U), pasos, aHt2MldP.length);
		System.out.println("Resultado BB: " + resultado);
		return resultado;
	}

}