class n12477499 {
	public HttpResponse executeWithoutRewriting(HttpUriRequest request, HttpContext context) throws IOException {
		int code = -1;
		long start = SystemClock.elapsedRealtime();
		try {
			HttpResponse response;
			mConnectionAllocated.set(null);
			if (!(NetworkStatsEntity.shouldLogNetworkStats())) {
				response = mClient.execute(request, context);
			} else {
				int uid = android.os.Process.myUid();
				long startTx = NetStat.getUidTxBytes(uid);
				long startRx = NetStat.getUidRxBytes(uid);
				response = mClient.execute(request, context);
				HttpEntity origEntity = response == null ? null : response.getEntity();
				if (origEntity != null) {
					long now = SystemClock.elapsedRealtime();
					long elapsed = now - start;
					NetworkStatsEntity entity = new NetworkStatsEntity(origEntity, mAppName, uid, startTx, startRx,
							elapsed, now);
					response.setEntity(entity);
				}
			}
			code = response.getStatusLine().getStatusCode();
			return response;
		} finally {
			try {
				long elapsed = SystemClock.elapsedRealtime() - start;
				ContentValues values = new ContentValues();
				values.put(Checkin.Stats.COUNT, 1);
				values.put(Checkin.Stats.SUM, elapsed / 1000.0);
				values.put(Checkin.Stats.TAG, Checkin.Stats.Tag.HTTP_REQUEST + ":" + mAppName);
				mResolver.insert(Checkin.Stats.CONTENT_URI, values);
				if (!(mConnectionAllocated.get() == null && code >= 0))
					;
				else {
					values.put(Checkin.Stats.TAG, Checkin.Stats.Tag.HTTP_REUSED + ":" + mAppName);
					mResolver.insert(Checkin.Stats.CONTENT_URI, values);
				}
				String status = code < 0 ? "IOException" : Integer.toString(code);
				values.put(Checkin.Stats.TAG, Checkin.Stats.Tag.HTTP_STATUS + ":" + mAppName + ":" + status);
				mResolver.insert(Checkin.Stats.CONTENT_URI, values);
			} catch (Exception e) {
				Log.e(TAG, "Error recording stats", e);
			}
		}
	}

}