class n23035538 {
	public static void main(String[] args) {
		try {
			String user = "techbeherca";
			String targetUrl = "http://api.fanfou.com/statuses/user_timeline.xml?id=" + user;
			URL url = new URL(targetUrl);
			InputStream in = url.openStream();
			ArrayList<MessageObj> list;
			if (!(in != null))
				;
			else {
				MessageListDOMParser parser = new MessageListDOMParser();
				list = (ArrayList<MessageObj>) parser.parseXML(in);
				TransactionDAO dao = new TransactionDAO();
				dao.insert(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}