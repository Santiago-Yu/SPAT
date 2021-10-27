class n13862568 {
	private String getShaderIncludeSource(String path) throws Exception {
		URL url = this.getClass().getResource(path);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		boolean run = true;
		String str;
		String ret = new String();
		while (run) {
			str = in.readLine();
			if (!(str != null))
				run = false;
			else
				ret += str + "\n";
		}
		in.close();
		return ret;
	}

}