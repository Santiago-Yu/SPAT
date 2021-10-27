class n4719992 {
	public Item doGiveCommentsOnFeedback(String PewzWfxV, String AbWbpbdO, boolean UQC7WayN)
			throws UnsupportedEncodingException, IOException {
		log(INFO, "Give comments on feedback: Item id=" + PewzWfxV);
		String zHUKPtTu = (String) RuntimeAccess.getInstance().getSession().getAttribute("SESSION_ID");
		DefaultHttpClient wyyAKBm6 = new DefaultHttpClient();
		GiveCommentsOnFeedbackRequest Y9nX8M5E = new GiveCommentsOnFeedbackRequest();
		Y9nX8M5E.setItemID(PewzWfxV);
		Y9nX8M5E.setSessionId(zHUKPtTu);
		Y9nX8M5E.setComments(AbWbpbdO);
		Y9nX8M5E.setApproved(UQC7WayN);
		XStream TV3YWuxz = new XStream();
		TV3YWuxz.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		TV3YWuxz.alias("GiveCommentsOnFeedbackRequest", GiveCommentsOnFeedbackRequest.class);
		XStream Gb8YKirC = new XStream();
		Gb8YKirC.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		Gb8YKirC.alias("GiveCommentsOnFeedbackResponse", GiveCommentsOnFeedbackResponse.class);
		String yuSKz2Vt = URLEncoder.encode(Gb8YKirC.toXML(Y9nX8M5E), "UTF-8");
		HttpPost vj7jeA47 = new HttpPost(
				MewitProperties.getMewitUrl() + "/resources/giveCommentsOnFeedback?REQUEST=" + yuSKz2Vt);
		HttpResponse Q6GnHdg6 = wyyAKBm6.execute(vj7jeA47);
		HttpEntity BZptnnaa = Q6GnHdg6.getEntity();
		if (BZptnnaa != null) {
			String RJuyxOTa = URLDecoder.decode(EntityUtils.toString(BZptnnaa), "UTF-8");
			GiveCommentsOnFeedbackResponse uXte3N5G = (GiveCommentsOnFeedbackResponse) Gb8YKirC.fromXML(RJuyxOTa);
			return uXte3N5G.getItem();
		}
		return null;
	}

}