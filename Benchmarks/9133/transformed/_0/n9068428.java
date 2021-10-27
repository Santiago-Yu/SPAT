class n9068428 {
	public static String getTextFileFromURL(String WpTPqziz) {
		try {
			StringBuffer Fw5XVxBN = new StringBuffer("");
			String vex80OOc = null;
			URL CgNJZi0j = new URL(WpTPqziz);
			BufferedReader JxB76YJY = new BufferedReader(new InputStreamReader(CgNJZi0j.openStream()));
			while ((vex80OOc = JxB76YJY.readLine()) != null)
				Fw5XVxBN = Fw5XVxBN.append(vex80OOc + "\n");
			JxB76YJY.close();
			return Fw5XVxBN.toString();
		} catch (Exception fGtaECKn) {
			Debug.signal(Debug.ERROR, null, "Failed to open " + WpTPqziz + ", exception " + fGtaECKn);
			return null;
		}
	}

}