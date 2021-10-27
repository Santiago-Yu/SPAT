class n15973192{
    private SpequlosResponse executeGet(String targetURL, String urlParameters) {
        URL url;
        HttpURLConnection connection = null;
        boolean succ = false;
        try {
            url = new URL(targetURL + "?" + urlParameters);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer log = new StringBuffer();
            ArrayList<String> response = new ArrayList<String>();
            while ((line = rd.readLine()) != null) {
                if (line.startsWith("<div class=\"qos\">")) {
                    System.out.println("here is the line : " + line);
                    String resp = line.split(">")[1].split("<")[0];
                    System.out.println("here is the splitted line : " + resp);
                    if (!resp.startsWith("None")) {
                        succ = true;
                        String[] values = resp.split(" ");
                        ArrayList<String> realvalues = new ArrayList<String>();
                        for (String s : values) {
                            realvalues.add(s);
                        }
                        if (realvalues.size() == 5) {
                            realvalues.add(2, realvalues.get(2) + " " + realvalues.get(3));
                            realvalues.remove(3);
                            realvalues.remove(3);
                        }
                        for (String n : realvalues) {
                            response.add(n);
                        }
                    }
                } else {
                    log.append(line);
                    log.append('\r');
                }
            }
            rd.close();
            SpequlosResponse speqresp = new SpequlosResponse(response, log.toString(), succ);
            return speqresp;
        } catch (Exception e) {
            e.printStackTrace();
            String log = "Please check the availability of Spequlos server!<br />" + "URL:" + targetURL + "<br />" + "PARAMETERS:" + urlParameters + "<br />";
            return new SpequlosResponse(null, log, succ);
        } finally {
            if (connection != null) connection.disconnect();
        }
    }

}