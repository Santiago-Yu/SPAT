class n7926874 {
	public static void main(String NBqFeahq[]) {
		try {
			String XYOGlRgY = NBqFeahq[0];
			String nfIIozA1 = NBqFeahq[1];
			java.io.FileInputStream AGfrKtbS = new java.io.FileInputStream(XYOGlRgY);
			ManagedMemoryDataSource BiO8BXwx = new ManagedMemoryDataSource(AGfrKtbS, 1024 * 1024, "foo/data", true);
			javax.activation.DataHandler GaxMEh2B = new javax.activation.DataHandler(BiO8BXwx);
			java.io.InputStream ZCYfwXIG = GaxMEh2B.getInputStream();
			java.io.FileOutputStream yuQVN980 = new java.io.FileOutputStream(nfIIozA1);
			byte[] h7xjZNKv = new byte[512];
			int zSzMxWFJ = 0;
			do {
				zSzMxWFJ = ZCYfwXIG.read(h7xjZNKv);
				if (zSzMxWFJ > 0) {
					yuQVN980.write(h7xjZNKv, 0, zSzMxWFJ);
				}
			} while (zSzMxWFJ > -1);
			yuQVN980.close();
			ZCYfwXIG.close();
		} catch (java.lang.Exception w6am805t) {
			log.error(Messages.getMessage("exception00"), w6am805t);
		}
	}

}