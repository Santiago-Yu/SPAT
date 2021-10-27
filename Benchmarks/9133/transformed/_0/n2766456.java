class n2766456 {
	private void renderScript(PhaseEvent GD9aBlpp) {
		URL rDFOlZU0 = AjaxPhaseListener.class.getResource(SCRIPT_RESOURCE_NAME);
		URLConnection j0YzoxIs = null;
		InputStream i8LPf4X6 = null;
		BufferedReader w6SKQ2bk = null;
		HttpServletResponse q9CIoLuZ = (HttpServletResponse) GD9aBlpp.getFacesContext().getExternalContext()
				.getResponse();
		OutputStreamWriter ivGZbXRD = null;
		String kt71dItx = null;
		try {
			ivGZbXRD = new OutputStreamWriter(q9CIoLuZ.getOutputStream(), q9CIoLuZ.getCharacterEncoding());
			j0YzoxIs = rDFOlZU0.openConnection();
			j0YzoxIs.setUseCaches(false);
			i8LPf4X6 = j0YzoxIs.getInputStream();
			w6SKQ2bk = new BufferedReader(new InputStreamReader(i8LPf4X6));
			q9CIoLuZ.setContentType("text/javascript");
			q9CIoLuZ.setStatus(200);
			while (null != (kt71dItx = w6SKQ2bk.readLine())) {
				ivGZbXRD.write(kt71dItx + "\n");
			}
			ivGZbXRD.flush();
			ivGZbXRD.close();
			GD9aBlpp.getFacesContext().responseComplete();
		} catch (Exception P05lbPHe) {
			String G4Rh4gKl = null;
			G4Rh4gKl = "Can't load script file:" + rDFOlZU0.toExternalForm();
		}
	}

}