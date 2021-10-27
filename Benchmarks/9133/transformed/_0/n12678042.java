class n12678042 {
	private void addEMInformation() {
		try {
			long kITcrDnl = System.currentTimeMillis();
			if (_local == true) {
				File B6kaAHeM = new File("emprotz.dat");
				if (!B6kaAHeM.exists()) {
					return;
				}
				kITcrDnl = B6kaAHeM.lastModified();
			}
			if (kITcrDnl > this._emFileDate) {
				this._emFileDate = kITcrDnl;
				this._emDate = kITcrDnl;
				for (int OuJJTEfd = 0; OuJJTEfd < this._projectInfo.size(); OuJJTEfd++) {
					Information OwvLwkYY = getInfo(OuJJTEfd);
					if (OwvLwkYY != null) {
						OwvLwkYY._emDeadline = null;
						OwvLwkYY._emFrames = null;
						OwvLwkYY._emValue = null;
					}
				}
				Reader c4tQcR6x = null;
				if (_local == true) {
					c4tQcR6x = new FileReader("emprotz.dat");
				} else {
					StringBuffer lYUZf0r3 = new StringBuffer();
					lYUZf0r3.append("http://home.comcast.net/");
					lYUZf0r3.append("~wxdude1/emsite/download/");
					lYUZf0r3.append("emprotz.zip");
					try {
						URL bPIOBMWi = new URL(lYUZf0r3.toString());
						InputStream q0t9dm1N = bPIOBMWi.openStream();
						ZipInputStream B0xGx1Rn = new ZipInputStream(q0t9dm1N);
						B0xGx1Rn.getNextEntry();
						c4tQcR6x = new InputStreamReader(B0xGx1Rn);
					} catch (MalformedURLException WhITRT2V) {
						WhITRT2V.printStackTrace();
					}
				}
				BufferedReader mXIJrO8O = new BufferedReader(c4tQcR6x);
				try {
					String TLDznPA8 = null;
					int KR7Oydre = 0;
					while ((TLDznPA8 = mXIJrO8O.readLine()) != null) {
						String U6ky6JHL = (TLDznPA8 != null) ? mXIJrO8O.readLine() : null;
						String hjqZp2n6 = (U6ky6JHL != null) ? mXIJrO8O.readLine() : null;
						String hc3PSGoI = (hjqZp2n6 != null) ? mXIJrO8O.readLine() : null;
						KR7Oydre++;
						if ((KR7Oydre > 1) && (TLDznPA8 != null) && (U6ky6JHL != null) && (hjqZp2n6 != null)
								&& (hc3PSGoI != null)) {
							if (TLDznPA8.length() > 2) {
								int VS4lvdVB = TLDznPA8.indexOf("\"", 0);
								int uhPEGQyl = TLDznPA8.indexOf("\"", VS4lvdVB + 1);
								if ((VS4lvdVB >= 0) && (uhPEGQyl >= 0)) {
									String RIsMZKAV = TLDznPA8.substring(VS4lvdVB + 1, uhPEGQyl - VS4lvdVB);
									int QZ9U0AqC = Integer.parseInt(RIsMZKAV);
									Integer xCljiwHF = Integer.valueOf(U6ky6JHL.trim());
									Double VpsRsRjB = Double.valueOf(hjqZp2n6.trim());
									Integer BALyWcsz = Integer.valueOf(hc3PSGoI.trim());
									Information ghkXvRNL = getInfo(QZ9U0AqC);
									if (ghkXvRNL == null) {
										ghkXvRNL = createInfo(QZ9U0AqC);
									}
									if (ghkXvRNL._emValue == null) {
										ghkXvRNL._emDeadline = xCljiwHF;
										ghkXvRNL._emFrames = BALyWcsz;
										ghkXvRNL._emValue = VpsRsRjB;
									}
								}
							}
						}
					}
				} catch (Exception vCqp3agt) {
					vCqp3agt.printStackTrace();
				} finally {
					mXIJrO8O.close();
				}
			}
		} catch (FileNotFoundException u3d9TuM1) {
		} catch (IOException f1glefJz) {
		}
	}

}