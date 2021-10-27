class n4598940 {
	public static void retrieveAttachments(RemoteAttachment[] KaRHqEq3, String XiT6bOZz, String iz9lYAID,
			String IIqIHMrU, SimpleDateFormat cDhRI6uk, java.sql.Connection v4DftkDr) {
		if (KaRHqEq3.length != 0) {
			for (RemoteAttachment YM7oj3q1 : KaRHqEq3) {
				attachmentAuthor = YM7oj3q1.getAuthor();
				if (YM7oj3q1.getCreated() != null) {
					attachmentCreated = cDhRI6uk.format(YM7oj3q1.getCreated().getTime());
				}
				attachmentFileName = YM7oj3q1.getFilename();
				attachmentFileSize = YM7oj3q1.getFilesize();
				attachmentId = YM7oj3q1.getId();
				attachmentMimeType = YM7oj3q1.getMimetype();
				if (attachmentMimeType.startsWith("text")) {
					URL UqxMjK34;
					try {
						UqxMjK34 = new URL("https://issues.apache.org/jira/secure/attachment/" + attachmentId + "/"
								+ attachmentFileName);
						urlConnection = (HttpURLConnection) UqxMjK34.openConnection();
						urlConnection.connect();
						serverCode = urlConnection.getResponseCode();
					} catch (MalformedURLException zcucj7GN) {
						zcucj7GN.printStackTrace();
					} catch (IOException qVMcFSY8) {
						qVMcFSY8.printStackTrace();
					}
					if (serverCode == 200) {
						actual = new File("../attachments/" + iz9lYAID + "/" + IIqIHMrU);
						if (!actual.exists()) {
							actual.mkdirs();
						}
						attachmentPath = "../attachments/" + iz9lYAID + "/" + IIqIHMrU + "/" + attachmentFileName;
						BufferedInputStream FsO0vqVl;
						try {
							FsO0vqVl = new BufferedInputStream(urlConnection.getInputStream());
							BufferedOutputStream RgSrPPMh = new BufferedOutputStream(
									new FileOutputStream(attachmentPath));
							byte[] QX8kjkrt = new byte[1024];
							int P8bTQQlP = -1;
							while ((P8bTQQlP = FsO0vqVl.read(QX8kjkrt)) != -1) {
								if (P8bTQQlP == 1024) {
									RgSrPPMh.write(QX8kjkrt);
								} else {
									RgSrPPMh.write(QX8kjkrt, 0, P8bTQQlP);
								}
							}
							RgSrPPMh.close();
							FsO0vqVl.close();
							insertAttachment(v4DftkDr, XiT6bOZz);
						} catch (IOException Ptk6Feqw) {
							Ptk6Feqw.printStackTrace();
						} catch (SQLException OBq06ZLo) {
							OBq06ZLo.printStackTrace();
						}
					}
				}
			}
		}
	}

}