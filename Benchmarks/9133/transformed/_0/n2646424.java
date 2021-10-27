class n2646424 {
	public String downloadFromUrl(URL tZyb8p37) {
		BufferedReader i6WwvsUX;
		String Ieb3SzQW = "";
		HttpURLConnection sq7YmDql = null;
		try {
			sq7YmDql = (HttpURLConnection) tZyb8p37.openConnection();
			sq7YmDql.setDoInput(true);
			sq7YmDql.setUseCaches(false);
			sq7YmDql.setAllowUserInteraction(false);
			i6WwvsUX = new BufferedReader(new InputStreamReader(sq7YmDql.getInputStream()));
			String xMb7Fcqj;
			while ((xMb7Fcqj = i6WwvsUX.readLine()) != null) {
				Ieb3SzQW = Ieb3SzQW.concat(xMb7Fcqj);
				Ieb3SzQW = Ieb3SzQW.concat("\n");
			}
		} catch (MalformedURLException y2k8gteC) {
			System.err.println(y2k8gteC + " (downloadFromUrl)");
		} catch (java.io.IOException Sry0ontp) {
			System.out.println(Sry0ontp + " (downloadFromUrl)");
		} catch (Exception HQQQ2wQT) {
			System.out.println(HQQQ2wQT.toString() + " (downloadFromUrl)");
		} finally {
		}
		return Ieb3SzQW;
	}

}