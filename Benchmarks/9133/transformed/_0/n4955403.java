class n4955403 {
	public FetchTextFromWebPage(String FI3pIFjJ) {
        HTMLEditorKit.Parser rswrHQqg;
        HTMLFile = new File(FI3pIFjJ);
        byte[] h6oFZwtl = new byte[new Long(HTMLFile.length()).intValue()];
        try {
            FileInputStream ldAIxc2T = new FileInputStream(HTMLFile);
            try {
                ldAIxc2T.read(h6oFZwtl);
            } catch (IOException tFOzuOfW) {
                tFOzuOfW.printStackTrace();
            }
            ByteArrayInputStream bzsDzsnz = new ByteArrayInputStream(h6oFZwtl);
            r = new InputStreamReader(bzsDzsnz);
        } catch (FileNotFoundException pAioZXLi) {
            URL UdouzaQ6 = null;
            try {
                UdouzaQ6 = new URL(FI3pIFjJ);
                URLConnection NIkTxYlf = null;
                try {
                    NIkTxYlf = UdouzaQ6.openConnection();
                    NIkTxYlf.setDoInput(true);
                    InputStream qGXbqMmC = null;
                    try {
                        qGXbqMmC = NIkTxYlf.getInputStream();
                        BufferedReader jWYFi9Up = new BufferedReader(new InputStreamReader(qGXbqMmC));
                        StringBuffer ldr8qNGs = new StringBuffer();
                        String Le1MsCvm = null;
                        try {
                            while ((Le1MsCvm = jWYFi9Up.readLine()) != null) {
                                System.out.println(Le1MsCvm);
                                ldr8qNGs.append(Le1MsCvm + "\n");
                            }
                        } catch (IOException NcnU2H9r) {
                            NcnU2H9r.printStackTrace();
                        }
                        File z3ZoSEtM = new File("//home//wiki14//temp.txt");
                        if (!z3ZoSEtM.exists()) {
                            if (!z3ZoSEtM.createNewFile()) System.out.println("File caanot be created");
                        } else {
                            z3ZoSEtM.delete();
                            if (!z3ZoSEtM.createNewFile()) System.out.println("File caanot be created");
                        }
                        java.io.FileWriter oiJujG2U = new java.io.FileWriter(z3ZoSEtM);
                        oiJujG2U.write(ldr8qNGs.toString());
                        oiJujG2U.close();
                        byte[] FrWkbXk7 = new byte[new Long(ldr8qNGs.length()).intValue()];
                        ByteArrayInputStream m5Mbcicm = new ByteArrayInputStream(FrWkbXk7);
                        r = new InputStreamReader(m5Mbcicm);
                    } catch (IOException N4x4uvnJ) {
                        N4x4uvnJ.printStackTrace();
                    }
                } catch (IOException D5RvriAR) {
                    D5RvriAR.printStackTrace();
                }
            } catch (MalformedURLException oUY8eiPI) {
                oUY8eiPI.printStackTrace();
            }
        }
        rswrHQqg = new ParserDelegator();
        htmltextparser = new HtmlTextParser();
        htmltextparser.initData();
        try {
            rswrHQqg.parse(r, htmltextparser, true);
        } catch (IOException S1TedFCx) {
            S1TedFCx.printStackTrace();
        }
        try {
            r.close();
        } catch (IOException BnE13Nab) {
            BnE13Nab.printStackTrace();
        }
    }

}