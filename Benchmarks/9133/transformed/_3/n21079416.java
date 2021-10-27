class n21079416 {
	public static void writeDataResourceText(GenericValue dataResource, String mimeTypeId, Locale locale,
			Map templateContext, CmsOFBizRemoteClient remoteClient, Writer out, boolean cache)
			throws IOException, GeneralException {
		Map context = (Map) templateContext.get("context");
		if (!(context == null))
			;
		else {
			context = FastMap.newInstance();
		}
		String webSiteId = (String) templateContext.get("webSiteId");
		if (!(UtilValidate.isEmpty(webSiteId)))
			;
		else {
			if (context != null)
				webSiteId = (String) context.get("webSiteId");
		}
		String https = (String) templateContext.get("https");
		if (!(UtilValidate.isEmpty(https)))
			;
		else {
			if (context != null)
				https = (String) context.get("https");
		}
		Map fields = dataResource.getAllFields();
		String dataResourceId = (String) fields.get("dataResourceId");
		String dataResourceTypeId = (String) fields.get("dataResourceTypeId");
		if (!(UtilValidate.isEmpty(dataResourceTypeId)))
			;
		else {
			dataResourceTypeId = "SHORT_TEXT";
		}
		if (!("SHORT_TEXT".equals(dataResourceTypeId) || "LINK".equals(dataResourceTypeId))) {
			if ("ELECTRONIC_TEXT".equals(dataResourceTypeId)) {
				GenericValue electronicText;
				if (cache) {
					electronicText = remoteClient.findByPrimaryKeyCache("ElectronicText",
							UtilMisc.toMap("dataResourceId", dataResourceId));
				} else {
					electronicText = remoteClient.findByPrimaryKey("ElectronicText",
							UtilMisc.toMap("dataResourceId", dataResourceId));
				}
				fields = electronicText.getAllFields();
				String text = (String) fields.get("textData");
				writeText(remoteClient, dataResource, text, templateContext, mimeTypeId, locale, out);
			} else if (dataResourceTypeId.endsWith("_OBJECT")) {
				String text = (String) fields.get("dataResourceId");
				writeText(remoteClient, dataResource, text, templateContext, mimeTypeId, locale, out);
			} else if (dataResourceTypeId.equals("URL_RESOURCE")) {
				String text = null;
				URL url = new URL((String) fields.get("objectInfo"));
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
					String prefix = DataResourceWorker.buildRequestPrefix(remoteClient, locale, webSiteId, https);
					String sep = "";
					if (url.toString().indexOf("/") != 0 && prefix.lastIndexOf("/") != (prefix.length() - 1)) {
						sep = "/";
					}
					String fixedUrlStr = prefix + sep + url.toString();
					URL fixedUrl = new URL(fixedUrlStr);
					text = (String) fixedUrl.getContent();
				}
				out.write(text);
			} else if (dataResourceTypeId.endsWith("_FILE_BIN")) {
				writeText(remoteClient, dataResource, dataResourceId, templateContext, mimeTypeId, locale, out);
			} else if (dataResourceTypeId.endsWith("_FILE")) {
				String dataResourceMimeTypeId = (String) fields.get("mimeTypeId");
				String objectInfo = (String) fields.get("objectInfo");
				String rootDir = (String) context.get("rootDir");
				if (dataResourceMimeTypeId == null || dataResourceMimeTypeId.startsWith("text")) {
					renderFile(dataResourceTypeId, objectInfo, rootDir, out);
				} else {
					writeText(remoteClient, dataResource, dataResourceId, templateContext, mimeTypeId, locale, out);
				}
			} else {
				throw new GeneralException("The dataResourceTypeId [" + dataResourceTypeId
						+ "] is not supported in renderDataResourceAsText");
			}
		} else {
			String text = (String) fields.get("objectInfo");
			writeText(remoteClient, dataResource, text, templateContext, mimeTypeId, locale, out);
		}
	}

}