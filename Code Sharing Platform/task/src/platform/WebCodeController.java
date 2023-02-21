package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebCodeController {

    @Autowired
    CodeRepository codeRepository;

    @GetMapping("/code/{id}")
    public String getHtmlPageById(@PathVariable Integer id, Model model) {
        model.addAttribute("code", codeRepository.findCodeById(id).getCode())
                .addAttribute("date", codeRepository.findCodeById(id).getDate());
        return "pageByNumber";
    }

    @GetMapping("/code/latest")
    public String getHtmlPageWithLatest(Model model) {
        model.addAttribute("allSnippets", codeRepository.getAllSnippetsFromMap());
        return "latestSnippets";
    }


}
