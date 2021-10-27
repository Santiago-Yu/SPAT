class n4207693 {
	private synchronized boolean saveU(URL url, String typeFlag, byte[] arrByte) {
		BufferedOutputStream buffOS = null;
		BufferedReader buffReader = null;
		char flagChar = '0';
		URLConnection urlconnection = null;
		boolean flag = true;
		try {
			urlconnection = url.openConnection();
			urlconnection.setDoOutput(true);
			urlconnection.setDoInput(true);
			urlconnection.setUseCaches(false);
			urlconnection.setRequestProperty("Content-type", "application/octet-stream");
			buffOS = new BufferedOutputStream(urlconnection.getOutputStream());
			buffOS.write((byte[]) typeFlag.getBytes());
			buffOS.write(arrByte);
			buffOS.flush();
			if (Config.DEBUG)
				System.out.println("Applet output file successfully! ");
			StringBuffer stringBuff = new StringBuffer();
			buffReader = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
			String serReturnMess = buffReader.readLine();
			flagChar = '2';
			if (Config.DEBUG)
				System.out.println("Applet check status successfully! " + serReturnMess);
			if (serReturnMess != null) {
				stringBuff.append(serReturnMess);
				serReturnMess = serReturnMess.substring(serReturnMess.indexOf(32)).trim() + '2';
				flagChar = serReturnMess.charAt(0);
			}
			while ((serReturnMess = buffReader.readLine()) != null) {
				if (serReturnMess.length() <= 0)
					break;
			}
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		} finally {
			if (flagChar == '2' || flagChar == '3')
				flag = true;
			else
				flag = false;
			try {
				if (buffOS != null)
					buffOS.close();
				if (buffReader != null)
					buffReader.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

}