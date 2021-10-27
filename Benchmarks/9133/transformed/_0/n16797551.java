class n16797551 {
	public boolean backup() {
		try {
			File q1780lzB = Environment.getExternalStorageDirectory();
			File n4Kjcelo = Environment.getDataDirectory();
			if (q1780lzB.canWrite()) {
				String Mj3mRiUU = "/data/android.bluebox/databases/bluebox.db";
				String YPyFskUa = "/Android/bluebox.bak";
				File xGS4NMxo = new File(n4Kjcelo, Mj3mRiUU);
				File ApiyBRLe = new File(q1780lzB, YPyFskUa);
				if (xGS4NMxo.exists()) {
					FileChannel JE402Q0F = new FileInputStream(xGS4NMxo).getChannel();
					FileChannel BHbfAzXp = new FileOutputStream(ApiyBRLe).getChannel();
					BHbfAzXp.transferFrom(JE402Q0F, 0, JE402Q0F.size());
					JE402Q0F.close();
					BHbfAzXp.close();
					return true;
				}
			}
		} catch (FileNotFoundException kuu1x9j5) {
			kuu1x9j5.printStackTrace();
		} catch (IOException QJAMZO3u) {
			QJAMZO3u.printStackTrace();
		}
		return false;
	}

}