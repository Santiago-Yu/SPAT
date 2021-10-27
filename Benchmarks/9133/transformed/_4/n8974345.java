class n8974345 {
	public String sruRead(String initialURL) {
		out('\n');
		out("    trying: ");
		out(initialURL);
		out('\n');
		numTests++;
		URL url = null;
		try {
			url = new URL(initialURL);
		} catch (java.net.MalformedURLException e) {
			out("</pre><pre class='red'>");
			out("test failed: using URL: ");
			out(e.getMessage());
			out('\n');
			out("</pre><pre>");
			return null;
		}
		HttpURLConnection huc = null;
		try {
			huc = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			out("</pre><pre class='red'>");
			out("test failed: using URL: ");
			out(e.getMessage());
			out('\n');
			out("</pre><pre>");
			return null;
		}
		String contentType = huc.getContentType();
		if (contentType == null
				|| (contentType.indexOf("text/xml") < 0 && contentType.indexOf("application/xml") < 0)) {
			out("  ** Warning: Content-Type not set to text/xml or application/xml");
			out('\n');
			out("    Content-type: ");
			out(contentType);
			out('\n');
			numWarns++;
		}
		InputStream urlStream = null;
		try {
			urlStream = huc.getInputStream();
		} catch (java.io.IOException e) {
			out("</pre><pre class='red'>");
			out("test failed: opening URL: ");
			out(e.getMessage());
			out('\n');
			out("</pre><pre>");
			return null;
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(urlStream));
		boolean xml = true;
		String href = null, inputLine = null;
		StringBuffer content = new StringBuffer(), stylesheet = null;
		Transformer transformer = null;
		try {
			inputLine = in.readLine();
		} catch (java.io.IOException e) {
			out("</pre><pre class='red'>");
			out("test failed: reading first line of response: ");
			out(e.getMessage());
			out('\n');
			out("</pre><pre>");
			return null;
		}
		if (inputLine == null) {
			out("</pre><pre class='red'>");
			out("test failed: No input read from URL");
			out('\n');
			out("</pre><pre>");
			return null;
		}
		if (!inputLine.startsWith("<?xml ")) {
			xml = false;
			content.append(inputLine);
		}
		if (xml) {
			int offset = inputLine.indexOf('>');
			if (offset + 2 < inputLine.length()) {
				inputLine = inputLine.substring(offset + 1);
				offset = inputLine.indexOf('<');
				inputLine = (offset > 0) ? inputLine.substring(offset) : inputLine;
			} else
				try {
					inputLine = in.readLine();
					while (inputLine.length() == 0)
						inputLine = in.readLine();
				} catch (java.io.IOException e) {
					out("</pre><pre class='red'>");
					out("test failed: reading response: ");
					out(e.getMessage());
					out('\n');
					out("</pre><pre>");
					return null;
				}
			if (inputLine.startsWith("<?xml-stylesheet ")) {
				offset = inputLine.indexOf("href=");
				href = (inputLine.substring(inputLine.indexOf("href=") + 6));
				href = href.substring(0, href.indexOf('"'));
				transformer = (Transformer) transformers.get(href);
				if (stylesheets.get(href) == null)
					try {
						out("        reading stylesheet: ");
						out(href);
						out('\n');
						out("           from source: ");
						out(url.toString());
						out('\n');
						StreamSource source = new StreamSource(url.toString());
						TransformerFactory tFactory = TransformerFactory.newInstance();
						Source stylesht = tFactory.getAssociatedStylesheet(source, null, null, null);
						transformer = tFactory.newTransformer(stylesht);
						transformers.put(href, transformer);
					} catch (Exception e) {
						e.printStackTrace();
						out("</pre><pre class='red'>");
						out("unable to load stylesheet: ");
						out(e.getMessage());
						out('\n');
						out("</pre><pre>");
					}
				stylesheets.put(href, href);
			} else
				content.append(inputLine);
		}
		try {
			while ((inputLine = in.readLine()) != null)
				content.append(inputLine);
		} catch (java.io.IOException e) {
			out("</pre><pre class='red'>");
			out("test failed: reading response: ");
			out(e.getMessage());
			out('\n');
			out("</pre><pre>");
			return null;
		}
		String contentStr = content.toString();
		if (transformer != null) {
			StreamSource streamXMLRecord = new StreamSource(new StringReader(contentStr));
			StringWriter xmlRecordWriter = new StringWriter();
			try {
				transformer.transform(streamXMLRecord, new StreamResult(xmlRecordWriter));
				out("        successfully applied stylesheet '");
				out(href);
				out("'");
				out('\n');
			} catch (javax.xml.transform.TransformerException e) {
				out("</pre><pre class='red'>");
				out("unable to apply stylesheet '");
				out(href);
				out("'to response: ");
				out(e.getMessage());
				out('\n');
				out("</pre><pre>");
				e.printStackTrace();
			}
		}
		return contentStr;
	}

}