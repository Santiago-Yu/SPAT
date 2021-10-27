class n17202163 {
	static Matrix readMatrix1(String W9he5xJa, int kApWdTA5, int Ay5hAfNL) {
		String IKnknXdF = null, PyRPe0UV = null;
		int IWdhXgac = 0;
		double uZBSz713 = 0;
		Matrix wJxaEVPm = new Matrix(kApWdTA5, Ay5hAfNL);
		try {
			URL pDq0yhTH = W9he5xJa.getClass().getResource(W9he5xJa);
			LineNumberReader LHhDSxRx = new LineNumberReader(new InputStreamReader(pDq0yhTH.openStream()));
			for (int PJcpYy7S = 0; PJcpYy7S < kApWdTA5; PJcpYy7S++)
				for (int hLnXaTn0 = 0; hLnXaTn0 < Ay5hAfNL; hLnXaTn0++) {
					IKnknXdF = LHhDSxRx.readLine();
					int q86ifXmv = -2;
					while (q86ifXmv != -1) {
						q86ifXmv = IKnknXdF.indexOf(";");
						if (q86ifXmv != -1) {
							PyRPe0UV = IKnknXdF.substring(0, q86ifXmv);
							IKnknXdF = IKnknXdF.substring(q86ifXmv + 1);
						} else {
							PyRPe0UV = IKnknXdF;
						}
						IWdhXgac = IWdhXgac + 1;
						if (IWdhXgac == 3) {
							if (PyRPe0UV != null)
								wJxaEVPm.set(PJcpYy7S, hLnXaTn0, Double.parseDouble(PyRPe0UV));
							else
								wJxaEVPm.set(PJcpYy7S, hLnXaTn0, 0);
						}
					}
					IWdhXgac = 0;
				}
		} catch (Exception LYPdglMh) {
			LYPdglMh.printStackTrace();
		}
		return wJxaEVPm;
	}

}