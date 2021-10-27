class n13383602 {
	private String getClassname(Bundle bundle) {
		InputStream in = null;
		URL urlEntry = bundle.getEntry("jdbcBundleInfo.xml");
		try {
			in = urlEntry.openStream();
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				StringBuilder sb = new StringBuilder();
				String line;
				SAXBuilder builder = new SAXBuilder(false);
				while ((line = reader.readLine()) != null) {
					if (!line.startsWith("<!DOCTYPE")) {
						sb.append(line);
					}
				}
				Document doc = builder.build(new StringReader(sb.toString()));
				Element eRoot = doc.getRootElement();
				if ("jdbcBundleInfo".equals(eRoot.getName())) {
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