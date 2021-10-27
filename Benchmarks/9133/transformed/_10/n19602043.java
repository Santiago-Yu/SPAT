class n19602043 {
	public RSClassLoader(Map<String, byte[]> classes, URL source) {
        try {
            CodeSource codeSource = new CodeSource(source, (CodeSigner[]) null);
            domain = new ProtectionDomain(codeSource, getPermissions());
            String s = getClass().getResource("RSClassLoader.class").toString();
            this.classes = classes;
            s = s.replace("bot/RSClassLoader.class", "client/RandomAccessFile.class");
            InputStream is = null;
            URL url = new URL(s);
            try {
                is = new BufferedInputStream(url.openStream());
                ByteArrayOutputStream bos = new ByteArrayOutputStream(5000);
                int len = -1;
                byte[] buff = new byte[1024];
                while ((len = is.read(buff)) != -1) bos.write(buff, 0, len);
                byte[] data = bos.toByteArray();
                this.classes.put("org.rsbot.client.RandomAccessFile", data);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (is != null) is.close();
            }
        } catch (final Exception ignored) {
        }
    }

}