class n20374942 {
	public TestReport runImpl() throws Exception {
		DefaultTestReport xHnt9Okp = new DefaultTestReport(this);
		ParsedURL MyDIrnxn;
		try {
			MyDIrnxn = new ParsedURL(base);
		} catch (Exception A636FEhQ) {
			StringWriter oQPsxzHW = new StringWriter();
			A636FEhQ.printStackTrace(new PrintWriter(oQPsxzHW));
			xHnt9Okp.setErrorCode(ERROR_CANNOT_PARSE_URL);
			xHnt9Okp.setDescription(new TestReport.Entry[] {
					new TestReport.Entry(TestMessages.formatMessage(ENTRY_KEY_ERROR_DESCRIPTION, null),
							TestMessages.formatMessage(ERROR_CANNOT_PARSE_URL,
									new String[] { "null", base, oQPsxzHW.toString() })) });
			xHnt9Okp.setPassed(false);
			return xHnt9Okp;
		}
		byte[] QWv5nw3J = new byte[5];
		int M4jODjyi = 0;
		try {
			InputStream MIgQ6OjW = MyDIrnxn.openStream();
			M4jODjyi = MIgQ6OjW.read(QWv5nw3J);
		} catch (IOException iTO7nNhx) {
			iTO7nNhx.printStackTrace();
		}
		StringBuffer HmYxEwR5 = new StringBuffer();
		for (int uIlYOjLO = 0; uIlYOjLO < M4jODjyi; uIlYOjLO++) {
			int bcr6ns3V = ((int) QWv5nw3J[uIlYOjLO]) & 0xFF;
			if (bcr6ns3V < 16) {
				HmYxEwR5.append("0");
			}
			HmYxEwR5.append(Integer.toHexString(bcr6ns3V) + " ");
		}
		String eG9fAF7I = ("CT: " + MyDIrnxn.getContentType() + " CE: " + MyDIrnxn.getContentEncoding() + " DATA: "
				+ HmYxEwR5 + "URL: " + MyDIrnxn);
		if (ref.equals(eG9fAF7I)) {
			xHnt9Okp.setPassed(true);
			return xHnt9Okp;
		}
		xHnt9Okp.setErrorCode(ERROR_WRONG_RESULT);
		xHnt9Okp.setDescription(new TestReport.Entry[] {
				new TestReport.Entry(TestMessages.formatMessage(ENTRY_KEY_ERROR_DESCRIPTION, null),
						TestMessages.formatMessage(ERROR_WRONG_RESULT, new String[] { eG9fAF7I, ref })) });
		xHnt9Okp.setPassed(false);
		return xHnt9Okp;
	}

}