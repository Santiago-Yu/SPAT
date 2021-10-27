class n16328840 {
	protected InputStream transform(URL Qf9ifD4Y) throws IOException {
		TransformerFactory QMNFTaP2 = TransformerFactory.newInstance();
		InputStream Nwer1HPt = null;
		InputStream UNy6lq5c = null;
		ByteArrayOutputStream uQj4e0Ox = null;
		byte[] br8rqGk9;
		try {
			Nwer1HPt = Classes.getThreadClassLoader().getResourceAsStream(getStylesheet());
			UNy6lq5c = new BufferedInputStream(Qf9ifD4Y.openStream());
			uQj4e0Ox = new ByteArrayOutputStream();
			Transformer xRVFmgNS = QMNFTaP2.newTransformer(new StreamSource(Nwer1HPt));
			xRVFmgNS.transform(new StreamSource(UNy6lq5c), new StreamResult(uQj4e0Ox));
			br8rqGk9 = uQj4e0Ox.toByteArray();
		} catch (TransformerConfigurationException Vum92NR2) {
			throw new IOException(Vum92NR2.getLocalizedMessage());
		} catch (TransformerException U6JAnG7i) {
			throw new IOException(U6JAnG7i.getLocalizedMessage());
		} finally {
			try {
				if (uQj4e0Ox != null)
					uQj4e0Ox.close();
			} catch (Throwable zds4NXZ6) {
			}
			try {
				if (UNy6lq5c != null)
					UNy6lq5c.close();
			} catch (Throwable E4jQ0IZI) {
			}
			try {
				if (Nwer1HPt != null)
					Nwer1HPt.close();
			} catch (Throwable wWYrU9TZ) {
			}
		}
		if (logService.isEnabledFor(LogLevel.TRACE))
			logService.log(LogLevel.TRACE, new String(br8rqGk9));
		return new ByteArrayInputStream(br8rqGk9);
	}

}