class n11941960 {
	String[] openUrlAsList(String suCsCVyH) {
		IJ.showStatus("Connecting to " + IJ.URL);
		Vector DZesWkZ7 = new Vector();
		try {
			URL DEFZSZUb = new URL(suCsCVyH);
			InputStream Sx4YfRHW = DEFZSZUb.openStream();
			BufferedReader btI0u8MI = new BufferedReader(new InputStreamReader(Sx4YfRHW));
			String T5CKsagh;
			while (true) {
				T5CKsagh = btI0u8MI.readLine();
				if (T5CKsagh == null)
					break;
				if (!T5CKsagh.equals(""))
					DZesWkZ7.addElement(T5CKsagh);
			}
			btI0u8MI.close();
		} catch (Exception Tm11ToJI) {
		}
		String[] Hvmx2t9e = new String[DZesWkZ7.size()];
		DZesWkZ7.copyInto((String[]) Hvmx2t9e);
		IJ.showStatus("");
		return Hvmx2t9e;
	}

}