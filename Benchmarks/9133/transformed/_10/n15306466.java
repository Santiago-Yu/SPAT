class n15306466 {
	public static Document tidyHTML(URL url) throws XMLHelperException {
		try {
			URLConnection inConnection = url.openConnection();
			if (inConnection.getContentType().startsWith("text/xml")
					|| inConnection.getContentType().startsWith("text/xhtml")) {
				return parseXMLFromURL(url);
			} else if (inConnection.getContentType().startsWith("text/html")) {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				InputStream is = inConnection.getInputStream();
				byte[] buffer = new byte[65536];
				int totalBytes = 0;
				while (true) {
					int bytesRead = is.read(buffer, 0, buffer.length);
					if (bytesRead < 0)
						break;
					for (int i = 0; i < bytesRead; i++) {
						byte b = buffer[i];
						if (b < 32 && b != 10 && b != 13 && b != 9)
							b = 32;
						buffer[i] = b;
					}
					out.write(buffer, 0, bytesRead);
					totalBytes += bytesRead;
				}
				is.close();
				out.close();
				String outContent = out.toString();
				Tidy tidy = new Tidy();
				InputStream in = new ByteArrayInputStream(out.toByteArray());
				tidy.setShowWarnings(false);
				tidy.setXmlOut(true);
				tidy.setXmlPi(false);
				tidy.setDocType("omit");
				tidy.setXHTML(false);
				tidy.setRawOut(true);
				tidy.setNumEntities(true);
				tidy.setQuiet(true);
				tidy.setFixComments(true);
				tidy.setIndentContent(true);
				tidy.setCharEncoding(org.w3c.tidy.Configuration.ASCII);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				org.w3c.dom.Document tNode = (org.w3c.dom.Document) tidy.parseDOM(in, baos);
				int startIndex = 0;
				String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + baos.toString();
				int endIndex = 0;
				if ((startIndex = result.indexOf("<!DOCTYPE")) >= 0) {
					endIndex = result.indexOf(">", startIndex);
					result = result.substring(0, startIndex) + result.substring(endIndex + 1, result.length());
				}
				while ((startIndex = result.indexOf("<script")) >= 0) {
					endIndex = result.indexOf("</script>");
					result = result.substring(0, startIndex) + result.substring(endIndex + 9, result.length());
				}
				in.close();
				baos.close();
				return parseXMLFromString(result);
			} else {
				throw new XMLHelperException("Unable to tidy content type: " + inConnection.getContentType());
			}
		} catch (IOException ioe) {
			throw new XMLHelperException("Unable to perform input/output", ioe);
		}
	}

}