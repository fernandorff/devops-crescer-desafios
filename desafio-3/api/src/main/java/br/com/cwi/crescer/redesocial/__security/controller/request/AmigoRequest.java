package br.com.cwi.crescer.redesocial.__security.controller.request;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmigoRequest {

    @NotNull
    private Long usuarioId;
}
