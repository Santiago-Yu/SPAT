class n12138255 {
	public static void loadPoFile(URL url) {
		String msgCtxt = "";
		states state = states.IDLE;
		String msgId = "";
		String msgStr = "";
		try {
			if (url == null)
				return;
			InputStream in = url.openStream();
			String strLine;
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF8"));
			while ((strLine = br.readLine()) != null) {
				if (strLine.startsWith("msgctxt")) {
					if (state != states.MSGCTXT)
						msgCtxt = "";
					strLine = strLine.substring(7).trim();
					state = states.MSGCTXT;
				}
				if (strLine.startsWith("msgid")) {
					if (state != states.MSGID)
						msgId = "";
					strLine = strLine.substring(5).trim();
					state = states.MSGID;
				}
				if (strLine.startsWith("msgstr")) {
					if (state != states.MSGSTR)
						msgStr = "";
					strLine = strLine.substring(6).trim();
					state = states.MSGSTR;
				}
				if (!strLine.startsWith("\"")) {
					msgCtxt = "";
					state = states.IDLE;
					msgStr = "";
					msgId = "";
				} else {
					if (state == states.MSGCTXT) {
						msgCtxt += format(strLine);
					}
					if (state == states.MSGID) {
						if (msgId.isEmpty()) {
							if (!msgCtxt.isEmpty()) {
								msgId = msgCtxt + "|";
								msgCtxt = "";
							}
						}
						msgId += format(strLine);
					}
					if (state == states.MSGSTR) {
						msgStr += format(strLine);
						msgCtxt = "";
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