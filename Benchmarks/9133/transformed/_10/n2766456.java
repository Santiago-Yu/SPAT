class n2766456 {
	private void renderScript(PhaseEvent event) {
		URLConnection conn = null;
		URL url = AjaxPhaseListener.class.getResource(SCRIPT_RESOURCE_NAME);
		BufferedReader bufReader = null;
		InputStream stream = null;
		OutputStreamWriter outWriter = null;
		HttpServletResponse response = (HttpServletResponse) event.getFacesContext().getExternalContext().getResponse();
		String curLine = null;
		try {
			outWriter = new OutputStreamWriter(response.getOutputStream(), response.getCharacterEncoding());
			conn = url.openConnection();
			conn.setUseCaches(false);
			stream = conn.getInputStream();
			bufReader = new BufferedReader(new InputStreamReader(stream));
			response.setContentType("text/javascript");
			response.setStatus(200);
			while (null != (curLine = bufReader.readLine())) {
				outWriter.write(curLine + "\n");
			}
			outWriter.flush();
			outWriter.close();
			event.getFacesContext().responseComplete();
		} catch (Exception e) {
			String message = null;
			message = "Can't load script file:" + url.toExternalForm();
		}
	}

}