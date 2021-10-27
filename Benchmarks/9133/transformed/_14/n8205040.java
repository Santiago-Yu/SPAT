class n8205040 {
	@Override
	public Template updateTemplate(Template template) {
		template.setContent(getTemplateContent(template.getScreen()));
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("name", template.getName()));
		params.add(new BasicNameValuePair("content", template.getContent()));
		params.add(new BasicNameValuePair("shared", template.isShared() + ""));
		params.add(new BasicNameValuePair("keywords", template.getKeywords()));
		try {
			String saveRestUrl = configuration.getBeehiveRESTRootUrl() + "account/" + userService.getAccount().getOid()
					+ "/template/" + template.getOid();
			HttpPut httpPut = new HttpPut(saveRestUrl);
			addAuthentication(httpPut);
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "UTF-8");
			httpPut.setEntity(formEntity);
			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse response = httpClient.execute(httpPut);
			if (response.getStatusLine().getStatusCode() == HttpServletResponse.SC_OK) {
				resourceService.saveTemplateResourcesToBeehive(template);
			} else if (response.getStatusLine().getStatusCode() == HttpServletResponse.SC_NOT_FOUND) {
				return null;
			} else {
				throw new BeehiveNotAvailableException("Failed to update template:" + template.getName()
						+ ", Status code: " + response.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			throw new BeehiveNotAvailableException(
					"Failed to save screen as a template: " + (null == e.getMessage() ? "" : e.getMessage()), e);
		}
		return template;
	}

}