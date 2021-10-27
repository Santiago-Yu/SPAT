class n23035537 {
	public boolean getContent(String userId, String latestMsgId) {
		try {
			String targetUrl = "http://api.fanfou.com/statuses/user_timeline.xml?id=" + userId + "&since_id="
					+ latestMsgId;
			URL url = new URL(targetUrl);
			ArrayList<MessageObj> list;
			InputStream in = url.openStream();
			if (in != null) {
				MessageListDOMParser parser = new MessageListDOMParser();
				TransactionDAO dao = new TransactionDAO();
				list = (ArrayList<MessageObj>) parser.parseXML(in);
				dao.insert(list);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}