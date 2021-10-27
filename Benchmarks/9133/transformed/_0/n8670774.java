class n8670774 {
	public String getHtmlPage(URL OmCNzo8A) {
		String L8VdrvI1 = null;
		try {
			BufferedReader gUWcFMjD = new BufferedReader(
					new InputStreamReader(OmCNzo8A.openConnection().getInputStream()));
			StringBuffer PW621SMO = new StringBuffer();
			String C5fhOJAn;
			while ((C5fhOJAn = gUWcFMjD.readLine()) != null) {
				PW621SMO.append(C5fhOJAn).append("\n");
			}
			gUWcFMjD.close();
			L8VdrvI1 = PW621SMO.toString().replaceAll(HTML_FILTER_RE, " ");
		} catch (MalformedURLException Mzd4tQEt) {
			Mzd4tQEt.printStackTrace();
		} catch (IOException D4wADa71) {
			D4wADa71.printStackTrace();
		}
		return L8VdrvI1;
	}

}