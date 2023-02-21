package platform;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CodeController {

    @Autowired
    CodeRepository codeRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/api/code/{id}")
    public String getCodeInJson(@PathVariable Integer id) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(codeRepository.findCodeById(id));
    }

    @PostMapping("/api/code/new")
    public String postNewCode(@RequestBody(required = false) Code code) {
        return codeRepository.saveCodeToMap(code);
    }

    @GetMapping("/api/code/latest")
    public String getLatestCodeSnippets() throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(codeRepository.getAllSnippetsFromMap());
    }

    @GetMapping("/code/new") // не трогать
    public String getNewHTMLPage() {
        return "<html lang =\"en\">\n" +
                "<head>\n" +
                "    <title>Create</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<textarea id=\"code_snippet\"> // paste your code here" + "</textarea>\n" +
                "    <button id=\"send_snippet\" type=\"submit\" onclick=\"send()\">Submit</button>\n" +
                "</body>\n" +
                "</html>";

    }


}
