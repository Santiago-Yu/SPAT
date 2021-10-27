class n23125251{
    public static HttpData postRequest(HttpPost postMethod, String xml) throws ClientProtocolException, SocketException, IOException, SocketTimeoutException {
        HttpData data = new HttpData();
        try {
            postMethod.addHeader("Content-Type", "text/xml; charset=utf-8");
            postMethod.addHeader("Connection", "Keep-Alive");
            postMethod.addHeader("User-Agent", "Openwave");
            StringEntity se = new StringEntity(xml, HTTP.UTF_8);
            postMethod.setEntity(se);
            printPostRequestHeader(postMethod);
            HttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, HTTP_TIMEOUT);
            HttpClient client = new DefaultHttpClient(httpParams);
            client.getParams().setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, DEFAULT_POST_REQUEST_TIMEOUT);
            client.getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT, DEFAULT_POST_REQUEST_TIMEOUT);
            HttpResponse httpResponse = client.execute(postMethod);
            if (httpResponse == null) throw new SocketTimeoutException();
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                byte bytearray[] = ImageInputStream(httpResponse.getEntity());
                data.setByteArray(bytearray);
            } else {
                data.setStatusCode(httpResponse.getStatusLine().getStatusCode() + "");
            }
        } catch (SocketException e) {
            throw new SocketException();
        } catch (SocketTimeoutException e) {
            throw new SocketTimeoutException();
        } catch (ClientProtocolException e) {
            throw new ClientProtocolException();
        } catch (IOException e) {
            throw new IOException();
        } finally {
            postMethod.abort();
        }
        return data;
    }

}