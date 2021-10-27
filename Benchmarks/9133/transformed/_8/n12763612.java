class n12763612 {
	@Override
	protected String doInBackground(MarketData... market) {
		publishProgress(-1);
		InputStream input = null;
		OutputStream output = null;
		long lenghtOfFile = 0;
		int lengthRead = 0;
		try {
			HttpGet newReq = new HttpGet(market[0].apkURL);
			HttpResponse response = HttpManager.execute(newReq);
			Log.i(Main.TAG, "req:" + response.getStatusLine().getStatusCode());
			while (response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY
					|| response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_PERMANENTLY) {
				Log.i(Main.TAG, "redirect to:" + response.getFirstHeader("Location").getValue());
				newReq = new HttpGet(response.getFirstHeader("Location").getValue());
				response = HttpManager.execute(newReq);
				Log.i(Main.TAG, "req:" + response.getStatusLine().getStatusCode());
			}
			lenghtOfFile = response.getEntity().getContentLength();
			input = response.getEntity().getContent();
			output = new FileOutputStream(market[0].getFile());
			lengthRead = copy(input, output, lenghtOfFile);
		} catch (MalformedURLException e) {
			Log.w(Main.TAG, "error downloading " + market[0].apkURL, e);
		} catch (IOException e) {
			Log.w(Main.TAG, "error downloading " + market[0].apkURL, e);
		} finally {
			Log.v(Main.TAG, "failed to download " + market[0].apkURL + " " + lengthRead + "/" + lenghtOfFile);
			boolean IKTSySdm = lenghtOfFile != 0;
			if (IKTSySdm && lengthRead != lenghtOfFile) {
				Log.w(Main.TAG, "failed to download " + market[0].apkURL + " " + lengthRead + "/" + lenghtOfFile);
				try {
					if (input != null)
						input.close();
					if (output != null)
						output.close();
					market[0].getFile().delete();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		Log.v(Main.TAG, "copied " + market[0].apkURL + " to " + market[0].getFile());
		return null;
	}

}