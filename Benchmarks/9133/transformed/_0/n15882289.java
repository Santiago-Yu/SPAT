class n15882289 {
	public GetMessages(String zKZt75n7) {
        String t1csW4Po = dms_url + "/servlet/com.ufnasoft.dms.server.ServerGetMessages";
        String Ae9qQq1d = "";
        String krMseBLN = dms_home + FS + "temp" + FS + username + "messages.xml";
        try {
            String sDvfmRFL = t1csW4Po + "?username=" + URLEncoder.encode(username, "UTF-8") + "&key=" + URLEncoder.encode(key, "UTF-8") + "&messagetype=" + zKZt75n7 + "&filename=" + URLEncoder.encode(username, "UTF-8") + "messages.xml";
            ;
            DocumentBuilderFactory WwC49JAT = DocumentBuilderFactory.newInstance();
            DocumentBuilder PCvtI2MY = WwC49JAT.newDocumentBuilder();
            URL udjJ1uLR = new URL(sDvfmRFL);
            DataInputStream heXTCs9m = new DataInputStream(udjJ1uLR.openStream());
            FileOutputStream mt6HgXpR = new FileOutputStream(krMseBLN);
            int ZcxmRGXp = heXTCs9m.available();
            byte Miz928q3[] = new byte[20000 * 1024];
            int X1qONQGP;
            while ((X1qONQGP = heXTCs9m.read(Miz928q3, 0, ZcxmRGXp)) > 0) mt6HgXpR.write(Miz928q3, 0, X1qONQGP);
            mt6HgXpR.close();
            heXTCs9m.close();
            File fwDEF8KQ = new File(krMseBLN);
            InputStream vvwZFA5Z = new FileInputStream(fwDEF8KQ);
            Document FMjiToWn = PCvtI2MY.parse(vvwZFA5Z);
            NodeList Wpyg45m4 = FMjiToWn.getElementsByTagName("message");
            int PhlJ3qQQ = Wpyg45m4.getLength();
            messages = new String[PhlJ3qQQ][7];
            for (int m7JbRD0C = 0; m7JbRD0C < PhlJ3qQQ; m7JbRD0C++) {
                messages[m7JbRD0C][0] = new String(DOMUtil.getSimpleElementText((Element) Wpyg45m4.item(m7JbRD0C), "messageid"));
                messages[m7JbRD0C][1] = new String(DOMUtil.getSimpleElementText((Element) Wpyg45m4.item(m7JbRD0C), "subject"));
                messages[m7JbRD0C][2] = (new String(DOMUtil.getSimpleElementText((Element) Wpyg45m4.item(m7JbRD0C), "firstname"))) + " " + (new String(DOMUtil.getSimpleElementText((Element) Wpyg45m4.item(m7JbRD0C), "lastname")));
                messages[m7JbRD0C][3] = new String(DOMUtil.getSimpleElementText((Element) Wpyg45m4.item(m7JbRD0C), "messagedatetime"));
                messages[m7JbRD0C][4] = new String(DOMUtil.getSimpleElementText((Element) Wpyg45m4.item(m7JbRD0C), "messagefrom"));
                messages[m7JbRD0C][5] = new String(DOMUtil.getSimpleElementText((Element) Wpyg45m4.item(m7JbRD0C), "messageto"));
                messages[m7JbRD0C][6] = new String(DOMUtil.getSimpleElementText((Element) Wpyg45m4.item(m7JbRD0C), "documentid"));
            }
        } catch (MalformedURLException yR3iY9ED) {
            System.out.println(yR3iY9ED);
        } catch (ParserConfigurationException LToUEHZj) {
            System.out.println(LToUEHZj);
        } catch (NullPointerException W5VzslFm) {
        } catch (Exception Y4C7hrT4) {
            System.out.println(Y4C7hrT4);
        }
    }

}