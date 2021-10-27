class n18248438 {
	private ByteArrayInputStream fetchUrl(String UNfTiVvR, Exception[] Ep6flGOM) {
		URL ucSr1Zto;
		try {
			ucSr1Zto = new URL(UNfTiVvR);
			InputStream pFn9XI4B = null;
			int Iitje011 = 65536;
			int XOzyTXkR = 0;
			byte[] MY9C5uoK = new byte[Iitje011];
			try {
				pFn9XI4B = ucSr1Zto.openStream();
				int iLU4XXKv;
				while ((iLU4XXKv = pFn9XI4B.read(MY9C5uoK, XOzyTXkR, MY9C5uoK.length - XOzyTXkR)) != -1) {
					XOzyTXkR += iLU4XXKv;
					if (XOzyTXkR == MY9C5uoK.length) {
						byte[] zXn7uEwT = new byte[XOzyTXkR + Iitje011];
						System.arraycopy(MY9C5uoK, 0, zXn7uEwT, 0, XOzyTXkR);
						MY9C5uoK = zXn7uEwT;
					}
				}
				return new ByteArrayInputStream(MY9C5uoK, 0, XOzyTXkR);
			} finally {
				if (pFn9XI4B != null) {
					try {
						pFn9XI4B.close();
					} catch (IOException Kmm3YHzn) {
					}
				}
			}
		} catch (Exception nB54H7kj) {
			Ep6flGOM[0] = nB54H7kj;
		}
		return null;
	}

}