class n16236980 {
	public void loadProperties() {
		try {
			java.util.Properties RmbZA5b2 = new java.util.Properties();
			java.net.URL aNs7f34P = ClassLoader.getSystemResource("env.properties");
			RmbZA5b2.load(aNs7f34P.openStream());
			this.proxyCertificatePath = RmbZA5b2.getProperty("proxy.certificate.path");
			this.dummyFileDirName = RmbZA5b2.getProperty("delete.dummyFileDirName");
			this.idleTimeTestDelay = new Integer(RmbZA5b2.getProperty("idleTimeTestDelaySeconds"));
			if (RmbZA5b2.getProperty("gridftp.timeoutMilliSecs") != null) {
				this.gridftpTimeoutMilliSecs = new Integer(RmbZA5b2.getProperty("gridftp.timeoutMilliSecs").trim());
			}
			this.assertContentInWriteTests = new Boolean(RmbZA5b2.getProperty("assertContentInWriteTests"));
			this.gridftpHost1 = RmbZA5b2.getProperty("gridftp.host1");
			this.gridftpPort1 = new Integer(RmbZA5b2.getProperty("gridftp.port1"));
			this.gridftpHost2 = RmbZA5b2.getProperty("gridftp.host2");
			this.gridftpPort2 = new Integer(RmbZA5b2.getProperty("gridftp.port2"));
			this.srbGsiHost = RmbZA5b2.getProperty("srb.gsi.host");
			this.srbGsiPort = new Integer(RmbZA5b2.getProperty("srb.gsi.port"));
			this.srbGsiPortMin = new Integer(RmbZA5b2.getProperty("srb.gsi.port.min"));
			this.srbGsiPortMax = new Integer(RmbZA5b2.getProperty("srb.gsi.port.max"));
			this.srbGsiDefaultResource = RmbZA5b2.getProperty("srb.gsi.defaultResource");
			this.srbEncryptHost = RmbZA5b2.getProperty("srb.encrypt.host");
			this.srbEncryptPort = new Integer(RmbZA5b2.getProperty("srb.encrypt.port"));
			this.srbEncryptPortMin = new Integer(RmbZA5b2.getProperty("srb.encrypt.port.min"));
			this.srbEncryptPortMax = new Integer(RmbZA5b2.getProperty("srb.encrypt.port.max"));
			this.srbEncryptDefaultResource = RmbZA5b2.getProperty("srb.encrypt.defaultResource");
			this.srbEncryptHomeDirectory = RmbZA5b2.getProperty("srb.encrypt.homeDirectory");
			this.srbEncryptMcatZone = RmbZA5b2.getProperty("srb.encrypt.mcatZone");
			this.srbEncryptMdasDomainName = RmbZA5b2.getProperty("srb.encrypt.mdasDomainName");
			this.srbEncryptUsername = RmbZA5b2.getProperty("srb.encrypt.username");
			this.srbEncryptPassword = RmbZA5b2.getProperty("srb.encrypt.password");
			this.sftpHost = RmbZA5b2.getProperty("sftp.host");
			this.sftpPort = new Integer(RmbZA5b2.getProperty("sftp.port"));
			this.sftpPath = RmbZA5b2.getProperty("sftp.path");
			this.sftpUsername = RmbZA5b2.getProperty("sftp.username");
			this.sftpPassword = RmbZA5b2.getProperty("sftp.password");
			if (RmbZA5b2.getProperty("sftp.timeoutMilliSecs") != null) {
				this.sftpTimeoutMilliSecs = new Integer(RmbZA5b2.getProperty("sftp.timeoutMilliSecs").trim());
			}
			irodsEncryptHost = RmbZA5b2.getProperty("irods.encrypt.host");
			irodsEncryptPort = new Integer(RmbZA5b2.getProperty("irods.encrypt.port"));
			irodsEncryptResource = RmbZA5b2.getProperty("irods.encrypt.defaultResource");
			irodsEncryptHomeDirectory = RmbZA5b2.getProperty("irods.encrypt.homeDirectory");
			irodsEncryptZone = RmbZA5b2.getProperty("irods.encrypt.zone");
			irodsEncryptUsername = RmbZA5b2.getProperty("irods.encrypt.username");
			irodsEncryptPassword = RmbZA5b2.getProperty("irods.encrypt.password");
			irodsGsiHost = RmbZA5b2.getProperty("irods.gsi.host");
			irodsGsiPort = new Integer(RmbZA5b2.getProperty("irods.gsi.port"));
			irodsGsiZone = RmbZA5b2.getProperty("irods.gsi.zone");
			srbQueryTimeout = new Integer(RmbZA5b2.getProperty("srb.query.timeout"));
			this.ftpUri = RmbZA5b2.getProperty("ftp.uri");
			this.httpUri = RmbZA5b2.getProperty("http.uri");
			this.httpProxy = RmbZA5b2.getProperty("http.proxy");
			this.httpPort = new Integer(RmbZA5b2.getProperty("http.port"));
			this.fileUri = RmbZA5b2.getProperty("file.uri");
			java.net.URI Ya2w8p74 = new java.net.URI(this.fileUri);
			File RFSzIa7w = new File(Ya2w8p74);
			if (!RFSzIa7w.exists()) {
				String FW6AnxIH = System.getProperty("java.io.tmpdir");
				System.out.println("Cannot list [" + fileUri + "] listing java.io.tmpdir instead [" + FW6AnxIH + "]");
				this.fileUri = FW6AnxIH;
			}
			useSrbGsiInFsCopyTest = new Boolean(RmbZA5b2.getProperty("srb.gsi.use.in.fs.copy.test"));
			useSrbEncryptInFsCopyTest = new Boolean(RmbZA5b2.getProperty("srb.encrypt.use.in.fs.copy.test"));
			useGridftpHost1InFsCopyTest = new Boolean(RmbZA5b2.getProperty("gridftp.host1.use.in.fs.copy.test"));
			useGridftpHost2InFsCopyTest = new Boolean(RmbZA5b2.getProperty("gridftp.host2.use.in.fs.copy.test"));
			useSftpInFsCopyTest = new Boolean(RmbZA5b2.getProperty("sftp.use.in.fs.copy.test"));
			useLocalFileInFsCopyTest = new Boolean(RmbZA5b2.getProperty("file.use.in.fs.copy.test"));
			useIrodsGsiCopyTest = new Boolean(RmbZA5b2.getProperty("irods.gsi.use.in.fs.copy.test"));
			useIrodsEncryptCopyTest = new Boolean(RmbZA5b2.getProperty("irods.encrypt.use.in.fs.copy.test"));
			assertNotNull(this.proxyCertificatePath);
			assertNotNull(this.dummyFileDirName);
			assertNotNull(this.idleTimeTestDelay);
			assertNotNull(this.ftpUri);
			assertNotNull(this.httpUri);
		} catch (Exception Y6G7jQ8j) {
			Logger.getLogger(AbstractTestClass.class.getName()).log(Level.SEVERE, null, Y6G7jQ8j);
			fail("Unable to locate and load 'testsettings.properties' file in source " + Y6G7jQ8j);
		}
	}

}