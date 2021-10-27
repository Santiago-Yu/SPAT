class n18310020 {
	public static String postToAddress(Map<String, String> hEJD2Ibn, String Yfb9cT8O) throws Exception {
		String I7qSMMoY = "";
		String tzuhidzl = "";
		for (String aGujUGu6 : hEJD2Ibn.keySet()) {
			I7qSMMoY += tzuhidzl + URLEncoder.encode(aGujUGu6, "UTF-8") + "="
					+ URLEncoder.encode(hEJD2Ibn.get(aGujUGu6), "UTF-8");
			tzuhidzl = "&";
		}
		System.out.println("sending: " + I7qSMMoY);
		URL x2o0DTDu = new URL(Yfb9cT8O);
		URLConnection a52A7yKn = x2o0DTDu.openConnection();
		a52A7yKn.setDoOutput(true);
		OutputStreamWriter s8d42uOY = new OutputStreamWriter(a52A7yKn.getOutputStream());
		s8d42uOY.write(I7qSMMoY);
		s8d42uOY.flush();
		StringBuilder RPPkwEDU = new StringBuilder();
		BufferedReader QyIi6tdP = new BufferedReader(new InputStreamReader(a52A7yKn.getInputStream()));
		String gf3pdzuy;
		while ((gf3pdzuy = QyIi6tdP.readLine()) != null) {
			RPPkwEDU.append(gf3pdzuy + System.getProperty("line.separator"));
		}
		s8d42uOY.close();
		QyIi6tdP.close();
		return RPPkwEDU.toString();
	}

}