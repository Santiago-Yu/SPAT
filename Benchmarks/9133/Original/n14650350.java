class n14650350{
    private boolean adjust(String stationUrl) throws LastFMError {
        try {
            URL url = new URL("http://" + mBaseURL + "/adjust.php?session=" + mSession + "&url=" + URLEncoder.encode(stationUrl, "UTF-8"));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader stringReader = new BufferedReader(reader);
            Utils.OptionsParser options = new Utils.OptionsParser(stringReader);
            if (!options.parse()) options = null;
            stringReader.close();
            if ("OK".equals(options.get("response"))) {
                return true;
            } else {
                Log.e(TAG, "Adjust failed: \"" + options.get("response") + "\"");
                return false;
            }
        } catch (MalformedURLException e) {
            Log.e(TAG, "in adjust", e);
            throw new LastFMError("Adjust failed:" + e.toString());
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "in adjust", e);
            throw new LastFMError("Adjust failed:" + e.toString());
        } catch (IOException e) {
            Log.e(TAG, "in adjust", e);
            throw new LastFMError("Station not found:" + stationUrl);
        }
    }

}