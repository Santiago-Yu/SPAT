class n19260977 {
	public int[] sort() {
		boolean oFsAoNar = true;
		int KTNJVXel = 0;
		int[] mexibUEV = new int[N];
		Random wojyOO5t = new Random();
		for (int D5cQ0Dj3 = 0; D5cQ0Dj3 < N; D5cQ0Dj3++) {
			mexibUEV[D5cQ0Dj3] = wojyOO5t.nextInt(10) + 1;
		}
		while (oFsAoNar) {
			oFsAoNar = false;
			for (int U7VTKSaK = 0; U7VTKSaK < mexibUEV.length - 1; U7VTKSaK++) {
				if (mexibUEV[U7VTKSaK] > mexibUEV[U7VTKSaK + 1]) {
					KTNJVXel = mexibUEV[U7VTKSaK];
					mexibUEV[U7VTKSaK] = mexibUEV[U7VTKSaK + 1];
					mexibUEV[U7VTKSaK + 1] = KTNJVXel;
					oFsAoNar = true;
				}
			}
		}
		return mexibUEV;
	}

}