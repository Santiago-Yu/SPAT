class n15153344 {
	public ActualTask(TEditor dYInaXpT, TIGDataBase gKX4cbgT, String zgSFFOcy) {
            File dRv6RvYe = new File(zgSFFOcy);
            int znLqc7ZE;
            Vector kgomJjDy = new Vector();
            kgomJjDy = gKX4cbgT.allImageSearch();
            lengthOfTask = kgomJjDy.size() * 2;
            String GShI4bx9 = zgSFFOcy + "Images" + dRv6RvYe.separator;
            File Wnxxh8n3 = new File(GShI4bx9);
            Wnxxh8n3.mkdirs();
            try {
                DocumentBuilderFactory tW8e8nPu = DocumentBuilderFactory.newInstance();
                DocumentBuilder Odvyg2Hk = tW8e8nPu.newDocumentBuilder();
                doc = Odvyg2Hk.newDocument();
            } catch (Exception NYiyfU8l) {
                System.out.println(NYiyfU8l.getMessage());
                System.out.println(NYiyfU8l.toString());
            }
            Element WsGtbO9f = doc.createElement("dataBase");
            for (znLqc7ZE = 0; ((znLqc7ZE < kgomJjDy.size()) && !stop); znLqc7ZE++) {
                current = znLqc7ZE;
                String VS0KhpT1 = (String) kgomJjDy.elementAt(znLqc7ZE);
                String HQFdou9t = "Images" + File.separator + VS0KhpT1.substring(0, 1).toUpperCase() + File.separator + VS0KhpT1;
                String HNKOTtzX = HQFdou9t.substring(HQFdou9t.lastIndexOf(dRv6RvYe.separator) + 1, HQFdou9t.length());
                String gbQCUUd1 = GShI4bx9 + HNKOTtzX;
                try {
                    FileChannel qJ4Yncd4 = new FileInputStream(HQFdou9t).getChannel();
                    FileChannel UwkqD5cQ = new FileOutputStream(gbQCUUd1).getChannel();
                    UwkqD5cQ.transferFrom(qJ4Yncd4, 0, qJ4Yncd4.size());
                    qJ4Yncd4.close();
                    UwkqD5cQ.close();
                } catch (IOException eFhi7H9n) {
                    System.out.println(eFhi7H9n.getMessage());
                    System.out.println(eFhi7H9n.toString());
                }
                Vector oY1ePHB3 = new Vector();
                oY1ePHB3 = gKX4cbgT.asociatedConceptSearch((String) kgomJjDy.elementAt(znLqc7ZE));
                Element PtSSq0NR = doc.createElement("image");
                Element bDSsHS5O = doc.createElement("name");
                bDSsHS5O.appendChild(doc.createTextNode(HNKOTtzX));
                PtSSq0NR.appendChild(bDSsHS5O);
                for (int dvwiSri0 = 0; dvwiSri0 < oY1ePHB3.size(); dvwiSri0++) {
                    Element g7BhempF = doc.createElement("keyWord");
                    g7BhempF.appendChild(doc.createTextNode((String) oY1ePHB3.elementAt(dvwiSri0)));
                    PtSSq0NR.appendChild(g7BhempF);
                }
                WsGtbO9f.appendChild(PtSSq0NR);
            }
            try {
                doc.appendChild(WsGtbO9f);
                File k8KACHbR = new File(GShI4bx9.concat("Images"));
                BufferedWriter tIojRTfI = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(k8KACHbR), "UTF-8"));
                TransformerFactory KeWgwIGs = TransformerFactory.newInstance();
                Transformer T73BGR0G = KeWgwIGs.newTransformer();
                DOMSource oxdjBwaO = new DOMSource(doc);
                StreamResult eoniZlhc = new StreamResult(tIojRTfI);
                T73BGR0G.transform(oxdjBwaO, eoniZlhc);
                tIojRTfI.close();
            } catch (Exception X5PQq29V) {
                System.out.println(X5PQq29V.getMessage());
                System.out.println(X5PQq29V.toString());
            }
            current = lengthOfTask;
        }

}