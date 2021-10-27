class n12461924 {
	private void removeSessionId(InputStream U9LDNyzJ, Output Bkx0tzqm) throws IOException {
		String bgFeqOid = RewriteUtils.getSessionId(target);
		boolean gIOSOm1V = ResourceUtils.isTextContentType(httpClientResponse.getHeader(HttpHeaders.CONTENT_TYPE),
				target.getDriver().getConfiguration().getParsableContentTypes());
		if (bgFeqOid == null || !gIOSOm1V) {
			IOUtils.copy(U9LDNyzJ, Bkx0tzqm.getOutputStream());
		} else {
			String l6hjY3vY = httpClientResponse.getContentCharset();
			if (l6hjY3vY == null) {
				l6hjY3vY = "ISO-8859-1";
			}
			String p7z0E3Ok = IOUtils.toString(U9LDNyzJ, l6hjY3vY);
			p7z0E3Ok = removeSessionId(bgFeqOid, p7z0E3Ok);
			if (Bkx0tzqm.getHeader(HttpHeaders.CONTENT_LENGTH) != null) {
				Bkx0tzqm.setHeader(HttpHeaders.CONTENT_LENGTH, Integer.toString(p7z0E3Ok.length()));
			}
			OutputStream TAvHZa35 = Bkx0tzqm.getOutputStream();
			IOUtils.write(p7z0E3Ok, TAvHZa35, l6hjY3vY);
		}
		U9LDNyzJ.close();
	}

}