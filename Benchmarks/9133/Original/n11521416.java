class n11521416{
    private static void sentRequest() {
        try {
            URLConnection urlConn;
            URL url = new URL(gatewayURL);
            urlConn = url.openConnection();
            urlConn.setRequestProperty("Content-Type", "text/xml");
            urlConn.setDoOutput(true);
            OutputStream ostream = urlConn.getOutputStream();
            PrintWriter out = new PrintWriter(ostream);
            out.print(request);
            out.close();
            ostream.close();
            InputStream inStream = urlConn.getInputStream();
            File myFile = new File(styleSheetLocation);
            if (type.equals("A") && myFile.exists()) {
                TransformerFactory tFactory = TransformerFactory.newInstance();
                Transformer transformer = tFactory.newTransformer(new StreamSource(styleSheetLocation));
                transformer.transform(new StreamSource(inStream), new StreamResult(System.out));
            } else {
                BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}