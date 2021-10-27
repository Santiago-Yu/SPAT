    public boolean getContent(String userId, String latestMsgId) {
        try {
            String targetUrl = "http://api.fanfou.com/statuses/user_timeline.xml?id=" + userId + "&since_id=" + latestMsgId;
            URL url = new URL(targetUrl);
            InputStream in = url.openStream();
            ArrayList<MessageObj> list;
            if (in != null) {
                MessageListDOMParser parser = new MessageListDOMParser();
                list = (ArrayList<MessageObj>) parser.parseXML(in);
                TransactionDAO dao = new TransactionDAO();
                dao.insert(list);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
