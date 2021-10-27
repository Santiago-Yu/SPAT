    public void run() {
        long time = System.currentTimeMillis();
        logger.info("Version: " + version);
        String hostname = properties.getProperty("mercuriushost");
        String protocol = properties.getProperty("mercuriusprotocol");
        String port = properties.getProperty("mercuriusport");
        String path = properties.getProperty("mercuriuspath");
        String action = properties.getProperty("mercuriusaction");
        logger.info("Getting Timex Data --- " + getTimeDifferent(time));
        String xml = timexfrmk.getUnsynchedSessionsXMLFormat();
        logger.info("Done getting Timex Data --- " + getTimeDifferent(time));
        if (timexfrmk.getSessionCount() > 0) {
            try {
                logger.info("Sending Timex Data to Mercurius --- " + getTimeDifferent(time));
                String data = URLEncoder.encode("action", "UTF-8") + "=" + URLEncoder.encode(action, "UTF-8");
                data += "&" + URLEncoder.encode("data", "UTF-8") + "=" + URLEncoder.encode(xml, "UTF-8");
                if (isAdminFeedKeySet()) {
                    data += "&" + URLEncoder.encode("adminfeedkey", "UTF-8") + "=" + URLEncoder.encode(adminfeedkey, "UTF-8");
                    logger.debug("Using adminfeedkey to authenticate");
                } else {
                    Authenticator.setDefault(new CustomAuthenticator(user, password));
                    logger.debug("Using user/pwd to authenticate");
                }
                String u = protocol + "://" + hostname + ":" + port + path;
                logger.debug("Posting xml data to: " + u);
                URL url = new URL(u);
                URLConnection conn = url.openConnection();
                conn.setRequestProperty("User-Agent", "TimexMercurius/" + version);
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(data);
                wr.flush();
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuffer s = new StringBuffer();
                while ((line = rd.readLine()) != null) {
                    s.append(line);
                }
                if (s.length() > 0) {
                    logger.debug(s.toString());
                    if (s.toString().indexOf("Result:") != -1) {
                        logger.info(s.toString().substring(s.toString().indexOf("Result:")));
                        if (s.toString().indexOf("Result: Successful") != -1) {
                            timexfrmk.updateSessionsStatus();
                        }
                    } else {
                        logger.error(s.toString());
                    }
                } else {
                    logger.info("No data returned");
                }
                wr.close();
                rd.close();
            } catch (MalformedURLException e) {
                logger.error(e);
                logger.trace(e, e);
            } catch (IOException e) {
                logger.error(e);
                logger.trace(e, e);
            } catch (Exception e) {
                logger.error(e);
                logger.trace(e, e);
            }
        } else {
            logger.info("There is nothing to send.  Everything has already been synchronized");
        }
        timexfrmk.close();
        logger.info("Done!!! Total Time: " + getTimeDifferent(time));
    }
