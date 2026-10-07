package velune.service;

import velune.dto.HospedeRequestDTO;
import velune.exception.HospedeJaExisteException;
import velune.model.Hospede;
import velune.repository.HospedeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HospedeServiceTest {

    @Test
    void deveRecusarHospedeComDocumentoDuplicado() {

        HospedeRepository repository = org.mockito.Mockito.mock(HospedeRepository.class);
        HospedeService service = new HospedeService(repository);

        when(repository.existsByDocumento("123")).thenReturn(true);

        HospedeRequestDTO dto = new HospedeRequestDTO();
        dto.setNome("Pedro");
        dto.setDocumento("123");

        HospedeJaExisteException excecao = assertThrows(
                HospedeJaExisteException.class, () -> service.salvarHospede(dto));

        assertEquals(
                "Este documento já está sendo utilizado por outro hóspede.",
                excecao.getMessage()
        );
    }

    @Test
    void deveSalvarHospedeQuandoDocumentoNaoExiste() {

        HospedeRepository repository = org.mockito.Mockito.mock(HospedeRepository.class);
        HospedeService service = new HospedeService(repository);

        when(repository.existsByDocumento("456")).thenReturn(false);

        HospedeRequestDTO dto = new HospedeRequestDTO();
        dto.setNome("Pedro");
        dto.setDocumento("456");

        ArgumentCaptor<Hospede> captor = ArgumentCaptor.forClass(Hospede.class);

        service.salvarHospede(dto);

        verify(repository).save(captor.capture());

        Hospede hospedeCapturado = captor.getValue();

        assertEquals("Pedro", hospedeCapturado.getNome());
        assertEquals("456", hospedeCapturado.getDocumento());
    }
}