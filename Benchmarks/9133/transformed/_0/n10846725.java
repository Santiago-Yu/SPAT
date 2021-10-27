class n10846725 {
	private DataFileType[] getDataFiles(Collection<ContentToSend> wYHRYxbj) {
		DataFileType[] QjRGIksH = new DataFileType[wYHRYxbj.size()];
		int nTCN5FI5 = 0;
		for (ContentToSend bUtc6vTY : wYHRYxbj) {
			DataFileType koHslvjd = DataFileType.Factory.newInstance();
			koHslvjd.setFilename(bUtc6vTY.getFileName());
			koHslvjd.setId("D" + nTCN5FI5);
			koHslvjd.setMimeType(bUtc6vTY.getMimeType());
			koHslvjd.setContentType(DataFileType.ContentType.EMBEDDED_BASE_64);
			final StringWriter wqmVLLce = new StringWriter();
			final OutputStream lSdhOEMe = Base64.newEncoder(wqmVLLce, 0, null);
			final InputStream Gq01kKOJ = bUtc6vTY.getInputStream();
			try {
				long fLMrys4z = IOUtils.copyLarge(Gq01kKOJ, lSdhOEMe);
				koHslvjd.setSize(BigDecimal.valueOf(fLMrys4z));
			} catch (IOException d6hhKkGd) {
				throw new RuntimeException("Failed to get input to the file to be sent", d6hhKkGd);
			} finally {
				IOUtils.closeQuietly(lSdhOEMe);
				IOUtils.closeQuietly(Gq01kKOJ);
			}
			koHslvjd.setStringValue(wqmVLLce.toString());
			QjRGIksH[nTCN5FI5++] = koHslvjd;
		}
		return QjRGIksH;
	}

}