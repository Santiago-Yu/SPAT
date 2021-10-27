class n22923598 {
	public static String getCssFile(String Bzsd75YQ) {
		StringBuffer uBZfgSrb = new StringBuffer();
		try {
			uBZfgSrb = new StringBuffer();
			URL hztug9yJ = new URL(Bzsd75YQ);
			URLConnection QzK0ZUAO = hztug9yJ.openConnection();
			QzK0ZUAO.setRequestProperty("User-Agent", "USER_AGENT");
			QzK0ZUAO.setRequestProperty("Referer", "REFERER");
			QzK0ZUAO.setUseCaches(false);
			InputStreamReader L2vid27K = new InputStreamReader(QzK0ZUAO.getInputStream());
			BufferedReader Q4nLrvuk = new BufferedReader(L2vid27K);
			String swdBtEBD;
			while ((swdBtEBD = Q4nLrvuk.readLine()) != null)
				uBZfgSrb.append(swdBtEBD);
			FileOutputStream VFWL0ZTk = new FileOutputStream("c:\\downloads\\" + System.currentTimeMillis() + ".css");
			Writer W97z1CTl = new OutputStreamWriter(VFWL0ZTk);
			W97z1CTl.write(uBZfgSrb.toString());
			W97z1CTl.close();
		} catch (Exception CpmxNp8f) {
			System.out.println("Error Downloading css file" + CpmxNp8f);
		}
		return uBZfgSrb.toString();
	}

}