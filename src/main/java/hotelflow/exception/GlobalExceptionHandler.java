package hotelflow.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> tratarErroValidacao(MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();
        var resultado = ex.getBindingResult();
        for (var erro : resultado.getFieldErrors()) {

            String campo = erro.getField();
            String mensagem = erro.getDefaultMessage();

            erros.put(campo, mensagem);
        }
        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler(HospedeJaExisteException.class)
    public ResponseEntity<String> tratarErroHospedeExistente(HospedeJaExisteException ex) {

        return ResponseEntity.badRequest().body(ex.getMessage());

    }
}
