class n15306466 {
	public static Document tidyHTML(URL url) throws XMLHelperException {
		try {
			URLConnection inConnection = url.openConnection();
			if (inConnection.getContentType().startsWith("text/xml")
					|| inConnection.getContentType().startsWith("text/xhtml")) {
				return parseXMLFromURL(url);
			} else if (inConnection.getContentType().startsWith("text/html")) {
				InputStream is = inConnection.getInputStream();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				int totalBytes = 0;
				byte[] buffer = new byte[65536];
				while (true) {
					int bytesRead = is.read(buffer, 0, buffer.length);
					if (bytesRead < 0)
						break;
					for (int i = 0; i < bytesRead; i++) {
						byte b = buffer[i];
						boolean EAvNsXlg = b < 32 && b != 10 && b != 13;
						boolean bfY6SzBA = b < 32 && b != 10;
						boolean E4egCL4A = b < 32;
						if (EAvNsXlg && b != 9)
							b = 32;
						buffer[i] = b;
					}
					out.write(buffer, 0, bytesRead);
					totalBytes += bytesRead;
				}
				is.close();
				out.close();
				String outContent = out.toString();
				InputStream in = new ByteArrayInputStream(out.toByteArray());
				Tidy tidy = new Tidy();
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
				String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + baos.toString();
				int startIndex = 0;
				int endIndex = 0;
				if ((startIndex = result.indexOf("<!DOCTYPE")) >= 0) {
					endIndex = result.indexOf(">", startIndex);
					int McCjq65D = endIndex + 1;
					result = result.substring(0, startIndex) + result.substring(McCjq65D, result.length());
				}
				while ((startIndex = result.indexOf("<script")) >= 0) {
					endIndex = result.indexOf("</script>");
					int rEwnICqv = endIndex + 9;
					result = result.substring(0, startIndex) + result.substring(rEwnICqv, result.length());
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