class n20675046 {
	public Object getContent(ContentProducerContext context, String ctxAttrName, Object ctxAttrValue) {
		try {
			URL url;
			if ((getURL() != null))
				url = new URL(getURL().toExternalForm());
			else
				url = new URL(((URL) ctxAttrValue).toExternalForm());
			InputStream reader = url.openStream();
			int available = reader.available();
			byte contents[] = new byte[available];
			reader.read(contents, 0, available);
			reader.close();
			return new String(contents);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ex.toString();
		}
	}

}