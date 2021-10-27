class n12138255 {
	public static void loadPoFile(URL url) {
		states state = states.IDLE;
		String msgCtxt = "";
		String msgId = "";
		String msgStr = "";
		try {
			if (null == url)
				return;
			InputStream in = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF8"));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				if (strLine.startsWith("msgctxt")) {
					if (state != states.MSGCTXT)
						msgCtxt = "";
					state = states.MSGCTXT;
					strLine = strLine.substring(7).trim();
				}
				if (strLine.startsWith("msgid")) {
					if (state != states.MSGID)
						msgId = "";
					state = states.MSGID;
					strLine = strLine.substring(5).trim();
				}
				if (strLine.startsWith("msgstr")) {
					if (state != states.MSGSTR)
						msgStr = "";
					state = states.MSGSTR;
					strLine = strLine.substring(6).trim();
				}
				if (!strLine.startsWith("\"")) {
					state = states.IDLE;
					msgCtxt = "";
					msgId = "";
					msgStr = "";
				} else {
					if (states.MSGCTXT == state) {
						msgCtxt += format(strLine);
					}
					if (states.MSGID == state) {
						if (msgId.isEmpty()) {
							if (!msgCtxt.isEmpty()) {
								msgId = msgCtxt + "|";
								msgCtxt = "";
							}
						}
						msgId += format(strLine);
					}
					if (states.MSGSTR == state) {
						msgCtxt = "";
						msgStr += format(strLine);
						if (!msgId.isEmpty())
							messages.setProperty(msgId, msgStr);
					}
				}
			}
			in.close();
		} catch (IOException e) {
			Logger.logError(e, "Error loading message.po.");
		}
	}

}