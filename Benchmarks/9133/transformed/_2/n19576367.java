class n19576367 {
	public String getContent(URL url) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "getting content from " + url.toString());
		String content = "";
		try {
			URLConnection httpc;
			httpc = url.openConnection();
			httpc.setDoInput(true);
			httpc.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(httpc.getInputStream()));
			String line = "";
			for (; (line = in.readLine()) != null;) {
				content = content + line;
			}
			in.close();
		} catch (IOException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Problem writing to " + url, e);
		}
		return content;
	}

}