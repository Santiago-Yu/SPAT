class n23035537 {
	public boolean getContent(String rm8g3Ff8, String iMLq9ivl) {
		try {
			String CeboK0Fs = "http://api.fanfou.com/statuses/user_timeline.xml?id=" + rm8g3Ff8 + "&since_id="
					+ iMLq9ivl;
			URL VltUVSKV = new URL(CeboK0Fs);
			InputStream USVFxPWK = VltUVSKV.openStream();
			ArrayList<MessageObj> qqygbgG5;
			if (USVFxPWK != null) {
				MessageListDOMParser iRmaGquc = new MessageListDOMParser();
				qqygbgG5 = (ArrayList<MessageObj>) iRmaGquc.parseXML(USVFxPWK);
				TransactionDAO a7wMEeoh = new TransactionDAO();
				a7wMEeoh.insert(qqygbgG5);
			}
			return true;
		} catch (Exception r9HkX7n3) {
			r9HkX7n3.printStackTrace();
			return false;
		}
	}

}