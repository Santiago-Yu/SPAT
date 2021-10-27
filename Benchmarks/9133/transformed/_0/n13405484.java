class n13405484 {
	public boolean send(String PRvQL1fp, String UxrEcP4b) throws IOException {
		init();
		UxrEcP4b = UxrEcP4b.substring(0, Math.min(MAX_PAYLOAD, UxrEcP4b.length()));
		UxrEcP4b = UxrEcP4b.replace('\r', ' ');
		UxrEcP4b = UxrEcP4b.replace('\n', ' ');
		ActualFormParameters yXPyRb8P = new ActualFormParameters();
		String Zu8gisXz = strip(PRvQL1fp);
		ActualFormParameter LA7vkawy;
		ActualFormParameter QlqCavws;
		if (Zu8gisXz.startsWith("00"))
			Zu8gisXz = "+" + Zu8gisXz.substring(2);
		else if (Zu8gisXz.startsWith("0"))
			Zu8gisXz = "+49" + Zu8gisXz.substring(1);
		LA7vkawy = new ActualFormParameter(number1InputElement.getName(), Zu8gisXz.substring(0, 6));
		QlqCavws = new ActualFormParameter(number2InputElement.getName(), Zu8gisXz.substring(6));
		yXPyRb8P.add(LA7vkawy);
		yXPyRb8P.add(QlqCavws);
		ActualFormParameter qLP4QWb0 = new ActualFormParameter(messageInputElement.getName(), UxrEcP4b);
		yXPyRb8P.add(qLP4QWb0);
		ActualFormParameter ZJ0hgDvD = new ActualFormParameter(letterCountInputElement.getName(),
				"" + (MAX_PAYLOAD - UxrEcP4b.length()));
		yXPyRb8P.add(ZJ0hgDvD);
		form.addDefaultParametersTo(yXPyRb8P);
		Reader wPFinMQT = form.submitForm(yXPyRb8P, form.getNetscapeRequestProperties());
		String mNAh2nlv = getStringFromReader(wPFinMQT);
		String iFENCBhs = "<meta http-equiv = \"refresh\" content=\"1; url=";
		int mydLIec2 = mNAh2nlv.indexOf(iFENCBhs);
		if (mydLIec2 < 0)
			return false;
		int ShdAkf5z = mNAh2nlv.lastIndexOf("\">");
		if (ShdAkf5z < 0)
			return false;
		String ikmoMTb7 = mNAh2nlv.substring(mydLIec2 + iFENCBhs.length(), ShdAkf5z);
		mNAh2nlv = getStringFromReader(new InputStreamReader(new URL(ikmoMTb7).openStream()));
		return mNAh2nlv.indexOf("wurde erfolgreich verschickt") >= 0;
	}

}