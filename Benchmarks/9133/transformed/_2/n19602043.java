class n19602043 {
	public RSClassLoader(Map<String, byte[]> classes, URL source) {
        try {
            CodeSource codeSource = new CodeSource(source, (CodeSigner[]) null);
            domain = new ProtectionDomain(codeSource, getPermissions());
            this.classes = classes;
            String s = getClass().getResource("RSClassLoader.class").toString();
            s = s.replace("bot/RSClassLoader.class", "client/RandomAccessFile.class");
            URL url = new URL(s);
            InputStream is = null;
            try {
                ByteArrayOutputStream bos = new ByteArrayOutputStream(5000);
                is = new BufferedInputStream(url.openStream());
                byte[] buff = new byte[1024];
                int len = -1;
                for (; (len = is.read(buff)) != -1;)
					bos.write(buff, 0, len);
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