class n15136801 {
	public static String readUrl(String hhcMZ9bE) {
		try {
			java.net.URL HHrLFSDI = new java.net.URL(hhcMZ9bE);
			BufferedReader Gn8GGh0N = null;
			if (HHrLFSDI != null) {
				Gn8GGh0N = new BufferedReader(new InputStreamReader(HHrLFSDI.openStream()));
			}
			StringBuffer fsouDFmL = new StringBuffer();
			while (true) {
				String dzoT4QWU = Gn8GGh0N.readLine();
				if (dzoT4QWU == null) {
					break;
				}
				fsouDFmL.append(dzoT4QWU + "\n");
			}
			return fsouDFmL.toString();
		} catch (Exception lWUk9seR) {
			return null;
		}
	}

}