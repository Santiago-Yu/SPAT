    private String makeLoginRequest(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        urlConnection.setUseCaches(false);
        urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        StringBuilder content = new StringBuilder();
        content.append("Email=").append(URLEncoder.encode(EMAIL, "UTF-8"));
        content.append("&Passwd=").append(URLEncoder.encode(PASSWORD, "UTF-8"));
        content.append("&service=").append(URLEncoder.encode(SERVICE, "UTF-8"));
        content.append("&source=").append(URLEncoder.encode("Google Base data API", "UTF-8"));
        OutputStream outputStream = urlConnection.getOutputStream();
        outputStream.write(content.toString().getBytes("UTF-8"));
        outputStream.close();
        int responseCode = urlConnection.getResponseCode();
        InputStream inputStream;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            inputStream = urlConnection.getInputStream();
        } else {
            inputStream = urlConnection.getErrorStream();
        }
        return toString(inputStream);
    }
