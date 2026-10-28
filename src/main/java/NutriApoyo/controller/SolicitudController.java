package NutriApoyo.controller;

import NutriApoyo.model.Beneficiario;
import NutriApoyo.model.CondicionAnemiaDeclarada;
import NutriApoyo.model.Solicitud;
import NutriApoyo.model.Sexo;
import NutriApoyo.model.TipoDocumento;
import NutriApoyo.service.SolicitudService;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @GetMapping("/solicitudes/nueva")
    public String mostrarFormulario(Model model) {
        prepararFormulario(model, new Beneficiario(), new Solicitud());
        return "solicitudes/formulario";
    }

    @PostMapping("/solicitudes")
    public String registrar(
            @Valid @ModelAttribute("beneficiario") Beneficiario beneficiario,
            BindingResult erroresBeneficiario,
            @Valid @ModelAttribute("solicitud") Solicitud solicitud,
            BindingResult erroresSolicitud,
            @RequestPart(required = false) MultipartFile documento,
            Authentication authentication,
            Model model,
            RedirectAttributes atributosRedireccion) {
        if (erroresBeneficiario.hasErrors() || erroresSolicitud.hasErrors()) {
            prepararFormulario(model, beneficiario, solicitud);
            return "solicitudes/formulario";
        }
        try {
            String correo = authentication instanceof AnonymousAuthenticationToken ? null : authentication.getName();
            Solicitud registrada = solicitudService.registrar(solicitud, beneficiario, correo, documento);
            atributosRedireccion.addFlashAttribute("codigo", registrada.getCodigoSeguimiento());
            return "redirect:/seguimiento";
        } catch (IllegalArgumentException | IllegalStateException excepcion) {
            erroresSolicitud.reject("solicitud.invalida", excepcion.getMessage());
            prepararFormulario(model, beneficiario, solicitud);
            return "solicitudes/formulario";
        }
    }

    @GetMapping("/seguimiento")
    public String consultarEstado(
            @RequestParam(required = false) String codigo,
            @RequestParam(required = false) String documento,
            Model model) {
        if (codigo != null && !codigo.isBlank()) {
            try {
                model.addAttribute("solicitud", solicitudService.consultarPorCodigo(codigo, documento));
            } catch (IllegalArgumentException excepcion) {
                model.addAttribute("error", excepcion.getMessage());
            }
        }
        return "solicitudes/seguimiento";
    }

    private void prepararFormulario(Model model, Beneficiario beneficiario, Solicitud solicitud) {
        model.addAttribute("beneficiario", beneficiario);
        model.addAttribute("solicitud", solicitud);
        model.addAttribute("sexos", Sexo.values());
        model.addAttribute("tiposDocumento", TipoDocumento.values());
        model.addAttribute("condiciones", CondicionAnemiaDeclarada.values());
    }
}
