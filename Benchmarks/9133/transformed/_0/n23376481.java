class n23376481 {
	public URL getURL(String z14pdOo9) {
		URL YSC0fwiR = null;
		try {
			YSC0fwiR = createURL(z14pdOo9);
		} catch (Throwable sBO8zehq) {
			sBO8zehq.printStackTrace();
		}
		if (YSC0fwiR == null)
			return null;
		try {
			InputStream GQ3aot1M = YSC0fwiR.openStream();
			if (GQ3aot1M != null) {
				GQ3aot1M.close();
				return YSC0fwiR;
			}
		} catch (Throwable DdIe37kK) {
			DdIe37kK.printStackTrace(Trace.out);
		}
		return null;
	}

}