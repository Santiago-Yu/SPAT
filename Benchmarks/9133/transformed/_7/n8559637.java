class n8559637 {
	protected String updateTwitter() {
		if (updatingTwitter)
			return null;
		updatingTwitter = true;
		String highestId = null;
		final Cursor cursor = query(TWITTER_TABLE, new String[] { KEY_TWEET_ID }, null, null, null);
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			highestId = cursor.getString(cursor.getColumnIndex(KEY_TWEET_ID));
		}
		cursor.close();
		final List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
		nameValuePairs.add(new BasicNameValuePair("screen_name", TWITTER_ACCOUNT));
		nameValuePairs.add(new BasicNameValuePair("count", "" + MAX_TWEETS));
		if (highestId != null)
			nameValuePairs.add(new BasicNameValuePair("since_id", highestId));
		final SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
		final HttpParams params = new BasicHttpParams();
		final SingleClientConnManager mgr = new SingleClientConnManager(params, schemeRegistry);
		final HttpClient httpclient = new DefaultHttpClient(mgr, params);
		final HttpGet request = new HttpGet();
		final String paramString = URLEncodedUtils.format(nameValuePairs, "utf-8");
		String data = "";
		try {
			final URI uri = new URI(TWITTER_URL + "?" + paramString);
			request.setURI(uri);
			final HttpResponse response = httpclient.execute(request);
			final BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				data = data + (inputLine);
			in.close();
		} catch (final URISyntaxException e) {
			e.printStackTrace();
			updatingTwitter = false;
			return "failed";
		} catch (final ClientProtocolException e) {
			e.printStackTrace();
			updatingTwitter = false;
			return "failed";
		} catch (final IOException e) {
			e.printStackTrace();
			updatingTwitter = false;
			return "failed";
		}
		try {
			final JSONArray tweets = new JSONArray(data);
			if (tweets == null) {
				updatingTwitter = false;
				return "failed";
			}
			if (tweets.length() == 0) {
				updatingTwitter = false;
				return "none";
			}
			final SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
			final SimpleDateFormat parser = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
			for (int i = 0; i < tweets.length(); i++) {
				final JSONObject tweet = tweets.getJSONObject(i);
				final ContentValues values = new ContentValues();
				Log.v(TAG, "Datum van tweet: " + tweet.getString(KEY_TWEET_DATE));
				values.put(KEY_TWEET_DATE, formatter.format(parser.parse(tweet.getString(KEY_TWEET_DATE))));
				values.put(KEY_TWEET_TEXT, tweet.getString(KEY_TWEET_TEXT));
				values.put(KEY_TWEET_ID, tweet.getString(KEY_TWEET_ID));
				insert(TWITTER_TABLE, values);
			}
		} catch (final JSONException e) {
			Log.v(TAG, "JSON decodering is mislukt.");
			e.printStackTrace();
			updatingTwitter = false;
			return "failed";
		} catch (final ParseException e) {
			Log.v(TAG, "Datum decodering is mislukt.");
			e.printStackTrace();
			updatingTwitter = false;
			return "failed";
		}
		purgeTweets();
		updatingTwitter = false;
		return "success";
	}

}