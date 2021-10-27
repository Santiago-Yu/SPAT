class n120346 {
	private static String getDocumentAt(String ZGqaCJnR) {
		StringBuffer YfKlSPx4 = new StringBuffer();
		try {
			URL gdFbnFxN = new URL(ZGqaCJnR);
			URLConnection u0F7t8uR = gdFbnFxN.openConnection();
			BufferedReader So75W8sk = new BufferedReader(new InputStreamReader(u0F7t8uR.getInputStream()));
			String U3ITSKaY = null;
			while ((U3ITSKaY = So75W8sk.readLine()) != null)
				YfKlSPx4.append(U3ITSKaY + "\n");
			So75W8sk.close();
		} catch (MalformedURLException v6VNn3Nt) {
			System.out.println("??งน??URL: " + ZGqaCJnR);
		} catch (IOException qNQiWnrO) {
			qNQiWnrO.printStackTrace();
		}
		return YfKlSPx4.toString();
	}

}