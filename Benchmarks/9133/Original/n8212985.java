class n8212985{
    private void writeCard() {
        try {
            new URL(createURLStringExistRESTGetXQuery("update value //scheda[cata = \"" + cata + "\"] with " + "\"replaced from /schede/scheda-... by jEpi-Scheda-Applet\"")).openStream().close();
            String urlString = "http://" + server + "/exist/rest/db/schede/" + "scheda-" + cata + ".xml";
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(urlString).openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("PUT");
            OutputStream outputStream = httpURLConnection.getOutputStream();
            uiSchedaXml.write(outputStream);
            outputStream.close();
            httpURLConnection.getInputStream().close();
            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}