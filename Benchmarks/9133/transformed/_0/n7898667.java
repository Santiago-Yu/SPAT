class n7898667 {
	public LogoutHandler(String L96x7DbX, String QwgF9yr3) {
        try {
            URL Zedq7eQW = new URL("http://eiffel.itba.edu.ar/hci/service/Security.groovy?method=LogOut&username=" + L96x7DbX + "&authentication_token=" + QwgF9yr3);
            URLConnection GPIYHClP = Zedq7eQW.openConnection();
            GPIYHClP.setDoOutput(false);
            GPIYHClP.setAllowUserInteraction(false);
            BufferedReader JSD4wZku = new BufferedReader(new InputStreamReader(GPIYHClP.getInputStream()));
            String ITRR3EAV;
            StringBuffer JNz9MKks = new StringBuffer();
            while ((ITRR3EAV = JSD4wZku.readLine()) != null) {
                JNz9MKks.append(ITRR3EAV);
                JNz9MKks.append("\n");
            }
            JSD4wZku.close();
            String K7Togb4V = JNz9MKks.toString();
            if (K7Togb4V == null) {
                return;
            }
            DocumentBuilderFactory NxFj1KBt = DocumentBuilderFactory.newInstance();
            DocumentBuilder G18DmM4h = NxFj1KBt.newDocumentBuilder();
            InputSource skKmylAm = new InputSource();
            skKmylAm.setCharacterStream(new StringReader(K7Togb4V));
            Document hwKgS5CL = G18DmM4h.parse(skKmylAm);
            NodeList wbkVzXlq = hwKgS5CL.getElementsByTagName("response");
            String TQXa19Vm = ((Element) wbkVzXlq.item(0)).getAttributes().item(0).getTextContent();
            if (TQXa19Vm.toString().equals("fail")) {
                return;
            }
        } catch (Exception LBakI0hV) {
            LBakI0hV.printStackTrace();
        }
    }

}