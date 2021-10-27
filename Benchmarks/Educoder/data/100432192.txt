    public static boolean downloadFile(String from, String to, ProgressMonitor pm) {
        try {
            FileOutputStream out = new FileOutputStream(to);
            URL url = new URL(from);
            URLConnection conn = url.openConnection();
            InputStream in = conn.getInputStream();
            byte[] buffer = new byte[1024];
            int read = 0;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
                if (pm != null) pm.addToProgress(read);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            Installer.getInstance().getLogger().log(StringUtils.getStackTrace(e));
            return false;
        }
        return true;
    }
