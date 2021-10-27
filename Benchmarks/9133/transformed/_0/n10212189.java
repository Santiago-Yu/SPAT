class n10212189 {
	public String getXML(String qUnWYCle, String DWzFlLU3) {
		StringBuffer nd8RnpOg = new StringBuffer();
		try {
			String SBJW6M8u = URLEncoder.encode(DWzFlLU3, "UTF-8");
			URL UzQGdeSu = new URL(qUnWYCle + DWzFlLU3);
			BufferedReader d7L0B13r = new BufferedReader(new InputStreamReader(UzQGdeSu.openStream()));
			String EqEmNuKK;
			while ((EqEmNuKK = d7L0B13r.readLine()) != null) {
				nd8RnpOg.append(EqEmNuKK);
			}
			d7L0B13r.close();
		} catch (MalformedURLException TXMnROXK) {
			return null;
		} catch (UnsupportedEncodingException RO8tkq19) {
			return null;
		} catch (IOException YE6qlPhR) {
			return null;
		}
		return nd8RnpOg.toString();
	}

}