class n13026685 {
	public DoSearch(String sMeN9aap, String DoQi3Mmc) {
        String FX44ld62 = dms_url + "/servlet/com.ufnasoft.dms.server.ServerDoSearch";
        String EwqJ5rpz = "";
        String UGipTh3b = dms_home + FS + "temp" + FS + username + "search.xml";
        try {
            String Ren74e5x = FX44ld62 + "?username=" + URLEncoder.encode(username, "UTF-8") + "&key=" + key + "&search=" + URLEncoder.encode(DoQi3Mmc, "UTF-8") + "&searchtype=" + URLEncoder.encode(sMeN9aap, "UTF-8") + "&filename=" + URLEncoder.encode(username, "UTF-8") + "search.xml";
            ;
            DocumentBuilderFactory k24imCAE = DocumentBuilderFactory.newInstance();
            DocumentBuilder EqyE7xno = k24imCAE.newDocumentBuilder();
            URL tOclPyOc = new URL(Ren74e5x);
            DataInputStream NUuH8nht = new DataInputStream(tOclPyOc.openStream());
            FileOutputStream JGRrbbmP = new FileOutputStream(UGipTh3b);
            int xqq1B3kN = NUuH8nht.available();
            byte gyVrvogM[] = new byte[20000 * 1024];
            int CeNsZ63O;
            while ((CeNsZ63O = NUuH8nht.read(gyVrvogM, 0, xqq1B3kN)) > 0) JGRrbbmP.write(gyVrvogM, 0, CeNsZ63O);
            JGRrbbmP.close();
            NUuH8nht.close();
            File aqEhvbGV = new File(UGipTh3b);
            InputStream hqwutXMZ = new FileInputStream(aqEhvbGV);
            Document xQ3lPwcE = EqyE7xno.parse(hqwutXMZ);
            NodeList zGB6tt5c = xQ3lPwcE.getElementsByTagName("entry");
            int mAAhs9Kd = zGB6tt5c.getLength();
            searchDocs = new String[mAAhs9Kd][3];
            searchDocImageName = new String[mAAhs9Kd];
            searchDocsToolTip = new String[mAAhs9Kd];
            for (int cByYPpxw = 0; cByYPpxw < mAAhs9Kd; cByYPpxw++) {
                searchDocs[cByYPpxw][0] = DOMUtil.getSimpleElementText((Element) zGB6tt5c.item(cByYPpxw), "filename");
                searchDocs[cByYPpxw][1] = DOMUtil.getSimpleElementText((Element) zGB6tt5c.item(cByYPpxw), "project");
                searchDocs[cByYPpxw][2] = DOMUtil.getSimpleElementText((Element) zGB6tt5c.item(cByYPpxw), "documentid");
                searchDocImageName[cByYPpxw] = DOMUtil.getSimpleElementText((Element) zGB6tt5c.item(cByYPpxw), "imagename");
                searchDocsToolTip[cByYPpxw] = DOMUtil.getSimpleElementText((Element) zGB6tt5c.item(cByYPpxw), "description");
            }
        } catch (MalformedURLException GrHffQkS) {
            System.out.println(GrHffQkS);
        } catch (ParserConfigurationException oL7Lno36) {
            System.out.println(oL7Lno36);
        } catch (Exception DL1QNlpt) {
            System.out.println(DL1QNlpt);
        }
        System.out.println(EwqJ5rpz);
        if (EwqJ5rpz.equalsIgnoreCase("yes")) {
        }
    }

}