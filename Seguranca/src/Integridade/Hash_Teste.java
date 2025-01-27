package Integridade;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash_Teste {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
    
    // Hash do Arquivo (MD5)
    public String doHash(String nomeArquivo) throws NoSuchAlgorithmException, IOException {
        
    	MessageDigest md = MessageDigest.getInstance("MD5");
        String conteudoArquivo = new String(Files.readAllBytes(Paths.get(nomeArquivo)));
        md.update(conteudoArquivo.getBytes());
        byte[] digest = md.digest();
        return(bytesToHex(digest).toLowerCase());
    }

    // Hash da Pasta.
    public String doHashInFolder(String folderPath) throws NoSuchAlgorithmException, IOException {
    	
    	// Caminho de cada um dos arquivos da pasta de teste.
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(folderPath))) {
        	String arquivoSaida = "Listagem de Hashs de Arquivos/Pastas: \n";
            for (Path path : directoryStream) {
            	
                if (Files.isRegularFile(path)) {
                	// Produção do Hash + String do Hash.
                    String pathArquivo = path.toString();
                    String hash = doHash(pathArquivo);
                    arquivoSaida += ("\nNomeArquivo: " + path.getFileName().toString()+"\n" + "Hash: " + hash + "\n");
                    
                }
            }
            
            return arquivoSaida;
        }    
    }
}
