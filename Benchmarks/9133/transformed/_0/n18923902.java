class n18923902 {
	public ActualTask(TEditor ofNFq19Y, TIGDataBase eiG9LPK0, String EBC6vUOM, String XOxSt4ij) {
            File qmfS00fy = new File(EBC6vUOM);
            String[] xjAOX8jW = qmfS00fy.list();
            File KvhxYdgF = new File(EBC6vUOM + "images.xml");
            SAXBuilder zfZgogSH = new SAXBuilder(false);
            try {
                Document DhLgWFC0 = zfZgogSH.build(KvhxYdgF);
                Element Bc5RJI25 = DhLgWFC0.getRootElement();
                List N92xYOa1 = Bc5RJI25.getChildren("image");
                Iterator Fj1JFF3z = N92xYOa1.iterator();
                int fJ1PiR4d = 0;
                TIGDataBase.activateTransactions();
                while (Fj1JFF3z.hasNext() && !stop && !cancel) {
                    current = fJ1PiR4d;
                    fJ1PiR4d++;
                    Element swdWSE5p = (Element) Fj1JFF3z.next();
                    String XzC5pZai = swdWSE5p.getAttributeValue("name");
                    List dSuO2nw4 = swdWSE5p.getChildren("category");
                    Iterator GlYF1VlG = dSuO2nw4.iterator();
                    if (exists(xjAOX8jW, XzC5pZai)) {
                        String WeOowHep = EBC6vUOM.concat(XzC5pZai);
                        String pQsTTDPj = System.getProperty("user.dir") + File.separator + "images" + File.separator + XzC5pZai.substring(0, 1).toUpperCase() + File.separator;
                        String qGx5mBZu = System.getProperty("user.dir") + File.separator + "images" + File.separator + XzC5pZai.substring(0, 1).toUpperCase();
                        if (XOxSt4ij.equals(TLanguage.getString("TIGImportDBDialog.REPLACE_IMAGES"))) {
                            Vector<Vector<String>> VC3qhYEB = TIGDataBase.imageSearchByName(XzC5pZai.substring(0, XzC5pZai.lastIndexOf('.')));
                            if (VC3qhYEB.size() != 0) {
                                int nHJ4bKl9 = TIGDataBase.imageKeySearchName(XzC5pZai.substring(0, XzC5pZai.lastIndexOf('.')));
                                TIGDataBase.deleteAsociatedOfImage(nHJ4bKl9);
                            }
                            pQsTTDPj = pQsTTDPj.concat(XzC5pZai);
                        }
                        if (XOxSt4ij.equals(TLanguage.getString("TIGImportDBDialog.ADD_IMAGES"))) {
                            Vector D9xi9Pfv = new Vector();
                            D9xi9Pfv = TIGDataBase.imageSearchByName(XzC5pZai.substring(0, XzC5pZai.lastIndexOf('.')));
                            int xSQSZtuq = 0;
                            if (D9xi9Pfv.size() != 0) {
                                while (D9xi9Pfv.size() != 0) {
                                    xSQSZtuq++;
                                    D9xi9Pfv = TIGDataBase.imageSearchByName(XzC5pZai.substring(0, XzC5pZai.lastIndexOf('.')) + "_" + xSQSZtuq);
                                }
                                pQsTTDPj = pQsTTDPj + XzC5pZai.substring(0, XzC5pZai.lastIndexOf('.')) + '_' + xSQSZtuq + XzC5pZai.substring(XzC5pZai.lastIndexOf('.'), XzC5pZai.length());
                                XzC5pZai = XzC5pZai.substring(0, XzC5pZai.lastIndexOf('.')) + '_' + xSQSZtuq + XzC5pZai.substring(XzC5pZai.lastIndexOf('.'), XzC5pZai.length());
                            } else {
                                pQsTTDPj = pQsTTDPj.concat(XzC5pZai);
                            }
                        }
                        String sshiBrec = (pQsTTDPj.substring(0, pQsTTDPj.lastIndexOf("."))).concat("_th.jpg");
                        File CZpyHkhI = new File(qGx5mBZu);
                        if (!CZpyHkhI.exists()) {
                            CZpyHkhI.mkdirs();
                        }
                        try {
                            FileChannel aeFZXqRg = new FileInputStream(WeOowHep).getChannel();
                            FileChannel eYS0FWWB = new FileOutputStream(pQsTTDPj).getChannel();
                            eYS0FWWB.transferFrom(aeFZXqRg, 0, aeFZXqRg.size());
                            aeFZXqRg.close();
                            eYS0FWWB.close();
                        } catch (IOException HMhMw0P5) {
                            System.out.println(HMhMw0P5.getMessage());
                            System.out.println(HMhMw0P5.toString());
                        }
                        TIGDataBase.insertImageDB(XzC5pZai.substring(0, XzC5pZai.lastIndexOf('.')), XzC5pZai);
                        int Oja8xdkJ = TIGDataBase.imageKeySearchName(XzC5pZai.substring(0, XzC5pZai.lastIndexOf('.')));
                        while (GlYF1VlG.hasNext()) {
                            Element lFgdifBp = (Element) GlYF1VlG.next();
                            int GjhVvqcB = TIGDataBase.insertConceptDB(lFgdifBp.getValue());
                            TIGDataBase.insertAsociatedDB(GjhVvqcB, Oja8xdkJ);
                        }
                    } else {
                        errorImages = errorImages + System.getProperty("line.separator") + XzC5pZai;
                    }
                }
                TIGDataBase.executeQueries();
                current = lengthOfTask;
            } catch (JDOMException NdtQc2FB) {
                NdtQc2FB.printStackTrace();
            } catch (IOException x227U13T) {
                x227U13T.printStackTrace();
            }
        }

}