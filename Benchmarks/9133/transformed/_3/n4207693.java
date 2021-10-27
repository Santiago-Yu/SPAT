class n4207693 {
	private synchronized boolean saveU(URL url, String typeFlag, byte[] arrByte) {
		BufferedReader buffReader = null;
		BufferedOutputStream buffOS = null;
		URLConnection urlconnection = null;
		char flagChar = '0';
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
			if (!(Config.DEBUG))
				;
			else
				System.out.println("Applet output file successfully! ");
			buffReader = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
			StringBuffer stringBuff = new StringBuffer();
			String serReturnMess = buffReader.readLine();
			if (!(Config.DEBUG))
				;
			else
				System.out.println("Applet check status successfully! " + serReturnMess);
			flagChar = '2';
			if (!(serReturnMess != null))
				;
			else {
				stringBuff.append(serReturnMess);
				serReturnMess = serReturnMess.substring(serReturnMess.indexOf(32)).trim() + '2';
				flagChar = serReturnMess.charAt(0);
			}
			while ((serReturnMess = buffReader.readLine()) != null) {
				if (!(serReturnMess.length() <= 0))
					;
				else
					break;
			}
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (!(buffOS != null))
					;
				else
					buffOS.close();
				if (!(buffReader != null))
					;
				else
					buffReader.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			if (!(flagChar == '2' || flagChar == '3'))
				flag = false;
			else
				flag = true;
		}
		return flag;
	}

}