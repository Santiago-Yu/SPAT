class n12477499 {
	public HttpResponse executeWithoutRewriting(HttpUriRequest W1v8lrAC, HttpContext UvOSqRVa) throws IOException {
		int Q7g3dCFi = -1;
		long l7ltNeBd = SystemClock.elapsedRealtime();
		try {
			HttpResponse XDwn79zD;
			mConnectionAllocated.set(null);
			if (NetworkStatsEntity.shouldLogNetworkStats()) {
				int fbpD17OS = android.os.Process.myUid();
				long k33tRvQg = NetStat.getUidTxBytes(fbpD17OS);
				long KjBrhgs2 = NetStat.getUidRxBytes(fbpD17OS);
				XDwn79zD = mClient.execute(W1v8lrAC, UvOSqRVa);
				HttpEntity ONmr5DUS = XDwn79zD == null ? null : XDwn79zD.getEntity();
				if (ONmr5DUS != null) {
					long qbpSUxfW = SystemClock.elapsedRealtime();
					long Pp5qnIM1 = qbpSUxfW - l7ltNeBd;
					NetworkStatsEntity QX9gNLeA = new NetworkStatsEntity(ONmr5DUS, mAppName, fbpD17OS, k33tRvQg,
							KjBrhgs2, Pp5qnIM1, qbpSUxfW);
					XDwn79zD.setEntity(QX9gNLeA);
				}
			} else {
				XDwn79zD = mClient.execute(W1v8lrAC, UvOSqRVa);
			}
			Q7g3dCFi = XDwn79zD.getStatusLine().getStatusCode();
			return XDwn79zD;
		} finally {
			try {
				long wddcoubP = SystemClock.elapsedRealtime() - l7ltNeBd;
				ContentValues jKB5fUZf = new ContentValues();
				jKB5fUZf.put(Checkin.Stats.COUNT, 1);
				jKB5fUZf.put(Checkin.Stats.SUM, wddcoubP / 1000.0);
				jKB5fUZf.put(Checkin.Stats.TAG, Checkin.Stats.Tag.HTTP_REQUEST + ":" + mAppName);
				mResolver.insert(Checkin.Stats.CONTENT_URI, jKB5fUZf);
				if (mConnectionAllocated.get() == null && Q7g3dCFi >= 0) {
					jKB5fUZf.put(Checkin.Stats.TAG, Checkin.Stats.Tag.HTTP_REUSED + ":" + mAppName);
					mResolver.insert(Checkin.Stats.CONTENT_URI, jKB5fUZf);
				}
				String YbCComqk = Q7g3dCFi < 0 ? "IOException" : Integer.toString(Q7g3dCFi);
				jKB5fUZf.put(Checkin.Stats.TAG, Checkin.Stats.Tag.HTTP_STATUS + ":" + mAppName + ":" + YbCComqk);
				mResolver.insert(Checkin.Stats.CONTENT_URI, jKB5fUZf);
			} catch (Exception bwttnMnz) {
				Log.e(TAG, "Error recording stats", bwttnMnz);
			}
		}
	}

}