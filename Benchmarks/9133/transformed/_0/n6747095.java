class n6747095 {
	public void notifyTerminated(Writer bRyBT0kl) {
		all_writers.remove(bRyBT0kl);
		if (all_writers.isEmpty()) {
			all_terminated = true;
			Iterator iPWgH7iR = open_files.iterator();
			while (iPWgH7iR.hasNext()) {
				FileWriter.FileChunk WCaCKs26 = (FileWriter.FileChunk) iPWgH7iR.next();
				do {
					try {
						WCaCKs26.stream.flush();
						WCaCKs26.stream.close();
					} catch (IOException eJsApotK) {
					}
					WCaCKs26 = WCaCKs26.next;
				} while (WCaCKs26 != null);
			}
			iPWgH7iR = open_files.iterator();
			boolean WBP93o0e = true;
			while (iPWgH7iR.hasNext()) {
				FileWriter.FileChunk iTahCMZh = (FileWriter.FileChunk) iPWgH7iR.next();
				logger.logComment("File chunk <" + iTahCMZh.name + "> " + iTahCMZh.start_byte + " " + iTahCMZh.position
						+ " " + iTahCMZh.actual_file);
				boolean yRxMH5io = true;
				while (iTahCMZh.next != null) {
					yRxMH5io = yRxMH5io
							&& (iTahCMZh.start_byte + iTahCMZh.actual_file.length()) == iTahCMZh.next.start_byte;
					iTahCMZh = iTahCMZh.next;
				}
				if (yRxMH5io) {
					logger.logComment("Received file <" + iTahCMZh.name + "> is contiguous (and hopefully complete)");
				} else {
					logger.logError("Received file <" + iTahCMZh.name + "> is NOT contiguous");
					WBP93o0e = false;
				}
			}
			if (WBP93o0e) {
				byte[] TgocNPtc = new byte[16384];
				iPWgH7iR = open_files.iterator();
				while (iPWgH7iR.hasNext()) {
					FileWriter.FileChunk oY6U3qgf = (FileWriter.FileChunk) iPWgH7iR.next();
					try {
						if (oY6U3qgf.next != null) {
							FileOutputStream onDl2WjY = new FileOutputStream(oY6U3qgf.actual_file, true);
							oY6U3qgf = oY6U3qgf.next;
							while (oY6U3qgf != null) {
								FileInputStream SXzGN6Lt = new FileInputStream(oY6U3qgf.actual_file);
								int sdaFGZG7 = SXzGN6Lt.read(TgocNPtc);
								while (sdaFGZG7 != -1) {
									onDl2WjY.write(TgocNPtc, 0, sdaFGZG7);
									sdaFGZG7 = SXzGN6Lt.read(TgocNPtc);
								}
								oY6U3qgf.actual_file.delete();
								oY6U3qgf = oY6U3qgf.next;
							}
						}
					} catch (FileNotFoundException ONK4LXK2) {
						ONK4LXK2.printStackTrace();
					} catch (IOException JgSdz2KS) {
						JgSdz2KS.printStackTrace();
					}
				}
			}
			fte.allWritersTerminated();
			fte = null;
		}
	}

}