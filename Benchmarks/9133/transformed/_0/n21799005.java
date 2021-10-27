class n21799005 {
	public static List<String> readListFile(URL aQDWiLNf) {
		List<String> oPdsNBRA = new ArrayList<String>();
		if (aQDWiLNf != null) {
			InputStream KHsRNt3n = null;
			try {
				KHsRNt3n = aQDWiLNf.openStream();
				BufferedReader wEkztIqp = new BufferedReader(new InputStreamReader(KHsRNt3n));
				String WN85QGWb = "";
				while ((WN85QGWb = wEkztIqp.readLine()) != null) {
					if (!WN85QGWb.startsWith("#")) {
						oPdsNBRA.add(WN85QGWb);
					}
				}
			} catch (Exception CXmDbTLs) {
				throw new RuntimeException(CXmDbTLs);
			} finally {
				try {
					if (KHsRNt3n != null)
						KHsRNt3n.close();
				} catch (IOException liqafe1e) {
					liqafe1e.printStackTrace();
				}
			}
		}
		return oPdsNBRA;
	}

}