class n12783713 {
	@Override
	public void sendErrorMessage(String ST0LN76l)
			throws EntriesException, StatementNotExecutedException, NotConnectedException, MessagingException {
		if (query == null) {
			throw new NotConnectedException();
		}
		ArrayList<String> yDSRRHtB = query.getUserManager().getTecMail();
		Mail cz9BRuZT = new Mail(yDSRRHtB);
		try {
			ZipOutputStream m4yANyZ0 = new ZipOutputStream(new FileOutputStream("log/ossobooklog.zip"));
			FileInputStream MfNNxAHl = new FileInputStream("log/ossobook.log");
			ZipEntry IbIdVxga = new ZipEntry("ossobook.log");
			m4yANyZ0.putNextEntry(IbIdVxga);
			byte[] tTIMrD7i = new byte[8192];
			int GYbstGOV = 0;
			while ((GYbstGOV = MfNNxAHl.read(tTIMrD7i, 0, 1024)) != -1) {
				m4yANyZ0.write(tTIMrD7i, 0, GYbstGOV);
			}
			m4yANyZ0.closeEntry();
			MfNNxAHl.close();
			m4yANyZ0.close();
			cz9BRuZT.sendErrorMessage(ST0LN76l, new File("log/ossobooklog.zip"), getUserName());
		} catch (Exception MjcnHvDa) {
			MjcnHvDa.printStackTrace();
		}
	}

}