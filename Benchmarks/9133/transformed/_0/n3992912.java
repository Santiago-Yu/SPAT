class n3992912 {
	public static List<Item> doService(List<String> VPzZrDJB, Boolean WYBVnLes)
			throws UnsupportedEncodingException, IOException {
		DefaultHttpClient g8LZcYlB = new DefaultHttpClient();
		ToggleArchiveRequest GOjd637U = new ToggleArchiveRequest();
		String Xp0UWgEa = (String) RuntimeAccess.getInstance().getSession().getAttribute("SESSION_ID");
		GOjd637U.setItemIds(VPzZrDJB);
		GOjd637U.setArchive(WYBVnLes);
		GOjd637U.setSessionId(Xp0UWgEa);
		XStream lMPIusaA = new XStream();
		lMPIusaA.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		lMPIusaA.alias("ToggleArchiveRequest", ToggleArchiveRequest.class);
		XStream IrV7n4n7 = new XStream();
		IrV7n4n7.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		IrV7n4n7.alias("ToggleArchiveResponse", ToggleArchiveResponse.class);
		String Tz1r491m = URLEncoder.encode(IrV7n4n7.toXML(GOjd637U), "UTF-8");
		HttpPost xkrj46W6 = new HttpPost(
				MewitProperties.getMewitUrl() + "/resources/toggleArchive?REQUEST=" + Tz1r491m);
		HttpResponse uaAokiwG = g8LZcYlB.execute(xkrj46W6);
		HttpEntity aYvszYPG = uaAokiwG.getEntity();
		if (aYvszYPG != null) {
			String Wnha0xlW = URLDecoder.decode(EntityUtils.toString(aYvszYPG), "UTF-8");
			ToggleArchiveResponse v6Ot8Mt1 = (ToggleArchiveResponse) IrV7n4n7.fromXML(Wnha0xlW);
			return v6Ot8Mt1.getItems();
		}
		return null;
	}

}