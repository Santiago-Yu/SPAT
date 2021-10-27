    protected JavaFileObject open(String className) throws IOException {
        JavaFileObject fo = getClassFileObject(className);
        if (fo != null) return fo;
        String cn = className;
        int lastDot;
        while ((lastDot = cn.lastIndexOf(".")) != -1) {
            cn = cn.substring(0, lastDot) + "$" + cn.substring(lastDot + 1);
            fo = getClassFileObject(cn);
            if (fo != null) return fo;
        }
        if (!className.endsWith(".class")) return null;
        if (fileManager instanceof StandardJavaFileManager) {
            StandardJavaFileManager sfm = (StandardJavaFileManager) fileManager;
            fo = sfm.getJavaFileObjects(className).iterator().next();
            if (fo != null && fo.getLastModified() != 0) {
                return fo;
            }
        }
        if (className.matches("^[A-Za-z]+:.*")) {
            try {
                final URI uri = new URI(className);
                final URL url = uri.toURL();
                final URLConnection conn = url.openConnection();
                return new JavaFileObject() {

                    public Kind getKind() {
                        return JavaFileObject.Kind.CLASS;
                    }

                    public boolean isNameCompatible(String simpleName, Kind kind) {
                        throw new UnsupportedOperationException();
                    }

                    public NestingKind getNestingKind() {
                        throw new UnsupportedOperationException();
                    }

                    public Modifier getAccessLevel() {
                        throw new UnsupportedOperationException();
                    }

                    public URI toUri() {
                        return uri;
                    }

                    public String getName() {
                        return url.toString();
                    }

                    public InputStream openInputStream() throws IOException {
                        return conn.getInputStream();
                    }

                    public OutputStream openOutputStream() throws IOException {
                        throw new UnsupportedOperationException();
                    }

                    public Reader openReader(boolean ignoreEncodingErrors) throws IOException {
                        throw new UnsupportedOperationException();
                    }

                    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
                        throw new UnsupportedOperationException();
                    }

                    public Writer openWriter() throws IOException {
                        throw new UnsupportedOperationException();
                    }

                    public long getLastModified() {
                        return conn.getLastModified();
                    }

                    public boolean delete() {
                        throw new UnsupportedOperationException();
                    }
                };
            } catch (URISyntaxException ignore) {
            } catch (IOException ignore) {
            }
        }
        return null;
    }
