class n23403205 {
	public void copyFile(File nAZfesBJ, String Q2O4JORH, boolean XRjVlB1H, boolean G8ZcVEYo)
			throws FileNotFoundException, IOException {
		FileInputStream q4X3bY2P = null;
		FileOutputStream a4gah70u = null;
		byte[] Cc3V2agR;
		int iocyt2em;
		File AaZQi4nz = new File(Q2O4JORH);
		if (XRjVlB1H && !AaZQi4nz.exists())
			AaZQi4nz.mkdirs();
		if (AaZQi4nz.exists()) {
			File GnC0JimE = new File(Q2O4JORH + "/" + nAZfesBJ.getName());
			try {
				if (!GnC0JimE.exists() || G8ZcVEYo) {
					q4X3bY2P = new FileInputStream(nAZfesBJ);
					a4gah70u = new FileOutputStream(GnC0JimE);
					Cc3V2agR = new byte[1024];
					while (true) {
						iocyt2em = q4X3bY2P.read(Cc3V2agR);
						if (iocyt2em == -1)
							break;
						a4gah70u.write(Cc3V2agR, 0, iocyt2em);
					}
				}
			} catch (Exception RQjnrvBF) {
				RQjnrvBF.printStackTrace();
			} finally {
				if (q4X3bY2P != null)
					try {
						q4X3bY2P.close();
					} catch (IOException QciBzrog) {
					}
				if (a4gah70u != null)
					try {
						a4gah70u.close();
					} catch (IOException wUUfUYop) {
					}
			}
		}
	}

}