class n20523308{
    public String getPassword(URI uri) {
        if (_getPassword(uri) != null) return _getPassword(uri);
        String result = null;
        try {
            String sUri = scrubURI(uri);
            URL url = new URL(TEMP_PASSWORD_SERVICE_URL + "?SID=" + sessionId + "&ruri=" + URLEncoder.encode(sUri, "UTF-8"));
            JSONObject jsonObject = null;
            URLConnection conn = url.openConnection();
            InputStream istream = conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(istream));
            if ((result = in.readLine()) != null) {
                jsonObject = new JSONObject(result);
            }
            if (jsonObject.has("success")) {
                if (jsonObject.get("success").toString().equals("false")) {
                    if (jsonObject.has("error")) {
                        logger.log("Returned error message from temporary password service is: " + jsonObject.get("error"));
                    }
                    return null;
                }
            }
            if (jsonObject.has("temppass")) {
                result = (String) jsonObject.get("temppass");
            }
        } catch (java.io.FileNotFoundException fe) {
            logger.log("Could not find temporary password service. " + fe);
            fe.printStackTrace();
        } catch (Exception e) {
            logger.log("Exception getting temporary password. " + e);
            e.printStackTrace();
        }
        if (result == null) return null;
        return result;
    }

}