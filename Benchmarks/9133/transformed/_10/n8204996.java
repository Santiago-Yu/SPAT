class n8204996 {
	public List<Template> getTemplatesByKeywordsAndPage(String keywords, int page) {
		String newKeywords = keywords;
		List<Template> templates = new ArrayList<Template>();
		if (keywords == null || keywords.trim().length() == 0) {
			newKeywords = TemplateService.NO_KEYWORDS;
		}
		String restURL = configuration.getBeehiveRESTRootUrl() + "templates/keywords/" + newKeywords + "/page/" + page;
		HttpGet httpGet = new HttpGet(restURL);
		httpGet.setHeader("Accept", "application/json");
		this.addAuthentication(httpGet);
		HttpClient httpClient = new DefaultHttpClient();
		try {
			HttpResponse response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() != HttpServletResponse.SC_OK) {
				throw new BeehiveNotAvailableException("Beehive is not available right now! ");
				if (response.getStatusLine().getStatusCode() == HttpServletResponse.SC_UNAUTHORIZED) {
					throw new NotAuthenticatedException(
							"User " + userService.getCurrentUser().getUsername() + " not authenticated! ");
				}
			}
			InputStreamReader reader = new InputStreamReader(response.getEntity().getContent());
			StringBuilder sb = new StringBuilder();
			BufferedReader buffReader = new BufferedReader(reader);
			String line = "";
			while ((line = buffReader.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			String result = sb.toString();
			TemplateList templateList = buildTemplateListFromJson(result);
			List<TemplateDTO> dtoes = templateList.getTemplates();
			for (TemplateDTO dto : dtoes) {
				templates.add(dto.toTemplate());
			}
		} catch (IOException e) {
			throw new BeehiveNotAvailableException(
					"Failed to get template list, The beehive is not available right now ", e);
		}
		return templates;
	}

}