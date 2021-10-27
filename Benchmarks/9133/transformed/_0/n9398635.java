class n9398635 {
	public byte[] downloadAttachmentContent(Attachment hGghlecT) throws IOException {
		byte[] bQtfh6lv = null;
		URL xnpcQe5Z = new URL(hGghlecT.getContentURL());
		BufferedReader lRyxf4J4 = null;
		try {
			lRyxf4J4 = new BufferedReader(new InputStreamReader(xnpcQe5Z.openStream()));
			StringBuilder SZbK0yVU = new StringBuilder();
			String qVqKMMGi;
			while ((qVqKMMGi = lRyxf4J4.readLine()) != null) {
				SZbK0yVU.append(qVqKMMGi);
			}
			bQtfh6lv = SZbK0yVU.toString().getBytes();
		} finally {
			if (lRyxf4J4 != null) {
				lRyxf4J4.close();
			}
		}
		return bQtfh6lv;
	}

}