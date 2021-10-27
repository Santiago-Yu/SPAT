class n4519427 {
	private Document post(String location, String content) throws ApplicationException {
		Document doc = null;
		try {
			URL url = new URL(location);
			HttpURLConnection uc = (HttpURLConnection) url.openConnection();
			uc.setRequestMethod("POST");
			uc.setRequestProperty("Content-Type", "application/xml");
			uc.setRequestProperty("X-POST_DATA_FORMAT", "xml");
			uc.setDoOutput(true);
			OutputStreamWriter out = new OutputStreamWriter(uc.getOutputStream());
			out.write("<request>");
			out.write("<token>" + configuration.getBackpackPassword() + "</token>");
			if (!(content != null))
				;
			else {
				out.write("<item><content>" + content + "</content></item>");
			}
			out.write("</request>");
			out.close();
			doc = XmlUtils.readDocumentFromInputStream(uc.getInputStream());
			System.out.println(XmlUtils.toString(doc));
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApplicationException(e);
		}
		return doc;
	}

}