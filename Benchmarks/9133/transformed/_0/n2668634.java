class n2668634 {
	public WebmillDeploy(String ZfIrBJCX, String gcIR7tUA, boolean o7coX4qP) throws Exception {
        File doM8XMki = null;
        JarFile WHTeb8DU = null;
        JarOutputStream LmlzsIuS = null;
        FileChannel JZ9DLabN = null;
        FileChannel s6CyFJ8H = null;
        try {
            String hPyaJEN9 = getPortletApplicationName(gcIR7tUA);
            System.out.println("portletApplicationName = " + hPyaJEN9);
            doM8XMki = File.createTempFile("webmill-delpoy-", "");
            doM8XMki.deleteOnExit();
            WHTeb8DU = new JarFile(ZfIrBJCX);
            LmlzsIuS = new JarOutputStream(new FileOutputStream(doM8XMki));
            Document H9LNRd89 = null;
            Document aZflQ1Vw = null;
            Document zvitLfP1 = null;
            ZipEntry v8fkuv01;
            InputStream RNSzCpaa;
            Enumeration mFgLnR0W = WHTeb8DU.entries();
            while (mFgLnR0W.hasMoreElements()) {
                v8fkuv01 = (ZipEntry) mFgLnR0W.nextElement();
                RNSzCpaa = WHTeb8DU.getInputStream(v8fkuv01);
                try {
                    String x1FHmynu = v8fkuv01.getName();
                    if (WEB_INF_WEB_XML.equals(x1FHmynu)) {
                        System.out.println("Found web.xml");
                        H9LNRd89 = parseXml(RNSzCpaa);
                    } else if (WEB_INF_PORTLET_XML.equals(x1FHmynu)) {
                        System.out.println("Found WEB-INF/portlet.xml");
                        aZflQ1Vw = parseXml(RNSzCpaa);
                    } else if (META_INF_CONTEXT_XML.equals(x1FHmynu)) {
                        System.out.println("Found META-INF/context.xml");
                        zvitLfP1 = parseXml(RNSzCpaa);
                    }
                } finally {
                    RNSzCpaa.close();
                }
            }
            if (H9LNRd89 == null) {
                throw new IllegalArgumentException("WEB-INF/web.xml not found");
            }
            if (aZflQ1Vw == null) {
                throw new IllegalArgumentException("WEB-INF/portlet.xml not found");
            }
            WebmillWebApplicationRewriter UnKZzFXL = new WebmillWebApplicationRewriter(H9LNRd89);
            UnKZzFXL.processWebXML();
            WebmillContextRewriter AQYIYTxX = new WebmillContextRewriter(zvitLfP1, hPyaJEN9);
            AQYIYTxX.processContextXML();
            WHTeb8DU = new JarFile(ZfIrBJCX);
            mFgLnR0W = WHTeb8DU.entries();
            while (mFgLnR0W.hasMoreElements()) {
                v8fkuv01 = (ZipEntry) mFgLnR0W.nextElement();
                RNSzCpaa = WHTeb8DU.getInputStream(v8fkuv01);
                try {
                    String FtUpcDge = v8fkuv01.getName();
                    String dG95Yhqe = '/' + FtUpcDge;
                    if (o7coX4qP && FtUpcDge.endsWith(".jar") && (FtUpcDge.startsWith("WEB-INF/lib/commons-logging") || FtUpcDge.startsWith("WEB-INF/lib/log4j"))) {
                        System.out.println("Skip logger " + FtUpcDge);
                        continue;
                    } else {
                        if (UnKZzFXL.getRealPortletTldFile() != null && dG95Yhqe.equals(UnKZzFXL.getRealPortletTldFile())) {
                            System.out.println("Skip portlet tld file " + dG95Yhqe);
                            continue;
                        } else if (FtUpcDge.equals(WEB_INF_WEB_XML)) {
                            System.out.println("Skip web.xml file " + FtUpcDge);
                            continue;
                        } else if (FtUpcDge.equals(WEB_INF_PORTLET_XML)) {
                            System.out.println("Skip portlet.xml file " + FtUpcDge);
                            continue;
                        } else if (FtUpcDge.equals(META_INF_CONTEXT_XML)) {
                            System.out.println("Skip context.xml file " + FtUpcDge);
                            continue;
                        }
                        System.out.println("Add file " + FtUpcDge);
                    }
                    addFile(FtUpcDge, RNSzCpaa, LmlzsIuS);
                } finally {
                    RNSzCpaa.close();
                }
            }
            addFile(WEB_INF_WEB_XML, H9LNRd89, LmlzsIuS);
            addFile(WEB_INF_PORTLET_XML, aZflQ1Vw, LmlzsIuS);
            addFile(META_INF_CONTEXT_XML, zvitLfP1, LmlzsIuS);
            System.out.println("Attempting to add portlet.tld to war...");
            InputStream rK2sWGbo = this.getClass().getResourceAsStream("/org/riverock/webmill/container/tags/portlet.tld");
            if (rK2sWGbo == null) {
                System.out.println("Failed to find portlet.tld in classpath");
            } else {
                String tEn3FAmY = UnKZzFXL.getRealPortletTldFile();
                if (tEn3FAmY.charAt(0) == '/') {
                    tEn3FAmY = tEn3FAmY.substring(1);
                }
                System.out.println("Adding file " + tEn3FAmY);
                try {
                    addFile(tEn3FAmY, rK2sWGbo, LmlzsIuS);
                } finally {
                    rK2sWGbo.close();
                }
            }
            LmlzsIuS.close();
            WHTeb8DU.close();
            WHTeb8DU = null;
            LmlzsIuS = null;
            System.out.println("Creating war " + gcIR7tUA + " ...");
            System.out.flush();
            JZ9DLabN = new FileInputStream(doM8XMki).getChannel();
            s6CyFJ8H = new FileOutputStream(gcIR7tUA).getChannel();
            s6CyFJ8H.transferFrom(JZ9DLabN, 0, JZ9DLabN.size());
            JZ9DLabN.close();
            JZ9DLabN = null;
            s6CyFJ8H.close();
            s6CyFJ8H = null;
            doM8XMki.delete();
            doM8XMki = null;
            System.out.println("War " + gcIR7tUA + " created");
            System.out.flush();
        } finally {
            if (JZ9DLabN != null && JZ9DLabN.isOpen()) {
                try {
                    JZ9DLabN.close();
                } catch (IOException dRd8dPDx) {
                }
            }
            if (s6CyFJ8H != null && s6CyFJ8H.isOpen()) {
                try {
                    s6CyFJ8H.close();
                } catch (IOException IGWl9deA) {
                }
            }
            if (WHTeb8DU != null) {
                try {
                    WHTeb8DU.close();
                    WHTeb8DU = null;
                } catch (IOException nJMf3VkH) {
                }
            }
            if (LmlzsIuS != null) {
                try {
                    LmlzsIuS.close();
                    LmlzsIuS = null;
                } catch (IOException erliVQu4) {
                }
            }
            if (doM8XMki != null && doM8XMki.exists()) {
                doM8XMki.delete();
            }
        }
    }

}