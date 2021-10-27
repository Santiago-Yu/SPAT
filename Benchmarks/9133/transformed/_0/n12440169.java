class n12440169 {
	public String openFileAsText(String zK1rXLL3) throws IOException {
		StringWriter uHaVOaHk = new StringWriter();
		InputStreamReader vgPXyrNU = new InputStreamReader(openFile(zK1rXLL3));
		try {
			IOUtils.copy(vgPXyrNU, uHaVOaHk);
		} finally {
			IOUtils.closeQuietly(vgPXyrNU);
		}
		return uHaVOaHk.toString();
	}

}