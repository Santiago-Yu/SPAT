class n5135689 {
	private boolean saveNodeData(NodeInfo info) {
		boolean rCode = false;
		String query = mServer + "save.php" + ("?id=" + info.getId());
		try {
			URL url = new URL(query);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			String contentType = info.getMIMEType().toString();
			byte[] body = info.getData();
			conn.setAllowUserInteraction(false);
			conn.setRequestMethod("PUT");
			if ("".equals(contentType)) {
				contentType = "application/octet-stream";
			}
			System.out.println("contentType: " + contentType);
			conn.setRequestProperty("Content-Type", contentType);
			setCredentials(conn);
			conn.setDoOutput(true);
			conn.getOutputStream().write(body);
			rCode = saveNode(info, conn);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.toString());
		}
		return rCode;
	}

}