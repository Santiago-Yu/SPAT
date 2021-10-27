class n4645054 {
	public ActualTask(TEditor F9U1oUyT, TIGDataBase Hd4M9dAB, String rbB1QqH1, Vector llDsG9Zr) {
            int RQmPxh0z;
            lengthOfTask = llDsG9Zr.size();
            Element oB4Rfn1U = new Element("dataBase");
            for (RQmPxh0z = 0; ((RQmPxh0z < llDsG9Zr.size()) && !stop && !cancel); RQmPxh0z++) {
                Vector jOsXx60b = new Vector(2);
                jOsXx60b = (Vector) llDsG9Zr.elementAt(RQmPxh0z);
                String zhMsrODO = (String) jOsXx60b.elementAt(0);
                current = RQmPxh0z;
                String wCi9UXtQ = System.getProperty("user.dir") + File.separator + "images" + File.separator + zhMsrODO.substring(0, 1).toUpperCase() + File.separator + zhMsrODO;
                String dd0h8OQ8 = wCi9UXtQ.substring(wCi9UXtQ.lastIndexOf(File.separator) + 1, wCi9UXtQ.length());
                String EDyBB5Ab = rbB1QqH1 + dd0h8OQ8;
                try {
                    FileChannel vfckVt0c = new FileInputStream(wCi9UXtQ).getChannel();
                    FileChannel Vp4Okn5a = new FileOutputStream(EDyBB5Ab).getChannel();
                    Vp4Okn5a.transferFrom(vfckVt0c, 0, vfckVt0c.size());
                    vfckVt0c.close();
                    Vp4Okn5a.close();
                } catch (IOException aibW3YHC) {
                    System.out.println(aibW3YHC.getMessage());
                    System.out.println(aibW3YHC.toString());
                }
                Vector<String> U4k17fWG = new Vector<String>();
                U4k17fWG = TIGDataBase.asociatedConceptSearch(zhMsrODO);
                Element GHvGWtkW = new Element("image");
                GHvGWtkW.setAttribute("name", dd0h8OQ8);
                if (U4k17fWG.size() != 0) {
                    for (int Z3RsgxvD = 0; Z3RsgxvD < U4k17fWG.size(); Z3RsgxvD++) {
                        Element vyNQsI1r = new Element("category");
                        vyNQsI1r.setText(U4k17fWG.get(Z3RsgxvD).trim());
                        GHvGWtkW.addContent(vyNQsI1r);
                    }
                }
                oB4Rfn1U.addContent(GHvGWtkW);
            }
            Document jaMdg5vH = new Document(oB4Rfn1U);
            try {
                XMLOutputter abE9WWpd = new XMLOutputter();
                FileOutputStream j1xloVEN = new FileOutputStream(rbB1QqH1 + "images.xml");
                abE9WWpd.output(jaMdg5vH, j1xloVEN);
                j1xloVEN.flush();
                j1xloVEN.close();
            } catch (Exception iTCOfGol) {
                iTCOfGol.printStackTrace();
            }
            current = lengthOfTask;
        }

}