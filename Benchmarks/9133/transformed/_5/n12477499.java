class n12477499 {
	public HttpResponse executeWithoutRewriting(HttpUriRequest request, HttpContext context) throws IOException {
		int code = -1;
		long start = SystemClock.elapsedRealtime();
		try {
			HttpResponse response;
			mConnectionAllocated.set(null);
			if (NetworkStatsEntity.shouldLogNetworkStats()) {
				int uid = android.os.Process.myUid();
				long startTx = NetStat.getUidTxBytes(uid);
				long startRx = NetStat.getUidRxBytes(uid);
				response = mClient.execute(request, context);
				HttpEntity origEntity;
				if (response == null)
					origEntity = null;
				else
					origEntity = response.getEntity();
				if (origEntity != null) {
					long now = SystemClock.elapsedRealtime();
					long elapsed = now - start;
					NetworkStatsEntity entity = new NetworkStatsEntity(origEntity, mAppName, uid, startTx, startRx,
							elapsed, now);
					response.setEntity(entity);
				}
			} else {
				response = mClient.execute(request, context);
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
				if (mConnectionAllocated.get() == null && code >= 0) {
					values.put(Checkin.Stats.TAG, Checkin.Stats.Tag.HTTP_REUSED + ":" + mAppName);
					mResolver.insert(Checkin.Stats.CONTENT_URI, values);
				}
				String status;
				if (code < 0)
					status = "IOException";
				else
					status = Integer.toString(code);
				values.put(Checkin.Stats.TAG, Checkin.Stats.Tag.HTTP_STATUS + ":" + mAppName + ":" + status);
				mResolver.insert(Checkin.Stats.CONTENT_URI, values);
			} catch (Exception e) {
				Log.e(TAG, "Error recording stats", e);
			}
		}
	}

}