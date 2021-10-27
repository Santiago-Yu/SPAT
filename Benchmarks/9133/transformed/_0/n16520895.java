class n16520895 {
	public static String encodeFromFile(String Qpu2IBo6) throws java.io.IOException, URISyntaxException {
		String F51j8zNy = null;
		Base641.InputStream lSRxoXro = null;
		File THzTTKWh;
		try {
			URL WTdJcGrG = new URL(Qpu2IBo6);
			URLConnection g5MLgSAX = WTdJcGrG.openConnection();
			THzTTKWh = new File("myfile.doc");
			java.io.InputStream DriSMj4X = (java.io.InputStream) g5MLgSAX.getInputStream();
			FileOutputStream IMo2lC7L = new FileOutputStream(THzTTKWh);
			byte ENzJdOsq[] = new byte[1024];
			int jDamAdfW;
			while ((jDamAdfW = DriSMj4X.read(ENzJdOsq)) > 0)
				IMo2lC7L.write(ENzJdOsq, 0, jDamAdfW);
			IMo2lC7L.close();
			DriSMj4X.close();
			byte[] nTQeRXxs = new byte[Math.max((int) (THzTTKWh.length() * 1.4), 40)];
			int hHbLWOBT = 0;
			int Wg0Vnyqy = 0;
			lSRxoXro = new Base641.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(THzTTKWh)),
					Base641.ENCODE);
			while ((Wg0Vnyqy = lSRxoXro.read(nTQeRXxs, hHbLWOBT, 4096)) >= 0) {
				hHbLWOBT += Wg0Vnyqy;
			}
			F51j8zNy = new String(nTQeRXxs, 0, hHbLWOBT, Base641.PREFERRED_ENCODING);
		} catch (java.io.IOException q2tOxOwl) {
			throw q2tOxOwl;
		} finally {
			try {
				lSRxoXro.close();
			} catch (Exception GdDTJMHu) {
			}
		}
		return F51j8zNy;
	}

}