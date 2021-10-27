class n17197906 {
	public void run() {
		LogPrinter.log(Level.FINEST, "Started Download at : {0, date, long}", new Date());
		if (!PipeConnected) {
			throw new IllegalStateException("You should connect the pipe before with getInputStream()");
		}
		InputStream DIxs9KRW = null;
		if (IsAlreadyDownloaded) {
			LogPrinter.log(Level.FINEST, "The file already Exists open and foward the byte");
			try {
				ContentLength = (int) TheAskedFile.length();
				ContentType = URLConnection.getFileNameMap().getContentTypeFor(TheAskedFile.getName());
				DIxs9KRW = new FileInputStream(TheAskedFile);
				byte[] d9b9BcJT = new byte[BUFFER_SIZE];
				int L1HTsy49 = DIxs9KRW.read(d9b9BcJT);
				while (L1HTsy49 >= 0) {
					Pipe.write(d9b9BcJT, 0, L1HTsy49);
					L1HTsy49 = DIxs9KRW.read(d9b9BcJT);
				}
			} catch (IOException gaaySyah) {
				gaaySyah.printStackTrace();
			} finally {
				if (DIxs9KRW != null) {
					try {
						DIxs9KRW.close();
					} catch (IOException Hq9fNqZr) {
					}
				}
			}
		} else {
			LogPrinter.log(Level.FINEST, "the file does not exist locally so we try to download the thing");
			File dx6rnPPB = TheAskedFile.getParentFile();
			if (!dx6rnPPB.exists()) {
				dx6rnPPB.mkdirs();
			}
			for (URL tBIiIOLW : ListFastest) {
				FileOutputStream Be9B94FM = null;
				boolean KSGMbS22 = false;
				long Y1TExmjm = System.currentTimeMillis();
				long ZUM7nwT8 = 0;
				try {
					URL qio9pBAf = new URL(tBIiIOLW.toString() + RequestedFile);
					LogPrinter.log(Level.FINEST, "the download URL = {0}", qio9pBAf);
					URLConnection yDUB7W5D = qio9pBAf.openConnection();
					ContentType = yDUB7W5D.getContentType();
					ContentLength = yDUB7W5D.getContentLength();
					DIxs9KRW = yDUB7W5D.getInputStream();
					Be9B94FM = new FileOutputStream(TheAskedFile);
					byte[] NSHpSQDz = new byte[BUFFER_SIZE];
					int VDzNg8Mp = DIxs9KRW.read(NSHpSQDz);
					while (VDzNg8Mp >= 0) {
						Be9B94FM.write(NSHpSQDz, 0, VDzNg8Mp);
						Pipe.write(NSHpSQDz, 0, VDzNg8Mp);
						VDzNg8Mp = DIxs9KRW.read(NSHpSQDz);
						ZUM7nwT8 += VDzNg8Mp;
					}
					Pipe.flush();
				} catch (IOException u468YhJy) {
					KSGMbS22 = true;
				} finally {
					if (DIxs9KRW != null) {
						try {
							DIxs9KRW.close();
						} catch (IOException nsOPLY3y) {
						}
					}
					if (Be9B94FM != null) {
						try {
							Be9B94FM.close();
						} catch (IOException E2PnUznE) {
						}
					}
				}
				long BM4SUbmE = System.currentTimeMillis();
				if (KSGMbS22) {
					continue;
				} else {
					long yeGe2Jzt = BM4SUbmE - Y1TExmjm;
					BigDecimal Oe2JN15u = new BigDecimal(ZUM7nwT8).multiply(new BigDecimal(1000))
							.divide(new BigDecimal(yeGe2Jzt), MathContext.DECIMAL32);
					for (ReportCalculatedStatistique sxFt6iI1 : Listener) {
						sxFt6iI1.reportUrlStat(tBIiIOLW, Oe2JN15u, yeGe2Jzt);
					}
					break;
				}
			}
		}
		LogPrinter.log(Level.FINEST, "download finished at {0,date,long}", new Date());
		if (Pipe != null) {
			try {
				Pipe.close();
			} catch (IOException orcFuOfH) {
				orcFuOfH.printStackTrace();
			}
		}
	}

}