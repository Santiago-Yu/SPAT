class n21644149 {
	public void downloadQFromMinibix(int ticketNo) {
		String minibixDomain = Preferences.userRoot().node("Spectatus").get("MBAddr",
				"http://mathassess.caret.cam.ac.uk");
		String minibixPort = Preferences.userRoot().node("Spectatus").get("MBPort", "80");
		File file = new File(tempdir + sep + "minibix.zip");
		String url = minibixDomain + ":" + minibixPort + "/qtibank-webserv/deposits/all/" + ticketNo;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				int l;
				InputStream instream = entity.getContent();
				byte[] tmp = new byte[2048];
				while ((l = instream.read(tmp)) != -1) {
					out.write(tmp, 0, l);
				}
				out.close();
				instream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}