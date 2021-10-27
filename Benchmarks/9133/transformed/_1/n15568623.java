class n15568623 {
	public Resultado procesar() {
		if (resultado != null)
			return resultado;
		int[] a = new int[elems.size()];
		Iterator iter = elems.iterator();
		int w = 0;
		while (iter.hasNext()) {
			a[w] = ((Integer) iter.next()).intValue();
			w++;
		}
		int n = a.length;
		long startTime = System.currentTimeMillis();
		int i, j, temp;
		i = 0;
		while (i < n - 1) {
			for (j = i; j < n - 1; j++) {
				if (a[i] > a[j + 1]) {
					temp = a[i];
					a[i] = a[j + 1];
					a[j + 1] = temp;
					pasos++;
				}
			}
			i++;
		}
		long endTime = System.currentTimeMillis();
		resultado = new Resultado((int) (endTime - startTime), pasos, a.length);
		System.out.println("Resultado BB: " + resultado);
		return resultado;
	}

}