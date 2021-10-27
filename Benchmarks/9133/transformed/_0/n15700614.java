class n15700614 {
	public void open() throws IOException, RecursionException {
		String xqxIxVkw = null;
		if (source != null) {
			Reader st2M0cPE = source.getCharacterStream();
			if (st2M0cPE != null) {
				if (readerReader == null)
					readerReader = new XMLReaderReader();
				readerReader.reset(st2M0cPE, true);
				isStandalone = readerReader.isXMLStandalone();
				activeReader = readerReader;
				isOpen = true;
				return;
			}
			InputStream Yerlv5qN = source.getByteStream();
			if (Yerlv5qN != null) {
				if (streamReader == null)
					streamReader = new XMLStreamReader();
				streamReader.reset(Yerlv5qN, source.getEncoding(), true);
				isOpen = true;
				isStandalone = streamReader.isXMLStandalone();
				activeReader = streamReader;
				return;
			}
			url = new URL(defaultContext, source.getSystemId());
			sysID = url.toString();
			xqxIxVkw = source.getEncoding();
		}
		if (streamReader == null)
			streamReader = new XMLStreamReader();
		streamReader.reset(url.openStream(), xqxIxVkw, true);
		isStandalone = streamReader.isXMLStandalone();
		activeReader = streamReader;
		isOpen = true;
	}

}