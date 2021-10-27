class n11028858 {
	@Override
	public void runTask(HashMap pjobParameters) throws Exception {
		if (hasRequiredResources(isSubTask())) {
			File lfileSource = new File(getSource());
			FileChannel lfisInput = null;
			File lfileTarget = new File(getTarget());
			FileChannel lfosOutput = null;
			try {
				boolean lblnDone = false;
				int mbCount = 64;
				while (!lblnDone) {
					lfisInput = new FileInputStream(lfileSource).getChannel();
					lfosOutput = new FileOutputStream(lfileTarget).getChannel();
					try {
						long size = lfisInput.size();
						int maxCount = (mbCount * 1024 * 1024) - (32 * 1024);
						long position = 0;
						lblnDone = true;
						while (position < size) {
							position += lfisInput.transferTo(position, maxCount, lfosOutput);
						}
					} catch (IOException lioXcp) {
						getLog().warn(lioXcp);
						if (lioXcp.getMessage()
								.contains("Insufficient system resources exist to complete the requested servic")) {
							mbCount--;
							getLog().debug("Dropped resource count down to [" + mbCount + "]");
							if (lfisInput != null) {
								lfisInput.close();
							}
							if (mbCount == 0) {
								lblnDone = true;
							}
							if (lfosOutput != null) {
								lfosOutput.close();
							}
						} else {
							throw lioXcp;
						}
					}
				}
			} finally {
				if (lfisInput != null) {
					lfisInput.close();
				}
				if (lfosOutput != null) {
					lfosOutput.close();
				}
			}
		}
	}

}