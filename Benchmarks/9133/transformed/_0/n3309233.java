class n3309233 {
	@Override
	protected String doInBackground(String... As62znSJ) {
		try {
			final HttpParams qZjMkgP1 = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(qZjMkgP1, 30000);
			HttpConnectionParams.setSoTimeout(qZjMkgP1, 30000);
			DefaultHttpClient trinrwRq = new DefaultHttpClient(qZjMkgP1);
			HttpPost v5WjmAcH = new HttpPost("http://www.google.com/loc/json");
			v5WjmAcH.setEntity(new StringEntity(As62znSJ[0]));
			if (DEBUG)
				Log.d("Location", As62znSJ[0]);
			HttpResponse Xm38vWYs = trinrwRq.execute(v5WjmAcH);
			if (Xm38vWYs.getStatusLine().getStatusCode() == 200) {
				HttpEntity ycbeBCFc = Xm38vWYs.getEntity();
				String jhN4Y6Cf = EntityUtils.toString(ycbeBCFc);
				return jhN4Y6Cf;
			} else {
				if (isFirstLocation) {
					requestGearsLocation(1);
					isFirstLocation = false;
					return RESULT_FIRST_FAILE;
				}
			}
		} catch (Exception O3jIV2CY) {
			O3jIV2CY.printStackTrace();
		}
		return null;
	}

}