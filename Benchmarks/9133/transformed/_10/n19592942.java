class n19592942 {
	public Fen_Download_FlameRobin() {
        super();
        initialize();
        long HeureActuelle;
        long HeureDebut = System.currentTimeMillis();
        int erreurOuverture = 0;
        String urlsetup = "http://downloads.sourceforge.net/project/autobackupbysim/tools/flamerobin-0.9.2-1-setup.exe";
        String cheminFichier = "";
        InputStream input = null;
        FileOutputStream writeFile = null;
        File fichier;
        try {
            URL url = new URL(urlsetup);
            URLConnection connection = url.openConnection();
            final int fileLength = connection.getContentLength();
            input = connection.getInputStream();
            if ((fileLength == -1) || (fileLength == 0)) {
				System.out.println("Invalide URL or file.");
				erreurOuverture++;
			}
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
            byte[] buffer = new byte[4096 * 1024];
            writeFile = new FileOutputStream(cheminFichier);
            int read;
            while ((read = input.read(buffer)) > 0) {
                writeFile.write(buffer, 0, read);
                long TailleEncours = fichier.length();
                HeureActuelle = System.currentTimeMillis();
                int progressionEnCours = (int) ((100 * (TailleEncours + 1)) / fileLength);
                long Vitesse = (long) (TailleEncours / (HeureActuelle - HeureDebut));
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
        Runtime r = Runtime.getRuntime();
        String cmdExecuteSetup = ("cmd /c \"" + cheminFichier + "\" /silent");
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