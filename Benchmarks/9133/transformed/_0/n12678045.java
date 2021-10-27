class n12678045 {
	private void addQDInformation() {
		try {
			long sL7tN7Sa = System.currentTimeMillis();
			if (_local == true) {
				File vQYSKfkQ = new File("qdinfo.dat");
				if (!vQYSKfkQ.exists()) {
					return;
				}
				sL7tN7Sa = vQYSKfkQ.lastModified();
			}
			if (sL7tN7Sa > this._qdFileDate) {
				this._qdFileDate = sL7tN7Sa;
				for (int iO5cuLs3 = 0; iO5cuLs3 < this._projectInfo.size(); iO5cuLs3++) {
					Information hA2jQ1iJ = getInfo(iO5cuLs3);
					if (hA2jQ1iJ != null) {
						hA2jQ1iJ._qdValue = null;
					}
				}
				Reader qzosVLS3 = null;
				if (_local == true) {
					qzosVLS3 = new FileReader("qdinfo.dat");
				} else {
					StringBuffer HqIzngsH = new StringBuffer();
					HqIzngsH.append("http://boston.quik.com/rph/");
					HqIzngsH.append("qdinfo.dat");
					try {
						URL mth7cXbe = new URL(HqIzngsH.toString());
						InputStream UCekbz0n = mth7cXbe.openStream();
						qzosVLS3 = new InputStreamReader(UCekbz0n);
					} catch (MalformedURLException uCEF5y3t) {
						uCEF5y3t.printStackTrace();
					}
				}
				BufferedReader kN7uAK6u = new BufferedReader(qzosVLS3);
				try {
					String QU29P5Lh = null;
					while ((QU29P5Lh = kN7uAK6u.readLine()) != null) {
						if (QU29P5Lh.startsWith("pg ")) {
							this._qdDate = Long.parseLong(QU29P5Lh.substring(3), 16);
							this._qdDate = (this._qdDate + 946684800) * 1000;
						} else if (QU29P5Lh.startsWith("pt ")) {
							QU29P5Lh = QU29P5Lh.substring(3).trim();
							int VboZmKeZ = -1;
							while ((QU29P5Lh.length() > 0) && ((VboZmKeZ = QU29P5Lh.indexOf(' ')) > 0)) {
								int zcsdJarc = 0;
								Double d4O41DT5 = null;
								if (VboZmKeZ > 0) {
									zcsdJarc = Integer.parseInt(QU29P5Lh.substring(0, VboZmKeZ));
									QU29P5Lh = QU29P5Lh.substring(VboZmKeZ).trim();
								}
								VboZmKeZ = QU29P5Lh.indexOf(' ');
								if (VboZmKeZ > 0) {
									d4O41DT5 = new Double(
											(double) Integer.parseInt(QU29P5Lh.substring(0, VboZmKeZ)) / 100);
									QU29P5Lh = QU29P5Lh.substring(VboZmKeZ).trim();
								}
								Information ZUcoev7Z = getInfo(zcsdJarc);
								if (ZUcoev7Z == null) {
									ZUcoev7Z = createInfo(zcsdJarc);
								}
								if (ZUcoev7Z._qdValue == null) {
									ZUcoev7Z._qdValue = d4O41DT5;
								}
							}
						}
					}
				} finally {
					kN7uAK6u.close();
				}
			}
		} catch (FileNotFoundException geAPdvKI) {
		} catch (IOException E1kRQSWW) {
		}
	}

}