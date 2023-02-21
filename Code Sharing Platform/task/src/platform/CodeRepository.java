package platform;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CodeRepository {
    private final Map<Integer, Code> codeSnippets = new ConcurrentHashMap<>();

//    private final static List<Code> codeList = new ArrayList<>();

    public String saveCodeToMap(Code code) {
        code.setDate(Code.formatDateTime());
        codeSnippets.put(codeSnippets.size() + 1, code);
        return String.format("{ \"id\" : \"%d\" }", codeSnippets.size());
    }

    public Code findCodeById(Integer id) {
        if (codeSnippets.containsKey(id) == true) {
            return codeSnippets.get(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Code> getAllSnippetsFromMap() {
        List<Code> listWith10Snippets = new ArrayList<>();
            if (codeSnippets.size() >= 10) {
                for (int i = codeSnippets.size() - 9; i <= codeSnippets.size(); i++) {
                    listWith10Snippets.add(codeSnippets.get(i));
                }
                Collections.reverse(listWith10Snippets);
                return listWith10Snippets;
            }
        for (int i = 1; i <= codeSnippets.size(); i++) {
            listWith10Snippets.add(codeSnippets.get(i));
        }
        Collections.reverse(listWith10Snippets);
        return listWith10Snippets;
        }
    }

//    public int getLengthOfMap() {
//        return codeSnippets.size();
//    }
//
//    public List<Code> getCodeList() {
//        return codeList;
//    }

