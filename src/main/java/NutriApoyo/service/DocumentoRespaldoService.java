package NutriApoyo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.UUID;

@Service
public class DocumentoRespaldoService {

    private static final long TAMANO_MAXIMO = 5L * 1024 * 1024;
    private static final Map<String, String> TIPOS_PERMITIDOS = Map.of(
            "application/pdf", "pdf",
            "image/jpeg", "jpg",
            "image/png", "png");

    private final Path directorioDocumentos;

    public DocumentoRespaldoService(@Value("${nutriapoyo.documentos.ruta:./datos/documentos}") String rutaDocumentos) {
        this.directorioDocumentos = Path.of(rutaDocumentos).toAbsolutePath().normalize();
    }

    public DocumentoGuardado guardar(MultipartFile archivo) {
        if (archivo == null || archivo.isEmpty()) {
            return null;
        }
        if (archivo.getSize() > TAMANO_MAXIMO) {
            throw new IllegalArgumentException("El documento no puede superar los 5 MB.");
        }
        String tipoContenido = archivo.getContentType();
        String extension = TIPOS_PERMITIDOS.get(tipoContenido);
        if (extension == null) {
            throw new IllegalArgumentException("Adjunte solo archivos PDF, PNG o JPG.");
        }

        try {
            Files.createDirectories(directorioDocumentos);
            String nombreAlmacenado = UUID.randomUUID() + "." + extension;
            Path destino = directorioDocumentos.resolve(nombreAlmacenado).normalize();
            if (!destino.startsWith(directorioDocumentos)) {
                throw new IllegalArgumentException("La ruta del documento no es válida.");
            }
            Files.copy(archivo.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);
            return new DocumentoGuardado(nombreAlmacenado, tipoContenido);
        } catch (IOException excepcion) {
            throw new IllegalStateException("No se pudo guardar el documento de respaldo.", excepcion);
        }
    }

    public Resource obtener(String nombreAlmacenado) {
        Path archivo = directorioDocumentos.resolve(nombreAlmacenado).normalize();
        if (!archivo.startsWith(directorioDocumentos) || !Files.exists(archivo)) {
            throw new IllegalArgumentException("No se encontró el documento solicitado.");
        }
        return new FileSystemResource(archivo);
    }

    public record DocumentoGuardado(String nombre, String tipoContenido) { }
}
