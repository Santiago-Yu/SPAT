class n8612323 {
	public ProductListByCatHandler(int zIXCHlcK, int kggLh1ub) {
        try {
            URL GBZ6SOhV = new URL("http://eiffel.itba.edu.ar/hci/service/Catalog.groovy?method=GetProductListByCategory&category_id=" + zIXCHlcK + "&language_id=" + kggLh1ub);
            URLConnection YMRF4Dkh = GBZ6SOhV.openConnection();
            YMRF4Dkh.setDoOutput(false);
            YMRF4Dkh.setAllowUserInteraction(false);
            BufferedReader diCu2IDD = new BufferedReader(new InputStreamReader(YMRF4Dkh.getInputStream()));
            String vVAKva24;
            StringBuffer iL8qMzex = new StringBuffer();
            while ((vVAKva24 = diCu2IDD.readLine()) != null) {
                iL8qMzex.append(vVAKva24);
                iL8qMzex.append("\n");
            }
            diCu2IDD.close();
            String cJAFMyAm = iL8qMzex.toString();
            if (cJAFMyAm == null) {
                return;
            }
            DocumentBuilderFactory iMPk8wNf = DocumentBuilderFactory.newInstance();
            DocumentBuilder bNjFtSBE = iMPk8wNf.newDocumentBuilder();
            InputSource cxlO4RNn = new InputSource();
            cxlO4RNn.setCharacterStream(new StringReader(cJAFMyAm));
            Document sDBo5vnU = bNjFtSBE.parse(cxlO4RNn);
            NodeList k5n4fGwH = sDBo5vnU.getElementsByTagName("product");
            for (int LKZPcGR9 = 0; LKZPcGR9 < k5n4fGwH.getLength(); LKZPcGR9++) {
                Element bBaEieoI = (Element) k5n4fGwH.item(LKZPcGR9);
                String ODpbTCaa = bBaEieoI.getAttribute("id").toString();
                NodeList ZmF5XnlX = bBaEieoI.getElementsByTagName("name");
                NodeList xM66v33M = bBaEieoI.getElementsByTagName("sales_rank");
                NodeList ePFYUj64 = bBaEieoI.getElementsByTagName("price");
                NodeList VdEmvSVO = bBaEieoI.getElementsByTagName("image_url");
                String M4aVj87Q = getCharacterDataFromElement((Element) ZmF5XnlX.item(0));
                String psL8Kjft = getCharacterDataFromElement((Element) xM66v33M.item(0));
                String JzMsFflm = getCharacterDataFromElement((Element) ePFYUj64.item(0));
                String E8lK2Ypm = getCharacterDataFromElement((Element) VdEmvSVO.item(0));
                list.add(new ProductShort(ODpbTCaa, M4aVj87Q, psL8Kjft, JzMsFflm, E8lK2Ypm));
            }
        } catch (Exception gSHkdfPE) {
            gSHkdfPE.printStackTrace();
        }
    }

}