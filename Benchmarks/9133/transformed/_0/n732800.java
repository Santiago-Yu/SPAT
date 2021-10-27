class n732800 {
	public BufferedWriter createOutputStream(String dBH25R1W, String luLpoGng) throws IOException {
		int KWgeVZeE = 1024;
		int lELwq3PY;
		char[] iaKsQmf5 = new char[KWgeVZeE];
		File C77nX0JN = new File(luLpoGng);
		ZipOutputStream zoHEWG77 = new ZipOutputStream(new FileOutputStream(C77nX0JN));
		zoHEWG77.setMethod(ZipOutputStream.DEFLATED);
		OutputStreamWriter zGebQMZm = new OutputStreamWriter(zoHEWG77, "ISO-8859-1");
		BufferedWriter iOYsJFFT = new BufferedWriter(zGebQMZm);
		ZipEntry NJGPOaqL = null;
		File Juf9Oy7H = new File(dBH25R1W);
		ZipInputStream ibuFmM1t = new ZipInputStream(new FileInputStream(Juf9Oy7H));
		InputStreamReader W6BCD6RV = new InputStreamReader(ibuFmM1t, "ISO-8859-1");
		BufferedReader JeayJT7v = new BufferedReader(W6BCD6RV);
		ZipEntry wqWwbweV = null;
		while ((wqWwbweV = ibuFmM1t.getNextEntry()) != null) {
			if (wqWwbweV.getName().equals("content.xml")) {
				continue;
			}
			NJGPOaqL = new ZipEntry(wqWwbweV.getName());
			zoHEWG77.putNextEntry(NJGPOaqL);
			while ((lELwq3PY = JeayJT7v.read(iaKsQmf5, 0, KWgeVZeE)) >= 0)
				iOYsJFFT.write(iaKsQmf5, 0, lELwq3PY);
			iOYsJFFT.flush();
			zoHEWG77.closeEntry();
		}
		zoHEWG77.putNextEntry(new ZipEntry("content.xml"));
		iOYsJFFT.flush();
		zGebQMZm = new OutputStreamWriter(zoHEWG77, "UTF8");
		iOYsJFFT = new BufferedWriter(zGebQMZm);
		return iOYsJFFT;
	}

}