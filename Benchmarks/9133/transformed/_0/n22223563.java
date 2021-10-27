class n22223563 {
	private String read(URL SeKV4HSM) throws IOException {
		BufferedReader iXDsGB4f = null;
		try {
			iXDsGB4f = new BufferedReader(new InputStreamReader(SeKV4HSM.openStream()));
			StringBuffer j8TZsiIH = new StringBuffer();
			String lrfbhc7r;
			while ((lrfbhc7r = iXDsGB4f.readLine()) != null) {
				j8TZsiIH.append(lrfbhc7r);
			}
			return j8TZsiIH.toString();
		} finally {
			iXDsGB4f.close();
		}
	}

}