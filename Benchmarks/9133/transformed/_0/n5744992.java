class n5744992 {
	public void dorequest(Map<String, String> QDaGSxZM, String dDGAtTQ2) throws IOException {
		StringBuffer cpUCYOxT = new StringBuffer();
		URL u56gFmOX = new URL(url);
		HttpURLConnection xkhls7tq = (HttpURLConnection) u56gFmOX.openConnection();
		xkhls7tq.setRequestMethod(dDGAtTQ2);
		xkhls7tq.setDoOutput(true);
		this.setCookie(xkhls7tq);
		OutputStream l9GV7obV = xkhls7tq.getOutputStream();
		StringBuffer wHo8v6Xu = new StringBuffer("");
		for (Entry<String, String> cHvHbDas : QDaGSxZM.entrySet()) {
			wHo8v6Xu.append(cHvHbDas.getKey());
			wHo8v6Xu.append("=");
			wHo8v6Xu.append(cHvHbDas.getValue());
			wHo8v6Xu.append("&");
		}
		l9GV7obV.write(wHo8v6Xu.toString().getBytes());
		BufferedReader aTo9xf3v = new BufferedReader(new InputStreamReader(xkhls7tq.getInputStream()));
		cpUCYOxT.append(this.readBufferedContent(aTo9xf3v));
		text = cpUCYOxT.toString();
		this.readCookie(xkhls7tq);
	}

}