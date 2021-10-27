class n17175191 {
	public Updater() {
        try {
            setTitle("OssoBook Updater");
            System.setProperty("java.net.preferIPv4Stack", "true");
            initComponents();
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            int posX = (screen.width / 2) - (640 / 2), posY = (screen.height / 2) - (480 / 2);
            setLocation(posX, posY);
            jProgressBar1.setVisible(true);
            labelPercuentalProgress.setVisible(true);
            URL url = new URL(updatePath + "currentVersion.txt");
            URLConnection con = url.openConnection();
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            for (; (line = in.readLine()) != null; ) {
                numberFiles++;
            }
            labelFileProgress.setText("0/" + numberFiles);
            labelPercuentalProgress.setText("0%");
            jProgressBar2.setMaximum(numberFiles);
            URL url2 = new URL(updatePath + "Changelog.txt");
            URLConnection con2 = url2.openConnection();
            con2.connect();
            BufferedReader in2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));
            jTextArea1.setMargin(new Insets(10, 10, 10, 10));
            Font f = new Font("Monospaced", Font.PLAIN, 12);
            jTextArea1.setFont(f);
            for (; (line = in2.readLine()) != null; ) {
                jTextArea1.setText(jTextArea1.getText() + line + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(Updater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}