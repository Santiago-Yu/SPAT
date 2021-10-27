            public void run() {
                Log.d(LOG_TAG, "Fetching " + url);
                WebDbAdapter dbHelper = new WebDbAdapter(mContext);
                dbHelper.open();
                boolean errorOccurred = true;
                int notifyId = 0;
                String host = AppUtils.getHostFromUrl(url);
                try {
                    if (host == null) {
                        Log.d(LOG_TAG, "Bad url " + url);
                        errorOccurred = true;
                    } else {
                        notifyId = showNotification("Fetching " + host, "Fetching " + host, android.R.drawable.stat_sys_download, 0);
                        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(mContext);
                        String userAgent = sp.getString(mContext.getString(R.string.pref_key_user_agent), mContext.getString(R.string.default_user_agent));
                        Log.d(LOG_TAG, "Using user agent=" + userAgent);
                        AndroidHttpClient ahc = AndroidHttpClient.newInstance(mContext, url, userAgent);
                        URI uri = new URI(url);
                        URI norm = new URI(uri.getScheme().toLowerCase(), uri.getUserInfo(), uri.getHost().toLowerCase(), uri.getPort(), uri.getPath(), uri.getQuery(), null);
                        norm = norm.normalize();
                        HttpUriRequest get = new HttpGet(norm);
                        HttpResponse response = ahc.execute(get);
                        if (response.getStatusLine().getStatusCode() == 200) {
                            HttpEntity entity = response.getEntity();
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            entity.writeTo(baos);
                            String data = baos.toString();
                            for (int i = 0; i < undesirables.length; i++) {
                                Pattern p = Pattern.compile(undesirables[i], Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
                                data = data.replaceAll(p.pattern(), "");
                            }
                            long sysMillis = System.currentTimeMillis();
                            String newFileName = getPath(sysMillis, sp.getBoolean(mContext.getString(R.string.pref_key_store_sdcard), false));
                            FileOutputStream strm = new FileOutputStream(newFileName);
                            Log.d(LOG_TAG, "Writing to " + newFileName + " for url " + url);
                            String jsData = AppUtils.fromRawResourceFile(R.raw.retain_loadcolors, mContext);
                            jsData = jsData.replaceAll("@css_file", RETAIN_COLORS_CSS);
                            strm.write(jsData.getBytes());
                            strm.write(data.getBytes());
                            strm.write(jsData.getBytes());
                            strm.flush();
                            strm.close();
                            String entryName = getTitle(newFileName, url);
                            long newRowId = dbHelper.createEntry(entryName, newFileName, url, sysMillis);
                            postToast("Downloaded \"" + entryName + "\"");
                            errorOccurred = false;
                            if (deleteRowId != 0) {
                                Log.d(LOG_TAG, "Deleting rowId=" + deleteRowId);
                                dbHelper.deleteEntry(deleteRowId);
                                if (url == null) postToast("Item Deleted");
                                mContext.startActivity(new Intent(mContext, RetainActivity.class));
                            } else {
                                showNotification("Download Complete", entryName, android.R.drawable.stat_sys_download_done, newRowId);
                            }
                        } else {
                            Log.e(LOG_TAG, "Response code=" + String.valueOf(response.getStatusLine().getStatusCode()));
                        }
                    }
                } catch (IOException ioe) {
                    Log.e(LOG_TAG, "RETAIN IOException: " + ioe.getMessage());
                } catch (URISyntaxException u) {
                    Log.e(LOG_TAG, "RETAIN URISyntaxException: " + u.getMessage());
                } catch (OutOfMemoryError oome) {
                    Log.e(LOG_TAG, "RETAIN OutOfMemoryError: " + oome.getMessage());
                } catch (Exception e) {
                    Log.e(LOG_TAG, "RETAIN Exception: " + e.getMessage());
                }
                hideNotification(notifyId);
                if (errorOccurred && host != null) {
                    showNotification("Error Downloading", host, android.R.drawable.stat_notify_error, 0);
                    postToast("Error fetching " + host);
                }
                dbHelper.close();
            }
