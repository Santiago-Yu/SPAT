class n12783713 {
	@Override
	public void sendErrorMessage(String message)
			throws EntriesException, StatementNotExecutedException, NotConnectedException, MessagingException {
		if (query == null) {
			throw new NotConnectedException();
		}
		ArrayList<String> recipients = query.getUserManager().getTecMail();
		Mail mail = new Mail(recipients);
		try {
			FileInputStream fis = new FileInputStream("log/ossobook.log");
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("log/ossobooklog.zip"));
			ZipEntry entry = new ZipEntry("ossobook.log");
			zos.putNextEntry(entry);
			int read = 0;
			byte[] buffer = new byte[8192];
			while ((read = fis.read(buffer, 0, 1024)) != -1) {
				zos.write(buffer, 0, read);
			}
			zos.closeEntry();
			fis.close();
			zos.close();
			mail.sendErrorMessage(message, new File("log/ossobooklog.zip"), getUserName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}