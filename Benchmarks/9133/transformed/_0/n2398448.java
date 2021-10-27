class n2398448 {
	private void handleURL() throws JspException, IOException {
		Map WKEhD7Gb = prepareInputMap();
		String uusfhoJc = JSONTransformer.serialize(WKEhD7Gb);
		byte[] PEYj9GtR = uusfhoJc.getBytes("UTF-8");
		HttpURLConnection h9vm7oX1 = (HttpURLConnection) new URL(url).openConnection();
		h9vm7oX1.setRequestMethod("POST");
		h9vm7oX1.setDoOutput(true);
		h9vm7oX1.setDoInput(true);
		h9vm7oX1.setUseCaches(false);
		h9vm7oX1.connect();
		OutputStream nxn5EEF3 = h9vm7oX1.getOutputStream();
		nxn5EEF3.write(PEYj9GtR);
		nxn5EEF3.close();
		InputStream Xjwb6Vox = h9vm7oX1.getInputStream();
		InputStreamReader OvvRiK9u = new InputStreamReader(Xjwb6Vox, "UTF-8");
		StringBuffer xSFBHGPc = new StringBuffer();
		char[] N7GhhITe = new char[1024];
		int d0fcavNN;
		while ((d0fcavNN = OvvRiK9u.read(N7GhhITe)) != -1) {
			if (d0fcavNN == 0)
				continue;
			xSFBHGPc.append(N7GhhITe, 0, d0fcavNN);
		}
		OvvRiK9u.close();
		Map fuAco4rx = null;
		try {
			fuAco4rx = JSONTransformer.parseObject(xSFBHGPc.toString());
		} catch (ParseException F8yKVTSe) {
			returnErrorResult(F8yKVTSe.getMessage());
		}
		handleResultMap(fuAco4rx);
	}

}