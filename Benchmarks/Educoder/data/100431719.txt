    public boolean submit(String uri) throws java.io.IOException, Exception {
        if (getUserInfo()) {
            String encodedrdf = URLEncoder.encode(rdfpayload, "UTF-8");
            URL url = new URL(uri);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            setDescription(mDescription.getText());
            addCreator(mUser.getText());
            lastUser = mUser.getText();
            PrintWriter out = new PrintWriter(connection.getOutputStream());
            out.println("rdfblob=" + encodedrdf);
            writeCreators(out);
            writeCategories(out);
            writeName(out);
            writeDescription(out);
            writeDate(out);
            out.println("&inputtype=1");
            out.println("&op=Submit");
            out.close();
            return doSubmit(connection, rdfpayload);
        } else {
            JOptionPane.showMessageDialog(null, "Submit cannot be completed without user information, please try again.", "User Info Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
