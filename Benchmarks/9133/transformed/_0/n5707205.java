class n5707205 {
	public void run() {
		Log.d(LOG_TAG, "Fetching " + url);
		WebDbAdapter fqHRu85t = new WebDbAdapter(mContext);
		fqHRu85t.open();
		boolean Iw3bEDDr = true;
		int L3EplhRj = 0;
		String lmZOQxBL = AppUtils.getHostFromUrl(url);
		try {
			if (lmZOQxBL == null) {
				Log.d(LOG_TAG, "Bad url " + url);
				Iw3bEDDr = true;
			} else {
				L3EplhRj = showNotification("Fetching " + lmZOQxBL, "Fetching " + lmZOQxBL,
						android.R.drawable.stat_sys_download, 0);
				SharedPreferences bRFRaFAc = PreferenceManager.getDefaultSharedPreferences(mContext);
				String fbAp9sQO = bRFRaFAc.getString(mContext.getString(R.string.pref_key_user_agent),
						mContext.getString(R.string.default_user_agent));
				Log.d(LOG_TAG, "Using user agent=" + fbAp9sQO);
				AndroidHttpClient o91QjBna = AndroidHttpClient.newInstance(mContext, url, fbAp9sQO);
				URI P0d5qdmc = new URI(url);
				URI JVyQJXgP = new URI(P0d5qdmc.getScheme().toLowerCase(), P0d5qdmc.getUserInfo(),
						P0d5qdmc.getHost().toLowerCase(), P0d5qdmc.getPort(), P0d5qdmc.getPath(), P0d5qdmc.getQuery(),
						null);
				JVyQJXgP = JVyQJXgP.normalize();
				HttpUriRequest Ar6Y3Sss = new HttpGet(JVyQJXgP);
				HttpResponse gPstas8o = o91QjBna.execute(Ar6Y3Sss);
				if (gPstas8o.getStatusLine().getStatusCode() == 200) {
					HttpEntity uXblwht7 = gPstas8o.getEntity();
					ByteArrayOutputStream VF3BDaw8 = new ByteArrayOutputStream();
					uXblwht7.writeTo(VF3BDaw8);
					String Y38zjPId = VF3BDaw8.toString();
					for (int ZL9Dywe9 = 0; ZL9Dywe9 < undesirables.length; ZL9Dywe9++) {
						Pattern Xq9wbJGY = Pattern.compile(undesirables[ZL9Dywe9],
								Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
						Y38zjPId = Y38zjPId.replaceAll(Xq9wbJGY.pattern(), "");
					}
					long UDBLDWep = System.currentTimeMillis();
					String ufdHMSdt = getPath(UDBLDWep,
							bRFRaFAc.getBoolean(mContext.getString(R.string.pref_key_store_sdcard), false));
					FileOutputStream Szhp1tZP = new FileOutputStream(ufdHMSdt);
					Log.d(LOG_TAG, "Writing to " + ufdHMSdt + " for url " + url);
					String o66E838T = AppUtils.fromRawResourceFile(R.raw.retain_loadcolors, mContext);
					o66E838T = o66E838T.replaceAll("@css_file", RETAIN_COLORS_CSS);
					Szhp1tZP.write(o66E838T.getBytes());
					Szhp1tZP.write(Y38zjPId.getBytes());
					Szhp1tZP.write(o66E838T.getBytes());
					Szhp1tZP.flush();
					Szhp1tZP.close();
					String wmVm5fgk = getTitle(ufdHMSdt, url);
					long tGFirYiL = fqHRu85t.createEntry(wmVm5fgk, ufdHMSdt, url, UDBLDWep);
					postToast("Downloaded \"" + wmVm5fgk + "\"");
					Iw3bEDDr = false;
					if (deleteRowId != 0) {
						Log.d(LOG_TAG, "Deleting rowId=" + deleteRowId);
						fqHRu85t.deleteEntry(deleteRowId);
						if (url == null)
							postToast("Item Deleted");
						mContext.startActivity(new Intent(mContext, RetainActivity.class));
					} else {
						showNotification("Download Complete", wmVm5fgk, android.R.drawable.stat_sys_download_done,
								tGFirYiL);
					}
				} else {
					Log.e(LOG_TAG, "Response code=" + String.valueOf(gPstas8o.getStatusLine().getStatusCode()));
				}
			}
		} catch (IOException ZuPnWEP8) {
			Log.e(LOG_TAG, "RETAIN IOException: " + ZuPnWEP8.getMessage());
		} catch (URISyntaxException lF9wLVNu) {
			Log.e(LOG_TAG, "RETAIN URISyntaxException: " + lF9wLVNu.getMessage());
		} catch (OutOfMemoryError YCY7iPFE) {
			Log.e(LOG_TAG, "RETAIN OutOfMemoryError: " + YCY7iPFE.getMessage());
		} catch (Exception KEIJqOUb) {
			Log.e(LOG_TAG, "RETAIN Exception: " + KEIJqOUb.getMessage());
		}
		hideNotification(L3EplhRj);
		if (Iw3bEDDr && lmZOQxBL != null) {
			showNotification("Error Downloading", lmZOQxBL, android.R.drawable.stat_notify_error, 0);
			postToast("Error fetching " + lmZOQxBL);
		}
		fqHRu85t.close();
	}

}