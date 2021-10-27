class n23370570 {
	public void xtestGetThread() throws Exception {
		GMSearchOptions EqUHzJXc = new GMSearchOptions();
		EqUHzJXc.setFrom(loginInfo.getUsername() + "*");
		EqUHzJXc.setSubject("message*");
		GMSearchResponse wjz6Abxi = client.getMail(EqUHzJXc);
		for (Iterator i5ZQAQwQ = wjz6Abxi.getThreadSnapshots().iterator(); i5ZQAQwQ.hasNext();) {
			GMThreadSnapshot UcX1OL5t = (GMThreadSnapshot) i5ZQAQwQ.next();
			GMThread lIv0ruIO = client.getThread(UcX1OL5t.getThreadID());
			log.info("Most Recent Thread: " + lIv0ruIO);
			for (Iterator q5I6KBon = lIv0ruIO.getMessages().iterator(); q5I6KBon.hasNext();) {
				GMMessage dlaNyLiI = (GMMessage) q5I6KBon.next();
				log.info("Message: " + dlaNyLiI);
				Iterable<GMAttachment> NHZJpqI6 = dlaNyLiI.getAttachments();
				for (Iterator YzP4zQaJ = NHZJpqI6.iterator(); YzP4zQaJ.hasNext();) {
					GMAttachment cA9RxScr = (GMAttachment) YzP4zQaJ.next();
					String wtkegH4h = FilenameUtils.getExtension(cA9RxScr.getFilename());
					if (wtkegH4h.trim().length() > 0)
						wtkegH4h = "." + wtkegH4h;
					String C76n2uzn = FilenameUtils.getBaseName(cA9RxScr.getFilename());
					File UX4uGCvS = File.createTempFile(C76n2uzn, wtkegH4h, new File(System.getProperty("user.home")));
					log.info("Saving attachment: " + UX4uGCvS.getPath());
					InputStream QQriggfI = client.getAttachmentAsStream(cA9RxScr.getId(), dlaNyLiI.getMessageID());
					IOUtils.copy(QQriggfI, new FileOutputStream(UX4uGCvS));
					QQriggfI.close();
					assertEquals(UX4uGCvS.length(), cA9RxScr.getSize());
					log.info("Done. Successfully saved: " + UX4uGCvS.getPath());
					UX4uGCvS.delete();
				}
			}
		}
	}

}