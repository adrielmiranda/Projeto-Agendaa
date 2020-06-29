package com.agenda.resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.agenda.storageFotos.ArquivosFotos;

@RestController
@RequestMapping("fotos")
public class FotosResource {
	
	@Autowired
	 private ArquivosFotos arq;

	 @PostMapping
	 public void upload(@RequestParam MultipartFile foto) {
	 arq.salvarFoto(foto);
	
	
	 }
	
	

}
