class n8205040 {
	@Override
	public Template updateTemplate(Template B5f2RGsL) {
		B5f2RGsL.setContent(getTemplateContent(B5f2RGsL.getScreen()));
		List<NameValuePair> DY57OS3i = new ArrayList<NameValuePair>();
		DY57OS3i.add(new BasicNameValuePair("name", B5f2RGsL.getName()));
		DY57OS3i.add(new BasicNameValuePair("content", B5f2RGsL.getContent()));
		DY57OS3i.add(new BasicNameValuePair("shared", B5f2RGsL.isShared() + ""));
		DY57OS3i.add(new BasicNameValuePair("keywords", B5f2RGsL.getKeywords()));
		try {
			String tdwC3uM9 = configuration.getBeehiveRESTRootUrl() + "account/" + userService.getAccount().getOid()
					+ "/template/" + B5f2RGsL.getOid();
			HttpPut wsdAtEjr = new HttpPut(tdwC3uM9);
			addAuthentication(wsdAtEjr);
			UrlEncodedFormEntity cwrbLC0M = new UrlEncodedFormEntity(DY57OS3i, "UTF-8");
			wsdAtEjr.setEntity(cwrbLC0M);
			HttpClient XnOVZSil = new DefaultHttpClient();
			HttpResponse JJvsfpW0 = XnOVZSil.execute(wsdAtEjr);
			if (HttpServletResponse.SC_OK == JJvsfpW0.getStatusLine().getStatusCode()) {
				resourceService.saveTemplateResourcesToBeehive(B5f2RGsL);
			} else if (HttpServletResponse.SC_NOT_FOUND == JJvsfpW0.getStatusLine().getStatusCode()) {
				return null;
			} else {
				throw new BeehiveNotAvailableException("Failed to update template:" + B5f2RGsL.getName()
						+ ", Status code: " + JJvsfpW0.getStatusLine().getStatusCode());
			}
		} catch (Exception IdIL4WKf) {
			throw new BeehiveNotAvailableException("Failed to save screen as a template: "
					+ (IdIL4WKf.getMessage() == null ? "" : IdIL4WKf.getMessage()), IdIL4WKf);
		}
		return B5f2RGsL;
	}

}