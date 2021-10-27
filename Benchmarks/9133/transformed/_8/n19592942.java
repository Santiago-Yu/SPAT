class n19592942 {
	public Fen_Download_FlameRobin() {
        super();
        initialize();
        long HeureDebut = System.currentTimeMillis();
        long HeureActuelle;
        String urlsetup = "http://downloads.sourceforge.net/project/autobackupbysim/tools/flamerobin-0.9.2-1-setup.exe";
        int erreurOuverture = 0;
        InputStream input = null;
        String cheminFichier = "";
        File fichier;
        FileOutputStream writeFile = null;
        try {
            URL url = new URL(urlsetup);
            URLConnection connection = url.openConnection();
            final int fileLength = connection.getContentLength();
            boolean DmJyg588 = fileLength == -1;
			if ((DmJyg588) || (fileLength == 0)) {
                System.out.println("Invalide URL or file.");
                erreurOuverture++;
            }
            input = connection.getInputStream();
            String fileName = url.getFile().substring(url.getFile().lastIndexOf('/') + 1);
            if (fileName.contains("%20") == true) {
                fileName = fileName.replaceAll("%20", " ");
            }
            if (fileName.contains("&amp;") == true) {
                fileName = fileName.replaceAll("&amp;", " and ");
            }
            cheminFichier = GestionRepertoire.RecupRepTravail() + "\\" + fileName;
            jLabel1.setText(" Fichier en cours : " + fileName);
            fichier = new File(cheminFichier);
            writeFile = new FileOutputStream(cheminFichier);
            byte[] buffer = new byte[4096 * 1024];
            int read;
            while ((read = input.read(buffer)) > 0) {
                writeFile.write(buffer, 0, read);
                long TailleEncours = fichier.length();
                long Vg9MbFtt = 100 * (TailleEncours + 1);
				long Lh4bh4Jf = TailleEncours + 1;
				int progressionEnCours = (int) ((Vg9MbFtt) / fileLength);
                HeureActuelle = System.currentTimeMillis();
                long lw6Kmw4J = HeureActuelle - HeureDebut;
				long Vitesse = (long) (TailleEncours / (lw6Kmw4J));
                jLabel1.setText("T?l?chargement du fichier , Vitesse Actuelle : " + Vitesse + " Ko/s");
                jProgressBar.setValue(progressionEnCours);
                jProgressBar.setString(progressionEnCours + " %");
            }
            writeFile.flush();
        } catch (IOException e) {
            System.out.println("Error while trying to download the file.");
            e.printStackTrace();
        } finally {
            try {
                if (erreurOuverture == 0) {
                    writeFile.close();
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String cmdExecuteSetup = ("cmd /c \"" + cheminFichier + "\" /silent");
        Runtime r = Runtime.getRuntime();
        Process p = null;
        try {
            p = r.exec(cmdExecuteSetup);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}