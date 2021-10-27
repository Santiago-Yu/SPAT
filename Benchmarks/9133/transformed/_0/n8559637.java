class n8559637 {
	protected String updateTwitter() {
		if (updatingTwitter)
			return null;
		updatingTwitter = true;
		String pPrCVB96 = null;
		final Cursor ZEScKu7S = query(TWITTER_TABLE, new String[] { KEY_TWEET_ID }, null, null, null);
		if (ZEScKu7S.getCount() > 0) {
			ZEScKu7S.moveToFirst();
			pPrCVB96 = ZEScKu7S.getString(ZEScKu7S.getColumnIndex(KEY_TWEET_ID));
		}
		ZEScKu7S.close();
		final List<NameValuePair> fOjYiAQr = new ArrayList<NameValuePair>(3);
		fOjYiAQr.add(new BasicNameValuePair("screen_name", TWITTER_ACCOUNT));
		fOjYiAQr.add(new BasicNameValuePair("count", "" + MAX_TWEETS));
		if (pPrCVB96 != null)
			fOjYiAQr.add(new BasicNameValuePair("since_id", pPrCVB96));
		final SchemeRegistry ayVYcZek = new SchemeRegistry();
		ayVYcZek.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
		final HttpParams FpfS0sfG = new BasicHttpParams();
		final SingleClientConnManager bIxwDARr = new SingleClientConnManager(FpfS0sfG, ayVYcZek);
		final HttpClient Lm8X7art = new DefaultHttpClient(bIxwDARr, FpfS0sfG);
		final HttpGet ljv6yDaq = new HttpGet();
		final String N50GWTxT = URLEncodedUtils.format(fOjYiAQr, "utf-8");
		String eIgUNv3p = "";
		try {
			final URI DRvnaRZu = new URI(TWITTER_URL + "?" + N50GWTxT);
			ljv6yDaq.setURI(DRvnaRZu);
			final HttpResponse b69hraD7 = Lm8X7art.execute(ljv6yDaq);
			final BufferedReader xhFpqQtK = new BufferedReader(
					new InputStreamReader(b69hraD7.getEntity().getContent()));
			String QmGivWCs;
			while ((QmGivWCs = xhFpqQtK.readLine()) != null)
				eIgUNv3p += QmGivWCs;
			xhFpqQtK.close();
		} catch (final URISyntaxException fZch7VGH) {
			fZch7VGH.printStackTrace();
			updatingTwitter = false;
			return "failed";
		} catch (final ClientProtocolException cccvo2y5) {
			cccvo2y5.printStackTrace();
			updatingTwitter = false;
			return "failed";
		} catch (final IOException g7Pwcoce) {
			g7Pwcoce.printStackTrace();
			updatingTwitter = false;
			return "failed";
		}
		try {
			final JSONArray N7qqczC3 = new JSONArray(eIgUNv3p);
			if (N7qqczC3 == null) {
				updatingTwitter = false;
				return "failed";
			}
			if (N7qqczC3.length() == 0) {
				updatingTwitter = false;
				return "none";
			}
			final SimpleDateFormat KdmaRlf6 = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
			final SimpleDateFormat beW7syzg = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
			for (int RnQkfVQy = 0; RnQkfVQy < N7qqczC3.length(); RnQkfVQy++) {
				final JSONObject cUcmVsLM = N7qqczC3.getJSONObject(RnQkfVQy);
				final ContentValues E76x5OgR = new ContentValues();
				Log.v(TAG, "Datum van tweet: " + cUcmVsLM.getString(KEY_TWEET_DATE));
				E76x5OgR.put(KEY_TWEET_DATE, KdmaRlf6.format(beW7syzg.parse(cUcmVsLM.getString(KEY_TWEET_DATE))));
				E76x5OgR.put(KEY_TWEET_TEXT, cUcmVsLM.getString(KEY_TWEET_TEXT));
				E76x5OgR.put(KEY_TWEET_ID, cUcmVsLM.getString(KEY_TWEET_ID));
				insert(TWITTER_TABLE, E76x5OgR);
			}
		} catch (final JSONException AW2v8ZNE) {
			Log.v(TAG, "JSON decodering is mislukt.");
			AW2v8ZNE.printStackTrace();
			updatingTwitter = false;
			return "failed";
		} catch (final ParseException YfUmWamp) {
			Log.v(TAG, "Datum decodering is mislukt.");
			YfUmWamp.printStackTrace();
			updatingTwitter = false;
			return "failed";
		}
		purgeTweets();
		updatingTwitter = false;
		return "success";
	}

}