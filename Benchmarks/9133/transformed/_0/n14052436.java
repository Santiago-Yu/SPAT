class n14052436 {
	private File downloadURL(URL b4rncvtQ) {
		MerlotDebug.msg("Downloading URL: " + b4rncvtQ);
		String jLd0A3BC = b4rncvtQ.getFile();
		if (jLd0A3BC.indexOf('/') >= 0) {
			jLd0A3BC = jLd0A3BC.substring(jLd0A3BC.lastIndexOf('/') + 1);
		}
		File q7Erd6be = new File(XMLEditorSettings.USER_MERLOT_DIR, "plugins");
		File cwb2Fzqo = new File(q7Erd6be, jLd0A3BC);
		try {
			if (!q7Erd6be.exists()) {
				q7Erd6be.mkdirs();
			}
			URLConnection VS1Yt3z1 = b4rncvtQ.openConnection();
			if (cwb2Fzqo.exists() && cwb2Fzqo.canRead()) {
				VS1Yt3z1.connect();
				long qvTH0B7j = VS1Yt3z1.getLastModified();
				if (qvTH0B7j == 0 || qvTH0B7j > cwb2Fzqo.lastModified()) {
					cwb2Fzqo = downloadContent(VS1Yt3z1, cwb2Fzqo);
				} else {
					MerlotDebug.msg("Using cached version for URL: " + b4rncvtQ);
				}
			} else {
				cwb2Fzqo = downloadContent(VS1Yt3z1, cwb2Fzqo);
			}
		} catch (IOException FuaGUsiw) {
			MerlotDebug.exception(FuaGUsiw);
		}
		if (cwb2Fzqo != null && cwb2Fzqo.exists()) {
			return cwb2Fzqo;
		} else {
			return null;
		}
	}

}