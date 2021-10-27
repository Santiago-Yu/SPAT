class n10642765 {
	protected Reader getText() throws IOException {
		String readLine;
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		do {
			readLine = br.readLine();
		} while (readLine != null && readLine.indexOf("</table><br clear=all>") < 0);
		return br;
	}

}