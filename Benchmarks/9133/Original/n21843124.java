class n21843124{
    protected String connectPost(String urlString, String parameter) {
        String response = null;
        try {
            URL url = new URL(urlString);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            log.fine(connection.getURL().toString());
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(parameter.getBytes());
            out.flush();
            out.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            response = in.readLine();
            in.close();
            log.finest(response);
        } catch (Exception e) {
            log.log(Level.SEVERE, urlString, e);
        }
        return response;
    }

}