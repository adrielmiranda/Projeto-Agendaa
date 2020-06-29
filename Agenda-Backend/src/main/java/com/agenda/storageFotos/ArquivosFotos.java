package com.agenda.storageFotos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ArquivosFotos {

	@Value("${disco.raiz}")
	private String raiz;

	@Value("${disco.diretorio-fotos}")
	private String diretorioFotos;

	public void salvarFoto(MultipartFile foto) {
		this.salvar(this.diretorioFotos, foto);
	}

	public void salvar(String diretorio, MultipartFile arquivo) {

		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

		long tamanho = arquivo.getSize();

		System.out.printf("O tamanho do arquivo é: %d\n", tamanho);

		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());

		} catch (IOException e) {
			throw new RuntimeException("Erro ao salvar o arquivo.", e);
		}
	}

}
