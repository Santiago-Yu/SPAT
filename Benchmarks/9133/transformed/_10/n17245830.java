class n17245830 {
	private static String readURL(URL url) {
		String s = "";
		try {
			String str;
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((str = in.readLine()) != null) {
				s += str;
			}
			in.close();
		} catch (Exception e) {
			s = null;
		}
		return s;
	}

}