class n18253221 {
	public boolean uploadFTP(String oeFa5dVi, String eXZ8Zn4I, String QLtFpOET, String YKB1vZQC, String Wqlnef8j,
			String KYf7LUDy) {
		try {
			dialogHandler.sendEmptyMessage(0);
			File JuMMq6JH = new File(Wqlnef8j);
			File eqjHKyUC = new File(Wqlnef8j + KYf7LUDy);
			Log.v("uploadFTP", "Atribuidas as vari?veis");
			String HXipmmOL = "";
			if (JuMMq6JH.isDirectory()) {
				Log.v("uploadFTP", "? diret?rio");
				if (JuMMq6JH.list().length > 0) {
					Log.v("uploadFTP", "file.list().length > 0");
					ftp.connect(oeFa5dVi);
					ftp.login(eXZ8Zn4I, QLtFpOET);
					ftp.enterLocalPassiveMode();
					ftp.setFileTransferMode(FTPClient.ASCII_FILE_TYPE);
					ftp.setFileType(FTPClient.ASCII_FILE_TYPE);
					ftp.changeWorkingDirectory(YKB1vZQC);
					FileInputStream Wb48EMDk = new FileInputStream(Wqlnef8j + KYf7LUDy);
					Log.v("uploadFTP", "FileInputStream declarado");
					if (ftp.storeFile(KYf7LUDy, Wb48EMDk)) {
						Log.v("uploadFTP", "ftp.storeFile(arquivoFTP, arqEnviar)");
						HXipmmOL = ftp.getStatus().toString();
						Log.v("uploadFTP", "getStatus(): " + HXipmmOL);
						if (eqjHKyUC.delete()) {
							Log.i("uploadFTP", "Arquivo " + KYf7LUDy + " exclu?do com sucesso");
							retorno = true;
						} else {
							Log.e("uploadFTP", "Erro ao excluir o arquivo " + KYf7LUDy);
							retorno = false;
						}
					} else {
						Log.e("uploadFTP", "ERRO: arquivo " + KYf7LUDy + "n?o foi enviado!");
						retorno = false;
					}
				} else {
					Log.e("uploadFTP", "N?o existe o arquivo " + KYf7LUDy + "neste diret?rio!");
					retorno = false;
				}
			} else {
				Log.e("uploadFTP", "N?o ? diret?rio");
				retorno = false;
			}
			if (ftp.isConnected()) {
				Log.v("uploadFTP", "isConnected ");
				ftp.abort();
				HXipmmOL = ftp.getStatus().toString();
				Log.v("uploadFTP", "quit " + retorno);
			}
			return retorno;
		} catch (IOException Z0PVKB1e) {
			Log.e("uploadFTP", "ERRO FTP: " + Z0PVKB1e);
			retorno = false;
			return retorno;
		} finally {
			handler.sendEmptyMessage(0);
			Log.v("uploadFTP", "finally executado");
		}
	}

}