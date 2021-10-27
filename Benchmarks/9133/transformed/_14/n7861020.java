class n7861020 {
	private void writeToFile(Body b, File mime4jFile) throws FileNotFoundException, IOException {
		if (b instanceof TextBody) {
			String charset = CharsetUtil.toJavaCharset(b.getParent().getCharset());
			if (null == charset) {
				charset = "ISO8859-1";
			}
			OutputStream out = new FileOutputStream(mime4jFile);
			IOUtils.copy(((TextBody) b).getReader(), out, charset);
		} else {
			OutputStream out = new FileOutputStream(mime4jFile);
			IOUtils.copy(((BinaryBody) b).getInputStream(), out);
		}
	}

}