            public void run() {
                URL url;
                try {
                    url = new URL(Config.UPDATE_SITE_URL);
                    InputStream is = url.openStream();
                    Writer writer = new StringWriter();
                    char[] buffer = new char[1024];
                    Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    int n;
                    while ((n = reader.read(buffer)) != -1) {
                        writer.write(buffer, 0, n);
                    }
                    String updatePage = writer.toString();
                    is.close();
                    writer.close();
                    System.out.println("DOWNLOAD PAGE :\n" + updatePage);
                    int pos1 = updatePage.indexOf("[ANA-CABV]") + 10;
                    int pos2 = updatePage.indexOf("[/ANA-CABV]");
                    int pos3 = updatePage.indexOf("[ANA-CABVURL]") + 13;
                    int pos4 = updatePage.indexOf("[/ANA-CABVURL]");
                    String currentVersion = updatePage.substring(pos1, pos2);
                    currentVersionLabel.setText(currentVersionLabel.getText() + currentVersion);
                    if (Double.valueOf(Config.VERSION) < Double.valueOf(currentVersion)) {
                        downloadButton.setEnabled(true);
                        label0.setText(mw.getLangMap().get("Update_Avalaible"));
                    } else label0.setText(mw.getLangMap().get("Update_NonAvalaible"));
                    downloadURL = updatePage.substring(pos3, pos4);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
