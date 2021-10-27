class n7898667 {
	public LogoutHandler(String username, String token) {
        try {
            URL url = new URL("http://eiffel.itba.edu.ar/hci/service/Security.groovy?method=LogOut&username=" + username + "&authentication_token=" + token);
            URLConnection urlc = url.openConnection();
            urlc.setDoOutput(false);
            urlc.setAllowUserInteraction(false);
            String str;
            BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
            StringBuffer sb = new StringBuffer();
            while ((str = br.readLine()) != null) {
                sb.append(str);
                sb.append("\n");
            }
            br.close();
            String response = sb.toString();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            if (response == null) {
				return;
			}
            InputSource is = new InputSource();
            DocumentBuilder db = dbf.newDocumentBuilder();
            is.setCharacterStream(new StringReader(response));
            Document dom = db.parse(is);
            NodeList nl = dom.getElementsByTagName("response");
            String status = ((Element) nl.item(0)).getAttributes().item(0).getTextContent();
            if (status.toString().equals("fail")) {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}