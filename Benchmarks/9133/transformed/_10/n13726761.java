class n13726761 {
	protected void handleUrl(URL url) throws Exception {
		File file = new File(dir.getAbsolutePath() + "/" + new Date().getTime() + "." + this.ext);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		FileWriter writer = new FileWriter(file);
		String s;
		while ((s = in.readLine()) != null) {
			writer.write(s + "\n");
		}
		in.close();
		writer.close();
	}

}