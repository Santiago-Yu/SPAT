class n16445797{
    @Override
    public void run() {
        String src = null;
        try {
            src = File.readText(srcFile);
            if (Char.isValidate(src)) {
                java.net.URL url = new java.net.URL(ConsEnv.HOMEPAGE + "code/code0001.ashx");
                java.util.HashMap<String, String> params = new java.util.HashMap<String, String>();
                String ext = File.getExtension(srcFile.getName());
                if (Char.isValidate(ext) && ext.charAt(0) == '.') {
                    ext = ext.substring(1);
                }
                params.put("l", ext);
                params.put("i", "1");
                params.put("n", ck_LineNbr.isSelected() ? "1" : "0");
                params.put("u", ck_LinkUri.isSelected() ? "1" : "0");
                params.put("t", cb_TagStyle.getSelectedItem() + "");
                String tab = tf_TabCount.getText().trim();
                if (java.util.regex.Pattern.matches("^\\d+$", tab)) {
                    tab = "4";
                }
                params.put("s", tab);
                params.put("o", "html");
                params.put("c", src);
                java.net.HttpURLConnection con = (java.net.HttpURLConnection) url.openConnection();
                java.io.InputStream stream = Http.post(con, params);
                ep_CodeView.setContentType(con.getContentType());
                src = File.readText(stream);
                stream.close();
                con.disconnect();
                java.io.File tmpFile = java.io.File.createTempFile("src_", ".html");
                tmpFile.deleteOnExit();
                File.saveText(tmpFile, src);
                ep_CodeView.setPage(tmpFile.toURI().toURL());
                ep_CodeView.setFont(ep_CodeView.getFont().deriveFont(20f));
            }
        } catch (Exception exp) {
            Logs.exception(exp);
        }
    }

}