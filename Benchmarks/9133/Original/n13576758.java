class n13576758{
    private void resourceCopy(String resource, IProject project, String target, IProgressMonitor monitor, Map<String, String> replacement, String charset) throws URISyntaxException, IOException {
        IFile targetFile = project.getFile(target);
        URL url = bundle.getEntry(resource);
        InputStream is = null;
        ByteArrayInputStream bais = null;
        try {
            is = FileLocator.toFileURL(url).openStream();
            int len = is.available();
            byte[] buf = new byte[len];
            is.read(buf);
            String str = new String(buf, charset);
            for (String toRepl : replacement.keySet()) {
                str = str.replaceAll(toRepl, replacement.get(toRepl));
            }
            bais = new ByteArrayInputStream(str.getBytes("UTF-8"));
            if (targetFile.exists()) {
                targetFile.setContents(bais, true, false, monitor);
            } else {
                targetFile.create(bais, true, monitor);
            }
        } catch (Exception e) {
            throw new IOException(e);
        } finally {
            if (bais != null) {
                bais.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

}