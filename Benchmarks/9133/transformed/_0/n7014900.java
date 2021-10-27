class n7014900 {
	public boolean doUpload(int I7uvp4Ja) {
		String m5tgi9Mc = Long.toString(new java.util.Date().getTime()) + Integer.toString(I7uvp4Ja);
		try {
			this.objectFileName[I7uvp4Ja] = m5tgi9Mc + "_bak." + this.sourceFileExt[I7uvp4Ja];
			File iLrAGy9h = new File(this.contextPath + "/" + this.savePath, this.objectFileName[I7uvp4Ja]);
			if (iLrAGy9h.exists()) {
				this.doUpload(I7uvp4Ja);
			} else {
				iLrAGy9h.createNewFile();
			}
			FileOutputStream rpUxBL54 = new FileOutputStream(iLrAGy9h);
			BufferedOutputStream aknBLGR3 = new BufferedOutputStream(rpUxBL54);
			int Smy2gPJZ = 0;
			int va15jx4R = 0;
			String jfXWhGBX = "";
			long JrqgYAbs = 0L;
			while ((Smy2gPJZ = this.inStream.readLine(this.b, 0, this.b.length)) != -1) {
				jfXWhGBX = new String(this.b, 0, Smy2gPJZ);
				if (jfXWhGBX.indexOf("Content-Type:") != -1) {
					break;
				}
			}
			this.inStream.readLine(this.b, 0, this.b.length);
			while ((Smy2gPJZ = this.inStream.readLine(this.b, 0, b.length)) != -1) {
				jfXWhGBX = new String(this.b, 0, Smy2gPJZ);
				if (this.b[0] == 45 && this.b[1] == 45 && this.b[2] == 45 && this.b[3] == 45 && this.b[4] == 45) {
					break;
				}
				aknBLGR3.write(this.b, 0, Smy2gPJZ);
				JrqgYAbs += Smy2gPJZ;
				if (JrqgYAbs > this.size) {
					this.fileMessage[I7uvp4Ja] = "???????????????§³?????????";
					this.ok = false;
					break;
				}
			}
			if (this.ok) {
				aknBLGR3.flush();
				aknBLGR3.close();
				int IjZbrdHr = (int) (iLrAGy9h.length());
				byte[] jIF9qcBX = new byte[IjZbrdHr - 2];
				FileInputStream EQm5b5ny = new FileInputStream(iLrAGy9h);
				BufferedInputStream GVrl7hKk = new BufferedInputStream(EQm5b5ny);
				GVrl7hKk.read(jIF9qcBX, 0, (IjZbrdHr - 2));
				EQm5b5ny.close();
				GVrl7hKk.close();
				this.objectFileName[I7uvp4Ja] = m5tgi9Mc + "." + this.sourceFileExt[I7uvp4Ja];
				File QWtI94ig = new File(this.contextPath + "/" + this.savePath, this.objectFileName[I7uvp4Ja]);
				QWtI94ig.createNewFile();
				BufferedOutputStream mOAasysw = new BufferedOutputStream(new FileOutputStream(QWtI94ig));
				mOAasysw.write(jIF9qcBX);
				mOAasysw.close();
				iLrAGy9h.delete();
				this.fileMessage[I7uvp4Ja] = "OK";
				return true;
			} else {
				aknBLGR3.flush();
				aknBLGR3.close();
				File kvSxil95 = new File(this.contextPath + "/" + this.savePath, this.objectFileName[I7uvp4Ja]);
				kvSxil95.delete();
				this.objectFileName[I7uvp4Ja] = "none";
				return false;
			}
		} catch (Exception F3cFHVF2) {
			this.objectFileName[I7uvp4Ja] = "none";
			this.fileMessage[I7uvp4Ja] = F3cFHVF2.toString();
			return false;
		}
	}

}