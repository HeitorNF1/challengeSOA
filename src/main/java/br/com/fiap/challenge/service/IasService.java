package br.com.fiap.challenge.service;

import br.com.fiap.challenge.model.Ias;
import br.com.fiap.challenge.DTO.IasDTO;
import br.com.fiap.challenge.DTO.IasResponseDTO;
import br.com.fiap.challenge.repository.IasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IasService {

    @Autowired
    IasRepository iasRepository;


    public Ias createIa(IasDTO ia){
        Ias newias = new Ias(ia);
        iasRepository.save(newias);
        return newias;
    }

    public List<IasResponseDTO> listAll() {
        List<IasResponseDTO> result = iasRepository.findAll().stream().map(IasResponseDTO::new).toList();
        return result;
    }

    public void deleteIa(String id){
        UUID uuid = UUID.fromString(id);
        iasRepository.findById(uuid).ifPresent(iasRepository::delete);
    }

    public Ias putIa(Ias modifyIa) {
        Ias antigo = iasRepository.findById(modifyIa.getId())
                .orElseThrow(() -> new RuntimeException("IA não encontrada"));

        antigo.setDescricao(modifyIa.getDescricao());
        antigo.setNome(modifyIa.getNome());
        antigo.setTipo(modifyIa.getTipo());

        return iasRepository.save(antigo);
    }

}
