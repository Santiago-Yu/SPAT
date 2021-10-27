class n383297{
    private String readAboutText(String urlStr) {
        String text = null;
        try {
            URL url = this.getClass().getResource(urlStr);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            StringWriter writer = new StringWriter();
            int character = reader.read();
            while (character != -1) {
                writer.write(character);
                character = reader.read();
            }
            text = writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            text = "<html><body><b>Author:</b><br>" + aAuthor + "<br>";
            text += "<a href=\"mailto:jhuwaldt@mac.com\">jhuwaldt@mac.com</a><br>";
            text += "<P ALIGN=CENTER><BR>" + aName + " comes with ABSOLUTELY NO WARRANTY;";
            text += "<BR>This is free software, and you are welcome to redistribute ";
            text += "it and it's source code under certain conditions.";
            text += "<BR>Source code is available at:";
            text += "<BR><a href=\"http://virtualhiker.sf.net/\">";
            text += "http://virtualhiker.sf.net/</a></P>";
            text += "</body></html>";
        }
        return text;
    }

}