class n2967952{
    private void showAboutBox() {
        String message = new String("Error: Resource Not Found.");
        java.net.URL url = ClassLoader.getSystemResource("docs/about.html");
        if (url != null) {
            try {
                StringBuffer buf = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                while (reader.ready()) {
                    buf.append(reader.readLine());
                }
                message = buf.toString();
            } catch (IOException ex) {
                message = new String("IO Error.");
            }
        }
        JOptionPane.showOptionDialog(this, message, "About jBudget", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    }

}