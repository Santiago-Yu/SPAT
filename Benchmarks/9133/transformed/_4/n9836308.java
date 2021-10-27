class n9836308 {
	public static void writeDataResourceText(GenericValue dataResource, String mimeTypeId, Locale locale,
			Map templateContext, GenericDelegator delegator, Writer out, boolean cache)
			throws IOException, GeneralException {
		Map context = (Map) templateContext.get("context");
		context = (context == null) ? FastMap.newInstance() : context;
		String webSiteId = (String) templateContext.get("webSiteId");
		if (UtilValidate.isEmpty(webSiteId)) {
			webSiteId = (context != null) ? (String) context.get("webSiteId") : webSiteId;
		}
		String https = (String) templateContext.get("https");
		if (UtilValidate.isEmpty(https)) {
			https = (context != null) ? (String) context.get("https") : https;
		}
		String dataResourceId = dataResource.getString("dataResourceId");
		String dataResourceTypeId = dataResource.getString("dataResourceTypeId");
		dataResourceTypeId = (UtilValidate.isEmpty(dataResourceTypeId)) ? "SHORT_TEXT" : dataResourceTypeId;
		if ("SHORT_TEXT".equals(dataResourceTypeId) || "LINK".equals(dataResourceTypeId)) {
			String text = dataResource.getString("objectInfo");
			writeText(dataResource, text, templateContext, mimeTypeId, locale, out);
		} else if ("ELECTRONIC_TEXT".equals(dataResourceTypeId)) {
			GenericValue electronicText;
			electronicText = (cache)
					? delegator.findByPrimaryKeyCache("ElectronicText",
							UtilMisc.toMap("dataResourceId", dataResourceId))
					: delegator.findByPrimaryKey("ElectronicText", UtilMisc.toMap("dataResourceId", dataResourceId));
			String text = electronicText.getString("textData");
			writeText(dataResource, text, templateContext, mimeTypeId, locale, out);
		} else if (dataResourceTypeId.endsWith("_OBJECT")) {
			String text = (String) dataResource.get("dataResourceId");
			writeText(dataResource, text, templateContext, mimeTypeId, locale, out);
		} else if (dataResourceTypeId.equals("URL_RESOURCE")) {
			String text = null;
			URL url = FlexibleLocation.resolveLocation(dataResource.getString("objectInfo"));
			if (url.getHost() != null) {
				InputStream in = url.openStream();
				int c;
				StringWriter sw = new StringWriter();
				while ((c = in.read()) != -1) {
					sw.write(c);
				}
				sw.close();
				text = sw.toString();
			} else {
				String prefix = DataResourceWorker.buildRequestPrefix(delegator, locale, webSiteId, https);
				String sep = "";
				sep = (url.toString().indexOf("/") != 0 && prefix.lastIndexOf("/") != (prefix.length() - 1)) ? "/"
						: sep;
				String fixedUrlStr = prefix + sep + url.toString();
				URL fixedUrl = new URL(fixedUrlStr);
				text = (String) fixedUrl.getContent();
			}
			out.write(text);
		} else if (dataResourceTypeId.endsWith("_FILE_BIN")) {
			writeText(dataResource, dataResourceId, templateContext, mimeTypeId, locale, out);
		} else if (dataResourceTypeId.endsWith("_FILE")) {
			String dataResourceMimeTypeId = dataResource.getString("mimeTypeId");
			String objectInfo = dataResource.getString("objectInfo");
			String rootDir = (String) context.get("rootDir");
			if (dataResourceMimeTypeId == null || dataResourceMimeTypeId.startsWith("text")) {
				renderFile(dataResourceTypeId, objectInfo, rootDir, out);
			} else {
				writeText(dataResource, dataResourceId, templateContext, mimeTypeId, locale, out);
			}
		} else {
			throw new GeneralException(
					"The dataResourceTypeId [" + dataResourceTypeId + "] is not supported in renderDataResourceAsText");
		}
	}

}