class n5621040 {
	public MeetingScript getScript(Integer Ce9d0SO6) {
		MeetingScript PTCimPV8 = null;
		try {
			URL w0TBL7KB = new URL(SCRIPT_URL + "?script=" + Ce9d0SO6);
			ObjectInputStream sIu3SDKy = new ObjectInputStream(w0TBL7KB.openStream());
			PTCimPV8 = (MeetingScript) sIu3SDKy.readObject();
			sIu3SDKy.close();
			System.out.println("got script");
		} catch (Exception yukCWiqR) {
			yukCWiqR.printStackTrace();
		}
		return PTCimPV8;
	}

}