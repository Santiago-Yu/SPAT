class n9730236 {
	public static void copy(String Dn1OsGOF, String xgDM4am1) throws IOException {
		File Y4icDD9G = new File(Dn1OsGOF);
		File FnamdBWx = new File(xgDM4am1);
		FileInputStream DZa7uszD = null;
		FileOutputStream eCO2C2Fw = null;
		try {
			DZa7uszD = new FileInputStream(Y4icDD9G);
			eCO2C2Fw = new FileOutputStream(FnamdBWx);
			byte[] lZutHZ4b = new byte[4096];
			int WrLymRVw;
			while ((WrLymRVw = DZa7uszD.read(lZutHZ4b)) != -1)
				eCO2C2Fw.write(lZutHZ4b, 0, WrLymRVw);
		} finally {
			DZa7uszD.close();
			eCO2C2Fw.close();
		}
	}

}