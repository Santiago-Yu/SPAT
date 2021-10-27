class n8644603{
    public static void main(String args[]) {
        org.apache.xml.security.Init.init();
        String signatureFileName = args[0];
        javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setAttribute("http://xml.org/sax/features/namespaces", Boolean.TRUE);
        try {
            long start = System.currentTimeMillis();
            org.apache.xml.security.Init.init();
            File f = new File(signatureFileName);
            System.out.println("Verifying " + signatureFileName);
            javax.xml.parsers.DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document doc = db.parse(new java.io.FileInputStream(f));
            VerifyExampleTest vf = new VerifyExampleTest();
            vf.verify(doc);
            Constants.setSignatureSpecNSprefix("dsig");
            Element sigElement = null;
            NodeList nodes = doc.getElementsByTagNameNS(org.apache.xml.security.utils.Constants.SignatureSpecNS, "Signature");
            if (nodes.getLength() != 0) {
                System.out.println("Found " + nodes.getLength() + " Signature  elements.");
                for (int i = 0; i < nodes.getLength(); i++) {
                    sigElement = (Element) nodes.item(i);
                    XMLSignature signature = new XMLSignature(sigElement, "");
                    KeyInfo ki = signature.getKeyInfo();
                    signature.addResourceResolver(new OfflineResolver());
                    if (ki != null) {
                        if (ki.containsX509Data()) {
                            System.out.println("Could find a X509Data element in the  KeyInfo");
                        }
                        KeyInfo kinfo = signature.getKeyInfo();
                        X509Certificate cert = null;
                        if (kinfo.containsRetrievalMethod()) {
                            RetrievalMethod m = kinfo.itemRetrievalMethod(0);
                            URL url = new URL(m.getURI());
                            CertificateFactory cf = CertificateFactory.getInstance("X.509");
                            cert = (X509Certificate) cf.generateCertificate(url.openStream());
                        } else {
                            cert = signature.getKeyInfo().getX509Certificate();
                        }
                        if (cert != null) {
                            System.out.println("The XML signature is " + (signature.checkSignatureValue(cert) ? "valid (good)" : "invalid !!!!! (bad)"));
                        } else {
                            System.out.println("Did not find a Certificate");
                            PublicKey pk = signature.getKeyInfo().getPublicKey();
                            if (pk != null) {
                                System.out.println("The XML signatur is " + (signature.checkSignatureValue(pk) ? "valid (good)" : "invalid !!!!! (bad)"));
                            } else {
                                System.out.println("Did not find a public key, so I can't check the signature");
                            }
                        }
                    } else {
                        System.out.println("Did not find a KeyInfo");
                    }
                }
            }
            long end = System.currentTimeMillis();
            double elapsed = end - start;
            System.out.println("verified:" + elapsed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}