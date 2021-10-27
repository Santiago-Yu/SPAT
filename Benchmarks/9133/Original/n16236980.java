class n16236980{
    public void loadProperties() {
        try {
            java.util.Properties props = new java.util.Properties();
            java.net.URL url = ClassLoader.getSystemResource("env.properties");
            props.load(url.openStream());
            this.proxyCertificatePath = props.getProperty("proxy.certificate.path");
            this.dummyFileDirName = props.getProperty("delete.dummyFileDirName");
            this.idleTimeTestDelay = new Integer(props.getProperty("idleTimeTestDelaySeconds"));
            if (props.getProperty("gridftp.timeoutMilliSecs") != null) {
                this.gridftpTimeoutMilliSecs = new Integer(props.getProperty("gridftp.timeoutMilliSecs").trim());
            }
            this.assertContentInWriteTests = new Boolean(props.getProperty("assertContentInWriteTests"));
            this.gridftpHost1 = props.getProperty("gridftp.host1");
            this.gridftpPort1 = new Integer(props.getProperty("gridftp.port1"));
            this.gridftpHost2 = props.getProperty("gridftp.host2");
            this.gridftpPort2 = new Integer(props.getProperty("gridftp.port2"));
            this.srbGsiHost = props.getProperty("srb.gsi.host");
            this.srbGsiPort = new Integer(props.getProperty("srb.gsi.port"));
            this.srbGsiPortMin = new Integer(props.getProperty("srb.gsi.port.min"));
            this.srbGsiPortMax = new Integer(props.getProperty("srb.gsi.port.max"));
            this.srbGsiDefaultResource = props.getProperty("srb.gsi.defaultResource");
            this.srbEncryptHost = props.getProperty("srb.encrypt.host");
            this.srbEncryptPort = new Integer(props.getProperty("srb.encrypt.port"));
            this.srbEncryptPortMin = new Integer(props.getProperty("srb.encrypt.port.min"));
            this.srbEncryptPortMax = new Integer(props.getProperty("srb.encrypt.port.max"));
            this.srbEncryptDefaultResource = props.getProperty("srb.encrypt.defaultResource");
            this.srbEncryptHomeDirectory = props.getProperty("srb.encrypt.homeDirectory");
            this.srbEncryptMcatZone = props.getProperty("srb.encrypt.mcatZone");
            this.srbEncryptMdasDomainName = props.getProperty("srb.encrypt.mdasDomainName");
            this.srbEncryptUsername = props.getProperty("srb.encrypt.username");
            this.srbEncryptPassword = props.getProperty("srb.encrypt.password");
            this.sftpHost = props.getProperty("sftp.host");
            this.sftpPort = new Integer(props.getProperty("sftp.port"));
            this.sftpPath = props.getProperty("sftp.path");
            this.sftpUsername = props.getProperty("sftp.username");
            this.sftpPassword = props.getProperty("sftp.password");
            if (props.getProperty("sftp.timeoutMilliSecs") != null) {
                this.sftpTimeoutMilliSecs = new Integer(props.getProperty("sftp.timeoutMilliSecs").trim());
            }
            irodsEncryptHost = props.getProperty("irods.encrypt.host");
            irodsEncryptPort = new Integer(props.getProperty("irods.encrypt.port"));
            irodsEncryptResource = props.getProperty("irods.encrypt.defaultResource");
            irodsEncryptHomeDirectory = props.getProperty("irods.encrypt.homeDirectory");
            irodsEncryptZone = props.getProperty("irods.encrypt.zone");
            irodsEncryptUsername = props.getProperty("irods.encrypt.username");
            irodsEncryptPassword = props.getProperty("irods.encrypt.password");
            irodsGsiHost = props.getProperty("irods.gsi.host");
            irodsGsiPort = new Integer(props.getProperty("irods.gsi.port"));
            irodsGsiZone = props.getProperty("irods.gsi.zone");
            srbQueryTimeout = new Integer(props.getProperty("srb.query.timeout"));
            this.ftpUri = props.getProperty("ftp.uri");
            this.httpUri = props.getProperty("http.uri");
            this.httpProxy = props.getProperty("http.proxy");
            this.httpPort = new Integer(props.getProperty("http.port"));
            this.fileUri = props.getProperty("file.uri");
            java.net.URI tempUri = new java.net.URI(this.fileUri);
            File f = new File(tempUri);
            if (!f.exists()) {
                String temp = System.getProperty("java.io.tmpdir");
                System.out.println("Cannot list [" + fileUri + "] listing java.io.tmpdir instead [" + temp + "]");
                this.fileUri = temp;
            }
            useSrbGsiInFsCopyTest = new Boolean(props.getProperty("srb.gsi.use.in.fs.copy.test"));
            useSrbEncryptInFsCopyTest = new Boolean(props.getProperty("srb.encrypt.use.in.fs.copy.test"));
            useGridftpHost1InFsCopyTest = new Boolean(props.getProperty("gridftp.host1.use.in.fs.copy.test"));
            useGridftpHost2InFsCopyTest = new Boolean(props.getProperty("gridftp.host2.use.in.fs.copy.test"));
            useSftpInFsCopyTest = new Boolean(props.getProperty("sftp.use.in.fs.copy.test"));
            useLocalFileInFsCopyTest = new Boolean(props.getProperty("file.use.in.fs.copy.test"));
            useIrodsGsiCopyTest = new Boolean(props.getProperty("irods.gsi.use.in.fs.copy.test"));
            useIrodsEncryptCopyTest = new Boolean(props.getProperty("irods.encrypt.use.in.fs.copy.test"));
            assertNotNull(this.proxyCertificatePath);
            assertNotNull(this.dummyFileDirName);
            assertNotNull(this.idleTimeTestDelay);
            assertNotNull(this.ftpUri);
            assertNotNull(this.httpUri);
        } catch (Exception ex) {
            Logger.getLogger(AbstractTestClass.class.getName()).log(Level.SEVERE, null, ex);
            fail("Unable to locate and load 'testsettings.properties' file in source " + ex);
        }
    }

}