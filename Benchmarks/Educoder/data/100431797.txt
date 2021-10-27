    public void actionPerformed(ActionEvent e) {
        if ("register".equals(e.getActionCommand())) {
            buttonClicked = "register";
            try {
                String data = URLEncoder.encode("ver", "UTF-8") + "=" + URLEncoder.encode(Double.toString(questVer), "UTF-8");
                data += "&" + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name.getText(), "UTF-8");
                data += "&" + URLEncoder.encode("os", "UTF-8") + "=" + URLEncoder.encode(os.getText(), "UTF-8");
                data += "&" + URLEncoder.encode("jre", "UTF-8") + "=" + URLEncoder.encode(jre.getText(), "UTF-8");
                data += "&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email.getText(), "UTF-8");
                data += "&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode("Qr7SchF", "UTF-8");
                data += "&" + URLEncoder.encode("answers", "UTF-8") + "=" + URLEncoder.encode(Integer.toString(getAnswers()), "UTF-8");
                URL url = new URL("http://ubcdcreator.sourceforge.net/register.php");
                URLConnection conn = url.openConnection();
                conn.setDoInput(true);
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(data);
                wr.flush();
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = rd.readLine()) != null) {
                }
                rd.close();
                wr.close();
            } catch (Exception ex) {
            }
            setVisible(false);
        } else if ("cancel".equals(e.getActionCommand())) {
            buttonClicked = "cancel";
            setVisible(false);
        } else if ("never".equals(e.getActionCommand())) {
            buttonClicked = "never";
            setVisible(false);
        }
    }
