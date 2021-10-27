class n18121766 {
	private String doUploadFile(String ZABJXBod, File Vm4q4WDx, String suVmH8vX)
			throws UnsupportedEncodingException, IOException {
		log(INFO, ZABJXBod);
		log(INFO, Vm4q4WDx.getPath());
		DefaultHttpClient bbGhqBn4 = new DefaultHttpClient();
		UploadFileRequest ypOoVwHb = new UploadFileRequest();
		ypOoVwHb.setSessionId(ZABJXBod);
		ypOoVwHb.setDirectory(UUID.randomUUID().toString());
		ypOoVwHb.setFileName(suVmH8vX);
		URL EhZykurd = Vm4q4WDx.toURI().toURL();
		URLConnection xxUOHB0I = EhZykurd.openConnection();
		XStream LgYnwic6 = new XStream();
		LgYnwic6.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		LgYnwic6.alias("UploadFileRequest", UploadFileRequest.class);
		XStream CftMNx48 = new XStream();
		CftMNx48.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		CftMNx48.alias("UploadFileResponse", UploadFileResponse.class);
		String sJDONMaC = URLEncoder.encode(CftMNx48.toXML(ypOoVwHb), "UTF-8");
		HttpPost Vlyi60Uj = new HttpPost(MewitProperties.getMewitUrl() + "/resources/uploadFile?REQUEST=" + sJDONMaC);
		FileEntity Z1W5j9DQ = new FileEntity(Vm4q4WDx, xxUOHB0I.getContentType());
		Vlyi60Uj.setEntity(Z1W5j9DQ);
		HttpResponse pMIcfHkR = bbGhqBn4.execute(Vlyi60Uj);
		HttpEntity SUw89dx5 = pMIcfHkR.getEntity();
		if (SUw89dx5 != null) {
			String k3qbVewb = URLDecoder.decode(EntityUtils.toString(SUw89dx5), "UTF-8");
			log(INFO, k3qbVewb);
			UploadFileResponse dAut3RSR = (UploadFileResponse) CftMNx48.fromXML(k3qbVewb);
			return dAut3RSR.getFile();
		}
		return null;
	}

}