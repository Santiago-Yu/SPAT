class n21644149 {
	public void downloadQFromMinibix(int ticketNo) {
		String minibixDomain = Preferences.userRoot().node("Spectatus").get("MBAddr",
				"http://mathassess.caret.cam.ac.uk");
		String minibixPort = Preferences.userRoot().node("Spectatus").get("MBPort", "80");
		String url = minibixDomain + ":" + minibixPort + "/qtibank-webserv/deposits/all/" + ticketNo;
		File file = new File(tempdir + sep + "minibix.zip");
		try {
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (!(entity != null))
				;
			else {
				InputStream instream = entity.getContent();
				int l;
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