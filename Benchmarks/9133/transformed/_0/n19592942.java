class n19592942 {
	public Fen_Download_FlameRobin() {
        super();
        initialize();
        long UYhQmkYz = System.currentTimeMillis();
        long jObidmYE;
        String hMc0DlWJ = "http://downloads.sourceforge.net/project/autobackupbysim/tools/flamerobin-0.9.2-1-setup.exe";
        int pxr24lrj = 0;
        InputStream jDRjbYO4 = null;
        String MR3WAoMt = "";
        File ArvQ0DBU;
        FileOutputStream vkbqVoJm = null;
        try {
            URL q20t52tc = new URL(hMc0DlWJ);
            URLConnection q74d7RSH = q20t52tc.openConnection();
            final int jqlhYObB = q74d7RSH.getContentLength();
            if ((jqlhYObB == -1) || (jqlhYObB == 0)) {
                System.out.println("Invalide URL or file.");
                pxr24lrj++;
            }
            jDRjbYO4 = q74d7RSH.getInputStream();
            String UBtfPmUe = q20t52tc.getFile().substring(q20t52tc.getFile().lastIndexOf('/') + 1);
            if (UBtfPmUe.contains("%20") == true) {
                UBtfPmUe = UBtfPmUe.replaceAll("%20", " ");
            }
            if (UBtfPmUe.contains("&amp;") == true) {
                UBtfPmUe = UBtfPmUe.replaceAll("&amp;", " and ");
            }
            MR3WAoMt = GestionRepertoire.RecupRepTravail() + "\\" + UBtfPmUe;
            jLabel1.setText(" Fichier en cours : " + UBtfPmUe);
            ArvQ0DBU = new File(MR3WAoMt);
            vkbqVoJm = new FileOutputStream(MR3WAoMt);
            byte[] vfDACAdM = new byte[4096 * 1024];
            int fPe8uHde;
            while ((fPe8uHde = jDRjbYO4.read(vfDACAdM)) > 0) {
                vkbqVoJm.write(vfDACAdM, 0, fPe8uHde);
                long To7uBE80 = ArvQ0DBU.length();
                int agYaPFgd = (int) ((100 * (To7uBE80 + 1)) / jqlhYObB);
                jObidmYE = System.currentTimeMillis();
                long hmmsEodS = (long) (To7uBE80 / (jObidmYE - UYhQmkYz));
                jLabel1.setText("T?l?chargement du fichier , Vitesse Actuelle : " + hmmsEodS + " Ko/s");
                jProgressBar.setValue(agYaPFgd);
                jProgressBar.setString(agYaPFgd + " %");
            }
            vkbqVoJm.flush();
        } catch (IOException eDYYuQZb) {
            System.out.println("Error while trying to download the file.");
            eDYYuQZb.printStackTrace();
        } finally {
            try {
                if (pxr24lrj == 0) {
                    vkbqVoJm.close();
                    jDRjbYO4.close();
                }
            } catch (IOException MFMhUdDn) {
                MFMhUdDn.printStackTrace();
            }
        }
        String V4yBw6jZ = ("cmd /c \"" + MR3WAoMt + "\" /silent");
        Runtime Z2zzNJZK = Runtime.getRuntime();
        Process Y7yNGOyz = null;
        try {
            Y7yNGOyz = Z2zzNJZK.exec(V4yBw6jZ);
        } catch (IOException TWor76HW) {
            TWor76HW.printStackTrace();
        }
        try {
            Y7yNGOyz.waitFor();
        } catch (InterruptedException BfwM6xSq) {
            BfwM6xSq.printStackTrace();
        }
    }

}