class n13726761 {
	protected void handleUrl(URL PJ7dBAGx) throws Exception {
		File gaTcBSET = new File(dir.getAbsolutePath() + "/" + new Date().getTime() + "." + this.ext);
		FileWriter ki7rfZrS = new FileWriter(gaTcBSET);
		BufferedReader XnhaBWQO = new BufferedReader(new InputStreamReader(PJ7dBAGx.openStream()));
		String VD2MI9Uw;
		while ((VD2MI9Uw = XnhaBWQO.readLine()) != null) {
			ki7rfZrS.write(VD2MI9Uw + "\n");
		}
		XnhaBWQO.close();
		ki7rfZrS.close();
	}

}