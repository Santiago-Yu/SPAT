class n5389524 {
	public ActualTask(TEditor l2QWAnqT, TIGDataBase OcMssHk6, String OQly6ShU) {
            File ZGd8TVUu = new File(OQly6ShU);
            String[] xfi44OF5 = ZGd8TVUu.list();
            int DiA0M5Gj;
            for (DiA0M5Gj = 0; ((DiA0M5Gj < xfi44OF5.length) && !stop); DiA0M5Gj++) {
                current = DiA0M5Gj;
                if ((xfi44OF5[DiA0M5Gj].compareTo("Images") != 0) && ((xfi44OF5[DiA0M5Gj].substring(xfi44OF5[DiA0M5Gj].lastIndexOf('.'), xfi44OF5[DiA0M5Gj].length()).toLowerCase().compareTo(".jpg") == 0) || (xfi44OF5[DiA0M5Gj].substring(xfi44OF5[DiA0M5Gj].lastIndexOf('.'), xfi44OF5[DiA0M5Gj].length()).toLowerCase().compareTo(".bmp") == 0) || (xfi44OF5[DiA0M5Gj].substring(xfi44OF5[DiA0M5Gj].lastIndexOf('.'), xfi44OF5[DiA0M5Gj].length()).toLowerCase().compareTo(".png") == 0))) {
                    String d0O5c5gB = xfi44OF5[DiA0M5Gj];
                    String JehDOjTC = OQly6ShU.concat(xfi44OF5[DiA0M5Gj]);
                    d0O5c5gB = d0O5c5gB.replace(' ', '_').replace(',', '-').replace('ив', 'a').replace('иж', 'e').replace('ик', 'i').replace('ио', 'o').replace('и▓', 'u').replace('?', 'A').replace('?', 'E').replace('?', 'I').replace('?', 'O').replace('?', 'U');
                    String cNxQMhNb = OQly6ShU.concat(d0O5c5gB);
                    Vector Kds7dImz = new Vector();
                    Kds7dImz = OcMssHk6.imageSearch(d0O5c5gB.substring(0, d0O5c5gB.lastIndexOf('.')));
                    if (Kds7dImz.size() != 0) cNxQMhNb = cNxQMhNb.substring(0, cNxQMhNb.lastIndexOf('.')) + '_' + Kds7dImz.size() + ".png";
                    File iyB4543i = new File(JehDOjTC);
                    File YjPqqebh = new File("");
                    String SPwXFTZb = '.' + iyB4543i.separator + "Images" + iyB4543i.separator + d0O5c5gB.substring(0, 1).toUpperCase() + iyB4543i.separator + cNxQMhNb.substring(cNxQMhNb.lastIndexOf(iyB4543i.separator) + 1, cNxQMhNb.length());
                    String XhVKvG5O = '.' + iyB4543i.separator + "Images" + iyB4543i.separator + d0O5c5gB.substring(0, 1).toUpperCase();
                    String hzn56WV5 = (SPwXFTZb.substring(0, SPwXFTZb.lastIndexOf("."))).concat("_th.jpg");
                    ImageIcon hksaFa7f = null;
                    if (iyB4543i != null) {
                        if (TFileUtils.isJAIRequired(iyB4543i)) {
                            RenderedOp vWZVOjRT = JAI.create("fileload", iyB4543i.getAbsolutePath());
                            BufferedImage Ken3B2SM = vWZVOjRT.getAsBufferedImage();
                            hksaFa7f = new ImageIcon(Ken3B2SM);
                        } else {
                            hksaFa7f = new ImageIcon(iyB4543i.getAbsolutePath());
                        }
                        if (hksaFa7f.getImageLoadStatus() == MediaTracker.ERRORED) {
                            System.out.print("Error al insertar imagen: ");
                            System.out.println(cNxQMhNb);
                        } else {
                            int mHPE48id = 0;
                            imageFile = new File(OQly6ShU + "Images");
                            if (!imageFile.exists()) {
                                TIGNewImageDataDialog pPnvm1Z4 = new TIGNewImageDataDialog(l2QWAnqT, OcMssHk6, hksaFa7f, SPwXFTZb.substring(SPwXFTZb.lastIndexOf(File.separator) + 1, SPwXFTZb.length()), xfi44OF5[DiA0M5Gj].substring(0, xfi44OF5[DiA0M5Gj].lastIndexOf('.')), myTask);
                                mHPE48id = pPnvm1Z4.getOption();
                                if (mHPE48id != 0) {
                                    File OmuYQv5E = new File(XhVKvG5O);
                                    OmuYQv5E.mkdirs();
                                    try {
                                        FileChannel enWVLuXd = new FileInputStream(JehDOjTC).getChannel();
                                        FileChannel ttQo8z34 = new FileOutputStream(SPwXFTZb).getChannel();
                                        ttQo8z34.transferFrom(enWVLuXd, 0, enWVLuXd.size());
                                        enWVLuXd.close();
                                        ttQo8z34.close();
                                    } catch (IOException aNeUM9J7) {
                                        System.out.println(aNeUM9J7.getMessage());
                                        System.out.println(aNeUM9J7.toString());
                                    }
                                }
                            }
                            if (imageFile.exists()) {
                                OcMssHk6.insertImageDB(xfi44OF5[DiA0M5Gj].substring(0, xfi44OF5[DiA0M5Gj].lastIndexOf('.')), SPwXFTZb.substring(SPwXFTZb.lastIndexOf(File.separator) + 1, SPwXFTZb.length()));
                                File WV2Z7IIa = new File(XhVKvG5O);
                                WV2Z7IIa.mkdirs();
                                try {
                                    FileChannel Kd1a9EFN = new FileInputStream(JehDOjTC).getChannel();
                                    FileChannel ZmJlJ11t = new FileOutputStream(SPwXFTZb).getChannel();
                                    ZmJlJ11t.transferFrom(Kd1a9EFN, 0, Kd1a9EFN.size());
                                    Kd1a9EFN.close();
                                    ZmJlJ11t.close();
                                } catch (IOException QzMGCRFc) {
                                    System.out.println(QzMGCRFc.getMessage());
                                    System.out.println(QzMGCRFc.toString());
                                }
                            }
                            try {
                                int vlXHTgt9 = PREVIEW_WIDTH;
                                int eO3yRWN8 = PREVIEW_HEIGHT;
                                double HHgYitis = (double) vlXHTgt9 / (double) eO3yRWN8;
                                int WBvME0nP = hksaFa7f.getIconWidth();
                                int HTd7GyW5 = hksaFa7f.getIconHeight();
                                double dHn5YCzF = (double) WBvME0nP / (double) HTd7GyW5;
                                if (HHgYitis < dHn5YCzF) {
                                    eO3yRWN8 = (int) (vlXHTgt9 / dHn5YCzF);
                                } else {
                                    vlXHTgt9 = (int) (eO3yRWN8 * dHn5YCzF);
                                }
                                BufferedImage o8tf8zcR = new BufferedImage(vlXHTgt9, eO3yRWN8, BufferedImage.TYPE_INT_RGB);
                                Graphics2D XdSG3B9Q = o8tf8zcR.createGraphics();
                                XdSG3B9Q.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                                XdSG3B9Q.drawImage(hksaFa7f.getImage(), 0, 0, vlXHTgt9, eO3yRWN8, null);
                                BufferedOutputStream VcAMz76p = new BufferedOutputStream(new FileOutputStream(hzn56WV5));
                                JPEGImageEncoder HCAfNysb = JPEGCodec.createJPEGEncoder(VcAMz76p);
                                JPEGEncodeParam C2MhUElo = HCAfNysb.getDefaultJPEGEncodeParam(o8tf8zcR);
                                int GT0Ws2EW = 100;
                                GT0Ws2EW = Math.max(0, Math.min(GT0Ws2EW, 100));
                                C2MhUElo.setQuality((float) GT0Ws2EW / 100.0f, false);
                                HCAfNysb.setJPEGEncodeParam(C2MhUElo);
                                HCAfNysb.encode(o8tf8zcR);
                                VcAMz76p.close();
                            } catch (Exception KK3Cs9cj) {
                                System.out.println(KK3Cs9cj.getMessage());
                                System.out.println(KK3Cs9cj.toString());
                            }
                        }
                    }
                }
            }
            if (imageFile.exists() && !stop) {
                try {
                    DocumentBuilderFactory rEOt5Up0 = DocumentBuilderFactory.newInstance();
                    DocumentBuilder q3Jvnr5D = rEOt5Up0.newDocumentBuilder();
                    Document yf9LMsCz = q3Jvnr5D.parse(imageFile);
                    Element zUFHosEf = yf9LMsCz.getDocumentElement();
                    if (zUFHosEf.getTagName().equals("dataBase")) {
                        NodeList POfuONlw = zUFHosEf.getElementsByTagName("image");
                        for (int Bl1zQCMA = 0; Bl1zQCMA < POfuONlw.getLength(); Bl1zQCMA++) {
                            current++;
                            Node fYdxNOe0 = POfuONlw.item(Bl1zQCMA);
                            NodeList ZGZkVhXB = fYdxNOe0.getChildNodes();
                            Node bvy9itt4 = fYdxNOe0.getChildNodes().item(0);
                            String vYZhS0IK = bvy9itt4.getChildNodes().item(0).getNodeValue();
                            int uHCEM2IS = OcMssHk6.imageKeySearchName(vYZhS0IK.substring(0, vYZhS0IK.lastIndexOf('.')));
                            if (uHCEM2IS != -1) {
                                for (int WyTUx1AA = 1; WyTUx1AA < fYdxNOe0.getChildNodes().getLength(); WyTUx1AA++) {
                                    Node fe7HmmUA = fYdxNOe0.getChildNodes().item(WyTUx1AA);
                                    String uTyfxNne = fe7HmmUA.getChildNodes().item(0).getNodeValue();
                                    int m94dHWYZ = OcMssHk6.conceptKeySearch(uTyfxNne);
                                    if (m94dHWYZ == -1) {
                                        OcMssHk6.insertConceptDB(uTyfxNne);
                                        m94dHWYZ = OcMssHk6.conceptKeySearch(uTyfxNne);
                                    }
                                    OcMssHk6.insertAsociatedDB(m94dHWYZ, uHCEM2IS);
                                }
                            }
                        }
                    }
                } catch (Exception RuYSFH0i) {
                    System.out.println(RuYSFH0i.getMessage());
                    System.out.println(RuYSFH0i.toString());
                }
            }
            current = lengthOfTask;
        }

}