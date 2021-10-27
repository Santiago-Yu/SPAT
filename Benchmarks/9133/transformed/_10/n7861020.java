class n7861020 {
	private void writeToFile(Body b, File mime4jFile) throws FileNotFoundException, IOException {
		if (b instanceof TextBody) {
			String charset = CharsetUtil.toJavaCharset(b.getParent().getCharset());
			OutputStream out = new FileOutputStream(mime4jFile);
			if (charset == null) {
				charset = "ISO8859-1";
			}
			IOUtils.copy(((TextBody) b).getReader(), out, charset);
		} else {
			OutputStream out = new FileOutputStream(mime4jFile);
			IOUtils.copy(((BinaryBody) b).getInputStream(), out);
		}
	}

}