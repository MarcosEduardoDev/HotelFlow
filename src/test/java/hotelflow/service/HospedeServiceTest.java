package hotelflow.service;

import hotelflow.dto.HospedeRequestDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import hotelflow.exception.HospedeJaExisteException;
import hotelflow.model.Hospede;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.sql.SQLException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HospedeServiceTest {

    @Test
    void deveRecusarHospedeComDocumentoDuplicado() throws SQLException {

        HospedeRepository repository = org.mockito.Mockito.mock(HospedeRepository.class);
        HospedeService service = new HospedeService(repository);

        when(repository.buscarPorDocumento("123")).thenReturn(new Hospede("João", "123"));

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
    void deveSalvarHospedeQuandoDocumentoNaoExiste() throws SQLException, HospedeJaExisteException {

        HospedeRepository repository = org.mockito.Mockito.mock(HospedeRepository.class);

        HospedeService service = new HospedeService(repository);

        when(repository.buscarPorDocumento("456"))
                .thenReturn(null);

        HospedeRequestDTO dto = new HospedeRequestDTO();
        dto.setNome("Pedro");
        dto.setDocumento("456");

        ArgumentCaptor<Hospede> captor = ArgumentCaptor.forClass(Hospede.class);

        service.salvarHospede(dto);

        verify(repository).salvarHospede(captor.capture());

        Hospede hospedeCapturado = captor.getValue();

        assertEquals("Pedro", hospedeCapturado.getNome());
        assertEquals("456", hospedeCapturado.getDocumento());
    }
}
