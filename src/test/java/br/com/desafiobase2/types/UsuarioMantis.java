package br.com.desafiobase2.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;


@Data
@NoArgsConstructor(force = true)
public class UsuarioMantis {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioMantis.class);

    @NonNull
    @JsonProperty("usuario")
    private String usuario;

    @NonNull
    @JsonProperty("senha")
    private String senha;

    public static UsuarioMantis get(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        UsuarioMantis usuarioMantis = mapper.readValue(new File(filename), UsuarioMantis.class);
        LOGGER.info("cliente lido o arquivo: '{}' ==> '{}'", filename, usuarioMantis);
        return usuarioMantis;
    }

}
