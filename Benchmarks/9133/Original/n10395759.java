class n10395759{
    public void run() {
        btnReintentar.setEnabled(false);
        try {
            lblEstado.setText("Conectando con servidor...");
            escribir("\nConectando con servidor...");
            URL url = new URL("http://apeiron.sourceforge.net/version.php");
            lblEstado.setText("Obteniendo informaci?n de versi?n...");
            escribir("Ok\n");
            escribir("Obteniendo informaci?n sobre ?ltima versi?n...");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String linea = br.readLine();
            escribir("Ok\n");
            if (linea != null) {
                escribir("Versi?n mas reciente: " + linea + "\n");
                if (Principal.version < Double.parseDouble(linea)) {
                    lblEstado.setText("Hay una nueva versi?n: Apeiron " + linea);
                    escribir("Puede obtener la actualizaci?n de: http://apeiron.sourceforge.net\n");
                    btnActualizar.setEnabled(true);
                    setVisible(true);
                } else {
                    lblEstado.setText("Usted tiene la ?ltima versi?n");
                }
            }
            br.close();
        } catch (MalformedURLException e) {
            escribir("Fall?\n" + e + "\n");
            e.printStackTrace();
        } catch (IOException e) {
            escribir("Fall?\n" + e + "\n");
            e.printStackTrace();
        }
        btnReintentar.setEnabled(true);
    }

}