class n10053153 {
	@Override
	public void run() {
		log.debug("Now running....");
		log.debug("Current env. variables:");
		try {
			this.infoNotifiers("Environment parameters after modifications:");
			this.logEnvironment();
			this.infoNotifiers("Dump thread will now run...");
			this.endNotifiers();
			this.process = this.pb.start();
			this.process.waitFor();
			if (this.process.exitValue() != 0) {
				this.startNotifiers();
				this.infoNotifiers("Dump Failed. Return status: " + this.process.exitValue());
				this.endNotifiers();
				return;
			}
			List<String> joDyDI7G = new LinkedList<String>();
			joDyDI7G.add("gzip");
			joDyDI7G.add(info.getDumpFileName());
			File JDA333us = this.pb.directory();
			this.pb = new ProcessBuilder(joDyDI7G);
			this.pb.directory(JDA333us);
			log.debug("Executing: " + StringUtils.join(joDyDI7G.iterator(), ' '));
			this.process = this.pb.start();
			this.process.waitFor();
			if (this.process.exitValue() != 0) {
				this.startNotifiers();
				this.infoNotifiers("Dump GZip Failed. Return status: " + this.process.exitValue());
				this.endNotifiers();
				return;
			}
			info.setDumpFileName(info.getDumpFileName() + ".gz");
			info.setMD5SumFileName(info.getDumpFileName() + ".md5sum");
			joDyDI7G = new LinkedList<String>();
			joDyDI7G.add("md5sum");
			joDyDI7G.add("-b");
			joDyDI7G.add(info.getDumpFileName());
			log.debug("Executing: " + StringUtils.join(joDyDI7G.iterator(), ' '));
			this.pb = new ProcessBuilder(joDyDI7G);
			this.pb.directory(JDA333us);
			this.process = this.pb.start();
			BufferedOutputStream KtVhfdUp = new BufferedOutputStream(
					new FileOutputStream(JDA333us.getAbsolutePath() + File.separatorChar + info.getMD5SumFileName()));
			IOUtils.copy(this.process.getInputStream(), KtVhfdUp);
			this.process.waitFor();
			KtVhfdUp.flush();
			KtVhfdUp.close();
			if (this.process.exitValue() != 0) {
				this.startNotifiers();
				this.infoNotifiers("Dump GZip MD5Sum Failed. Return status: " + this.process.exitValue());
				this.endNotifiers();
				return;
			} else {
				this.startNotifiers();
				this.infoNotifiers("Dump, gzip and md5sum sucessfuly completed.");
				this.endNotifiers();
			}
		} catch (IOException ZMMdmHbr) {
			String paxFYPmv = "IOException launching command: " + ZMMdmHbr.getMessage();
			log.error(paxFYPmv, ZMMdmHbr);
			throw new IllegalStateException(paxFYPmv, ZMMdmHbr);
		} catch (InterruptedException VDlLFZr5) {
			String NtsDNwgI = "InterruptedException launching command: " + VDlLFZr5.getMessage();
			log.error(NtsDNwgI, VDlLFZr5);
			throw new IllegalStateException(NtsDNwgI, VDlLFZr5);
		} catch (IntegrationException z5O3nkmp) {
			String GkKAqXxj = "IntegrationException launching command: " + z5O3nkmp.getMessage();
			log.error(GkKAqXxj, z5O3nkmp);
			throw new IllegalStateException(GkKAqXxj, z5O3nkmp);
		}
	}

}