package NutriApoyo.controller;

import NutriApoyo.model.EstadoSolicitud;
import NutriApoyo.model.Solicitud;
import NutriApoyo.service.DocumentoRespaldoService;
import NutriApoyo.service.SolicitudService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/evaluaciones")
public class EvaluacionSolicitudController {

    private final SolicitudService solicitudService;
    private final DocumentoRespaldoService documentoRespaldoService;

    public EvaluacionSolicitudController(SolicitudService solicitudService, DocumentoRespaldoService documentoRespaldoService) {
        this.solicitudService = solicitudService;
        this.documentoRespaldoService = documentoRespaldoService;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) EstadoSolicitud estado, Model model) {
        model.addAttribute("solicitudes", solicitudService.buscarParaEvaluacion(estado));
        model.addAttribute("estados", EstadoSolicitud.values());
        model.addAttribute("estadoSeleccionado", estado);
        return "evaluaciones/lista";
    }

    @GetMapping("/{id}")
    public String verSolicitud(@PathVariable Long id, Model model) {
        model.addAttribute("solicitud", solicitudService.obtenerDetalle(id));
        model.addAttribute("decisiones", new EstadoSolicitud[] {
                EstadoSolicitud.APROBADA, EstadoSolicitud.OBSERVADA, EstadoSolicitud.RECHAZADA});
        return "evaluaciones/detalle";
    }

    @PostMapping("/{id}/iniciar")
    public String iniciar(@PathVariable Long id, RedirectAttributes atributosRedireccion) {
        solicitudService.iniciarEvaluacion(id);
        atributosRedireccion.addFlashAttribute("exito", "La solicitud quedó en evaluación.");
        return "redirect:/evaluaciones/" + id;
    }

    @PostMapping("/{id}/decision")
    public String registrarDecision(
            @PathVariable Long id,
            @RequestParam EstadoSolicitud decision,
            @RequestParam String motivo,
            Authentication authentication,
            RedirectAttributes atributosRedireccion) {
        try {
            solicitudService.registrarDecision(id, decision, motivo, authentication.getName());
            atributosRedireccion.addFlashAttribute("exito", "La decisión fue registrada correctamente.");
        } catch (IllegalArgumentException excepcion) {
            atributosRedireccion.addFlashAttribute("error", excepcion.getMessage());
        }
        return "redirect:/evaluaciones/" + id;
    }

    @GetMapping("/{id}/documento")
    public ResponseEntity<Resource> descargarDocumento(@PathVariable Long id) {
        Solicitud solicitud = solicitudService.obtenerDetalle(id);
        if (solicitud.getDocumentoRespaldo() == null) {
            return ResponseEntity.notFound().build();
        }
        Resource recurso = documentoRespaldoService.obtener(solicitud.getDocumentoRespaldo());
        MediaType tipo = MediaType.parseMediaType(solicitud.getTipoDocumentoRespaldo());
        return ResponseEntity.ok()
                .contentType(tipo)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"documento-respaldo\"")
                .body(recurso);
    }
}
