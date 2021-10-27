class n8939074 {
	public RawTableData(int uH2g1RTV) {
        selectedProjectId = uH2g1RTV;
        String nvZiw86I = dms_url + "/servlet/com.ufnasoft.dms.server.ServerGetProjectDocuments";
        String x9fJCJpE = "";
        String FZwa5fce = dms_home + FS + "temp" + FS + username + "documents.xml";
        try {
            String XaDSuQ1W = nvZiw86I + "?username=" + URLEncoder.encode(username, "UTF-8") + "&key=" + URLEncoder.encode(key, "UTF-8") + "&projectid=" + selectedProjectId + "&filename=" + URLEncoder.encode(username, "UTF-8") + "documents.xml";
            ;
            DocumentBuilderFactory pvl9J7J0 = DocumentBuilderFactory.newInstance();
            DocumentBuilder BfnCrjoO = pvl9J7J0.newDocumentBuilder();
            URL nvG4VG4V = new URL(XaDSuQ1W);
            DataInputStream kQ4rhlEr = new DataInputStream(nvG4VG4V.openStream());
            FileOutputStream AsOYnhIw = new FileOutputStream(FZwa5fce);
            int z9V9cxaH = kQ4rhlEr.available();
            byte xmi0bTG8[] = new byte[20000 * 1024];
            int MJ5BaX1Y;
            while ((MJ5BaX1Y = kQ4rhlEr.read(xmi0bTG8, 0, z9V9cxaH)) > 0) AsOYnhIw.write(xmi0bTG8, 0, MJ5BaX1Y);
            AsOYnhIw.close();
            kQ4rhlEr.close();
            File pyqrAyTs = new File(FZwa5fce);
            InputStream D8lLZrx5 = new FileInputStream(pyqrAyTs);
            Document olYWo2xV = BfnCrjoO.parse(D8lLZrx5);
            NodeList FH1qmBFi = olYWo2xV.getElementsByTagName("doc");
            int EN7PR1z9 = FH1qmBFi.getLength();
            rawTableData = new String[EN7PR1z9][11];
            imageNames = new String[EN7PR1z9];
            for (int NYvFTRqV = 0; NYvFTRqV < EN7PR1z9; NYvFTRqV++) {
                rawTableData[NYvFTRqV][0] = new String(DOMUtil.getSimpleElementText((Element) FH1qmBFi.item(NYvFTRqV), "did"));
                rawTableData[NYvFTRqV][1] = new String(DOMUtil.getSimpleElementText((Element) FH1qmBFi.item(NYvFTRqV), "t"));
                rawTableData[NYvFTRqV][2] = new String(DOMUtil.getSimpleElementText((Element) FH1qmBFi.item(NYvFTRqV), "f"));
                rawTableData[NYvFTRqV][3] = new String(DOMUtil.getSimpleElementText((Element) FH1qmBFi.item(NYvFTRqV), "d"));
                rawTableData[NYvFTRqV][4] = new String(DOMUtil.getSimpleElementText((Element) FH1qmBFi.item(NYvFTRqV), "l"));
                String k0UB4XsL = new String(DOMUtil.getSimpleElementText((Element) FH1qmBFi.item(NYvFTRqV), "fn"));
                String GnfzvNC0 = new String(DOMUtil.getSimpleElementText((Element) FH1qmBFi.item(NYvFTRqV), "ln"));
                rawTableData[NYvFTRqV][5] = k0UB4XsL + " " + GnfzvNC0;
                rawTableData[NYvFTRqV][6] = new String(DOMUtil.getSimpleElementText((Element) FH1qmBFi.item(NYvFTRqV), "dln"));
                rawTableData[NYvFTRqV][7] = new String(DOMUtil.getSimpleElementText((Element) FH1qmBFi.item(NYvFTRqV), "rsid"));
                rawTableData[NYvFTRqV][8] = new String(DOMUtil.getSimpleElementText((Element) FH1qmBFi.item(NYvFTRqV), "img"));
                imageNames[NYvFTRqV] = new String(DOMUtil.getSimpleElementText((Element) FH1qmBFi.item(NYvFTRqV), "img"));
                rawTableData[NYvFTRqV][9] = new String(DOMUtil.getSimpleElementText((Element) FH1qmBFi.item(NYvFTRqV), "ucin"));
                rawTableData[NYvFTRqV][10] = new String(DOMUtil.getSimpleElementText((Element) FH1qmBFi.item(NYvFTRqV), "dtid"));
            }
        } catch (MalformedURLException E0TFmSL0) {
            System.out.println(E0TFmSL0);
        } catch (ParserConfigurationException cC67rlEM) {
            System.out.println(cC67rlEM);
        } catch (NullPointerException C5W5HPPN) {
        } catch (Exception e0ihwGns) {
            System.out.println(e0ihwGns);
        }
    }

}