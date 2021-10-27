class n17761372{
            public void run() {
                try {
                    String data = URLEncoder.encode("send_id", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8");
                    data += "&" + URLEncoder.encode("author", "UTF-8") + "=" + URLEncoder.encode(name.getText(), "UTF-8");
                    data += "&" + URLEncoder.encode("location", "UTF-8") + "=" + URLEncoder.encode(System.getProperty("user.language"), "UTF-8");
                    data += "&" + URLEncoder.encode("contact", "UTF-8") + "=" + URLEncoder.encode(email.getText(), "UTF-8");
                    data += "&" + URLEncoder.encode("content", "UTF-8") + "=" + URLEncoder.encode(comment.getText(), "UTF-8");
                    data += "&" + URLEncoder.encode("rate", "UTF-8") + "=" + URLEncoder.encode(rate.getSelectedItem().toString(), "UTF-8");
                    System.out.println(data);
                    URL url = new URL("http://javablock.sourceforge.net/book/index.php");
                    URLConnection conn = url.openConnection();
                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    wr.write(data);
                    wr.flush();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String address = rd.readLine();
                    JPanel panel = new JPanel();
                    panel.add(new JLabel("Comment added"));
                    panel.add(new JTextArea("visit: http://javablock.sourceforge.net/"));
                    JOptionPane.showMessageDialog(null, new JLabel("Comment sended correctly!"));
                    wr.close();
                    rd.close();
                    hide();
                } catch (IOException ex) {
                    Logger.getLogger(guestBook.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

}