package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;

import Integridade.Hash_Teste;

public class Hash_Main {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		
			// *** Introduzir o caminho da pasta de Teste!!! ***
			// String folderPath = "caminho_da_pasta";
	        String folderPath = "C:\\Users\\mtcor\\OneDrive\\Área de Trabalho\\Hash\\Virus";
	        
	        Files.writeString(Path.of("listaDeHash.txt"), (new Hash_Teste()).doHashInFolder(folderPath));;

	        System.out.println("Listagem dos Arquivos da pasta foram gerados com sucesso.\n");
	        System.out.println("Atualize ou dê um Refresh no Projeto de Java Segurança.");
	        
	}

}
