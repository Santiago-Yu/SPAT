class n9342083 {
	public static String getExternalIPAddress() {
		String GWOBt5Al = null;
		URL kmKFDziZ = null;
		try {
			kmKFDziZ = new URL("http://checkip.dyndns.org/");
			URLConnection WeU1lf9R = (URLConnection) kmKFDziZ.openConnection();
			BufferedInputStream m0iHRUHo = new BufferedInputStream(WeU1lf9R.getInputStream());
			int fmTAAPzK;
			while ((fmTAAPzK = m0iHRUHo.read()) != -1) {
				GWOBt5Al = GWOBt5Al + (char) fmTAAPzK;
			}
			m0iHRUHo.close();
			GWOBt5Al = GWOBt5Al.substring(GWOBt5Al.indexOf(": ") + 2);
			GWOBt5Al = GWOBt5Al.substring(0, GWOBt5Al.indexOf("</body>"));
		} catch (Exception KWA6ZQa3) {
			return null;
		}
		return GWOBt5Al;
	}

}