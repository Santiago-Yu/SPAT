class n22365062 {
	private void inject(int uu8PR2SQ, int MsK50Vj1) throws IOException {
		Tag MDgNRc0l = data.getTag();
		Log.event(Log.DEBUG_INFO, "source: " + MDgNRc0l.getString());
		if (MDgNRc0l == Tag.ORGANISM) {
			String mSJlYUNP = data.readString();
			data.readTag(Tag.STREAM);
			injectCodeTape(data.getIn(), mSJlYUNP, uu8PR2SQ, MsK50Vj1);
		} else if (MDgNRc0l == Tag.URL) {
			String JCuXnoDb = data.readString();
			String jJqF2FIh = JCuXnoDb.substring(JCuXnoDb.lastIndexOf('.') + 1);
			BufferedReader Ss645nDt = null;
			try {
				Ss645nDt = new BufferedReader(new InputStreamReader(new URL(JCuXnoDb).openStream()));
				injectCodeTape(Ss645nDt, jJqF2FIh, uu8PR2SQ, MsK50Vj1);
			} finally {
				if (Ss645nDt != null)
					Ss645nDt.close();
			}
		} else
			data.writeString("unknown organism source: " + MDgNRc0l.getString());
	}

}