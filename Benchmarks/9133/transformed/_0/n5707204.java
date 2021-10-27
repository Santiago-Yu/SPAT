class n5707204 {
	public void download(final String bTpmf7Yn, final long i6mroTRg) {
		new Thread(new Runnable() {

			public void run() {
				Log.d(LOG_TAG, "Fetching " + bTpmf7Yn);
				WebDbAdapter NVRFqxjd = new WebDbAdapter(mContext);
				NVRFqxjd.open();
				boolean QfDMDppi = true;
				int RXUWSJot = 0;
				String NYHCEBNI = AppUtils.getHostFromUrl(bTpmf7Yn);
				try {
					if (NYHCEBNI == null) {
						Log.d(LOG_TAG, "Bad url " + bTpmf7Yn);
						QfDMDppi = true;
					} else {
						RXUWSJot = showNotification("Fetching " + NYHCEBNI, "Fetching " + NYHCEBNI,
								android.R.drawable.stat_sys_download, 0);
						SharedPreferences vQ0KOrPr = PreferenceManager.getDefaultSharedPreferences(mContext);
						String gNelSuXy = vQ0KOrPr.getString(mContext.getString(R.string.pref_key_user_agent),
								mContext.getString(R.string.default_user_agent));
						Log.d(LOG_TAG, "Using user agent=" + gNelSuXy);
						AndroidHttpClient hVIqcdI7 = AndroidHttpClient.newInstance(mContext, bTpmf7Yn, gNelSuXy);
						URI ZBXt62ND = new URI(bTpmf7Yn);
						URI uKnwNHcA = new URI(ZBXt62ND.getScheme().toLowerCase(), ZBXt62ND.getUserInfo(),
								ZBXt62ND.getHost().toLowerCase(), ZBXt62ND.getPort(), ZBXt62ND.getPath(),
								ZBXt62ND.getQuery(), null);
						uKnwNHcA = uKnwNHcA.normalize();
						HttpUriRequest lXv17xU1 = new HttpGet(uKnwNHcA);
						HttpResponse q4TGGiWz = hVIqcdI7.execute(lXv17xU1);
						if (q4TGGiWz.getStatusLine().getStatusCode() == 200) {
							HttpEntity Ex8d5knT = q4TGGiWz.getEntity();
							ByteArrayOutputStream cXHwDl99 = new ByteArrayOutputStream();
							Ex8d5knT.writeTo(cXHwDl99);
							String dnzN0cuN = cXHwDl99.toString();
							for (int jAlzTSgf = 0; jAlzTSgf < undesirables.length; jAlzTSgf++) {
								Pattern D8nFEXFB = Pattern.compile(undesirables[jAlzTSgf],
										Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
								dnzN0cuN = dnzN0cuN.replaceAll(D8nFEXFB.pattern(), "");
							}
							long FYofTWhs = System.currentTimeMillis();
							String Y5FHEKoo = getPath(FYofTWhs,
									vQ0KOrPr.getBoolean(mContext.getString(R.string.pref_key_store_sdcard), false));
							FileOutputStream bIMv7eg0 = new FileOutputStream(Y5FHEKoo);
							Log.d(LOG_TAG, "Writing to " + Y5FHEKoo + " for url " + bTpmf7Yn);
							String DBtMF0hs = AppUtils.fromRawResourceFile(R.raw.retain_loadcolors, mContext);
							DBtMF0hs = DBtMF0hs.replaceAll("@css_file", RETAIN_COLORS_CSS);
							bIMv7eg0.write(DBtMF0hs.getBytes());
							bIMv7eg0.write(dnzN0cuN.getBytes());
							bIMv7eg0.write(DBtMF0hs.getBytes());
							bIMv7eg0.flush();
							bIMv7eg0.close();
							String zlgkDVQa = getTitle(Y5FHEKoo, bTpmf7Yn);
							long WEnjq2bm = NVRFqxjd.createEntry(zlgkDVQa, Y5FHEKoo, bTpmf7Yn, FYofTWhs);
							postToast("Downloaded \"" + zlgkDVQa + "\"");
							QfDMDppi = false;
							if (i6mroTRg != 0) {
								Log.d(LOG_TAG, "Deleting rowId=" + i6mroTRg);
								NVRFqxjd.deleteEntry(i6mroTRg);
								if (bTpmf7Yn == null)
									postToast("Item Deleted");
								mContext.startActivity(new Intent(mContext, RetainActivity.class));
							} else {
								showNotification("Download Complete", zlgkDVQa,
										android.R.drawable.stat_sys_download_done, WEnjq2bm);
							}
						} else {
							Log.e(LOG_TAG, "Response code=" + String.valueOf(q4TGGiWz.getStatusLine().getStatusCode()));
						}
					}
				} catch (IOException kvvf5yNJ) {
					Log.e(LOG_TAG, "RETAIN IOException: " + kvvf5yNJ.getMessage());
				} catch (URISyntaxException m7UxiZ2d) {
					Log.e(LOG_TAG, "RETAIN URISyntaxException: " + m7UxiZ2d.getMessage());
				} catch (OutOfMemoryError Ho4xgJ23) {
					Log.e(LOG_TAG, "RETAIN OutOfMemoryError: " + Ho4xgJ23.getMessage());
				} catch (Exception QH5xlrB1) {
					Log.e(LOG_TAG, "RETAIN Exception: " + QH5xlrB1.getMessage());
				}
				hideNotification(RXUWSJot);
				if (QfDMDppi && NYHCEBNI != null) {
					showNotification("Error Downloading", NYHCEBNI, android.R.drawable.stat_notify_error, 0);
					postToast("Error fetching " + NYHCEBNI);
				}
				NVRFqxjd.close();
			}
		}).start();
	}

}