class n12763612 {
	@Override
	protected String doInBackground(MarketData... r2xOpIqj) {
		publishProgress(-1);
		InputStream c6FQL2ES = null;
		OutputStream APeTcDuB = null;
		long kkGoTdy9 = 0;
		int sAYXym5F = 0;
		try {
			HttpGet tJtUeF5u = new HttpGet(r2xOpIqj[0].apkURL);
			HttpResponse i2iFtoAe = HttpManager.execute(tJtUeF5u);
			Log.i(Main.TAG, "req:" + i2iFtoAe.getStatusLine().getStatusCode());
			while (i2iFtoAe.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY
					|| i2iFtoAe.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_PERMANENTLY) {
				Log.i(Main.TAG, "redirect to:" + i2iFtoAe.getFirstHeader("Location").getValue());
				tJtUeF5u = new HttpGet(i2iFtoAe.getFirstHeader("Location").getValue());
				i2iFtoAe = HttpManager.execute(tJtUeF5u);
				Log.i(Main.TAG, "req:" + i2iFtoAe.getStatusLine().getStatusCode());
			}
			kkGoTdy9 = i2iFtoAe.getEntity().getContentLength();
			c6FQL2ES = i2iFtoAe.getEntity().getContent();
			APeTcDuB = new FileOutputStream(r2xOpIqj[0].getFile());
			sAYXym5F = copy(c6FQL2ES, APeTcDuB, kkGoTdy9);
		} catch (MalformedURLException OmR8o0hq) {
			Log.w(Main.TAG, "error downloading " + r2xOpIqj[0].apkURL, OmR8o0hq);
		} catch (IOException RYBalDvw) {
			Log.w(Main.TAG, "error downloading " + r2xOpIqj[0].apkURL, RYBalDvw);
		} finally {
			Log.v(Main.TAG, "failed to download " + r2xOpIqj[0].apkURL + " " + sAYXym5F + "/" + kkGoTdy9);
			if (kkGoTdy9 != 0 && sAYXym5F != kkGoTdy9) {
				Log.w(Main.TAG, "failed to download " + r2xOpIqj[0].apkURL + " " + sAYXym5F + "/" + kkGoTdy9);
				try {
					if (c6FQL2ES != null)
						c6FQL2ES.close();
					if (APeTcDuB != null)
						APeTcDuB.close();
					r2xOpIqj[0].getFile().delete();
				} catch (IOException fAjsR1cr) {
					fAjsR1cr.printStackTrace();
				}
			}
		}
		Log.v(Main.TAG, "copied " + r2xOpIqj[0].apkURL + " to " + r2xOpIqj[0].getFile());
		return null;
	}

}