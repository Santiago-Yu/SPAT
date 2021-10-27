class n22724693{
    public MytemMaster getMytemMaster(String janCode) throws GaeException {
        HttpClient client = new DefaultHttpClient();
        HttpParams httpParams = client.getParams();
        HttpConnectionParams.setSoTimeout(httpParams, 10000);
        HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
        BufferedReader reader = null;
        StringBuffer request = new StringBuffer(address);
        request.append("api/mytems/show?jan=");
        request.append(janCode);
        try {
            HttpGet httpGet = new HttpGet(request.toString());
            HttpResponse httpResponse = client.execute(httpGet);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == NOT_FOUND) {
                return null;
            }
            if (statusCode >= 400) {
                throw new GaeException("Status Error = " + Integer.toString(statusCode));
            }
            reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            return createMytemMaster(builder.toString());
        } catch (ClientProtocolException e) {
            throw new GaeException(e);
        } catch (SocketTimeoutException e) {
            throw new GaeException(e);
        } catch (IOException exception) {
            throw new GaeException(exception);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}