package NutriApoyo.controller;

import NutriApoyo.model.Beneficiario;
import NutriApoyo.model.EstadoBeneficiario;
import NutriApoyo.model.Sexo;
import NutriApoyo.model.TipoDocumento;
import NutriApoyo.service.BeneficiarioService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/beneficiarios")
public class BeneficiarioController {

    private final BeneficiarioService beneficiarioService;

    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @GetMapping
    public String listar(
            @RequestParam(required = false) String termino,
            @RequestParam(required = false) EstadoBeneficiario estado,
            @RequestParam(required = false) String distrito,
            Model model) {
        model.addAttribute("beneficiarios", beneficiarioService.buscar(termino, estado, distrito));
        model.addAttribute("distritos", beneficiarioService.obtenerDistritos());
        model.addAttribute("estados", EstadoBeneficiario.values());
        model.addAttribute("termino", termino);
        model.addAttribute("estadoSeleccionado", estado);
        model.addAttribute("distritoSeleccionado", distrito);
        return "beneficiarios/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        prepararFormulario(model, new Beneficiario(), "Registrar beneficiario");
        return "beneficiarios/formulario";
    }

    @PostMapping
    public String registrar(
            @Valid @ModelAttribute("beneficiario") Beneficiario beneficiario,
            BindingResult resultado,
            Authentication authentication,
            Model model,
            RedirectAttributes atributosRedireccion) {
        if (resultado.hasErrors()) {
            prepararFormulario(model, beneficiario, "Registrar beneficiario");
            return "beneficiarios/formulario";
        }
        try {
            beneficiarioService.registrar(beneficiario, authentication.getName());
        } catch (IllegalArgumentException excepcion) {
            resultado.rejectValue("numeroDocumento", "duplicado", excepcion.getMessage());
            prepararFormulario(model, beneficiario, "Registrar beneficiario");
            return "beneficiarios/formulario";
        }
        atributosRedireccion.addFlashAttribute("exito", "El beneficiario fue registrado correctamente.");
        return "redirect:/beneficiarios";
    }

    @GetMapping("/{id}")
    public String verDetalle(@PathVariable Long id, Model model) {
        model.addAttribute("beneficiario", beneficiarioService.obtenerPorId(id));
        return "beneficiarios/detalle";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        prepararFormulario(model, beneficiarioService.obtenerPorId(id), "Editar beneficiario");
        return "beneficiarios/formulario";
    }

    @PostMapping("/{id}")
    public String actualizar(
            @PathVariable Long id,
            @Valid @ModelAttribute("beneficiario") Beneficiario beneficiario,
            BindingResult resultado,
            Model model,
            RedirectAttributes atributosRedireccion) {
        if (resultado.hasErrors()) {
            prepararFormulario(model, beneficiario, "Editar beneficiario");
            return "beneficiarios/formulario";
        }
        try {
            beneficiarioService.actualizar(id, beneficiario);
        } catch (IllegalArgumentException excepcion) {
            resultado.rejectValue("numeroDocumento", "duplicado", excepcion.getMessage());
            prepararFormulario(model, beneficiario, "Editar beneficiario");
            return "beneficiarios/formulario";
        }
        atributosRedireccion.addFlashAttribute("exito", "Los datos del beneficiario fueron actualizados.");
        return "redirect:/beneficiarios/" + id;
    }

    private void prepararFormulario(Model model, Beneficiario beneficiario, String titulo) {
        model.addAttribute("beneficiario", beneficiario);
        model.addAttribute("titulo", titulo);
        model.addAttribute("sexos", Sexo.values());
        model.addAttribute("tiposDocumento", TipoDocumento.values());
        model.addAttribute("estados", EstadoBeneficiario.values());
    }
}
