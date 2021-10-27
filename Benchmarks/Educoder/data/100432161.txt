    public Set<String> getAvailableRoles() {
        if (availableRoles == null) {
            availableRoles = new HashSet<String>();
            try {
                Enumeration<URL> resources = org.springframework.util.ClassUtils.getDefaultClassLoader().getResources(ROLE_FILE_LOCATION);
                while (resources.hasMoreElements()) {
                    URL url = resources.nextElement();
                    InputStream is = null;
                    try {
                        URLConnection con = url.openConnection();
                        con.setUseCaches(false);
                        is = con.getInputStream();
                        List<String> lines = IOUtils.readLines(is, "ISO-8859-1");
                        if (lines != null) {
                            for (String line : lines) {
                                availableRoles.add(line.trim());
                            }
                        }
                    } finally {
                        if (is != null) {
                            is.close();
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return availableRoles;
    }
