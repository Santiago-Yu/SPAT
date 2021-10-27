class n2967951{
    public void showGetStartedBox() {
        String message = new String("Error: Resource Not Found.");
        java.net.URL url = ClassLoader.getSystemResource("docs/get_started.html");
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
        new HtmlDisplayDialog(this, "Get Started", message);
    }

}