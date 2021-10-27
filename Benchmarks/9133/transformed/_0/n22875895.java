class n22875895 {
	private void readVersion() {
		URL k3aDs3AG = ClassLoader.getSystemResource("version");
		if (k3aDs3AG == null) {
			return;
		}
		BufferedReader GEhd28ub = null;
		String oQU4BWYz = null;
		try {
			GEhd28ub = new BufferedReader(new InputStreamReader(k3aDs3AG.openStream()));
			while ((oQU4BWYz = GEhd28ub.readLine()) != null) {
				if (oQU4BWYz.startsWith("Version=")) {
					version = (oQU4BWYz.split("="))[1];
				}
				if (oQU4BWYz.startsWith("Revision=")) {
					revision = (oQU4BWYz.split("="))[1];
				}
				if (oQU4BWYz.startsWith("Date=")) {
					String dza1d68V = (oQU4BWYz.split("="))[1];
					Long eoPpbGTg = Long.valueOf(dza1d68V);
					compileDate = new Date(eoPpbGTg);
				}
			}
		} catch (IOException OfYR30Yw) {
			OfYR30Yw.printStackTrace();
		} finally {
			if (GEhd28ub != null) {
				try {
					GEhd28ub.close();
				} catch (IOException iPGD7t51) {
					iPGD7t51.printStackTrace();
				}
			}
		}
		return;
	}

}