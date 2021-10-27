class n8119563 {
	protected boolean checkLink(URL yzuus6jq) {
		try {
			URLConnection KRmwMveo = yzuus6jq.openConnection();
			KRmwMveo.connect();
			return true;
		} catch (IOException UJlwE1Wy) {
			MsgLog.error("DapParser.checkLink(): IOException: " + UJlwE1Wy.toString());
			return false;
		}
	}

}