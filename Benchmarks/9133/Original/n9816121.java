class n9816121{
    private Callable<Request> newRequestCall(final Request request) {
        return new Callable<Request>() {

            public Request call() {
                InputStream is = null;
                try {
                    if (DEBUG) Log.d(TAG, "Requesting: " + request.uri);
                    HttpGet httpGet = new HttpGet(request.uri.toString());
                    httpGet.addHeader("Accept-Encoding", "gzip");
                    HttpResponse response = mHttpClient.execute(httpGet);
                    String mimeType = response.getHeaders("Content-Type")[0].getValue();
                    if (DEBUG) Log.d(TAG, "mimeType:" + mimeType);
                    if (mimeType.startsWith("image")) {
                        HttpEntity entity = response.getEntity();
                        is = getUngzippedContent(entity);
                        Bitmap bitmap = BitmapFactory.decodeStream(is);
                        if (mResourceCache.store(request.hash, bitmap)) {
                            mCache.put(request.uri.toString(), new SoftReference<Bitmap>(bitmap));
                            if (DEBUG) Log.d(TAG, "Request successful: " + request.uri);
                        } else {
                            mResourceCache.invalidate(request.hash);
                        }
                    }
                } catch (IOException e) {
                    if (DEBUG) Log.d(TAG, "IOException", e);
                } finally {
                    if (DEBUG) Log.e(TAG, "Request finished: " + request.uri);
                    mActiveRequestsMap.remove(request);
                    if (is != null) {
                        notifyObservers(request.uri);
                    }
                    try {
                        if (is != null) {
                            is.close();
                        }
                    } catch (IOException e) {
                        if (DEBUG) e.printStackTrace();
                    }
                }
                return request;
            }
        };
    }

}