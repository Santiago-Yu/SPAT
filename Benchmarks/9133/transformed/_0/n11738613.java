class n11738613 {
	public String move(Integer hLboWlNC) {
		LOG.debug("move " + hLboWlNC);
		StringBuffer SlSMb4iT = new StringBuffer();
		try {
			URL pOo4ht3P = new URL("http://" + host + "/decoder_control.cgi?command=" + hLboWlNC + "&user=" + user
					+ "&pwd=" + password);
			URLConnection CfTf5KfI = pOo4ht3P.openConnection();
			BufferedReader eEmycJAj = new BufferedReader(new InputStreamReader(CfTf5KfI.getInputStream()));
			String ZBf5u52l;
			while ((ZBf5u52l = eEmycJAj.readLine()) != null) {
				SlSMb4iT.append(ZBf5u52l);
			}
			eEmycJAj.close();
		} catch (Exception CGoKDNYG) {
			logException(CGoKDNYG);
			connect(host, user, password);
		}
		return SlSMb4iT.toString();
	}

}