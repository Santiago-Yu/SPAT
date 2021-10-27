class n15568623 {
	public Resultado procesar() {
		if (resultado != null)
			return resultado;
		int[] a = new int[elems.size()];
		int w = 0;
		Iterator iter = elems.iterator();
		while (iter.hasNext()) {
			a[w] = ((Integer) iter.next()).intValue();
			w++;
		}
		long startTime = System.currentTimeMillis();
		int n = a.length;
		int i, j, temp;
		long endTime = System.currentTimeMillis();
		for (i = 0; i < n - 1; i++) {
			for (j = i; j < n - 1; j++) {
				if (a[i] > a[j + 1]) {
					temp = a[i];
					a[i] = a[j + 1];
					a[j + 1] = temp;
					pasos++;
				}
			}
		}
		resultado = new Resultado((int) (endTime - startTime), pasos, a.length);
		System.out.println("Resultado BB: " + resultado);
		return resultado;
	}

}