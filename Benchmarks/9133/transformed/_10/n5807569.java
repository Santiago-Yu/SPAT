class n5807569 {
	@RequestMapping("/import")
	public String importPicture(@ModelAttribute PictureImportCommand command) throws IOException {
		URL url = command.getUrl();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		IOUtils.copy(url.openStream(), baos);
		byte[] imageData = imageFilterService.touchupImage(baos.toByteArray());
		String filename = StringUtils.substringAfterLast(url.getPath(), "/");
		String email = userService.getCurrentUser().getEmail();
		Picture picture = new Picture(email, filename, command.getDescription(), imageData);
		pictureRepository.store(picture);
		return "redirect:/picture/gallery";
	}

}