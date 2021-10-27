class n8204995 {
	public List<Template> getTemplates(boolean zL67eh5v) {
		String PuUcVyln = zL67eh5v ? "private" : "public";
		List<Template> AIu1YpfD = new ArrayList<Template>();
		String f9jh5D9A = configuration.getBeehiveRESTRootUrl() + "account/" + userService.getAccount().getOid()
				+ "/templates/" + PuUcVyln;
		HttpGet VGxkVldk = new HttpGet(f9jh5D9A);
		VGxkVldk.setHeader("Accept", "application/json");
		this.addAuthentication(VGxkVldk);
		HttpClient A41IlLSN = new DefaultHttpClient();
		try {
			HttpResponse XnAZJNDS = A41IlLSN.execute(VGxkVldk);
			if (XnAZJNDS.getStatusLine().getStatusCode() != HttpServletResponse.SC_OK) {
				if (XnAZJNDS.getStatusLine().getStatusCode() == HttpServletResponse.SC_UNAUTHORIZED) {
					throw new NotAuthenticatedException(
							"User " + userService.getCurrentUser().getUsername() + " not authenticated! ");
				}
				throw new BeehiveNotAvailableException("Beehive is not available right now! ");
			}
			InputStreamReader KQGaHRf9 = new InputStreamReader(XnAZJNDS.getEntity().getContent());
			BufferedReader wYb8RQYR = new BufferedReader(KQGaHRf9);
			StringBuilder Fl6p6hcU = new StringBuilder();
			String OOS4e281 = "";
			while ((OOS4e281 = wYb8RQYR.readLine()) != null) {
				Fl6p6hcU.append(OOS4e281);
				Fl6p6hcU.append("\n");
			}
			String AI6MnccT = Fl6p6hcU.toString();
			TemplateList hggyGd16 = buildTemplateListFromJson(AI6MnccT);
			List<TemplateDTO> IzRe02pO = hggyGd16.getTemplates();
			for (TemplateDTO JVO3dYmK : IzRe02pO) {
				AIu1YpfD.add(JVO3dYmK.toTemplate());
			}
		} catch (IOException k0EBG3Cz) {
			throw new BeehiveNotAvailableException(
					"Failed to get template list, The beehive is not available right now ", k0EBG3Cz);
		}
		return AIu1YpfD;
	}

}