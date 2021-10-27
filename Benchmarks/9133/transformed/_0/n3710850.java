class n3710850 {
	@Override
	public boolean connect(String gPLyXSvc, String PhPXkXZO, String TlcwzNC4) throws IOException, UnknownHostException {
		try {
			if (ftpClient != null)
				if (ftpClient.isConnected())
					ftpClient.disconnect();
			ftpClient = new FTPSClient("SSL", false);
			boolean JgJNhmq3 = false;
			ftpClient.connect(gPLyXSvc);
			int g3Yuvnhn = ftpClient.getReplyCode();
			if (FTPReply.isPositiveCompletion(g3Yuvnhn))
				JgJNhmq3 = ftpClient.login(PhPXkXZO, TlcwzNC4);
			if (!JgJNhmq3)
				ftpClient.disconnect();
			return JgJNhmq3;
		} catch (Exception DvJ16krG) {
			throw new IOException(DvJ16krG.getMessage());
		}
	}

}