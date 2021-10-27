class n1274215 {
	public static void main(String[] xbDzwRlS) {
		try {
			if (xbDzwRlS.length < 2) {
				System.err.println("usage: test [src] [dest]");
				return;
			}
			FileInputStream R9zvdXox = new FileInputStream(xbDzwRlS[0]);
			FileOutputStream zD2Vzt7q = new FileOutputStream(xbDzwRlS[1]);
			FileChannel DFfDw5KZ = R9zvdXox.getChannel();
			FileChannel nGzaPNNP = zD2Vzt7q.getChannel();
			long v4P4VPDW = 0, Wrr7pDnU = DFfDw5KZ.size(), FbX2fKkb;
			while (Wrr7pDnU > 0) {
				if ((FbX2fKkb = nGzaPNNP.transferFrom(DFfDw5KZ, v4P4VPDW, Wrr7pDnU)) < 0)
					break;
				Wrr7pDnU -= FbX2fKkb;
				v4P4VPDW += FbX2fKkb;
			}
			zD2Vzt7q.close();
			R9zvdXox.close();
		} catch (IOException KohDb4yN) {
			KohDb4yN.printStackTrace();
		}
	}

}