class n15882289 {
	public GetMessages(String messageType) {
        String urlString = dms_url + "/servlet/com.ufnasoft.dms.server.ServerGetMessages";
        String rvalue = "";
        String filename = dms_home + FS + "temp" + FS + username + "messages.xml";
        try {
            String urldata = urlString + "?username=" + URLEncoder.encode(username, "UTF-8") + "&key=" + URLEncoder.encode(key, "UTF-8") + "&messagetype=" + messageType + "&filename=" + URLEncoder.encode(username, "UTF-8") + "messages.xml";
            ;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder parser = factory.newDocumentBuilder();
            URL u = new URL(urldata);
            DataInputStream is = new DataInputStream(u.openStream());
            FileOutputStream os = new FileOutputStream(filename);
            int iBufSize = is.available();
            byte inBuf[] = new byte[20000 * 1024];
            int iNumRead;
            while ((iNumRead = is.read(inBuf, 0, iBufSize)) > 0) os.write(inBuf, 0, iNumRead);
            os.close();
            is.close();
            File f = new File(filename);
            InputStream inputstream = new FileInputStream(f);
            Document document = parser.parse(inputstream);
            NodeList nodelist = document.getElementsByTagName("message");
            int num = nodelist.getLength();
            messages = new String[num][7];
            int iAXq3 = 0;
			while (iAXq3 < num) {
				messages[iAXq3][0] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(iAXq3), "messageid"));
				messages[iAXq3][1] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(iAXq3), "subject"));
				messages[iAXq3][2] = (new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(iAXq3), "firstname"))) + " "
						+ (new String(DOMUtil.getSimpleElementText((Element) nodelist.item(iAXq3), "lastname")));
				messages[iAXq3][3] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(iAXq3), "messagedatetime"));
				messages[iAXq3][4] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(iAXq3), "messagefrom"));
				messages[iAXq3][5] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(iAXq3), "messageto"));
				messages[iAXq3][6] = new String(
						DOMUtil.getSimpleElementText((Element) nodelist.item(iAXq3), "documentid"));
				iAXq3++;
			}
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
        } catch (NullPointerException e) {
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}