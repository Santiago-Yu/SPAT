class n17117841 {
	public SearchHandler(String ryCVeU5R, int u5fhpydP) {
        try {
            URL Dy8mKZvK = new URL("http://eiffel.itba.edu.ar/hci/service/Catalog.groovy?method=GetProductListByName&criteria=" + ryCVeU5R + "&language_id=" + u5fhpydP);
            URLConnection DVQcjp3q = Dy8mKZvK.openConnection();
            DVQcjp3q.setDoOutput(false);
            DVQcjp3q.setAllowUserInteraction(false);
            BufferedReader uHna3Lxt = new BufferedReader(new InputStreamReader(DVQcjp3q.getInputStream()));
            String onMDbs2G;
            StringBuffer CPyiciBA = new StringBuffer();
            while ((onMDbs2G = uHna3Lxt.readLine()) != null) {
                CPyiciBA.append(onMDbs2G);
                CPyiciBA.append("\n");
            }
            uHna3Lxt.close();
            String fkSErinG = CPyiciBA.toString();
            if (fkSErinG == null) {
                return;
            }
            DocumentBuilderFactory juoZBO4E = DocumentBuilderFactory.newInstance();
            DocumentBuilder DaaG3NJW = juoZBO4E.newDocumentBuilder();
            InputSource Clp166j3 = new InputSource();
            Clp166j3.setCharacterStream(new StringReader(fkSErinG));
            Document TStj12jv = DaaG3NJW.parse(Clp166j3);
            NodeList UgRp2qjp = TStj12jv.getElementsByTagName("product");
            for (int L5bGbPAJ = 0; L5bGbPAJ < UgRp2qjp.getLength(); L5bGbPAJ++) {
                Element CwrK5jNJ = (Element) UgRp2qjp.item(L5bGbPAJ);
                String SSwn5oQ0 = CwrK5jNJ.getAttribute("id").toString();
                NodeList hOurrQwv = CwrK5jNJ.getElementsByTagName("name");
                NodeList gkwoyLwN = CwrK5jNJ.getElementsByTagName("sales_rank");
                NodeList C1tYHIed = CwrK5jNJ.getElementsByTagName("price");
                NodeList YedJXTGB = CwrK5jNJ.getElementsByTagName("image_url");
                String ZHaNLW7T = getCharacterDataFromElement((Element) hOurrQwv.item(0));
                String z9ovEXlB = getCharacterDataFromElement((Element) gkwoyLwN.item(0));
                String nqZxXUAA = getCharacterDataFromElement((Element) C1tYHIed.item(0));
                String PEHultzo = getCharacterDataFromElement((Element) YedJXTGB.item(0));
                list.add(new ProductShort(SSwn5oQ0, ZHaNLW7T, z9ovEXlB, nqZxXUAA, PEHultzo));
            }
        } catch (Exception iV7Y1Nra) {
            iV7Y1Nra.printStackTrace();
        }
    }

}