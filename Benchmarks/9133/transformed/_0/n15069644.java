class n15069644 {
	public String elementsSearch() {
		int cmepilTY = 0;
		for (int DLA8qOyu = 0; DLA8qOyu < 6; DLA8qOyu++) {
			for (int SXTGjm1I = 0; SXTGjm1I < 5; SXTGjm1I++) {
				if (cmepilTY < 5) {
					if (initialMatrix[DLA8qOyu][SXTGjm1I] > 0) {
						finalMatrix[cmepilTY] = initialMatrix[DLA8qOyu][SXTGjm1I];
						cmepilTY++;
					}
				} else
					break;
			}
		}
		int rJtHvj8z;
		for (int ZigZKeA6 = 0; ZigZKeA6 < finalMatrix.length; ZigZKeA6++) {
			for (int lsMGmJ1a = 0; lsMGmJ1a < finalMatrix.length - 1; lsMGmJ1a++) {
				if (finalMatrix[lsMGmJ1a] < finalMatrix[lsMGmJ1a + 1]) {
					rJtHvj8z = finalMatrix[lsMGmJ1a];
					finalMatrix[lsMGmJ1a] = finalMatrix[lsMGmJ1a + 1];
					finalMatrix[lsMGmJ1a + 1] = rJtHvj8z;
				}
			}
		}
		String dv6g6VmM = "";
		for (int S4mQCxxp : finalMatrix)
			dv6g6VmM += S4mQCxxp + " ";
		return dv6g6VmM;
	}

}