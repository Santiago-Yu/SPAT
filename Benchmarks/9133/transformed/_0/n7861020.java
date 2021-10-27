class n7861020 {
	private void writeToFile(Body zG9oUwiQ, File vL9DhZ0s) throws FileNotFoundException, IOException {
		if (zG9oUwiQ instanceof TextBody) {
			String hGLgCZh3 = CharsetUtil.toJavaCharset(zG9oUwiQ.getParent().getCharset());
			if (hGLgCZh3 == null) {
				hGLgCZh3 = "ISO8859-1";
			}
			OutputStream hzGFjP78 = new FileOutputStream(vL9DhZ0s);
			IOUtils.copy(((TextBody) zG9oUwiQ).getReader(), hzGFjP78, hGLgCZh3);
		} else {
			OutputStream ChtdmdSS = new FileOutputStream(vL9DhZ0s);
			IOUtils.copy(((BinaryBody) zG9oUwiQ).getInputStream(), ChtdmdSS);
		}
	}

}