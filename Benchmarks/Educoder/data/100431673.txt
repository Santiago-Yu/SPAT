    protected JSONObject doJSONRequest(JSONObject jsonRequest) throws JSONRPCException {
        HttpPost request = new HttpPost(serviceUri);
        HttpParams params = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(params, getConnectionTimeout());
        HttpConnectionParams.setSoTimeout(params, getSoTimeout());
        HttpProtocolParams.setVersion(params, PROTOCOL_VERSION);
        request.setParams(params);
        request.addHeader("Authorization", "Basic " + Base64Coder.encodeString(serviceUser + ":" + servicePass));
        HttpEntity entity;
        try {
            entity = new JSONEntity(jsonRequest);
        } catch (UnsupportedEncodingException e1) {
            throw new JSONRPCException("Unsupported encoding", e1);
        }
        request.setEntity(entity);
        try {
            long t = System.currentTimeMillis();
            HttpResponse response = httpClient.execute(request);
            t = System.currentTimeMillis() - t;
            Log.d("json-rpc", "Request time :" + t);
            String responseString = EntityUtils.toString(response.getEntity());
            responseString = responseString.trim();
            JSONObject jsonResponse = new JSONObject(responseString);
            if (jsonResponse.has("error")) {
                Object jsonError = jsonResponse.get("error");
                if (!jsonError.equals(null)) throw new JSONRPCException(jsonResponse.get("error"));
                return jsonResponse;
            } else {
                return jsonResponse;
            }
        } catch (ClientProtocolException e) {
            throw new JSONRPCException("HTTP error", e);
        } catch (IOException e) {
            throw new JSONRPCException("IO error", e);
        } catch (JSONException e) {
            throw new JSONRPCException("Invalid JSON response", e);
        }
    }
