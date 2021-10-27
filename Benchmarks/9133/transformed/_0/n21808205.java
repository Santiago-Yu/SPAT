class n21808205 {
	public static String ReadURLString(String HeNjFZRl) throws IOException {
		try {
			URL TR5qICwp = new URL(HeNjFZRl);
			InputStream QmQSF9x4 = TR5qICwp.openStream();
			InputStreamReader BQpk3eRx = new InputStreamReader(QmQSF9x4);
			BufferedReader jY1yfE01 = new BufferedReader(BQpk3eRx);
			String qhQAtMVZ;
			String KKQ8n6P6 = "";
			int rAoltlq4 = 0;
			while ((qhQAtMVZ = jY1yfE01.readLine()) != null) {
				KKQ8n6P6 += qhQAtMVZ + "\n";
			}
			QmQSF9x4.close();
			BQpk3eRx.close();
			jY1yfE01.close();
			return KKQ8n6P6;
		} catch (Exception JKQk1pcW) {
			JKQk1pcW.printStackTrace();
		}
		return "";
	}

}