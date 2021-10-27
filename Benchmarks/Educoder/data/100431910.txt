    private void setProfile(String loginName, SimpleUserProfile profile) throws MM4UCannotStoreUserProfileException {
        try {
            OutputStream outStream = null;
            URL url = new URL(this.profileURI + profile.getID() + FILE_SUFFIX);
            if (url.getProtocol().equals("file")) {
                File file = new File(url.getFile());
                outStream = new FileOutputStream(file);
            } else {
                URLConnection connection = url.openConnection();
                connection.setDoOutput(true);
                outStream = connection.getOutputStream();
            }
            OutputStreamWriter writer = new OutputStreamWriter(outStream);
            Enumeration myEnum = profile.keys();
            while (myEnum.hasMoreElements()) {
                String key = myEnum.nextElement().toString();
                if (key != "id") writer.write(key + "=" + profile.getStringValue(key) + System.getProperty("line.separator"));
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            throw new MM4UCannotStoreUserProfileException(this, "setProfile", e.toString());
        }
    }
