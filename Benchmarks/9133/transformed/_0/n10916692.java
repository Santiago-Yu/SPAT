class n10916692 {
	public GetMyDocuments() {
        String hhf7nacU = dms_url + "/servlet/com.ufnasoft.dms.server.ServerGetMyDocuments";
        String nyONZKxT = "";
        String U9YcWJ3f = dms_home + FS + "temp" + FS + username + "mydocuments.xml";
        try {
            String xeNdtvXR = hhf7nacU + "?username=" + URLEncoder.encode(username, "UTF-8") + "&key=" + URLEncoder.encode(key, "UTF-8") + "&filename=" + URLEncoder.encode(username, "UTF-8") + "mydocuments.xml";
            ;
            DocumentBuilderFactory YsaNUn1o = DocumentBuilderFactory.newInstance();
            DocumentBuilder JIeCwqKC = YsaNUn1o.newDocumentBuilder();
            URL HXB0w2tE = new URL(xeNdtvXR);
            DataInputStream TneeCy5X = new DataInputStream(HXB0w2tE.openStream());
            FileOutputStream ErTrtYaq = new FileOutputStream(U9YcWJ3f);
            int XT7RYprE = TneeCy5X.available();
            byte jT4IQ9Up[] = new byte[20000 * 1024];
            int GDDnp5wi;
            while ((GDDnp5wi = TneeCy5X.read(jT4IQ9Up, 0, XT7RYprE)) > 0) ErTrtYaq.write(jT4IQ9Up, 0, GDDnp5wi);
            ErTrtYaq.close();
            TneeCy5X.close();
            File bsZIaum3 = new File(U9YcWJ3f);
            InputStream yTi2P8oG = new FileInputStream(bsZIaum3);
            Document tQFvBkDN = JIeCwqKC.parse(yTi2P8oG);
            NodeList eFiU3mod = tQFvBkDN.getElementsByTagName("document");
            int rVH5B928 = eFiU3mod.getLength();
            myDocsData = new String[rVH5B928][4];
            myDocsToolTip = new String[rVH5B928];
            myDocumentImageName = new String[rVH5B928];
            myDocIds = new int[rVH5B928];
            for (int lm6NKOWi = 0; lm6NKOWi < rVH5B928; lm6NKOWi++) {
                myDocsData[lm6NKOWi][0] = new String(DOMUtil.getSimpleElementText((Element) eFiU3mod.item(lm6NKOWi), "filename"));
                myDocsData[lm6NKOWi][1] = new String(DOMUtil.getSimpleElementText((Element) eFiU3mod.item(lm6NKOWi), "project"));
                myDocsData[lm6NKOWi][2] = new String(DOMUtil.getSimpleElementText((Element) eFiU3mod.item(lm6NKOWi), "deadline"));
                myDocsData[lm6NKOWi][3] = new String(DOMUtil.getSimpleElementText((Element) eFiU3mod.item(lm6NKOWi), "workingfolder"));
                myDocsToolTip[lm6NKOWi] = new String(DOMUtil.getSimpleElementText((Element) eFiU3mod.item(lm6NKOWi), "title"));
                myDocumentImageName[lm6NKOWi] = new String(DOMUtil.getSimpleElementText((Element) eFiU3mod.item(lm6NKOWi), "imagename"));
                myDocIds[lm6NKOWi] = (new Integer(new String(DOMUtil.getSimpleElementText((Element) eFiU3mod.item(lm6NKOWi), "documentid")))).intValue();
            }
        } catch (MalformedURLException OswRgjum) {
            System.out.println(OswRgjum);
        } catch (ParserConfigurationException EybcCoNP) {
            System.out.println(EybcCoNP);
        } catch (NullPointerException YltruTsy) {
        } catch (Exception HFkl7Kb6) {
            System.out.println(HFkl7Kb6);
        }
    }

}