class n13979533 {
	public Resource get(URL serviceUrl, String resourceId) throws Exception {
		Resource resource = new Resource();
		String openurl = serviceUrl.toString() + "?url_ver=Z39.88-2004" + "&rft_id="
				+ URLEncoder.encode(resourceId, "UTF-8") + "&svc_id=" + SVCID_ADORE4;
		log.debug("OpenURL Request: " + openurl);
		URL url;
		try {
			url = new URL(openurl);
			HttpURLConnection huc = (HttpURLConnection) (url.openConnection());
			int code = huc.getResponseCode();
			if (200 == code) {
				InputStream is = huc.getInputStream();
				resource.setBytes(StreamUtil.getByteArray(is));
				resource.setContentType(huc.getContentType());
			} else {
				log.error("An error of type " + code + " occurred for " + url.toString());
				throw new Exception("Cannot get " + url.toString());
			}
		} catch (MalformedURLException e) {
			throw new Exception("A MalformedURLException occurred for " + openurl);
		} catch (IOException e) {
			throw new Exception("An IOException occurred attempting to connect to " + openurl);
		}
		return resource;
	}

}