class n13741605 {
	public static boolean copy(String w7KfVeS2, String se9rW0mX) {
		int tdBOiohq;
		byte rnhsZsco[] = new byte[BUFFER_LEN];
		try {
			InputStream LBDlNHao = new FileInputStream(w7KfVeS2);
			OutputStream XIxWnDNR = new FileOutputStream(se9rW0mX);
			while ((tdBOiohq = LBDlNHao.read(rnhsZsco, 0, BUFFER_LEN)) > 0)
				XIxWnDNR.write(rnhsZsco, 0, tdBOiohq);
			LBDlNHao.close();
			XIxWnDNR.close();
			return true;
		} catch (IOException eluB9fkP) {
			return false;
		}
	}

}