class n15167113 {
	public static void doHttpPost(String XWLmnYLZ, byte[] YProtob8, String jK1SKAPv, String OT6ZmJ2p)
			throws InteropException {
		URL glhl4JIx = getAccessURL(XWLmnYLZ);
		try {
			HttpURLConnection YNkGrhKM = (HttpURLConnection) glhl4JIx.openConnection();
			YNkGrhKM.setDoOutput(true);
			YNkGrhKM.setRequestMethod("POST");
			YNkGrhKM.setRequestProperty("Cookie", OT6ZmJ2p);
			YNkGrhKM.setRequestProperty("Content-type", jK1SKAPv);
			YNkGrhKM.setRequestProperty("Content-length", "" + YProtob8.length);
			OutputStream BILUn1av = YNkGrhKM.getOutputStream();
			BILUn1av.write(YProtob8);
			BILUn1av.flush();
			BILUn1av.close();
			YNkGrhKM.connect();
			InputStream Ra1pftnn = YNkGrhKM.getInputStream();
			Ra1pftnn.close();
		} catch (IOException XnTxdQ7j) {
			throw new InteropException("Error POSTing to " + XWLmnYLZ, XnTxdQ7j);
		}
	}

}