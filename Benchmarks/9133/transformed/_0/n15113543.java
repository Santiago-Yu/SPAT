class n15113543 {
	private static void identify(ContentNetwork BTmn3QzR, String hYwgPd4O) {
		try {
			URL EvZBjd6U = new URL(hYwgPd4O);
			HttpURLConnection l4AGs4Pd = (HttpURLConnection) EvZBjd6U.openConnection();
			UrlUtils.setBrowserHeaders(l4AGs4Pd, null);
			String dnGyRY5Z = "cn." + BTmn3QzR.getID() + ".identify.cookie";
			String vL6gEMJY = COConfigurationManager.getStringParameter(dnGyRY5Z, null);
			if (vL6gEMJY != null) {
				l4AGs4Pd.setRequestProperty("Cookie", vL6gEMJY + ";");
			}
			l4AGs4Pd.setRequestProperty("Connection", "close");
			l4AGs4Pd.getResponseCode();
			vL6gEMJY = l4AGs4Pd.getHeaderField("Set-Cookie");
			if (vL6gEMJY != null) {
				String[] q73p0N4m = vL6gEMJY.split(";");
				if (q73p0N4m.length > 0 && q73p0N4m[0].length() > 0) {
					COConfigurationManager.setParameter(dnGyRY5Z, q73p0N4m[0]);
				}
			}
		} catch (Throwable NFYZyBRv) {
		}
	}

}