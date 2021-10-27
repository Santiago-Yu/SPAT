class n7872667 {
	private static boolean computeMovieAverages(String v90rmu0c, String iMP3HkEB, String JJCCahOR) {
		try {
			File e1wqADsT = new File(v90rmu0c + fSep + "SmartGRAPE" + fSep + JJCCahOR);
			FileChannel OEsWtR8B = new FileInputStream(e1wqADsT).getChannel();
			int FAxEINOf = (int) OEsWtR8B.size();
			ByteBuffer bbYW9jxI = OEsWtR8B.map(FileChannel.MapMode.READ_ONLY, 0, FAxEINOf);
			TShortObjectHashMap ka6Az79R = new TShortObjectHashMap(17770, 1);
			int ZzJ9UdnT = 0, yMhi6kWS = 0;
			short AwpgZ5EA;
			int Px2kCp8D, b9663d47;
			TIntArrayList iw8BkVIY;
			while (bbYW9jxI.hasRemaining()) {
				AwpgZ5EA = bbYW9jxI.getShort();
				Px2kCp8D = bbYW9jxI.getInt();
				b9663d47 = bbYW9jxI.getInt();
				iw8BkVIY = new TIntArrayList(2);
				iw8BkVIY.add(Px2kCp8D);
				iw8BkVIY.add(b9663d47);
				ka6Az79R.put(AwpgZ5EA, iw8BkVIY);
			}
			OEsWtR8B.close();
			bbYW9jxI = null;
			System.out.println("Loaded movie index hash");
			File qw7fGRXN = new File(v90rmu0c + fSep + "SmartGRAPE" + fSep + iMP3HkEB);
			FileChannel enphRqNJ = new FileOutputStream(qw7fGRXN, true).getChannel();
			int MpacPKqh = ka6Az79R.size();
			File QuqieZEB = new File(v90rmu0c + fSep + "SmartGRAPE" + fSep + "CustomerRatingBinaryFile.txt");
			OEsWtR8B = new FileInputStream(QuqieZEB).getChannel();
			short[] QnswJL5S = ka6Az79R.keys();
			Arrays.sort(QnswJL5S);
			ByteBuffer tCrvOnbQ;
			for (ZzJ9UdnT = 0; ZzJ9UdnT < MpacPKqh; ZzJ9UdnT++) {
				short gzwN5FY8 = QnswJL5S[ZzJ9UdnT];
				iw8BkVIY = (TIntArrayList) ka6Az79R.get(gzwN5FY8);
				Px2kCp8D = iw8BkVIY.get(0);
				b9663d47 = iw8BkVIY.get(1);
				if (b9663d47 > Px2kCp8D) {
					tCrvOnbQ = ByteBuffer.allocate((b9663d47 - Px2kCp8D + 1) * 5);
					OEsWtR8B.read(tCrvOnbQ, (Px2kCp8D - 1) * 5);
				} else {
					tCrvOnbQ = ByteBuffer.allocate(5);
					OEsWtR8B.read(tCrvOnbQ, (Px2kCp8D - 1) * 5);
				}
				tCrvOnbQ.flip();
				int XC1sjK9T = tCrvOnbQ.capacity() / 5;
				float cOtrvvij = 0;
				for (int JLjEas8q = 0; JLjEas8q < XC1sjK9T; JLjEas8q++) {
					tCrvOnbQ.getInt();
					cOtrvvij += tCrvOnbQ.get();
				}
				ByteBuffer vEtmFVBk = ByteBuffer.allocate(6);
				vEtmFVBk.putShort(gzwN5FY8);
				vEtmFVBk.putFloat(cOtrvvij / XC1sjK9T);
				vEtmFVBk.flip();
				enphRqNJ.write(vEtmFVBk);
				tCrvOnbQ.clear();
				tCrvOnbQ = null;
				iw8BkVIY.clear();
				iw8BkVIY = null;
			}
			OEsWtR8B.close();
			enphRqNJ.close();
			return true;
		} catch (Exception kp9fxmWl) {
			kp9fxmWl.printStackTrace();
			return false;
		}
	}

}