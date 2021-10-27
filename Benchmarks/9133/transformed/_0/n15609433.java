class n15609433 {
	public static int[] bubbleSort2(int[] CY9cB61y) {
		if (null != CY9cB61y && CY9cB61y.length > 0) {
			boolean qxPJunzB = false;
			while (!qxPJunzB) {
				for (int CxAHBdfC = 0; CxAHBdfC < CY9cB61y.length - 1; CxAHBdfC++) {
					if (CY9cB61y[CxAHBdfC] > CY9cB61y[CxAHBdfC + 1]) {
						int pFjMSeVA = CY9cB61y[CxAHBdfC];
						CY9cB61y[CxAHBdfC] = CY9cB61y[CxAHBdfC + 1];
						CY9cB61y[CxAHBdfC + 1] = pFjMSeVA;
						break;
					} else if (CxAHBdfC == CY9cB61y.length - 2) {
						qxPJunzB = true;
					}
				}
			}
		}
		return CY9cB61y;
	}

}