class n20374942 {
	public TestReport runImpl() throws Exception {
		ParsedURL purl;
		DefaultTestReport report = new DefaultTestReport(this);
		byte[] data = new byte[5];
		try {
			purl = new ParsedURL(base);
		} catch (Exception e) {
			StringWriter trace = new StringWriter();
			e.printStackTrace(new PrintWriter(trace));
			report.setErrorCode(ERROR_CANNOT_PARSE_URL);
			report.setDescription(new TestReport.Entry[] {
					new TestReport.Entry(TestMessages.formatMessage(ENTRY_KEY_ERROR_DESCRIPTION, null), TestMessages
							.formatMessage(ERROR_CANNOT_PARSE_URL, new String[] { "null", base, trace.toString() })) });
			report.setPassed(false);
			return report;
		}
		int num = 0;
		StringBuffer sb = new StringBuffer();
		try {
			InputStream is = purl.openStream();
			num = is.read(data);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		for (int i = 0; i < num; i++) {
			int val = ((int) data[i]) & 0xFF;
			if (val < 16) {
				sb.append("0");
			}
			sb.append(Integer.toHexString(val) + " ");
		}
		String info = ("CT: " + purl.getContentType() + " CE: " + purl.getContentEncoding() + " DATA: " + sb + "URL: "
				+ purl);
		if (ref.equals(info)) {
			report.setPassed(true);
			return report;
		}
		report.setErrorCode(ERROR_WRONG_RESULT);
		report.setDescription(new TestReport.Entry[] {
				new TestReport.Entry(TestMessages.formatMessage(ENTRY_KEY_ERROR_DESCRIPTION, null),
						TestMessages.formatMessage(ERROR_WRONG_RESULT, new String[] { info, ref })) });
		report.setPassed(false);
		return report;
	}

}