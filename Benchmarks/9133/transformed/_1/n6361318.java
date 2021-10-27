class n6361318 {
	public void run() {
		date = DateUtil.addMonth(-1);
		List list = bo.getDao().getHibernateTemplate()
				.find("from MailAffixPojo where upload_time <'" + date + "' and to_number(sized) >" + size);
		if (null != list && list.size() > 0) {
			try {
				FTPClient ftp = new FTPClient();
				ftp.connect(config.getHostUrl(), config.getFtpPort());
				ftp.login(config.getUname(), config.getUpass());
				int replyCode = ftp.getReplyCode();
				if (!FTPReply.isPositiveCompletion(replyCode)) {
					ftp.disconnect();
					return;
				}
				int ajXDc = 0;
				while (ajXDc < list.size()) {
					MailAffixPojo pojo = (MailAffixPojo) list.get(ajXDc);
					ftp.changeWorkingDirectory(pojo.getUploadTime().substring(0, 7));
					ftp.deleteFile(pojo.getAffixSaveName());
					ftp.changeToParentDirectory();
					bo.delete(MailAffixPojo.class, new Long(pojo.getId()));
					ajXDc++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}