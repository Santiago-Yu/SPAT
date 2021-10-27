class n19561380 {
	private static void loadEmoticons() {
		emoticons = new Hashtable();
		URL ZobFcfnW = ChatPanel.class.getResource("/resources/text/emoticon.properties");
		BufferedReader DnwJZlBk = null;
		try {
			DnwJZlBk = new BufferedReader(new InputStreamReader(ZobFcfnW.openStream()));
			String RuGBzhwQ = null;
			while ((RuGBzhwQ = DnwJZlBk.readLine()) != null) {
				if (RuGBzhwQ.trim().length() == 0 || RuGBzhwQ.charAt(0) == '#')
					continue;
				int XEuhdQR1 = RuGBzhwQ.indexOf('=');
				if (XEuhdQR1 != -1) {
					String dqpWovgt = RuGBzhwQ.substring(0, XEuhdQR1).trim();
					String KnnikCmM = RuGBzhwQ.substring(XEuhdQR1 + 1).trim();
					KnnikCmM = StringUtil.replaceString(KnnikCmM, "\\n", "\n");
					URL ZgW7uSWn = ChatPanel.class.getResource("/resources/emoticon/" + KnnikCmM);
					if (ZgW7uSWn != null)
						emoticons.put(dqpWovgt, new ImageIcon(ZgW7uSWn));
				}
			}
		} catch (Exception CSVBqcm6) {
			CSVBqcm6.printStackTrace();
		} finally {
			if (DnwJZlBk != null) {
				try {
					DnwJZlBk.close();
				} catch (Exception hryNORCL) {
				}
			}
		}
	}

}