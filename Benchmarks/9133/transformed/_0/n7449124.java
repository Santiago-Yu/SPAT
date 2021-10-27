class n7449124 {
	private long getRecordedSessionLength() {
		long RfYR8TGP = -1;
		String GmWD4D3z = this.applet.getParameter(Constants.PLAYBACK_MEETING_LENGTH_PARAM);
		if (null != GmWD4D3z) {
			RfYR8TGP = (new Long(GmWD4D3z)).longValue();
		} else {
			Properties fuoQHx1j = new Properties();
			try {
				URL MTTZMb0x = new URL(applet.getDocumentBase(), Constants.RECORDED_SESSION_INFO_PROPERTIES);
				fuoQHx1j.load(MTTZMb0x.openStream());
				RfYR8TGP = (new Long(fuoQHx1j.getProperty(Constants.PLAYBACK_MEETING_LENGTH_PARAM))).longValue();
			} catch (Exception QHAI4pO3) {
				QHAI4pO3.printStackTrace();
			}
		}
		return RfYR8TGP;
	}

}