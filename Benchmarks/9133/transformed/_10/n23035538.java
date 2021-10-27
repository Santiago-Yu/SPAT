class n23035538 {
	public static void main(String[] args) {
		try {
			String user = "techbeherca";
			String targetUrl = "http://api.fanfou.com/statuses/user_timeline.xml?id=" + user;
			URL url = new URL(targetUrl);
			ArrayList<MessageObj> list;
			InputStream in = url.openStream();
			if (in != null) {
				MessageListDOMParser parser = new MessageListDOMParser();
				TransactionDAO dao = new TransactionDAO();
				list = (ArrayList<MessageObj>) parser.parseXML(in);
				dao.insert(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}