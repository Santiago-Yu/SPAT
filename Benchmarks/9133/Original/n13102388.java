class n13102388{
    public void callBatch(final List<JsonRpcClient.Call> calls, final JsonRpcClient.BatchCallback callback) {
        HttpPost httpPost = new HttpPost(mRpcUrl);
        JSONObject requestJson = new JSONObject();
        JSONArray callsJson = new JSONArray();
        try {
            for (int i = 0; i < calls.size(); i++) {
                JsonRpcClient.Call call = calls.get(i);
                JSONObject callJson = new JSONObject();
                callJson.put("method", call.getMethodName());
                if (call.getParams() != null) {
                    JSONObject callParams = (JSONObject) call.getParams();
                    @SuppressWarnings("unchecked") Iterator<String> keysIterator = callParams.keys();
                    String key;
                    while (keysIterator.hasNext()) {
                        key = keysIterator.next();
                        callJson.put(key, callParams.get(key));
                    }
                }
                callsJson.put(i, callJson);
            }
            requestJson.put("calls", callsJson);
            httpPost.setEntity(new StringEntity(requestJson.toString(), "UTF-8"));
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "POST request: " + requestJson.toString());
            }
        } catch (JSONException e) {
        } catch (UnsupportedEncodingException e) {
        }
        try {
            HttpResponse httpResponse = mHttpClient.execute(httpPost);
            final int responseStatusCode = httpResponse.getStatusLine().getStatusCode();
            if (200 <= responseStatusCode && responseStatusCode < 300) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"), 8 * 1024);
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    Log.v(TAG, "POST response: " + sb.toString());
                }
                JSONTokener tokener = new JSONTokener(sb.toString());
                JSONObject responseJson = new JSONObject(tokener);
                JSONArray resultsJson = responseJson.getJSONArray("results");
                Object[] resultData = new Object[calls.size()];
                for (int i = 0; i < calls.size(); i++) {
                    JSONObject result = resultsJson.getJSONObject(i);
                    if (result.has("error")) {
                        callback.onError(i, new JsonRpcException((int) result.getInt("error"), calls.get(i).getMethodName(), result.getString("message"), null));
                        resultData[i] = null;
                    } else {
                        resultData[i] = result.get("data");
                    }
                }
                callback.onData(resultData);
            } else {
                callback.onError(-1, new JsonRpcException(-1, "Received HTTP status code other than HTTP 2xx: " + httpResponse.getStatusLine().getReasonPhrase()));
            }
        } catch (IOException e) {
            Log.e("JsonRpcJavaClient", e.getMessage());
            e.printStackTrace();
        } catch (JSONException e) {
            Log.e("JsonRpcJavaClient", "Error parsing server JSON response: " + e.getMessage());
            e.printStackTrace();
        }
    }

}