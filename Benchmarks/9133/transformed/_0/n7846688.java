class n7846688 {
	public void postData(String ROAT3WWx, String AiFwCggx, String vypKEbm8, String EJvoDg1n) throws Exception {
		if ((ROAT3WWx == null) || (ROAT3WWx.equals(""))) {
			ROAT3WWx = DEFAULT_PROTOCOL;
		}
		if ((AiFwCggx == null) || (AiFwCggx.equals(""))) {
			AiFwCggx = DEFAULT_HOST;
		}
		if (vypKEbm8 == null) {
			vypKEbm8 = DEFAULT_FORM;
		}
		if (EJvoDg1n == null) {
			throw new IllegalArgumentException("Invalid data");
		}
		URL qsOx5j1d = new URL(ROAT3WWx, AiFwCggx, vypKEbm8);
		URLConnection ACyI5xFO = qsOx5j1d.openConnection();
		ACyI5xFO.setDoOutput(true);
		ACyI5xFO.setDoInput(true);
		ACyI5xFO.setUseCaches(false);
		ACyI5xFO.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
		ACyI5xFO.setRequestProperty("Content-length", String.valueOf(EJvoDg1n.length()));
		PrintStream y75c9odH = new PrintStream(ACyI5xFO.getOutputStream(), true);
		y75c9odH.print(EJvoDg1n);
		y75c9odH.close();
		BufferedReader nF3DxmOk = new BufferedReader(new InputStreamReader(ACyI5xFO.getInputStream()));
		while (nF3DxmOk.readLine() != null) {
		}
		nF3DxmOk.close();
	}

}