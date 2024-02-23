package sebastian.sas.pizzeria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sebastian.sas.pizzeria.model.EmailForm;

@Controller
public class CommonController {


    @RequestMapping(path={"/main"}, method = RequestMethod.GET)
    public String main(){
        return "redirect:/";
    }

    @RequestMapping(path="/contact", method = RequestMethod.GET)
    public String contact(){
        return "contact";
    }

    @RequestMapping(path="/sale", method = RequestMethod.GET)
    public String sale(){
        return "sale";
    }
    @RequestMapping(path="/delivery", method = RequestMethod.GET)
    public String delivery(){
        return "delivery";
    }

/*    @GetMapping("/send-email")
    public String showForm(Model model) {
        model.addAttribute("emailForm", new EmailForm());
        return "yourFormView";
    }

    @PostMapping("/send-email")
    public String sendEmail(@ModelAttribute("emailForm") EmailForm emailForm, Model model) {
        // Tutaj umieść logikę wysyłania e-maila
        // Możesz skorzystać z bibliotek do wysyłania e-maili, np. JavaMail

        // Przykładowa logika:
        String recipientEmail = emailForm.getRecipientEmail();
        String message = emailForm.getMessage();

        // Tutaj możesz dodać kod do wysłania e-maila
        // np. korzystając z JavaMail lub innej biblioteki

        // Poniżej zakładamy, że wiadomość została wysłana pomyślnie
        model.addAttribute("message", "Wiadomość została wysłana pomyślnie na adres: " + recipientEmail);

        // Przekierowanie do widoku potwierdzającego
        return "redirect/contact";
    }*/


}
