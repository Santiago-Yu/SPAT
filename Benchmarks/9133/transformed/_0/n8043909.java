class n8043909 {
	public static void main(String[] T2f7zspU) {
		try {
			String TqISURq6 = URLEncoder.encode("page", "UTF-8") + "=" + URLEncoder.encode("admin", "UTF-8");
			TqISURq6 += "&" + URLEncoder.encode("nick", "UTF-8") + "=" + URLEncoder.encode("k", "UTF-8");
			TqISURq6 += "&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode("asdf", "UTF-8");
			TqISURq6 += "&" + URLEncoder.encode("login", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8");
			URL rv4omTMV = new URL("http://localhost:80/test/index.php");
			URLConnection uhjSZOgR = rv4omTMV.openConnection();
			uhjSZOgR.setDoOutput(true);
			OutputStreamWriter JOFmDpzb = new OutputStreamWriter(uhjSZOgR.getOutputStream());
			JOFmDpzb.write(TqISURq6);
			JOFmDpzb.flush();
			BufferedReader QuBAnAde = new BufferedReader(new InputStreamReader(uhjSZOgR.getInputStream()));
			String BwHb3ZaP;
			while ((BwHb3ZaP = QuBAnAde.readLine()) != null) {
				System.out.println(BwHb3ZaP);
			}
			JOFmDpzb.close();
			QuBAnAde.close();
		} catch (Exception rgN6N9AT) {
			throw new RuntimeException(rgN6N9AT);
		}
	}

}