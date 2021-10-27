class n10642765 {
	protected Reader getText() throws IOException {
		BufferedReader rvh2NNBt = new BufferedReader(new InputStreamReader(url.openStream()));
		String rzixusaL;
		do {
			rzixusaL = rvh2NNBt.readLine();
		} while (rzixusaL != null && rzixusaL.indexOf("</table><br clear=all>") < 0);
		return rvh2NNBt;
	}

}