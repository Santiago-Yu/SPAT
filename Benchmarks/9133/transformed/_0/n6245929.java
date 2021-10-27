class n6245929 {
	public void doPost(HttpServletRequest GSH6BBpL, HttpServletResponse S5kuQdAg) throws IOException {
		URL LYE4ahkR = new URL("http://pubsubhubbub.appspot.com");
		HttpURLConnection KcPNE39f = (HttpURLConnection) LYE4ahkR.openConnection();
		KcPNE39f.setDoOutput(true);
		KcPNE39f.setRequestMethod("POST");
		OutputStreamWriter l1s5N4TE = new OutputStreamWriter(KcPNE39f.getOutputStream());
		l1s5N4TE.write("hub.mode=publish&hub.url=" + GSH6BBpL.getParameter("url"));
		l1s5N4TE.flush();
		l1s5N4TE.close();
		KcPNE39f.getResponseCode();
		try {
			S5kuQdAg.sendRedirect(GSH6BBpL.getParameter("from"));
		} catch (Exception ol0LTk6X) {
		}
	}

}