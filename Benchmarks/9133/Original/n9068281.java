class n9068281{
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            String classFile = name.replace('.', '/') + ".class";
            InputStream classInputStream = null;
            for (JarFile java3DJar : this.java3DJars) {
                JarEntry jarEntry = java3DJar.getJarEntry(classFile);
                if (jarEntry != null) {
                    try {
                        classInputStream = java3DJar.getInputStream(jarEntry);
                    } catch (IOException ex) {
                        throw new ClassNotFoundException("Couldn't read class " + name, ex);
                    }
                }
            }
            if (classInputStream == null) {
                URL url = getResource(classFile);
                if (url == null) {
                    throw new ClassNotFoundException("Class " + name);
                }
                try {
                    classInputStream = url.openStream();
                } catch (IOException ex) {
                    throw new ClassNotFoundException("Couldn't read class " + name, ex);
                }
            }
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                BufferedInputStream in = new BufferedInputStream(classInputStream);
                byte[] buffer = new byte[8096];
                int size;
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);
                }
                in.close();
                return defineClass(name, out.toByteArray(), 0, out.size(), this.protectionDomain);
            } catch (IOException ex) {
                throw new ClassNotFoundException("Class " + name, ex);
            }
        }

}