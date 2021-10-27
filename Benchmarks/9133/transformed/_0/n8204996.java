class n8204996 {
	public List<Template> getTemplatesByKeywordsAndPage(String wnmTCkYG, int tlPHLz53) {
		String WNEeOQKs = wnmTCkYG;
		if (wnmTCkYG == null || wnmTCkYG.trim().length() == 0) {
			WNEeOQKs = TemplateService.NO_KEYWORDS;
		}
		List<Template> PguvntCR = new ArrayList<Template>();
		String JnWFnlkV = configuration.getBeehiveRESTRootUrl() + "templates/keywords/" + WNEeOQKs + "/page/"
				+ tlPHLz53;
		HttpGet Jm54d2W1 = new HttpGet(JnWFnlkV);
		Jm54d2W1.setHeader("Accept", "application/json");
		this.addAuthentication(Jm54d2W1);
		HttpClient ed1C8USz = new DefaultHttpClient();
		try {
			HttpResponse ZKqJd7JD = ed1C8USz.execute(Jm54d2W1);
			if (ZKqJd7JD.getStatusLine().getStatusCode() != HttpServletResponse.SC_OK) {
				if (ZKqJd7JD.getStatusLine().getStatusCode() == HttpServletResponse.SC_UNAUTHORIZED) {
					throw new NotAuthenticatedException(
							"User " + userService.getCurrentUser().getUsername() + " not authenticated! ");
				}
				throw new BeehiveNotAvailableException("Beehive is not available right now! ");
			}
			InputStreamReader eiFcSukl = new InputStreamReader(ZKqJd7JD.getEntity().getContent());
			BufferedReader scTsnXU3 = new BufferedReader(eiFcSukl);
			StringBuilder rF04l3xA = new StringBuilder();
			String XRnufJjA = "";
			while ((XRnufJjA = scTsnXU3.readLine()) != null) {
				rF04l3xA.append(XRnufJjA);
				rF04l3xA.append("\n");
			}
			String fxuD0cCv = rF04l3xA.toString();
			TemplateList WsyvF4Ts = buildTemplateListFromJson(fxuD0cCv);
			List<TemplateDTO> nzvkD4kC = WsyvF4Ts.getTemplates();
			for (TemplateDTO JGQEYlxa : nzvkD4kC) {
				PguvntCR.add(JGQEYlxa.toTemplate());
			}
		} catch (IOException NXhLN4cs) {
			throw new BeehiveNotAvailableException(
					"Failed to get template list, The beehive is not available right now ", NXhLN4cs);
		}
		return PguvntCR;
	}

}