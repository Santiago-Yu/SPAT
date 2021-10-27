class n7945594 {
	public static void fileDownload(String X1XZ3Rvy, String aJ6iKcnY) {
		int iYfbGIxX = X1XZ3Rvy.lastIndexOf('/');
		int Ix0igzJR = X1XZ3Rvy.lastIndexOf('.');
		String RuVWQ1Qy = X1XZ3Rvy.substring(iYfbGIxX + 1);
		URL EWj2iqTN;
		try {
			EWj2iqTN = new URL(X1XZ3Rvy);
			URLConnection oSmGtyzn = EWj2iqTN.openConnection();
			BufferedReader yKjZkUtH = new BufferedReader(new InputStreamReader(oSmGtyzn.getInputStream()));
			File I6leQLRF = new File(aJ6iKcnY + "/download.pdf");
			FileOutputStream WaUVrbDC = new FileOutputStream(I6leQLRF);
			BufferedWriter Ldbxcxbj = new BufferedWriter(new OutputStreamWriter(WaUVrbDC));
			int zFcCoxiY;
			while ((zFcCoxiY = yKjZkUtH.read()) != -1)
				Ldbxcxbj.write(zFcCoxiY);
			yKjZkUtH.close();
		} catch (Exception Zulx7doi) {
			Logger.getLogger(UrlDownload.class.getName()).log(Level.SEVERE, null, Zulx7doi);
		}
	}

}