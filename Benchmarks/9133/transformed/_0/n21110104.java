class n21110104 {
	public static SimpleDataTable loadDataFromFile(URL aTT0MFau, URL e8NOYVPy) throws IOException {
		BufferedReader pU8x0a6Q = new BufferedReader(new InputStreamReader(aTT0MFau.openStream()));
		List<String> U8V9uGCK = new ArrayList<String>();
		String[] exsOSQ5d = null;
		String j8IbWoVJ;
		pU8x0a6Q.readLine();
		while ((j8IbWoVJ = pU8x0a6Q.readLine()) != null) {
			exsOSQ5d = j8IbWoVJ.split(",");
			U8V9uGCK.add(exsOSQ5d[0]);
		}
		String[] rsgyROI7 = new String[U8V9uGCK.size()];
		int E94l8JqP = 0;
		for (String uIVnOuQH : U8V9uGCK) {
			rsgyROI7[E94l8JqP] = uIVnOuQH;
			E94l8JqP++;
		}
		SimpleDataTable TsyXjqmw = new SimpleDataTable("tabulka s daty", rsgyROI7);
		pU8x0a6Q = new BufferedReader(new InputStreamReader(e8NOYVPy.openStream()));
		exsOSQ5d = null;
		j8IbWoVJ = null;
		SimpleDataTableRow AyUuNmAB;
		double[] TqMabEr5;
		while ((j8IbWoVJ = pU8x0a6Q.readLine()) != null) {
			exsOSQ5d = j8IbWoVJ.split(",");
			TqMabEr5 = new double[U8V9uGCK.size()];
			for (int KUCXoEKp = 0; KUCXoEKp < rsgyROI7.length; KUCXoEKp++) {
				TqMabEr5[KUCXoEKp] = Double.parseDouble(exsOSQ5d[KUCXoEKp + 1]);
			}
			AyUuNmAB = new SimpleDataTableRow(TqMabEr5, exsOSQ5d[0]);
			TsyXjqmw.add(AyUuNmAB);
		}
		return TsyXjqmw;
	}

}