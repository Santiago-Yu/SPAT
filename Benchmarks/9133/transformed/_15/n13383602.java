class n13383602 {
	private String getClassname(Bundle bundle) {
		URL urlEntry = bundle.getEntry("jdbcBundleInfo.xml");
		InputStream in = null;
		try {
			in = urlEntry.openStream();
			try {
				StringBuilder sb = new StringBuilder();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				String line;
				while ((line = reader.readLine()) != null) {
					if (!line.startsWith("<!DOCTYPE")) {
						sb.append(line);
					}
				}
				SAXBuilder builder = new SAXBuilder(false);
				Document doc = builder.build(new StringReader(sb.toString()));
				Element eRoot = doc.getRootElement();
				if ((eRoot.getName() != null && eRoot.getName().equals("jdbcBundleInfo"))) {
					Attribute atri = eRoot.getAttribute("className");
					if (atri != null) {
						return atri.getValue();
					}
				}
			} catch (JDOMException e) {
			}
		} catch (IOException e) {
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		return null;
	}

}