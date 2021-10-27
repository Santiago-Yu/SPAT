class n19870772 {
	@RequestMapping(value = "/verdocumentoFisico.html", method = RequestMethod.GET)
	public String editFile(ModelMap Zddb0mQ8, @RequestParam("id") int PpBA9Xrt) {
		Anexo kcZHsfXi = anexoService.selectById(PpBA9Xrt);
		Zddb0mQ8.addAttribute("path", kcZHsfXi.getAnexoCaminho());
		try {
			InputStream BG1kz8uG = new FileInputStream(
					new File(config.baseDir + "/arquivos_upload_direto/" + kcZHsfXi.getAnexoCaminho()));
			FileOutputStream HP2OS8QO = new FileOutputStream(
					new File(config.baseDir + "/temp/" + kcZHsfXi.getAnexoCaminho()));
			IOUtils.copy(BG1kz8uG, HP2OS8QO);
			Runtime.getRuntime().exec("chmod 777 " + config.tempDir + kcZHsfXi.getAnexoCaminho());
		} catch (FileNotFoundException lRxXRmVS) {
			lRxXRmVS.printStackTrace();
		} catch (IOException rDFoNlJI) {
			rDFoNlJI.printStackTrace();
		}
		return "verdocumentoFisico";
	}

}